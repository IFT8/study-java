package com.comodin.basic.util.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 该类实现了将一组对象转换为Excel表格，并且可以从Excel表格中读取到一组List对象中
 * 该类利用了BeanUtils框架中的反射完成
 * 使用该类的前提，在相应的实体对象上通过ExcelReources来完成相应的注解
 *
 * @author Administrator
 */
@SuppressWarnings({"rawtypes"})
public class ExcelUtil {
    private static ExcelUtil eu = new ExcelUtil();

    private ExcelUtil() {
    }

    public static ExcelUtil getInstance() {
        return eu;
    }

    /**
     * 处理对象转换为Excel
     * <p>
     * //* @param datas
     *
     * @param template
     * @param objs
     * @param clz
     * @param isClasspath
     *
     * @return
     */
    private ExcelTemplate handlerObj2Excel(String template, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = ExcelTemplate.getInstance();
        try {
            if (isClasspath) {
                et.readTemplateByClasspath(template);
            } else {
                et.readTemplateByPath(template);
            }
            List<ExcelHeader> headers = getHeaderList(clz);
            Collections.sort(headers);
            //输出标题
            et.createNewRow();
            for (ExcelHeader eh : headers) {
                et.createCell(eh.getTitle());
            }
            //输出值
            for (Object obj : objs) {
                et.createNewRow();
                for (ExcelHeader eh : headers) {
//				Method m = clz.getDeclaredMethod(mn);
//				Object rel = m.invoke(obj);
                    et.createCell(BeanUtils.getProperty(obj, getMethodName(eh)));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return et;
    }

    /**
     * 根据标题获取相应的方法名称
     *
     * @param eh
     *
     * @return
     */
    private String getMethodName(ExcelHeader eh) {
        String mn = eh.getMethodName().substring(3);
        mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
        return mn;
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到流
     *
     * @param datas       模板中的替换的常量数据
     * @param template    模板路径
     * @param os          输出流
     * @param objs        对象列表
     * @param clz         对象的类型
     * @param isClasspath 模板是否在classPath路径下
     */
    public void exportObj2ExcelByTemplate(Map<String, String> datas, String template, OutputStream os, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(datas);
        et.wirteToStream(os);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到一个具体的路径中
     *
     * @param datas       模板中的替换的常量数据
     * @param template    模板路径
     * @param outPath     输出路径
     * @param objs        对象列表
     * @param clz         对象的类型
     * @param isClasspath 模板是否在classPath路径下
     */
    public void exportObj2ExcelByTemplate(Map<String, String> datas, String template, String outPath, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(datas);
        et.writeToFile(outPath);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到流,基于Properties作为常量数据
     *
     * @param prop        基于Properties的常量数据模型
     * @param template    模板路径
     * @param os          输出流
     * @param objs        对象列表
     * @param clz         对象的类型
     * @param isClasspath 模板是否在classPath路径下
     */
    public void exportObj2ExcelByTemplate(Properties prop, String template, OutputStream os, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(prop);
        et.wirteToStream(os);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到一个具体的路径中,基于Properties作为常量数据
     *
     * @param prop        基于Properties的常量数据模型
     * @param template    模板路径
     * @param outPath     输出路径
     * @param objs        对象列表
     * @param clz         对象的类型
     * @param isClasspath 模板是否在classPath路径下
     */
    public void exportObj2ExcelByTemplate(Properties prop, String template, String outPath, List objs, Class clz, boolean isClasspath) {
        ExcelTemplate et = handlerObj2Excel(template, objs, clz, isClasspath);
        et.replaceFinalData(prop);
        et.writeToFile(outPath);
    }

    private Workbook handleObj2Excel(List objs, Class clz, boolean isXssf) {
        Workbook wb = null;
        try {
            if (isXssf) {
                wb = new XSSFWorkbook();
            } else {
                wb = new HSSFWorkbook();
            }
            Sheet sheet = wb.createSheet();
            Row r = sheet.createRow(0);
            List<ExcelHeader> headers = getHeaderList(clz);
            Collections.sort(headers);
            //写标题
            for (int i = 0; i < headers.size(); i++) {
                r.createCell(i).setCellValue(headers.get(i).getTitle());
            }
            //写数据
            Object obj = null;
            for (int i = 0; i < objs.size(); i++) {
                r = sheet.createRow(i + 1);
                obj = objs.get(i);
                for (int j = 0; j < headers.size(); j++) {
                    r.createCell(j).setCellValue(BeanUtils.getProperty(obj, getMethodName(headers.get(j))));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return wb;
    }

    /**
     * 导出对象到Excel，不是基于模板的，直接新建一个Excel完成导出，基于路径的导出
     *
     * @param outPath 导出路径
     * @param objs    对象列表
     * @param clz     对象类型
     * @param isXssf  是否是2007版本
     */
    public void exportObj2Excel(String outPath, List objs, Class clz, boolean isXssf) {
        Workbook wb = handleObj2Excel(objs, clz, isXssf);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outPath);
            wb.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导出对象到Excel，不是基于模板的，直接新建一个Excel完成导出，基于流
     *
     * @param os     输出流
     * @param objs   对象列表
     * @param clz    对象类型
     * @param isXssf 是否是2007版本
     */
    public void exportObj2Excel(OutputStream os, List objs, Class clz, boolean isXssf) {
        try {
            Workbook wb = handleObj2Excel(objs, clz, isXssf);
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从类路径读取相应的Excel文件到对象列表，标题行为0，没有尾行
     *
     * @param path 路径
     * @param clz  类型
     *
     * @return 对象列表
     */
    public <T> List<T> readExcel2ObjsByClasspath(String path, Class<T> clz) {
        return this.readExcel2ObjsByClasspath(path, clz, 0, 0);
    }

    /**
     * 从类路径读取相应的Excel文件到对象列表
     *
     * @param path     类路径下的path
     * @param clz      对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时，会减去这些行
     *
     * @return
     */
    public <T> List<T> readExcel2ObjsByClasspath(String path, Class<T> clz, int readLine, int tailLine) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(ExcelUtil.class.getResourceAsStream(path));
            return handlerExcel2Objs(wb, clz, readLine, tailLine);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从文件路径读取相应的Excel文件到对象列表，标题行为0，没有尾行
     *
     * @param path 路径
     * @param clz  类型
     *
     * @return 对象列表
     */
    public <T> List<T> readExcel2ObjsByPath(String path, Class<T> clz) {
        return this.readExcel2ObjsByPath(path, clz, 0, 0);
    }

    /**
     * 从文件路径读取相应的Excel文件到对象列表
     *
     * @param path     文件路径下的path
     * @param clz      对象类型
     * @param readLine 开始行，注意是标题所在行
     * @param tailLine 底部有多少行，在读入对象时，会减去这些行
     *
     * @return
     */
    public <T> List<T> readExcel2ObjsByPath(String path, Class<T> clz, int readLine, int tailLine) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            return handlerExcel2Objs(wb, clz, readLine, tailLine);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从类路径读取相应的Excel文件到对象列表，标题行为0，没有尾行
     *
     * @param inputStream 类路径下的path
     * @param clz         对象类型
     *
     * @return
     */
    public <T> List<T> readExcel2ObjsByInputStream(InputStream inputStream, Class<T> clz) {
        return readExcel2ObjsByInputStream(inputStream, clz, 0, 0);
    }

    /**
     * 从类路径读取相应的Excel文件到对象列表
     *
     * @param inputStream 类路径下的path
     * @param clz         对象类型
     * @param readLine    开始行，注意是标题所在行
     * @param tailLine    底部有多少行，在读入对象时，会减去这些行
     *
     * @return
     */
    public <T> List<T> readExcel2ObjsByInputStream(InputStream inputStream, Class<T> clz, int readLine, int tailLine) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(inputStream);
            return handlerExcel2Objs(wb, clz, readLine, tailLine);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getCellValue(Cell c) {
        String cellvalue = null;
        switch (c.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:    //数字类型【日期也为数字，需要转换】
                short format = c.getCellStyle().getDataFormat();
                if (format == 14 || format == 31 || format == 57 || format == 58) {   //excel中的时间格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    double value = c.getNumericCellValue();
                    Date date = DateUtil.getJavaDate(value);
                    cellvalue = sdf.format(date);
                }
                // 判断当前的cell是否为Date
                else if (DateUtil.isCellDateFormatted(c)) {  //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                    // 如果是Date类型则，取得该Cell的Date值           // 对2014-02-02格式识别不出是日期格式
                    Date date = c.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = formater.format(date);
                } else { // 如果是纯数字
                    // 取得当前Cell的数值
                    cellvalue = NumberToTextConverter.toText(c.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING:     //字符串
                cellvalue = c.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellvalue = String.valueOf(c.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:    ////Excel里面的“公式”，可以用cell.getNumericCellValue(); 来获得“结果”，也就是“公式”计算之后的结果
                cellvalue = String.valueOf(c.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                cellvalue = String.valueOf(c.getErrorCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                cellvalue = "";
                break;
            default:
                cellvalue = null;
                break;
        }
        return cellvalue;
    }

    private <T> List<T> handlerExcel2Objs(Workbook wb, Class<T> clz, int readLine, int tailLine) {
        Sheet sheet = wb.getSheetAt(0);
        List<T> objs = null;
        try {
            Row row = sheet.getRow(readLine);
            objs = new ArrayList<T>();
            Map<Integer, String> maps = getHeaderMap(row, clz);
            if (maps == null || maps.size() <= 0) throw new RuntimeException("要读取的Excel的格式不正确，检查是否设定了合适的行");
            for (int i = readLine + 1, lastRowNum = (sheet.getLastRowNum() - tailLine); i <= lastRowNum; i++) {
                row = sheet.getRow(i);
                T obj = clz.newInstance();
                for (Cell c : row) {
                    int ci = c.getColumnIndex();
                    String mn = maps.get(ci).substring(3);
                    mn = mn.substring(0, 1).toLowerCase() + mn.substring(1);
                    BeanUtils.copyProperty(obj, mn, this.getCellValue(c));
                }
                objs.add(obj);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return objs;
    }

    private List<ExcelHeader> getHeaderList(Class clz) {
        List<ExcelHeader> headers = new ArrayList<ExcelHeader>();
        //Method[] ms = clz.getDeclaredMethods();
        //for (Method m : ms) {
        //    String mn = m.getName();
        //    if (mn.startsWith("get")) {
        //        if (m.isAnnotationPresent(ExcelResources.class)) {
        //            ExcelResources er = m.getAnnotation(ExcelResources.class);
        //            headers.add(new ExcelHeader(er.title(), er.order(), mn));
        //        }
        //    }
        //}
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (field.isAnnotationPresent(ExcelResources.class)) {
                ExcelResources er = field.getAnnotation(ExcelResources.class);
                String fieldGetMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                headers.add(new ExcelHeader(er.title(), er.order(), er.required(), er.pattern(), fieldGetMethodName));
            }
        }
        return headers;
    }

    private Map<Integer, String> getHeaderMap(Row titleRow, Class clz) {
        List<ExcelHeader> headers = getHeaderList(clz);
        Map<Integer, String> maps = new HashMap<Integer, String>();
        for (Cell c : titleRow) {
            String title = c.getStringCellValue();
            for (ExcelHeader eh : headers) {
                if (eh.getTitle().equals(title.trim())) {
                    maps.put(c.getColumnIndex(), eh.getMethodName().replace("get", "set"));
                    break;
                }
            }
        }
        return maps;
    }
}