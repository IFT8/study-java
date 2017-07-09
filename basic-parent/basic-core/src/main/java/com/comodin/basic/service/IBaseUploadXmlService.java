package com.comodin.basic.service;

import com.comodin.basic.exception.UploadDataErrorException;

import java.io.File;
import java.io.Serializable;

@SuppressWarnings("unused")
public interface IBaseUploadXmlService<XML_BEAN extends Serializable> {
    /**
     * 处理 xml文件业务逻辑入口方法
     * 1、先调用  validateXml
     * 2、将XML解析成 bean 再调用 checkBusinessLogicByXmlDataBean
     * 3、处理自己的业务代码
     *
     * @param xmlFile             xml文件流
     * @param xmlOriginalFilename xml文件原始名字
     *
     * @throws UploadDataErrorException //
     */
    void uploadByXml(final File xmlFile, final String xmlOriginalFilename, final String xmlDataInfoPrefix) throws UploadDataErrorException;

    void validateXml(final File xmlFile, final File schemaFile, final String xmlOriginalFilename, final String xmlDataInfoPrefix) throws UploadDataErrorException;

    XML_BEAN xmlFileToJavaBean(File xmlFile, final String xmlOriginalFilename, final String xmlDataInfoPrefix) throws UploadDataErrorException;

    void checkBusinessLogicByXmlBean(final XML_BEAN xmlBean, final String xmlOriginalFilename, final String xmlDataInfoPrefix) throws UploadDataErrorException;
}
