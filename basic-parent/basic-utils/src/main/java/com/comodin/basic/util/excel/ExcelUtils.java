package com.comodin.basic.util.excel;

import com.comodin.basic.exception.UploadDataErrorException;
import com.comodin.basic.util.reflect.MyBeanUtils;
import com.comodin.basic.util.validator.HibernateValidatorUtils;
import com.comodin.basic.validation.constraints.ValidDateTimeFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@SuppressWarnings({"Convert2Diamond", "unused", "Duplicates", "WeakerAccess", "InfiniteRecursion", "TypeParameterHidesVisibleType"})
public class ExcelUtils {
    private static Logger log = Logger.getLogger(ExcelUtils.class);
    private static ExcelUtils instance = new ExcelUtils();

    private ExcelUtils() {
    }

    public static ExcelUtils getInstance() {
        return instance;
    }

    /**
     * 设定：excelSheet名；若为空，即会选择 下标为0的工作表。 默认调用 workbook.getSheetAt(0);
     */
    private String sheetName = "";
    private Class<?>[] validGroups;

    /**
     * 标题，初始化参数 1、设定，标题行，所在的位置，默认值为1，代表标题设置excel第1行 【只有为正整数】
     * 标题，初始化参数 2、设定，标题列，开始的位置，默认值为1，代表标题设置excel第1列 【只有为正整数】
     * 标题，初始化参数 3、设定，标题列，结束的位置，默认为0，不做限制 【只有为正整数】
     * 标题，初始化参数 4、设定，标题列，最大的位置，默认为0，不做限制 【只有为正整数】
     * 标题，初始化参数 5、设定，是否校验标题顺序，默认为：false，代表不校验；true 代表强制检查其数据的顺序
     */
    private static final int TITLE_ROW_POSITIONS_DEFAULT_1 = 1;
    private static final int TITLE_COLUMN_START_POSITIONS_DEFAULT_1 = 1;
    private static final int TITLE_COLUMN_END_POSITIONS_DEFAULT_0 = 0;
    private static final int TITLE_COLUMN_MAX_POSITIONS_DEFAULT_0 = 0;
    private static final boolean TITLE_ORDER_DEFAULT_FALSE = false;
    private int titleRowPositions = TITLE_ROW_POSITIONS_DEFAULT_1;
    private int titleColumnStartPositions = TITLE_COLUMN_START_POSITIONS_DEFAULT_1;
    private int titleColumnEndPositions = TITLE_COLUMN_END_POSITIONS_DEFAULT_0;
    private int titleColumnMaxPositions = TITLE_COLUMN_MAX_POSITIONS_DEFAULT_0;
    @SuppressWarnings("FieldCanBeLocal")
    private boolean titleOrder = TITLE_ORDER_DEFAULT_FALSE;

    /**
     * 数据区域，初始化参数 1、设定，行，开始读取的位置，默认为2，代表从excel第2行开始读取 【只有为正整数】
     * 数据区域，初始化参数 2、设定，行，结束读取的位置，默认为0，为最后一行（索引值=0，用负数来表示倒数第n行）
     * 数据区域，初始化参数 3、设定，行，最大读取的位置，默认为0，代表不设置限制； 【只有为正整数】
     */
    private final int DATA_ROW_START_POSITIONS_DEFAULT_2 = 2;
    private final int DATA_ROW_END_POSITIONS_DEFAULT_0 = 0;
    private final int DATA_ROW_MAX_POSITIONS_DEFAULT_0 = 0;
    private int dataRowStartPositions = DATA_ROW_START_POSITIONS_DEFAULT_2;
    private int dataRowEndPositions = DATA_ROW_END_POSITIONS_DEFAULT_0;
    private int dataRowMaxPositions = DATA_ROW_MAX_POSITIONS_DEFAULT_0;

    /**
     * 数据区域，初始化参数 1、设定，每行列，开始读取的位置，默认为1，代表从excel第1列开始读取 【只有为正整数】
     * 数据区域，初始化参数 2、设定，每行列，结束读取的位置，默认为0，代表不设置限制 【只有为正整数】
     * 数据区域，初始化参数 3、设定，每行列，最大读取的位置，默认为0，代表不设置限制； 【只有为正整数】
     */
    private final int DATA_COLUMN_START_POSITIONS_DEFAULT_1 = 1;
    private final int DATA_COLUMN_END_POSITIONS_DEFAULT_0 = 0;
    private final int DATA_COLUMN_MAX_POSITIONS_DEFAULT_0 = 0;
    private int dataColumnStartPositions = DATA_COLUMN_START_POSITIONS_DEFAULT_1;
    private int dataColumnEndPositions = DATA_COLUMN_END_POSITIONS_DEFAULT_0;
    private int dataColumnMaxPositions = DATA_COLUMN_MAX_POSITIONS_DEFAULT_0;

    private String recordExcelAddressColumnProperty;

    /**
     * 装换失败的数据信息，记录行数
     */
    private StringBuffer error = new StringBuffer(0);

    /**
     * @return true 存在错误，false 不存在错误
     */
    @SuppressWarnings("WeakerAccess")
    public boolean hasError() {
        return error.capacity() > 0;
    }

    public StringBuffer getError() {
        return error;
    }


    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    // 以下，导出对象到Excel，基于模板方式 // by:supeng date:2017-8-10 17:00:56
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到流
     *
     * @param replaceFinalDataMap 模板中的替换的常量数据
     * @param templatePath        模板路径
     * @param outputStream        输出流
     * @param beanList            对象列表
     * @param tClass              对象的类型
     * @param isClassPath         模板是否在classPath路径下
     */
    public <T> void exportBeanList2ExcelByTemplate(Map<String, String> replaceFinalDataMap, String templatePath, OutputStream outputStream, List<T> beanList, Class<?> tClass, boolean isClassPath) {
        ExcelTemplate et = handlerBeanList2Excel(templatePath, beanList, tClass, isClassPath);
        et.replaceFinalData(replaceFinalDataMap);
        et.writeToStream(outputStream);
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    // 以下，导出对象到Excel，基于模板方式 // by:supeng date:2017-8-10 17:00:56
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到流
     *
     * @param replaceFinalDataMap 模板中的替换的常量数据
     * @param templatePath        模板路径
     * @param outputStream        输出流
     * @param beanList            对象列表
     * @param tClass              对象的类型
     * @param isClassPath         模板是否在classPath路径下
     *
     */
    public <T> void exportBeanList3ExcelByTemplate(Map<String, String> replaceFinalDataMap, String templatePath, OutputStream outputStream, List<T> beanList, Class<?> tClass, boolean isClassPath) {
        ExcelTemplate et = handlerBeanList3Excel(templatePath, beanList, tClass, isClassPath);
        et.replaceFinalData(replaceFinalDataMap);
        et.writeToStream(outputStream);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到一个具体的路径中
     *
     * @param replaceFinalDataMap 模板中的替换的常量数据
     * @param templatePath        模板路径
     * @param outPath             输出路径
     * @param beanList            对象列表
     * @param tClass              对象的类型
     * @param isClassPath         模板是否在classPath路径下
     */
    public <T> void exportBeanList2ExcelByTemplate(Map<String, String> replaceFinalDataMap, String templatePath, String outPath, List<T> beanList, Class<?> tClass, boolean isClassPath) {
        ExcelTemplate et = handlerBeanList2Excel(templatePath, beanList, tClass, isClassPath);
        et.replaceFinalData(replaceFinalDataMap);
        et.writeToFile(outPath);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到流,基于Properties作为常量数据
     *
     * @param properties   基于Properties的常量数据模型
     * @param templatePath 模板路径
     * @param outputStream 输出流
     * @param beanList     对象列表
     * @param tClass       对象的类型
     * @param isClassPath  模板是否在classPath路径下
     */
    public <T> void exportBeanList2ExcelByTemplate(Properties properties, String templatePath, OutputStream outputStream, List<T> beanList, Class<?> tClass, boolean isClassPath) {
        ExcelTemplate et = handlerBeanList2Excel(templatePath, beanList, tClass, isClassPath);
        et.replaceFinalData(properties);
        et.writeToStream(outputStream);
    }

    /**
     * 将对象转换为Excel并且导出，该方法是基于模板的导出，导出到一个具体的路径中,基于Properties作为常量数据
     *
     * @param properties   基于Properties的常量数据模型
     * @param templatePath 模板路径
     * @param outPath      输出路径
     * @param beanList     对象列表
     * @param tClass       对象的类型
     * @param isClassPath  模板是否在classPath路径下
     */
    public <T> void exportBeanList2ExcelByTemplate(Properties properties, String templatePath, String outPath, List<T> beanList, Class<?> tClass, boolean isClassPath) {
        ExcelTemplate et = handlerBeanList2Excel(templatePath, beanList, tClass, isClassPath);
        et.replaceFinalData(properties);
        et.writeToFile(outPath);
    }

    /**
     * 处理对象转换为Excel
     *
     * @param templatePath //模版路径
     * @param beanList     bean对象列表
     * @param tClass       bean对象列表 中的Class
     * @param isClassPath  是绝对路径，还是相对路径，模版
     *
     * @return //
     */
    private <T> ExcelTemplate handlerBeanList2Excel(final String templatePath, final List<T> beanList, final Class<?> tClass, final boolean isClassPath) {
        ExcelTemplate et = ExcelTemplate.getInstance();

        try {
            if (isClassPath) {
                et.readTemplateByClasspath(templatePath);
            } else {
                et.readTemplateByPath(templatePath);
            }
            List<ExcelHeader> headers = getHeaderList(tClass);
            Collections.sort(headers);

            ////输出标题
            //et.createNewRow();
            //for (ExcelHeader eh : headers) {
            //    et.createCell(eh.getTitle());
            //}

            //输出值
            for (T t : beanList) {
                et.createNewRow();
                for (ExcelHeader eh : headers) {
                    String propertyValue = BeanUtils.getProperty(t, eh.getPropertyName());

                    et.createCell(propertyValue);
                    //if (log.isDebugEnabled()) {
                    //    log.info("output bean info: beanPropertyName: " + eh.getPropertyName() + " beanPropertyValue: " + propertyValue + " excelTitle: " + eh.getTitle());
                    //}
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("output bean BeanUtils.getProperty(t, eh.getPropertyName()) error ", e);
        }
        return et;
    }

    /**
     * 处理对象转换为Excel
     *
     * @param templatePath //模版路径
     * @param beanList     bean对象列表
     * @param tClass       bean对象列表 中的Class
     * @param isClassPath  是绝对路径，还是相对路径，模版
     *
     * @return //
     */
    private <T> ExcelTemplate handlerBeanList3Excel(final String templatePath, final List<T> beanList, final Class<?> tClass, final boolean isClassPath) {
        ExcelTemplate et = ExcelTemplate.getInstance();

        try {
            if (isClassPath) {
                et.readTemplateByClasspath(templatePath);
            } else {
                et.readTemplateByPath(templatePath);
            }
            List<ExcelHeader> headers = getHeaderList(tClass);
            Collections.sort(headers);

            ////输出标题
            //et.createNewRow();
            //for (ExcelHeader eh : headers) {
            //    et.createCell(eh.getTitle());
            //}

            //输出值
            for (T t : beanList) {
                et.createNewRow();
                for (ExcelHeader eh : headers) {
                    String propertyName = eh.getPropertyName();
                    String propertyValue = BeanUtils.getProperty(t, propertyName);
                    Cell cell = et.createCell(propertyValue);

                    CellBean cellBean = new CellBean(propertyName,propertyValue,cell);
                    CellStyle style = getStyle(cellBean);
                    if (style != null) {
                        cell.setCellStyle(style);
                    }

                    //if (log.isDebugEnabled()) {
                    //    log.info("output bean info: beanPropertyName: " + eh.getPropertyName() + " beanPropertyValue: " + propertyValue + " excelTitle: " + eh.getTitle());
                    //}
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("output bean BeanUtils.getProperty(t, eh.getPropertyName()) error ", e);
        }
        return et;
    }

    private static CellStyle getStyle(CellBean cellBean){
        String propertyName = cellBean.getPropertyName();
        if(propertyName.equals("serviceLevel")){//若是遇到serviceLevel列，则需要判断需不需要高亮
            return getServiceLevelStyle(cellBean);
        }

        return null;
    }

    private static CellStyle getServiceLevelStyle(CellBean cellBean){

        String propertyValue = cellBean.getPropertyValue();
        CellStyle cellStyle = cellBean.getCell().getCellStyle();//获取默认样式
        Workbook workbook = cellBean.getCell().getSheet().getWorkbook();
        if ("DENTRO DE HORARIO".equalsIgnoreCase(propertyValue) || "N/A".equalsIgnoreCase(propertyValue)) {//属于正常，不高亮
            CellStyle newCellStyle = workbook.createCellStyle();
            newCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            newCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            newCellStyle.setBorderBottom(BorderStyle.THIN);
            newCellStyle.setBorderLeft(BorderStyle.THIN);
            newCellStyle.setBorderRight(BorderStyle.THIN);
            newCellStyle.setBorderTop(BorderStyle.THIN);

            return newCellStyle;
        } else {
            //增加背景颜色
            //cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());
            cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return cellStyle;
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    // 以下，导出对象到Excel，不基于模板方式 // by:supeng date:2017-8-10 17:00:56
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    private <T> Workbook handleBeanList2Excel(List<T> beanList, Class<?> tClass, boolean isXSSFWorkbook) {
        Workbook workbook = null;
        try {
            workbook = isXSSFWorkbook ? new XSSFWorkbook() : new HSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);

            List<ExcelHeader> headers = getHeaderList(tClass);
            Collections.sort(headers);

            //写标题
            for (int i = 0; i < headers.size(); i++) {
                row.createCell(i).setCellValue(headers.get(i).getTitle());
            }

            //写数据
            for (int i = 0; i < beanList.size(); i++) {
                row = sheet.createRow(i + 1);
                T t = beanList.get(i);
                for (int j = 0; j < headers.size(); j++) {
                    ExcelHeader excelHeader = headers.get(j);
                    String propertyValue = BeanUtils.getProperty(t, excelHeader.getPropertyName());
                    //r.createCell(j).setCellValue(BeanUtils.getProperty(obj, getMethodName(headers.get(j))));
                    row.createCell(j).setCellValue(propertyValue);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("output bean BeanUtils.getProperty(t, eh.getPropertyName()) error ", e);
        }
        return workbook;
    }

    /**
     * 导出对象到Excel，不是基于模板的，直接新建一个Excel完成导出，基于路径的导出
     *
     * @param outPath        导出路径
     * @param beanList       对象列表
     * @param tClass         对象类型
     * @param isXSSFWorkbook 是否是2007版本
     */
    public <T> void exportBeanList2Excel(String outPath, List<T> beanList, Class<?> tClass, boolean isXSSFWorkbook) {
        Workbook wb = handleBeanList2Excel(beanList, tClass, isXSSFWorkbook);
        try {
            try (FileOutputStream fos = new FileOutputStream(outPath)) {
                wb.write(fos);
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException("写入的文件不存在");
            throw new UploadDataErrorException("-1201", "The written file does not exist. filePath: " + outPath, e.getMessage(), e);
        } catch (IOException e) {
            //throw new RuntimeException("写入数据失败:" + e.getMessage());
            throw new UploadDataErrorException("-1201", "Write data to file failed. filePath: " + outPath, e.getMessage(), e);
        }
    }

    /**
     * 导出对象到Excel，不是基于模板的，直接新建一个Excel完成导出，基于流
     *
     * @param outputStream   输出流
     * @param beanList       对象列表
     * @param tClass         对象类型
     * @param isXSSFWorkbook 是否是2007版本
     */
    public <T> void exportBeanList2Excel(OutputStream outputStream, List<T> beanList, Class<?> tClass, boolean isXSSFWorkbook) {
        try {
            Workbook wb = handleBeanList2Excel(beanList, tClass, isXSSFWorkbook);
            wb.write(outputStream);
        } catch (IOException e) {
            //throw new RuntimeException("写入流失败:" + e.getMessage());
            throw new UploadDataErrorException("-1201", "Write data to Output Stream.", e.getMessage(), e);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    // 以下，读取 Excel到bean // by:supeng date:2017-8-10 17:00:56
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////

    /**
     * 从类路径读取相应的Excel文件到对象列表
     *
     * @param path   路径
     * @param tClass 类型
     *
     * @return 对象列表
     */
    public <T> List<T> readExcel2BeanListByClasspath(String path, Class<T> tClass) {
        String file;
        try {
            file = URLDecoder.decode(ExcelUtils.class.getResource(path).getFile(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //throw new UploadDataErrorException("-1201", "Upload an Excel file that does not exist. FilePath: " + path, e.getMessage(), e);
            throw new UploadDataErrorException("-1201", "Cargar un archivo de Excel que no existe. Ruta de archivo: " + path, e.getMessage(), e);
        }
        return this.readExcel2BeanListByPath(file, tClass);
    }

    /**
     * 从文件路径读取相应的Excel文件到对象列表
     *
     * @param path   路径
     * @param tClass 类型
     *
     * @return 对象列表
     */
    public <T> List<T> readExcel2BeanListByPath(String path, Class<T> tClass) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {//上传Excel文件，不存在. filePath:
            //throw new UploadDataErrorException("-1201", "Upload an Excel file that does not exist. FilePath: " + path, e.getMessage(), e);
            throw new UploadDataErrorException("-1201", "Cargar un archivo de Excel que no existe. Ruta de archivo: " + path, e.getMessage(), e);
        }
        return this.readExcel2BeanListByInputStream(fileInputStream, tClass);
    }

    /**
     * 从类路径读取相应的Excel文件到对象列表
     *
     * @param inputStream 类路径下的path
     * @param tClass      对象类型
     *
     * @return // List<tClass>
     */
    public <T> List<T> readExcel2BeanListByInputStream(InputStream inputStream, Class<T> tClass) {
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException | InvalidFormatException e) {//上传文件无效Excel文件或已损坏。 请检查是否正常打开.
            //throw new UploadDataErrorException("-1201", "The upload file is not valid Excel files or corrupted. Please check whether the normal open.", e);
            throw new UploadDataErrorException("-1201", "El archivo de subida es archivos de Excel no válidos o dañado. Por favor, compruebe si el normalmente abierto.", e);
        }
        if (workbook.getNumberOfSheets() < 1) {//Excel没有工作表，是一个空文件，请检查.
            //throw new UploadDataErrorException("-1202", "Excel does not have a worksheet, it is an empty file, please check.");
            throw new UploadDataErrorException("-1202", "Excel no tiene una hoja de cálculo, es un archivo vacío, compruebe.");
        }

        this.initConfig(tClass);
        if (this.sheetName == null || "".equals(this.sheetName.trim())) {
            this.sheetName = workbook.getSheetAt(0).getSheetName();
        }

        Sheet workbookSheet = workbook.getSheet(this.sheetName);
        if (workbookSheet == null) {
            //throw new UploadDataErrorException("-1203", String.format("worksheet name: %s not found.", this.sheetName));
            throw new UploadDataErrorException("-1203", String.format("nombre de la hoja: %s no se ha encontrado.", this.sheetName));
        }

        return handlerExcel2Bean(workbookSheet, tClass);
    }

    public <T> List<T> readExcel2BeanListBySheet(final Sheet sheet, final Class<T> tClass) {
        this.initConfig(tClass);
        if (this.sheetName == null || "".equals(this.sheetName.trim())) {
            this.sheetName = sheet.getSheetName();
        }
        if (sheet == null || !sheet.getSheetName().equals(this.sheetName)) {
            throw new UploadDataErrorException("-1203", String.format("nombre de la hoja: %s no se ha encontrado.", this.sheetName));
        }
        return handlerExcel2Bean(sheet, tClass);
    }

    private <T> List<T> handlerExcel2Bean(final Sheet sheet, final Class<T> tClass) {
        List<T> result = new ArrayList<>();
        this.error.setLength(0);

        //1、检查，整个工作表,不能为空
        int sheetRowTotalNumber = sheet.getPhysicalNumberOfRows(); //获取总行数，包含《标题》
        if (sheetRowTotalNumber <= 0) {
            //throw new UploadDataErrorException("-1211", this.getMessageBySheet("The entire worksheet can not be empty"));
            throw new UploadDataErrorException("-1211", this.getMessageBySheet("Toda la hoja no puede estar vacía"));
        }

        Map<Integer, ExcelHeader> excelTitleToPropertyMapping = new HashMap<Integer, ExcelHeader>();
        //2、标题，检查与解析标题数据
        //2.1.1、检查标题位置
        //2.1.1、检查，系统设置,标题行,所在行为第10行,当前Excel总行数4行,请检查.
        //2.1.2、检查，系统设置,标题行,所在行为第10行,数据不能为空，请检查.
        //2.1.3、检查，系统设置,标题行,读取数据的开始列为第10列,当前Excel标题行总列数为:9列,请检查.
        //2.1.4、检查，系统设置,标题行,读取数据的结束列为第20列,当前Excel标题行总列数为:19列,请检查.
        //2.1.5、检查，系统设置,标题行,最大列数为20列,当前Excel标题行总列数为:21列,请检查.
        if (sheetRowTotalNumber < this.titleRowPositions) {
            throw new UploadDataErrorException("-1221", this.getMessageBySheet(
                    //String.format("System settings, the header line, where the behavior of the first %d lines, the current total number of Excel %d lines, please check.", this.titleRowPositions, sheetRowTotalNumber)));
                    String.format("La configuración del sistema, la línea de cabecera, donde el comportamiento de la primera %d líneas, el número total actual de Excel %d líneas, Por favor, compruebe.", this.titleRowPositions, sheetRowTotalNumber)));
        }
        Row titleRow = sheet.getRow((this.titleRowPositions - 1));
        int titleColumnTotalNumber = titleRow.getLastCellNum();
        if (titleColumnTotalNumber <= 0) {
            throw new UploadDataErrorException("-1222", this.getMessageByRow(titleRow,
                    //String.format("System settings, the title line, where the behavior of line %d, the data can not be empty, please check.", this.titleRowPositions)));
                    String.format("La configuración del sistema, la línea del título, donde el comportamiento de la línea %d, los datos no pueden estar vacíos, por favor, compruebe.", this.titleRowPositions)));
        }
        if (titleColumnTotalNumber < this.titleColumnStartPositions) {
            throw new UploadDataErrorException("-1223", this.getMessageByRow(titleRow,
                    //String.format("System settings, header line, read the beginning of the data listed as column %d, the current Excel header line total number of columns: %d, please check.", this.titleColumnStartPositions, titleColumnTotalNumber)));
                    String.format("La configuración del sistema, línea de cabecera, leen el principio de los datos que figuran como columna %d, el número total actual línea de cabecera de las columnas de Excel: %d, Por favor, compruebe.", this.titleColumnStartPositions, titleColumnTotalNumber)));
        }
        if (this.titleColumnEndPositions != TITLE_COLUMN_END_POSITIONS_DEFAULT_0 && titleColumnTotalNumber < this.titleColumnEndPositions) {
            throw new UploadDataErrorException("-1224", this.getMessageByRow(titleRow,
                    //String.format("System settings, the header line, the end of the read data as the first %d columns, the current Excel header line total number of columns: %d columns, please check.", this.titleColumnEndPositions, titleColumnTotalNumber)));
                    String.format("La configuración del sistema, la línea de cabecera, al final de los datos de lectura como la primera %d columnas, el número total actual línea de cabecera de las columnas de Excel: %d columns, Por favor, compruebe.", this.titleColumnEndPositions, titleColumnTotalNumber)));
        }
        if (this.titleColumnMaxPositions != TITLE_COLUMN_MAX_POSITIONS_DEFAULT_0 && titleColumnTotalNumber > this.titleColumnMaxPositions) {
            throw new UploadDataErrorException("-1225", this.getMessageByRow(titleRow,
                    //String.format("System settings, the header row, the maximum number of columns for the %d columns, the current Excel header line total number of columns: %d columns, please check.", this.titleColumnMaxPositions, titleColumnTotalNumber)));
                    String.format("La configuración del sistema, la fila de encabezado, el número máximo de columnas para el %d columnas, el número total actual línea de cabecera de las columnas de Excel: %d columnas, Por favor, compruebe.", this.titleColumnMaxPositions, titleColumnTotalNumber)));
        }
        //2.2、提出javaBean配置的注解@ExcelResources所对应的标题——>在Excel对应对应标题的列索引
        //2.2.1、提出javaBean配置的注解@ExcelResources所对应的标题
        List<ExcelHeader> headerList = this.getHeaderList(tClass);
        //2.2.2、计算出，标题列开始读取的位置和结束位置；遍历Excel标题列；组装JavaBean的标题与在Excel对应对应标题的列索引
        int titleReadColumnStartPositions = this.titleColumnStartPositions;
        int titleReadColumnEndPositions = this.titleColumnEndPositions != TITLE_COLUMN_END_POSITIONS_DEFAULT_0 ? this.titleColumnEndPositions : titleColumnTotalNumber;
        if (log.isDebugEnabled()) {
            log.info("title --> excelColumnIndex ---> property ---> propertyType");
        }

        for (int i = titleReadColumnStartPositions; i <= titleReadColumnEndPositions; i++) {
            Cell currentTitleCell = titleRow.getCell((i - 1));
            for (ExcelHeader excelHeader : headerList) {
                if (excelHeader.getTitle().equals(currentTitleCell.toString())) {
                    excelTitleToPropertyMapping.put(currentTitleCell.getColumnIndex(), excelHeader);
                    if (log.isDebugEnabled()) {
                        log.info(String.format("%s ---> %d ---> %s ---> %s", excelHeader.getTitle(), currentTitleCell.getColumnIndex(), excelHeader.getPropertyName(), excelHeader.getPropertyType()));
                    }
                    break;
                }
            }
        }
        //2.3、检查，Excel中的标题信息与JavaBean属性配置的注解@ExcelResources(title) 数量是否一致；
        if (excelTitleToPropertyMapping.isEmpty() || excelTitleToPropertyMapping.size() != headerList.size()) {
            throw new UploadDataErrorException("-1226", this.getMessageByRow(this.titleRowPositions,//系统设置,Excel标题名必需含有[],请检查.
                    //String.format("System settings, Excel title name must contain %s, please check.", headerList.stream().map(ExcelHeader::getTitle).collect(Collectors.toList()).toString())));
                    String.format("La configuración del sistema, Excel nombre del título debe contener %s, por favor consulte.", headerList.stream().map(ExcelHeader::getTitle).collect(Collectors.toList()).toString())));
        }

        //3、检查数据区域
        //3.1.、检查数据区域
        //3.1.1、检查，系统设置,数据区域,读取数据的开始行为:102行,当前Excel总行数为:101行,请检查.
        //3.1.1、检查，系统设置,数据区域,读取数据的开始行为:102行,当前Excel总行数为:101行,数据为空，请检查.
        //3.1.3、检查，系统设置,数据区域,读取数据的开始行为:102行,当前Excel总行数为:200行,已限定数据行数不能少于100行,请检查.
        //3.1.4、检查，系统设置,数据区域,读取数据的开始行为:102行,当前Excel总行数为:400行,已限定数据区域每次最大处理行数为:300行,请分批再重试.
        if (sheetRowTotalNumber < this.dataRowStartPositions) {
            //throw new UploadDataErrorException("-1231", this.getMessageBySheet(String.format("System settings, data area, read the beginning of the data: %d lines, the current number of Excel total line: %d lines, please check.", this.dataRowStartPositions, sheetRowTotalNumber)));
            throw new UploadDataErrorException("-1231", this.getMessageBySheet(String.format("La configuración del sistema, área de datos, leen el principio de los datos: %d líneas, el número actual de la línea total de Excel: %d líneas, Por favor, compruebe.", this.dataRowStartPositions, sheetRowTotalNumber)));
        }
        int dataAreaTotalRowNumber = sheetRowTotalNumber - ((this.dataRowStartPositions - 1) + Math.abs(this.dataRowEndPositions));
        if (dataAreaTotalRowNumber <= 0) {
            //throw new UploadDataErrorException("-1232", this.getMessageBySheet(String.format("System settings, data area, read the beginning of the data: %d lines, the current number of Excel total line: %d lines, limited number of rows can not be less than %d lines, please check.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowEndPositions)));
            throw new UploadDataErrorException("-1232", this.getMessageBySheet(String.format("La configuración del sistema, área de datos, leen el principio de los datos: %d líneas, el número actual de la línea total de Excel: %d líneas, número limitado de filas no puede ser inferior a %d líneas, Por favor, compruebe.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowEndPositions)));
        }
        if (this.dataRowEndPositions != DATA_ROW_END_POSITIONS_DEFAULT_0 && dataAreaTotalRowNumber < this.dataRowEndPositions) {
            //throw new UploadDataErrorException("-1233", this.getMessageBySheet(String.format("System settings, data area, read the beginning of the data: %d lines, the current number of Excel total line: %d lines, limited number of rows can not be less than %d lines, please check.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowEndPositions)));
            throw new UploadDataErrorException("-1233", this.getMessageBySheet(String.format("La configuración del sistema, área de datos, leen el principio de los datos: %d líneas, el número actual de la línea total de Excel: %d líneas, número limitado de filas no puede ser inferior a %d líneas, Por favor, compruebe.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowEndPositions)));
        }
        if (this.dataRowMaxPositions != this.DATA_ROW_MAX_POSITIONS_DEFAULT_0 && dataAreaTotalRowNumber > this.dataRowMaxPositions) {
            //throw new UploadDataErrorException("-1234", this.getMessageBySheet(String.format("System settings, data area, read the beginning of the data: %d lines, the current total number of Excel lines: %d lines, has been limited to the maximum number of data processing area per line: %d lines, please try again in batches.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowMaxPositions)));
            throw new UploadDataErrorException("-1234", this.getMessageBySheet(String.format("La configuración del sistema, área de datos, leen el principio de los datos: %d líneas, el número actual de la línea total de Excel: %d líneas, se ha limitado a la cantidad máxima de área de procesamiento de datos por línea: %d líneas, Por favor, inténtelo de nuevo en lotes.", this.dataRowStartPositions, sheetRowTotalNumber, this.dataRowMaxPositions)));
        }

        //4、遍历，数据区域，每行每列的数据；
        //4.1、检查每一行数据的列，系统设置
        //4.2、组装到List<Bean>集合中
        //计算出，数据区域行数，开始读取的位置，和结束位置
        int dataReadRowStartPositions = this.dataRowStartPositions;
        int dataReadRowEndPositions = dataAreaTotalRowNumber + this.dataRowStartPositions;
        for (int i = dataReadRowStartPositions; i < dataReadRowEndPositions; i++) {
            Row currentDataRow = sheet.getRow((i - 1));
            short currentDataRowColumnTotalNumber = currentDataRow.getLastCellNum();

            //1.1、数据区域,当前Excel列数为:0列,无效数据,请检查.
            //1.2、系统设置,数据区域,每行读取列的开始列数为:10列,当前Excel列数为:9列,请检查.
            //1.3、系统设置,数据区域,每行读取列的结束列数为:10列,当前Excel列数为:9列,请检查.
            //1.4、系统设置,数据区域,每行读取列的最大列数为:10列,当前Excel列数为:9列,请检查.
            if (currentDataRowColumnTotalNumber <= 0) {
                //throw new UploadDataErrorException("-1241", this.getMessageByRow(currentDataRow, String.format("Data area, the current number of Excel columns: %d column, invalid data, please check.", currentDataRowColumnTotalNumber)));
                throw new UploadDataErrorException("-1241", this.getMessageByRow(currentDataRow, String.format("Área de datos, el número actual de columnas de Excel: %d la columna, los datos no válidos, por favor, compruebe.", currentDataRowColumnTotalNumber)));
            }
            if (currentDataRowColumnTotalNumber < this.dataRowStartPositions) {
                //throw new UploadDataErrorException("-1242", this.getMessageByRow(currentDataRow, String.format("System settings, data area, the number of columns for each row to read the column: %d columns, the current number of Excel columns: %d, please check.", this.dataRowStartPositions, currentDataRowColumnTotalNumber)));
                throw new UploadDataErrorException("-1242", this.getMessageByRow(currentDataRow, String.format("La configuración del sistema, el área de datos, el número de columnas para cada fila para leer la columna: %d columnas, el número actual de columnas de Excel: %d, Por favor, compruebe.", this.dataRowStartPositions, currentDataRowColumnTotalNumber)));
            }
            if (this.dataColumnEndPositions != DATA_COLUMN_END_POSITIONS_DEFAULT_0 && currentDataRowColumnTotalNumber < this.dataColumnEndPositions) {
                //throw new UploadDataErrorException("-1243", this.getMessageByRow(currentDataRow, String.format("System settings, data area, the number of rows per column to read the column: %d, the current number of Excel columns: %d, please check.", this.dataColumnEndPositions, currentDataRowColumnTotalNumber)));
                throw new UploadDataErrorException("-1243", this.getMessageByRow(currentDataRow, String.format("La configuración del sistema, el área de datos, el número de filas por la columna de leer la columna: %d, el número actual de columnas de Excel: %d, Por favor, compruebe.", this.dataColumnEndPositions, currentDataRowColumnTotalNumber)));
            }
            if (this.dataColumnMaxPositions != this.DATA_COLUMN_MAX_POSITIONS_DEFAULT_0 && currentDataRowColumnTotalNumber > this.dataColumnMaxPositions) {
                //throw new UploadDataErrorException("-1244", this.getMessageByRow(currentDataRow, String.format("System settings, data area, the maximum number of rows per row to read the column: %d columns, the current number of Excel columns: %d, please check.", this.dataColumnMaxPositions, currentDataRowColumnTotalNumber)));
                throw new UploadDataErrorException("-1244", this.getMessageByRow(currentDataRow, String.format("La configuración del sistema, el área de datos, el número máximo de filas por fila para leer la columna: %d columnas, el número actual de columnas de Excel: %d, Por favor, compruebe.", this.dataColumnMaxPositions, currentDataRowColumnTotalNumber)));
            }

            //4.2、组装到List<Bean>集合中
            try {
                T instance = tClass.newInstance();

                //4.2.1、计算出，数据区域 列，开始读取的位置，和结束位置
                int dataReadColumnStartPositions = this.dataColumnStartPositions;
                int dataReadColumnEndPositions = this.dataColumnEndPositions != DATA_COLUMN_END_POSITIONS_DEFAULT_0 ? this.dataColumnEndPositions : currentDataRowColumnTotalNumber;
                for (int j = dataReadColumnStartPositions; j <= dataReadColumnEndPositions; j++) {
                    int columnIndex = j - 1;
                    //遍历、每一个单元格，对应的Excel列下标索引引对应的标题与ExcelTitleToPropertyMapping关系，如果不存在，代表该列不是bean是所需要的数据，即直接过滤真是
                    ExcelHeader currentColumnToExcelHeader = excelTitleToPropertyMapping.get(columnIndex);
                    if (currentColumnToExcelHeader == null) {
                        continue;
                    }

                    //解析单元格原始数据，并根据 单元格数据的类型，与JavaBean对应字段的数据类型，进行分析判断。若无法进行数据类型交换，抛出异常.
                    Cell cell = currentDataRow.getCell(columnIndex);
                    if (cell != null) {
                        Object cellValue = this.validateCellValueDataType(this.getCellValue(cell), currentColumnToExcelHeader, cell);
                        MyBeanUtils.copyProperty(instance, currentColumnToExcelHeader.getPropertyName(), cellValue);
                    }

                    Class<?>[] validGroups = (currentColumnToExcelHeader.getValidGroups() != null && currentColumnToExcelHeader.getValidGroups().length >= 1) ? currentColumnToExcelHeader.getValidGroups() : this.validGroups;
                    Map<String, String> validatePropertyValueErrorMessageMap = HibernateValidatorUtils.getInstance().validateProperty(instance, currentColumnToExcelHeader.getPropertyName(), validGroups);
                    if (!validatePropertyValueErrorMessageMap.isEmpty()) {
                        for (String validateValueErrorMessage : validatePropertyValueErrorMessageMap.values()) {
                            String infoError = this.getMessageByRowColumn(i, currentColumnToExcelHeader.getTitle(), validateValueErrorMessage);
                            this.error.append("\n").append(infoError);
                            log.debug(infoError);
                        }
                        ValidExcelRepeat.Validator.clear();
                        throw new UploadDataErrorException(currentColumnToExcelHeader.getErrorCode(), this.getError().toString());
                    }
                }

                if (StringUtils.isNotBlank(this.recordExcelAddressColumnProperty)) {
                    MyBeanUtils.copyProperty(instance, this.recordExcelAddressColumnProperty, (currentDataRow.getRowNum() + 1));
                }

                //此处逻辑是，针对 class是否增加了注解 ValidExcelMultipleIf，即代表多字段多条件进行判断，要么全部为空，要么全部不为空.
                if (tClass.isAnnotationPresent(ValidExcelMultipleIf.class)) {
                    //Map[propertyName,Map[violationAnnotationSimpleName,message]]
                    Map<String, Map<String, String>> stringMapMap = HibernateValidatorUtils.getInstance().validateBean(instance, tClass.getAnnotation(ValidExcelMultipleIf.class).groups());
                    stringMapMap.forEach((propertyName, stringStringMap) -> stringStringMap.forEach((violationAnnotationSimpleName, message) -> {
                        if (ValidExcelMultipleIf.class.getSimpleName().equals(violationAnnotationSimpleName)) {
                            ValidExcelRepeat.Validator.clear();
                            throw new UploadDataErrorException(instance.getClass().getAnnotation(ValidExcelMultipleIf.class).errorCode(), message);
                        }
                    }));
                }

                result.add(instance);
            } catch (InstantiationException | IllegalAccessException e) {
                if (log.isDebugEnabled()) {
                    log.error(String.format("instance bean: %s failed", tClass.getTypeName()), e);
                }
                //} catch (Exception e) {
                //    throw new UploadDataErrorException("-1", "unknown error.", String.format("handle excel fail. %s", e.getMessage()), e);
            }
        }
        if (log.isDebugEnabled()) {
            log.debug("<<<<< Conversion is complete " + (this.hasError() ? "Error message" : "") + "，Total objects:" + result.size() + "A" + ">>>>>>");
        }
        ValidExcelRepeat.Validator.clear();
        return result;
    }

    private <T> Object validateCellValueDataType(final Object cellValue, final ExcelHeader excelHeader, Cell cell) {
        if (cellValue == null) {
            return null;
        }
        //如果Excel数据的类型，与bean 字段声明的数据类型是否一致。 相同，即直接返回excel的数据，不一致，根据Bean字段声明的数据类型，进行转换
        String excelDateType = cellValue.getClass().getTypeName();
        if (excelDateType.equals(excelHeader.getPropertyTypeName())) {
            return cellValue;
        }
        if (!excelDateType.equals(excelHeader.getPropertyTypeName())) {
            if (Date.class.getTypeName().equals(excelHeader.getPropertyTypeName())) {
                if (!validDate(cellValue, excelHeader.getPattern())) {
                    throw new UploadDataErrorException(excelHeader.getErrorCode(),
                            this.getMessageByRowColumn(cell, String.format("Hora no válida o error de formato de fecha. patrón: %s valor actual: %s", excelHeader.getPattern(), cellValue)));
                }
                return objToDate(cellValue, excelHeader.getPattern());
            } else if (Integer.class.getTypeName().equals(excelHeader.getPropertyTypeName())) {
                return Integer.valueOf(String.valueOf(cellValue));
            } else if (String.class.getTypeName().equals(excelHeader.getPropertyTypeName())) {
                if (Date.class.getTypeName().equals(excelDateType)) {
                    if (!validDate(cellValue, excelHeader.getPattern())) {
                        throw new UploadDataErrorException(excelHeader.getErrorCode(),
                                this.getMessageByRowColumn(cell, String.format("Hora no válida o error de formato de fecha. Patrón: %s valor actual: %s", excelHeader.getPattern(), cellValue)));
                    }
                    return dateToStr(cellValue, excelHeader.getPattern());
                } else {
                    return cellValue.toString();
                }
            }
        }
        return cellValue;
    }

    private Object getCellValue(final Cell cell) {
        if (cell == null) {
            return null;
        }
        Object cellValue = null;
        switch (cell.getCellTypeEnum()) {
            case NUMERIC://数字类型【日期也为数字，需要转换】
                if (DateUtil.isCellDateFormatted(cell)) { //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                    cellValue = cell.getDateCellValue();
                } else {// 如果是纯数字
                    // 取得当前Cell的数值 NumberToTextConverter.toText() 已包含，去除科学计算法
                    cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
                }
                break;
            case STRING: //字符串
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN: //
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: //Excel里面的“公式”，可以用cell.getNumericCellValue(); 来获得“结果”，也就是“公式”计算之后的结果
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case ERROR:
                cellValue = String.valueOf(cell.getErrorCellValue());
                break;
            case BLANK:
                break;
            default:
                break;
        }
        return cellValue;
    }

    /**
     * 提取出 bean 对应 excel标题，配置的数据
     *
     * @param tClass //
     *
     * @return //
     */
    private <T> List<ExcelHeader> getHeaderList(final Class<T> tClass) {
        List<ExcelHeader> headers = new ArrayList<ExcelHeader>();

        List<Field> list = new ArrayList<>();
        try {
            T t = tClass.newInstance();
            Field[] fields = t.getClass().getDeclaredFields();
            Collections.addAll(list, fields);
            Field[] superClassFields = t.getClass().getSuperclass().getDeclaredFields();
            Collections.addAll(list, superClassFields);
            //noinspection UnusedAssignment
            t = null;
        } catch (InstantiationException | IllegalAccessException ignored) {
        }

        for (Field field : list) {
            String fieldName = field.getName();
            if (field.isAnnotationPresent(ExcelResources.class)) {
                ExcelResources er = field.getAnnotation(ExcelResources.class);
                ExcelHeader excelHeader = new ExcelHeader(er.title(), er.order(), er.errorCode(), er.pattern(), fieldName, field.getType(), field.getType().getTypeName(), er.validGroups());
                if ("".equals(er.pattern().trim()) && field.isAnnotationPresent(ValidDateTimeFormat.class)) {
                    if (!"".equals(field.getAnnotation(ValidDateTimeFormat.class).pattern().trim())) {
                        excelHeader.setPattern(field.getAnnotation(ValidDateTimeFormat.class).pattern().trim());
                    }
                }
                headers.add(excelHeader);
            }
        }
        return headers;
    }

    /**
     * 根据 javaBean，类上面的注解 @see com.comodin.basic.util.excel.ExcelRootResources
     * 读取使用者，设置的配置参数，来初始化. 若没有该注解，即使用工具类提供的默认，配置参数，来初始化。
     *
     * @param tClass javaBean
     */
    private void initConfig(final Class<?> tClass) {
        if (!tClass.isAnnotationPresent(ExcelRoot.class)) {
            return;
        }

        ExcelRoot tClassExcelRootAnnotation = tClass.getAnnotation(ExcelRoot.class);
        this.validatorExcelRootParameters(tClassExcelRootAnnotation);

        this.sheetName = tClassExcelRootAnnotation.sheetName();
        this.validGroups = tClassExcelRootAnnotation.validGroups();
        this.titleRowPositions = tClassExcelRootAnnotation.titleRowPositions();
        this.titleColumnStartPositions = tClassExcelRootAnnotation.titleColumnStartPositions();
        this.titleColumnEndPositions = tClassExcelRootAnnotation.titleColumnEndPositions();
        this.titleColumnMaxPositions = tClassExcelRootAnnotation.titleColumnMaxPositions();
        this.titleOrder = tClassExcelRootAnnotation.titleOrder();
        this.dataRowStartPositions = tClassExcelRootAnnotation.dataRowStartPositions();
        this.dataRowEndPositions = tClassExcelRootAnnotation.dataRowEndPositions();
        this.dataRowMaxPositions = tClassExcelRootAnnotation.dataRowMaxPositions();
        this.dataColumnStartPositions = tClassExcelRootAnnotation.dataColumnStartPositions();
        this.dataColumnEndPositions = tClassExcelRootAnnotation.dataColumnEndPositions();
        this.dataColumnMaxPositions = tClassExcelRootAnnotation.dataColumnMaxPositions();

        this.recordExcelAddressColumnProperty = tClassExcelRootAnnotation.recordExcelAddressColumnProperty();
    }

    /**
     * //检查，@ExcelRoot 参数，是否属于正常值范围
     *
     * @param tClassAnnotation //
     */
    private void validatorExcelRootParameters(ExcelRoot tClassAnnotation) {
        //1、检查 标题，各参数配置
        if (tClassAnnotation.titleRowPositions() != TITLE_ROW_POSITIONS_DEFAULT_1) {
            if (!validNumber(String.valueOf(tClassAnnotation.titleRowPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.titleRowPositions Can only be a positive integer.");
            }
        }
        if (tClassAnnotation.titleColumnStartPositions() != TITLE_COLUMN_START_POSITIONS_DEFAULT_1) {
            if (!validNumber(String.valueOf(tClassAnnotation.titleColumnStartPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.titleColumnStartPositions Can only be a positive integer.");
            }
        }
        if (tClassAnnotation.titleColumnEndPositions() != TITLE_COLUMN_END_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.titleColumnEndPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.titleColumnEndPositions Can only be a positive integer.");
            }
            if (tClassAnnotation.titleColumnEndPositions() < tClassAnnotation.titleColumnStartPositions()) {
                throw new RuntimeException("@ExcelRootResources.titleColumnEndPositions Can not be less than @ExcelRootResources.titleColumnStartPositions");
            }
            if (tClassAnnotation.titleColumnMaxPositions() != TITLE_COLUMN_MAX_POSITIONS_DEFAULT_0 && tClassAnnotation.titleColumnEndPositions() > tClassAnnotation.titleColumnMaxPositions()) {
                throw new RuntimeException("@ExcelRootResources.titleColumnEndPositions Can not be greater than @ExcelRootResources.titleColumnMaxPositions");
            }
        }
        if (tClassAnnotation.titleColumnMaxPositions() != TITLE_COLUMN_MAX_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.titleColumnMaxPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.titleColumnMaxPositions Can only be a positive integer.");
            }
            if (tClassAnnotation.titleColumnMaxPositions() < tClassAnnotation.titleColumnStartPositions()) {
                throw new RuntimeException("@ExcelRootResources.titleColumnMaxPositions Can not be less than @ExcelRootResources.titleColumnStartPositions");
            }
            if (tClassAnnotation.titleColumnMaxPositions() < tClassAnnotation.titleColumnEndPositions()) {
                throw new RuntimeException("@ExcelRootResources.titleColumnMaxPositions Can not be less than @ExcelRootResources.titleColumnEndPositions");
            }
        }

        //2、检查 数据区域，行参数，各参数配置
        if (tClassAnnotation.dataRowStartPositions() != DATA_ROW_START_POSITIONS_DEFAULT_2) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataRowStartPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.dataRowStartPositions Can only be a positive integer.");
            }
        }
        if (tClassAnnotation.dataRowEndPositions() != DATA_ROW_END_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataRowEndPositions()), "")) {
                throw new RuntimeException("@ExcelRootResources.dataRowEndPositions Not a valid integer.");
            }

            if (tClassAnnotation.dataRowMaxPositions() != DATA_ROW_MAX_POSITIONS_DEFAULT_0 && tClassAnnotation.dataRowEndPositions() > tClassAnnotation.dataRowMaxPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataRowEndPositions Can not be greater than @ExcelRootResources.dataRowMaxPositions");
            }
        }
        if (tClassAnnotation.dataRowMaxPositions() != DATA_ROW_MAX_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataRowMaxPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.dataRowMaxPositions Can only be a positive integer.");
            }
            if (tClassAnnotation.dataRowMaxPositions() < tClassAnnotation.dataRowStartPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataRowMaxPositions Can not be less than @ExcelRootResources.dataRowStartPositions");
            }
            if (tClassAnnotation.dataRowMaxPositions() < tClassAnnotation.dataRowEndPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataRowMaxPositions Can not be less than @ExcelRootResources.dataRowEndPositions");
            }
        }

        //3、检查 数据区域，行参数，各参数配置
        if (tClassAnnotation.dataColumnStartPositions() != DATA_COLUMN_START_POSITIONS_DEFAULT_1) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataColumnStartPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.dataColumnStartPositions Can only be a positive integer.");
            }
        }
        if (tClassAnnotation.dataColumnEndPositions() != DATA_COLUMN_END_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataColumnEndPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.dataColumnEndPositions Can only be a positive integer.");
            }
            if (tClassAnnotation.dataColumnEndPositions() < tClassAnnotation.dataColumnStartPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataColumnEndPositions Can not be less than @ExcelRootResources.dataColumnStartPositions");
            }
            if (tClassAnnotation.dataColumnMaxPositions() != DATA_COLUMN_MAX_POSITIONS_DEFAULT_0 && tClassAnnotation.dataColumnEndPositions() > tClassAnnotation.dataColumnMaxPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataColumnEndPositions Can not be greater than @ExcelRootResources.dataColumnMaxPositions");
            }
        }
        if (tClassAnnotation.dataColumnMaxPositions() != DATA_COLUMN_MAX_POSITIONS_DEFAULT_0) {
            if (!validNumber(String.valueOf(tClassAnnotation.dataColumnMaxPositions()), "+")) {
                throw new RuntimeException("@ExcelRootResources.dataColumnMaxPositions Can only be a positive integer.");
            }
            if (tClassAnnotation.dataColumnMaxPositions() < tClassAnnotation.dataColumnStartPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataColumnMaxPositions Can not be less than @ExcelRootResources.dataColumnStartPositions");
            }
            if (tClassAnnotation.dataColumnMaxPositions() < tClassAnnotation.dataColumnEndPositions()) {
                throw new RuntimeException("@ExcelRootResources.dataColumnMaxPositions Can not be less than @ExcelRootResources.dataColumnEndPositions");
            }
        }
    }

    private String getMessageBySheet(String message) {
        return String.format("hoja de cálculo: %s %s", this.sheetName, message);
    }

    private String getMessageByRow(Row row, String message) {
        return String.format("hoja de cálculo: %s fila: %d dataError: %s", this.sheetName, (row.getRowNum() + 1), message);
    }

    private String getMessageByRow(String rowNumber, String message) {
        return String.format("hoja de cálculo: %s fila: %s dataError: %s", this.sheetName, rowNumber, message);
    }

    private String getMessageByRow(int rowNumber, String message) {
        return String.format("hoja de cálculo: %s fila: %s dataError: %s", this.sheetName, rowNumber, message);
    }

    private String getMessageByColumn(String columnTitleName, String message) {
        return String.format("hoja de cálculo: %s columna: %s dataError: %s", this.sheetName, columnTitleName, message);
    }

    private String getMessageByRowColumn(Cell cell, String message) {
        return String.format("hoja de cálculo: %s ==>célula: %s dataError: %s", this.sheetName, cell.getAddress().toString(), message);
    }

    private String getMessageByRowColumn(String rowNumber, String columnTitleName, String message) {
        return String.format("hoja de cálculo: %s ==>fila: %s ==>columna: %s dataError: %s", this.sheetName, rowNumber, columnTitleName, message);
    }

    private String getMessageByRowColumn(int rowNumber, String columnTitleName, String message) {
        return String.format("hoja de cálculo: %s ==>fila: %d ==>columna: %s dataError: %s", this.sheetName, rowNumber, columnTitleName, message);
    }


    public static <T> String getMessageByRow(T obj, String message) {
        String sheetName = getExcelRootAnnotationSheetName(obj);
        String excelRootRecordExcelAddressColumnProperty = getExcelRootAnnotationRecordExcelAddressColumnProperty(obj);
        String rowNumber = "";
        if (StringUtils.isNotBlank(excelRootRecordExcelAddressColumnProperty)) {
            try {
                rowNumber = BeanUtils.getProperty(obj, excelRootRecordExcelAddressColumnProperty);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                if (log.isDebugEnabled()) {
                    log.debug("ExcelUtils get bean ExcelRoot Annotation RecordExcelAddressColumnProperty value fail.", e);
                }
            }
        }
        return String.format("hoja de cálculo: %s Fila: %s error de datos: %s", sheetName, rowNumber, message);
        //return String.format("worksheet: %s Row: %s dataError: %s", sheetName, rowNumber, message);
    }

    public static <T> String getMessageByRowColumn(T obj, String propertyName, String message) {
        String sheetName = getExcelRootAnnotationSheetName(obj);
        String excelRootRecordExcelAddressColumnProperty = getExcelRootAnnotationRecordExcelAddressColumnProperty(obj);
        String rowNumber = "";
        if (StringUtils.isNotBlank(excelRootRecordExcelAddressColumnProperty)) {
            try {
                rowNumber = BeanUtils.getProperty(obj, excelRootRecordExcelAddressColumnProperty);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                if (log.isDebugEnabled()) {
                    log.debug("ExcelUtils get bean ExcelRoot Annotation RecordExcelAddressColumnProperty value fail.", e);
                }
            }
        }
        String columnTitleName = ExcelUtils.getExcelResourcesTitleByPropertyName(obj, propertyName);

        return getMessageByRowColumn(sheetName, rowNumber, columnTitleName, message);
    }

    public static <T> String getMessageByRowColumn(T obj, Set<String> columnTitleSet, String message) {
        String sheetName = getExcelRootAnnotationSheetName(obj);
        String excelRootRecordExcelAddressColumnProperty = getExcelRootAnnotationRecordExcelAddressColumnProperty(obj);
        String rowNumber = "";
        if (StringUtils.isNotBlank(excelRootRecordExcelAddressColumnProperty)) {
            try {
                rowNumber = BeanUtils.getProperty(obj, excelRootRecordExcelAddressColumnProperty);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                if (log.isDebugEnabled()) {
                    log.debug("ExcelUtils get bean ExcelRoot Annotation RecordExcelAddressColumnProperty value fail.", e);
                }
            }
        }
        String columnTitleName = columnTitleSet.toString();
        return getMessageByRowColumn(sheetName, rowNumber, columnTitleName, message);
    }

    public static String getMessageByRowColumn(String sheetName, String rowNumber, String columnTitleName, String message) {
        return String.format("hoja de cálculo: %s ==>Fila: %s ==>Columna: %s error de datos: %s", sheetName, rowNumber, columnTitleName, message);
        //return String.format("worksheet: %s ==>Row: %s ==>Column: %s dataError: %s", sheetName, rowNumber, columnTitleName, message);
    }

    public static String getMessageByRowColumn(String sheetName, int rowNumber, String columnTitleName, String message) {
        return String.format("hoja de cálculo: %s ==>Fila: %d ==>Columna: %s error de datos: %s", sheetName, rowNumber, columnTitleName, message);
        //return String.format("worksheet: %s ==>Row: %d ==>Column: %s dataError: %s", sheetName, rowNumber, columnTitleName, message);
    }

    /**
     * 检查整数
     *
     * @param num  //
     * @param type "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数 "":整数
     *
     * @return //
     */
    @SuppressWarnings("Duplicates")
    private static boolean validNumber(String num, String type) {
        if (num == null || "".equals(num)) {
            return false;
        }
        String eL = "^-?\\d+$";//整数;
        if (Objects.equals("0+", type)) {
            eL = "^\\d+$";//非负整数
        } else if (Objects.equals("+", type)) {
            eL = "^\\d*[1-9]\\d*$";//正整数
        } else if (Objects.equals("-0", type)) {
            eL = "^((-\\d+)|(0+))$";//非正整数
        } else if (Objects.equals("-", type)) {
            eL = "^-\\d*[1-9]\\d*$";//负整数
        }
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(num);
        return m.matches();
    }

    private static boolean validDate(Object obj, String pattern) {
        boolean isValid = false;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01

            if (Date.class.getTypeName().equals(obj.getClass().getTypeName())) {
                sdf.parse(sdf.format((Date) obj));
            } else if (Long.class.getTypeName().equals(obj.getClass().getTypeName())) {
                sdf.parse(sdf.format(new Date(Long.valueOf(obj.toString()))));
            } else if (String.class.getTypeName().equals(obj.getClass().getTypeName())) {
                sdf.parse(obj.toString());
            } else {
                return false;
            }
            isValid = true;
        } catch (Exception e) {// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
        }
        return isValid;
    }

    private static Date objToDate(Object obj, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01

            if (Date.class.getTypeName().equals(obj.getClass().getTypeName())) {
                return (Date) obj;
            } else if (Long.class.getTypeName().equals(obj.getClass().getTypeName())) {
                return new Date(Long.valueOf(obj.toString()));
            } else if (String.class.getTypeName().equals(obj.getClass().getTypeName())) {
                return sdf.parse(obj.toString());
            } else {
                return null;
            }
        } catch (Exception e) {// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return null;
        }
    }

    private static String dateToStr(Object obj, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            return sdf.format(obj);
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return null;
        }
    }


    public static String getExcelRootAnnotationRecordExcelAddressColumnProperty(Object bean) {
        return getExcelRootAnnotationRecordExcelAddressColumnProperty(bean.getClass());
    }

    public static String getExcelRootAnnotationRecordExcelAddressColumnProperty(Class<?> tClass) {
        ExcelRoot excelRootAnnotation = getExcelRootAnnotation(tClass);
        if (excelRootAnnotation != null) {
            return excelRootAnnotation.recordExcelAddressColumnProperty();
        }
        return null;
    }

    public static String getExcelRootAnnotationSheetName(Object bean) {
        return getExcelRootAnnotationSheetName(bean.getClass());
    }

    public static String getExcelRootAnnotationSheetName(Class<?> tClass) {
        ExcelRoot excelRootAnnotation = getExcelRootAnnotation(tClass);
        if (excelRootAnnotation != null) {
            return excelRootAnnotation.sheetName();
        }
        return null;
    }

    public static ExcelRoot getExcelRootAnnotation(Object bean) {
        return getExcelRootAnnotation(bean.getClass());
    }

    public static ExcelRoot getExcelRootAnnotation(Class<?> tClass) {
        if (tClass.isAnnotationPresent(ExcelRoot.class)) {
            return tClass.getAnnotation(ExcelRoot.class);
        }
        return null;
    }

    public static ExcelResources getExcelResourcesAnnotationByPropertyName(Object bean, String propertyName) {
        return getExcelResourcesAnnotationByPropertyName(bean.getClass(), propertyName);
    }

    public static ExcelResources getExcelResourcesAnnotationByPropertyName(Class<?> tClass, String propertyName) {
        try {
            Field declaredField = tClass.getDeclaredField(propertyName);
            if (declaredField == null) {
                return null;
            }
            if (declaredField.isAnnotationPresent(ExcelResources.class)) {
                return declaredField.getAnnotation(ExcelResources.class);
            }
        } catch (NoSuchFieldException ignored) {
        }
        return null;
    }

    public static String getExcelResourcesTitleByPropertyName(Object bean, String propertyName) {
        return getExcelResourcesTitleByPropertyName(bean.getClass(), propertyName);
    }

    public static String getExcelResourcesTitleByPropertyName(Class<?> tClass, String propertyName) {
        ExcelResources beanFieldExcelResourcesAnnotation = getExcelResourcesAnnotationByPropertyName(tClass, propertyName);
        if (beanFieldExcelResourcesAnnotation != null) {
            return beanFieldExcelResourcesAnnotation.title();
        }
        return null;
    }

    public static String getExcelResourcesErrorCodeByPropertyName(Object bean, String propertyName) {
        return getExcelResourcesErrorCodeByPropertyName(bean.getClass(), propertyName);
    }

    public static String getExcelResourcesErrorCodeByPropertyName(Class<?> tClass, String propertyName) {
        ExcelResources beanFieldExcelResourcesAnnotation = getExcelResourcesAnnotationByPropertyName(tClass, propertyName);
        if (beanFieldExcelResourcesAnnotation != null) {
            return beanFieldExcelResourcesAnnotation.errorCode();
        }
        return null;
    }
}