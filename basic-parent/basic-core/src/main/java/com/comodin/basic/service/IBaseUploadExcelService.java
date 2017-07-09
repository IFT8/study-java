package com.comodin.basic.service;

import com.comodin.basic.exception.UploadDataErrorException;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public interface IBaseUploadExcelService<EXCEL_BEAN extends Serializable> {
    /**
     * 处理 Excel文件业务逻辑入口方法
     * 1、将 excel文件，解析 javaBean
     * 2、对javaBean 进行数据校验
     * 3、处理自己的业务代码
     *
     * @param excelInputStream      excel文件流
     * @param excelOriginalFilename excel文件原始名字
     * @param excelVersion          excel文件版本【此作用于，针对Excel中的数据，进行版本迭代问题】
     *
     * @throws UploadDataErrorException 抛出异常===对外抛出的异常错误代码范围【-100 至 -1000】
     */
    void uploadByExcel(final InputStream excelInputStream, final String excelOriginalFilename, String excelVersion) throws UploadDataErrorException;

    /**
     * 将excelFile保存到服务中【本地/Ftp服务器】
     *
     * @param excelInputStream excel文件流
     *
     * @throws UploadDataErrorException 抛出异常===对外抛出的异常错误代码范围【-1101 至 -1200】
     */
    @SuppressWarnings("UnusedReturnValue")
    String saveExcelFile(final InputStream excelInputStream) throws UploadDataErrorException;

    /**
     * 将 excelFile 解析成javaBean
     *
     * @param excelInputStream excel文件流
     *
     * @return 返回 被解析成的javaBean List集合
     *
     * @throws UploadDataErrorException 抛出异常===对外抛出的异常错误代码范围【-1201 至 -1300】
     */
    List<EXCEL_BEAN> dataAnalysisToJavaBeanByExcelInputStream(final InputStream excelInputStream) throws UploadDataErrorException;

    /**
     * 对 解释完之后的javaBean List集合进行数据检验
     *
     * @param excelBeanList 被解析成的javaBean List集合
     *
     * @throws UploadDataErrorException 抛出异常===对外抛出的异常错误代码范围【-1301 至 -1500】
     */
    void dataValidateByExcelBean(final List<EXCEL_BEAN> excelBeanList) throws UploadDataErrorException;
}