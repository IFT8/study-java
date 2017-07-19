package cn.assupg.java.xml.xpath;

import cn.assupg.java.xml.stax.StaxTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by supeng on 11/17/2016.
 */
public class XpathTest {

    /**
     * xpath 读取xml
     * java.xml.parsers.DocumentBuilder
     * 要通过 java.xml.parsers.DocumentBuilderFactory，来创建我们的DocumentBuilder.
     * 通过DocumentBuilder.parse(File f) 转换成一个Document.
     * 如果要使用xpath，必需要把整个文档读进内存；然后通过xpath进行转换；也可以截取文档中一小部分来处理
     *
     * @throws Exception
     */
    @Test
    public void testName006() throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = StaxTest.class.getResourceAsStream("/books.xml");

            //创建文档处理对象
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            //通过 DocumentBuilder 创建doc的文档对象
            //org.w3c.dom.Document
            Document doc = documentBuilder.parse(inputStream);

            //创建XPath
            XPath xPath = XPathFactory.newInstance().newXPath();

            // xPath.evaluate() 第一个参数就是 xpath；第二个参数就是 doc
            //表达式计算，找book 中 属性category 为WEB，书的名称
            //需要将查找的到节点，指定返回类型为：XPathConstants.NODESET  且强制转换为 org.w3c.dom.NodeList
            NodeList nodeList = (NodeList) xPath.evaluate("//book[@category='WEB']", doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                //遍历输出相应的结果
                //现在在book这个节点上，我们要输出的是 title节点上的信息
                // 需要将 Node转换转换为 Element
                Element element = (Element) nodeList.item(i);
                System.out.println(element.getElementsByTagName("title").item(0).getTextContent());
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
}