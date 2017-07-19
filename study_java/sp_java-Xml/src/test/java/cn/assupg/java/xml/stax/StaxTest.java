package cn.assupg.java.xml.stax;

import org.testng.annotations.Test;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by supeng on 11/16/2016.
 */
public class StaxTest {

    /**
     * stax原理，是基于光标，而不是将整个xml文件读到内在中 javax.xml.stream.XMLStreamReader 通过工厂 XMLInputFactory来进行读取
     * 测试，每种节点类型
     */
    @Test
    public void testName001() throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) { //开始节点
                    System.out.println(reader.getName());
                } else if (type == XMLStreamConstants.CHARACTERS) { //文本节点
                    System.out.println(reader.getText().trim());
                } else if (type == XMLStreamConstants.END_ELEMENT) { //结束节点
                    System.out.println("/" + reader.getName());
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * stax原理，是基于光标，而不是将整个xml文件读到内在中 javax.xml.stream.XMLStreamReader 通过工厂 XMLInputFactory来进行读取
     * 输入，节点 book  第一个属性名 和 属性值
     *
     * @throws Exception
     */
    @Test
    public void testName002() throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) { //开始节点
                    String name = reader.getName().toString();
                    if ("book".equals(name)) {
                        String attributeName = reader.getAttributeName(0).toString();
                        String attributeValue = reader.getAttributeValue(0);
                        System.out.println(attributeName + ":" + attributeValue);
                    }
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * stax原理，是基于光标，而不是将整个xml文件读到内在中 javax.xml.stream.XMLStreamReader 通过工厂 XMLInputFactory来进行读取
     * 输出： 每本书名 和 价格
     *
     * @throws Exception
     */
    @Test
    public void testName003() throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) { //开始节点
                    String name = reader.getName().toString();
                    if ("title".equals(name)) {
                        System.out.print(reader.getElementText() + ":");
                    }
                    if ("price".equals(name)) {
                        System.out.print(reader.getElementText() + "\n");
                    }
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 基于迭代模型的查找
     * 这种是，从头到尾，进行逐个迭代。 应该使用，过滤器
     *
     * @throws Exception
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void testName004() throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");

            //基于迭代模型的查找
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(inputStream);

            int number = 0;
            while (reader.hasNext()) {
                //通过 XMLEventReader 来获取是否是某种节点类型
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {

                    //通过  event.asXXX转换节点
                    String name = event.asStartElement().getName().toString();
                    if ("title".equals(name)) {
                        System.out.print(reader.getElementText() + ":");
                    }
                    if ("price".equals(name)) {
                        System.out.print(reader.getElementText() + "\n");
                    }
                }
                number++;
            }

            System.out.println("number: " + number);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 基于迭代模型的查找 + 过滤器
     *
     * @throws Exception
     */
    @SuppressWarnings("Duplicates")
    @Test
    public void testName005() throws Exception {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");
            //基于迭代模型的查找+过滤方式，可以有效的过滤掉不用进行操作的节点，效率会高一点
            XMLEventReader reader = xmlInputFactory.createFilteredReader(xmlInputFactory.createXMLEventReader(inputStream),
                    event -> {
                        //返回 true 表示会显示，返回false表示不显示
                        if (event.isStartElement()) {
                            String name = event.asStartElement().getName().toString();
                            if ("title".equals(name) || "price".equals(name)) {
                                return true;
                            }
                        }
                        return false;
                    });


            int number = 0;
            while (reader.hasNext()) {
                //通过 XMLEventReader 来获取是否是某种节点类型
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    //通过  event.asXXX转换节点
                    String name = event.asStartElement().getName().toString();
                    if ("title".equals(name)) {
                        System.out.print(reader.getElementText() + ":");
                    }
                    if ("price".equals(name)) {
                        System.out.print(reader.getElementText() + "\n");
                    }
                }
                number++;
            }

            System.out.println("number: " + number);

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * <pre>
     *  写xml文档
     *  通过 XMLOutputFactory 工厂 创建出 XMLEventWriter 或 XMLStreamWriter
     *      XMLEventWriter
     *      XMLStreamWriter     相应比较方法，可以按节点类型，直接写操作
     *
     * </pre>
     *
     * @throws Exception
     */
    @Test
    public void testName007() throws Exception {
        XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeEndDocument();

        //写命名空间
        String ns = "http://11:dd";

        //writer.writeStartElement("person");
        //writer.writeStartElement("id");
        writer.writeStartElement("ns", "person", ns);
        writer.writeStartElement(ns, "id");

        writer.writeCharacters("1");

        writer.writeEndElement();
        writer.writeEndElement();

        writer.flush();
        writer.close();
    }
}