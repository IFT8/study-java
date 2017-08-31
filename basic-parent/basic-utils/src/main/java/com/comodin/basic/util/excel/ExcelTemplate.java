package com.comodin.basic.util.excel;

import com.comodin.basic.exception.UploadDataErrorException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

/**
 * 该类实现了基于模板的导出
 * 如果要导出序号，需要在excel中定义一个标识为 sternums
 * 如果要替换信息，需要传入一个Map，这个map中存储着要替换信息的值，在excel中通过#来开头
 * 要从哪一行那一列开始替换需要定义一个标识为datas
 * 如果要设定相应的样式，可以在该行使用styles完成设定，此时所有此行都使用该样式
 * 如果使用defaultStyles作为表示，表示默认样式，如果没有defaultStyles使用datas行作为默认样式
 *
 * @author KongHao
 */
@SuppressWarnings({"Duplicates", "WeakerAccess", "unused", "UnusedReturnValue"})
public class ExcelTemplate {
    /**
     * 数据行标识
     */
    public final static String MARK_DATA_LINE = "datas";
    /**
     * 默认样式标识
     */
    public final static String MARK_DEFAULT_STYLE = "defaultStyles";
    /**
     * 默认样式
     */
    private CellStyle defaultStyle;

    /**
     * 行样式标识
     */
    public final static String MARK_DATA_STYLE = "styles";
    /**
     * 存储某一列所对于的样式
     */
    private Map<Integer, CellStyle> dataColumnIndexToCellStyleMap;

    /**
     * 插入序号样式标识
     */
    public final static String MARK_SERIAL_NUMBER = "sternums";
    /**
     * 序号的列
     */
    private int serialNumberColIndex;

    private static ExcelTemplate et = new ExcelTemplate();
    private Workbook wb;
    private Sheet sheet;
    /**
     * 数据的初始化列数
     */
    private int initColIndex;
    /**
     * 数据的初始化行数
     */
    private int initRowIndex;
    /**
     * 当前列数
     */
    private int curColIndex;
    /**
     * 当前行数
     */
    private int curRowIndex;
    /**
     * 当前行对象
     */
    private Row curRow;
    /**
     * 最后一行的数据
     */
    private int lastRowIndex;

    /**
     * 默认行高
     */
    private float rowHeight;


    private ExcelTemplate() {

    }

    public static ExcelTemplate getInstance() {
        return et;
    }

    //1、读取相应的模板文档

    /**
     * 从classpath路径下读取相应的模板文件
     *
     * @param path //
     *
     * @return //
     */
    public ExcelTemplate readTemplateByClasspath(String path) {
        try {
            wb = WorkbookFactory.create(ExcelTemplate.class.getResourceAsStream(path));
            initTemplate();
        } catch (InvalidFormatException e) {
            //throw new RuntimeException("读取模板格式有错，！请检查");
            throw new UploadDataErrorException("-1201", "Read the template format is wrong! Please check.", e.getMessage(), e);
        } catch (IOException e) {
            //throw new RuntimeException("读取模板不存在！请检查");
            throw new UploadDataErrorException("-1201", "Read template does not exist! Please check.", e.getMessage(), e);
        }
        return this;
    }

    /**
     * 从某个路径来读取模板
     *
     * @param path //
     *
     * @return //
     */
    public ExcelTemplate readTemplateByPath(String path) {
        try {
            wb = WorkbookFactory.create(new File(path));
            initTemplate();
        } catch (InvalidFormatException e) {
            throw new UploadDataErrorException("-1201", "Read the template format is wrong! Please check.", e.getMessage(), e);
        } catch (IOException e) {
            throw new UploadDataErrorException("-1201", "Read template does not exist! Please check.", e.getMessage(), e);
        }
        return this;
    }

    /**
     * 将文件写到相应的路径下
     *
     * @param outPath //导出路径
     */
    public void writeToFile(String outPath) {
        FileOutputStream fos = null;
        //sheet.shiftRows(0, 8, 3, true, true);
        try {
            fos = new FileOutputStream(outPath);
            wb.write(fos);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException("写入的文件不存在");
            throw new UploadDataErrorException("-1201", "The written file does not exist. filePath: " + outPath, e.getMessage(), e);
        } catch (IOException e) {
            //throw new RuntimeException("写入数据失败:" + e.getMessage());
            throw new UploadDataErrorException("-1201", "Write data to file failed. filePath: " + outPath, e.getMessage(), e);
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将文件写到某个输出流中
     *
     * @param outputStream //输出流
     */
    public void writeToStream(OutputStream outputStream) {
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            //throw new RuntimeException("写入流失败:" + e.getMessage());
            throw new UploadDataErrorException("-1201", "Write data to Output Stream.", e.getMessage(), e);
        }
    }

    /**
     * 初始化，模版
     */
    private void initTemplate() {
        sheet = wb.getSheetAt(0);
        initConfigData();
        lastRowIndex = sheet.getLastRowNum();
        curRow = sheet.createRow(curRowIndex);  //得到 data标识的当前行
    }

    /**
     * 初始化数据信息
     */
    private void initConfigData() {
        boolean findDataMark = false;
        boolean findSerialNumberMark = false;
        for (Row row : sheet) {
            if (findDataMark) break;
            for (Cell c : row) {
                if (c.getCellTypeEnum() != CellType.STRING) continue;
                String str = c.getStringCellValue().trim();
                //插入序号样式标识
                if (str.equals(MARK_SERIAL_NUMBER)) {
                    serialNumberColIndex = c.getColumnIndex();
                    findSerialNumberMark = true;
                }
                //等需要插入数据的，标识位置
                if (str.equals(MARK_DATA_LINE)) {
                    initColIndex = c.getColumnIndex();
                    initRowIndex = row.getRowNum();
                    curColIndex = initColIndex; //当前行
                    curRowIndex = initRowIndex; //当前列
                    findDataMark = true;
                    defaultStyle = c.getCellStyle();
                    rowHeight = row.getHeightInPoints();
                    initStyles();
                    break;
                }
            }
        }
        if (!findSerialNumberMark) {
            initSerialNumber();
        }
    }

    /**
     * 创建新行，在使用时只要添加完一行，需要调用该方法创建
     */
    public ExcelTemplate createNewRow() {
        //最新一行，大于当前行，即代表 模版datas标记后面行，还有数据。
        if (lastRowIndex > curRowIndex && curRowIndex != initRowIndex) {
            sheet.shiftRows(curRowIndex, lastRowIndex, 1, true, true);
            lastRowIndex++;
        }
        curRow = sheet.createRow(curRowIndex);  //通过当前行的下标，创建新的行,创建之后，将当前行的下标++
        curRow.setHeightInPoints(rowHeight);
        curRowIndex++;
        curColIndex = initColIndex; //当前的列应该等于，初始化的列
        return this;
    }

    /**
     * 创建相应的元素，基于String类型
     *
     * @param value //
     */
    public Cell createCell(String value) {
        Cell c = curRow.createCell(curColIndex); //通过data标识的当前行当前列，创建一个单元格
        setCellStyle(c);
        c.setCellValue(value);  //将String类型的数据，写入单元格中，并对当前处理的列，进行++操作
        curColIndex++;
        return c;
    }

    public Cell createCell(int value) {
        Cell c = curRow.createCell(curColIndex);
        setCellStyle(c);
        c.setCellValue(value);
        curColIndex++;
        return c;
    }

    public Cell createCell(Date value) {
        Cell c = curRow.createCell(curColIndex);
        setCellStyle(c);
        c.setCellValue(value);
        curColIndex++;
        return c;
    }

    public Cell createCell(double value) {
        Cell c = curRow.createCell(curColIndex);
        setCellStyle(c);
        c.setCellValue(value);
        curColIndex++;
        return c;
    }

    public Cell createCell(boolean value) {
        Cell c = curRow.createCell(curColIndex);
        setCellStyle(c);
        c.setCellValue(value);
        curColIndex++;
        return c;
    }

    public Cell createCell(Calendar value) {
        Cell c = curRow.createCell(curColIndex);
        setCellStyle(c);
        c.setCellValue(value);
        curColIndex++;
        return c;
    }

    /**
     * 设置某个元素的样式
     *
     * @param c //
     */
    private void setCellStyle(Cell c) {
        c.setCellStyle(dataColumnIndexToCellStyleMap.getOrDefault(curColIndex, defaultStyle));
    }

    /**
     * 插入序号，会自动找相应的序号标示的位置完成插入
     */
    public void insertSer() {
        int index = 1;
        Row row;
        Cell c;
        for (int i = initRowIndex; i < curRowIndex; i++) {
            row = sheet.getRow(i);
            c = row.createCell(serialNumberColIndex);
            setCellStyle(c);
            c.setCellValue(index++);
        }
    }

    /**
     * 根据map替换相应的常量，通过Map中的值来替换#开头的值
     *
     * @param datas //
     */
    public void replaceFinalData(Map<String, String> datas) {
        if (datas == null || datas.isEmpty()) return;
        for (Row row : sheet) {
            for (Cell c : row) {
                if (c.getCellTypeEnum() != CellType.STRING) continue;
                String str = c.getStringCellValue().trim();
                if (str.startsWith("#")) {
                    if (datas.containsKey(str.substring(1))) {
                        c.setCellValue(datas.get(str.substring(1)));
                    }
                }
            }
        }
    }

    /**
     * 基于Properties的替换，依然也是替换#开始的
     *
     * @param prop //
     */
    public void replaceFinalData(Properties prop) {
        if (prop == null) return;
        for (Row row : sheet) {
            for (Cell c : row) {
                if (c.getCellTypeEnum() != CellType.STRING) continue;
                String str = c.getStringCellValue().trim();
                if (str.startsWith("#")) {
                    if (prop.containsKey(str.substring(1))) {
                        c.setCellValue(prop.getProperty(str.substring(1)));
                    }
                }
            }
        }
    }


    /**
     * 初始化序号位置
     */
    private void initSerialNumber() {
        for (Row row : sheet) {
            for (Cell c : row) {
                if (c.getCellTypeEnum() != CellType.STRING) continue;
                String str = c.getStringCellValue().trim();
                if (str.equals(MARK_SERIAL_NUMBER)) {
                    serialNumberColIndex = c.getColumnIndex();
                }
            }
        }
    }

    /**
     * 初始化样式信息
     */
    private void initStyles() {
        dataColumnIndexToCellStyleMap = new HashMap<>();
        for (Row row : sheet) {
            for (Cell c : row) {
                if (c.getCellTypeEnum() != CellType.STRING) continue;
                String str = c.getStringCellValue().trim();
                if (str.equals(MARK_DEFAULT_STYLE)) {
                    defaultStyle = c.getCellStyle();
                }
                if (str.equals(MARK_DATA_STYLE)) {
                    dataColumnIndexToCellStyleMap.put(c.getColumnIndex(), c.getCellStyle());
                }
                if (str.equals(MARK_DATA_LINE)) {
                    dataColumnIndexToCellStyleMap.put(c.getColumnIndex(), c.getCellStyle());
                }
            }
        }
    }
}
