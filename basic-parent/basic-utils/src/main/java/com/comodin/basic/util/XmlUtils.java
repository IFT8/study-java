package com.comodin.basic.util;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

@SuppressWarnings({"unused", "Duplicates"})
public class XmlUtils {

    private static final String encoding = "UTF-8";

    /**
     * JavaBean转换成xml
     * 默认编码UTF-8
     *
     * @param javaBean //
     *
     * @return //
     */
    public static String jaxbBeanToXml(Object javaBean) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(javaBean.getClass());
        Marshaller marshaller = context.createMarshaller();
        //Marshaller.JAXB_FORMATTED_OUTPUT 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshaller.JAXB_ENCODING xml的编码方式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, XmlUtils.encoding);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(javaBean, stringWriter);
        return stringWriter.toString();
    }

    public static void jaxbBeanToXml(Object javaBean, File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(javaBean.getClass());
        Marshaller marshaller = context.createMarshaller();
        //Marshaller.JAXB_FORMATTED_OUTPUT 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshaller.JAXB_ENCODING xml的编码方式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, XmlUtils.encoding);
        marshaller.marshal(javaBean, file);
    }

    public static void jaxbBeanToXml(Object javaBean, OutputStream outputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(javaBean.getClass());
        Marshaller marshaller = context.createMarshaller();
        //Marshaller.JAXB_FORMATTED_OUTPUT 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //Marshaller.JAXB_ENCODING xml的编码方式
        marshaller.setProperty(Marshaller.JAXB_ENCODING, XmlUtils.encoding);
        marshaller.marshal(javaBean, outputStream);
    }

    /**
     * xml转换成JavaBean
     *
     * @param xmlStr //
     * @param tClass //
     *
     * @return //
     */
    @SuppressWarnings("unchecked")
    public static <T> T jaxbXmlToJavaBean(final String xmlStr, Class<T> tClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new StringReader(xmlStr));
    }

    /**
     * xml转换成JavaBean
     *
     * @param is     //
     * @param tClass //
     *
     * @return //
     */
    @SuppressWarnings("unchecked")
    public static <T> T jaxbXmlToJavaBean(final InputStream is, Class<T> tClass) throws JAXBException, ParserConfigurationException, SAXException {
        try {
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            SAXParserFactory sax = SAXParserFactory.newInstance();
            sax.setNamespaceAware(false);
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(is));
            return (T) unmarshaller.unmarshal(source);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ignored) {
            }
        }
    }


    public static boolean xsdValidate(String schemaFile, String xmlFile) throws SAXException, IOException {
        return xsdValidate(new File(schemaFile), new File(xmlFile));
    }

    public static boolean xsdValidate(File schemaFile, File xmlFile) throws SAXException, IOException {
        return xsdValidate(new FileInputStream(schemaFile), new FileInputStream(xmlFile));
    }

    public static boolean xsdValidate(InputStream schemaFile, InputStream xmlFile) throws SAXException, IOException {
        // 建立schema工厂
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        // 建立验证文档文件对象，利用此文件对象所封装的文件进行schema验证
        //File schemaFile = new File(xsdPath);
        // 利用schema工厂，接收验证文档文件对象生成Schema对象
        Schema schema = schemaFactory.newSchema(new StreamSource(schemaFile));
        // 通过Schema产生针对于此Schema的验证器，利用schemaFile进行验证
        Validator validator = schema.newValidator();
        // 得到验证的数据源
        Source source = new StreamSource(xmlFile);
        // 开始验证，成功输出success.，失败输出fail
        validator.validate(source);
        return true;
    }

}
