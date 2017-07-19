package cn.assupg.ws.soap;

import cn.assupg.ws.soap.bean.User;
import org.testng.annotations.Test;
import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

/**
 * Created by supeng on 11/22/2016.
 */
public class SoapTest {

    String wsdlURL = "http://localhost:8989/ms/?wsdl";
    String namespaceURL = "http://www.assupg.cn/webservice";

    @Test
    public void test001() throws Exception {

        //1、创建，soap 消息工厂
        MessageFactory messageFactory = MessageFactory.newInstance();

        //2、根据 消息工厂，创建Soap消息
        SOAPMessage soapMessage = messageFactory.createMessage();

        //3、根据 Soap消息对象，创建  SOAPPart
        SOAPPart soapPart = soapMessage.getSOAPPart();

        //4、获取 SOAPEnvelope（信封）
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

        /**
         * SOAPMessage整个主体部分是SOAPPart，AttachmentPart（传递附件信息）
         *
         * SOAPPart中包含SOAPEnvelope（信封）
         * SOAPEnvelope（信封）包含了，SOAPHeader头信息（header）和SOAPBody 实体信息（body）
         *      SOAPBody【是具体的传递内容《XML内容，SOAPFault异常信息》】
         *      SOAPHeader【传递一些，请求信息，权限认证】
         *
         * AttachmentPart（传递附件信息） 可以传递多个AttachmentPart
         *      MIME Headers    和   Content(XML or non-XML)
         */
        //5、可以通过 SOAPEnvelope（信封）有效的获取相应的Body 和 Header等信息
        SOAPBody soapBody = soapEnvelope.getBody();

        //6、根据QName创建相应的节点【QName就是一个带有命名空间的节点】.并将QName增加到 SAOPBody中
        // <MyServiceService xmlns="http://www.assupg.cn/ws"></MyServiceService>

        /**
         * @param namespaceURI webService 要执行的方法名 对应的命名空间
         * @param localPart    webService 要执行的方法名
         * @param prefix       webService 要执行的方法名 的前缀【必须指定，不然会使用SOAP默认的命名空间的东西，SOAP默认名称空间是没有，这个消息会是无效的】
         */
        QName qName = new QName("http://www.assupg.cn/ws/", "add", "ns");// <ns:add xmlns="http://www.assupg.cn/ws/">
        //soapBody.addBodyElement(qName).setValue("123123");
        //          <ns:add xmlns:ns="http://www.assupg.cn/ws/">123123</ns:add>

        //soapBody.addBodyElement(qName).setValue("<a>123</a><b>123</b>");  //【会被转义】
        //          <ns:add xmlns:ns="http://www.assupg.cn/ws">&lt;a&gt;123&lt;/a&gt;&lt;b&gt;123&lt;/b&gt;</ns:add>

        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(qName);
        soapBodyElement.addChildElement("a").setValue("22");
        soapBodyElement.addChildElement("b").setValue("33");
        //          <ns:add xmlns:ns="http://www.assupg.cn/ws"><a>22</a><b>33</b></ns:add>

        /**
         *打印消息信息
         *
         *  <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">  信封
         *      <SOAP-ENV:Header/>  头
         *
         *      <SOAP-ENV:Body> 体
         *          <ns:add xmlns:ns="http://www.assupg.cn/ws">123123</ns:add>
         *      </SOAP-ENV:Body>
         *  </SOAP-ENV:Envelope>
         */
        soapMessage.writeTo(System.out);
    }

    @Test
    public void test001_study() throws Exception {
        //1、根据MessageFactory工厂，创建SOAPMessage
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        //2、得到SOAPPart的信封，根据soapMessage中的SOAPPart
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();

        //3、得到soapBody，并创建调用对应WS业务方法的QName
        SOAPBody soapEnvelopeBody = soapEnvelope.getBody();

        QName addQName = new QName("http://www.assupg.cn/webservice","add","ns");
        SOAPBodyElement soapBodyElement = soapEnvelopeBody.addBodyElement(addQName);
        soapBodyElement.addChildElement("a").setValue("22");
        soapBodyElement.addChildElement("b").setValue("33");

        //4、检查一下，消息信息是否正确；通过 soapMessage
        soapMessage.writeTo(System.out);


    }

    @Test
    public void test002() throws Exception {
        //基于 soapMessage 提交到服务器

        //1、创建 服务(Service)
        URL url = new URL(wsdlURL);
        QName qName = new QName(namespaceURL, "MyServiceService");
        Service service = Service.create(url, qName);

        //2、创建Dispatch 有两种方式： SOAPMessage方式  和 赋载【编好码的数据传递，不会有进行转义】
        /**
         * @param portName  WSDL 所访问的 port
         * @param type 所使用的类型 SOPMessage.class
         * @param mode Service.MESSAGE
         */
        Dispatch<SOAPMessage> soapMessageDispatch = service.createDispatch(new QName(namespaceURL, "MyServicePort"), SOAPMessage.class, Service.Mode.MESSAGE);

        //3、创建SOAPMessage
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();    //先获取信封
        SOAPBody soapEnvelopeBody = soapEnvelope.getBody();

        //4、创建QName，来指定消息中传递的数据
        QName bodyElementQName = new QName(namespaceURL, "add", "ns");
        SOAPBodyElement soapBodyElement = soapEnvelopeBody.addBodyElement(bodyElementQName);
        soapBodyElement.addChildElement("a").setValue("22");
        soapBodyElement.addChildElement("b").setValue("33");
        //输出消息，检查一上
        soapMessage.writeTo(System.out);


        //5、通过 javax.xml.ws.Dispatch.invoke方法，传递消息；会返回响应消息
        System.out.println(" invoke.....");
        SOAPMessage soapResponse = soapMessageDispatch.invoke(soapMessage);
        soapResponse.writeTo(System.out);
        System.out.println();


        //将响应消息，转换为 dom对象
        Document document = soapResponse.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        String addResult = document.getElementsByTagName("addResult").item(0).getTextContent();
        System.out.println(addResult);
    }

    @Test
    public void test002_study() throws Exception {

        Service myServiceService = Service.create(new URL(wsdlURL), new QName(namespaceURL, "MyServiceService"));
        Dispatch<SOAPMessage> myServiceServiceDispatch = myServiceService.createDispatch(new QName(namespaceURL, "MyServicePort"), SOAPMessage.class, Service.Mode.MESSAGE);

        SOAPMessage addSOAPMessage = MessageFactory.newInstance().createMessage();
        SOAPEnvelope soapEnvelope = addSOAPMessage.getSOAPPart().getEnvelope();
        SOAPBody soapEnvelopeBody = soapEnvelope.getBody();

        QName addQName = new QName(namespaceURL, "add", "ns");
        SOAPBodyElement soapBodyElement = soapEnvelopeBody.addBodyElement(addQName);
        soapBodyElement.addChildElement("a").setValue("22");
        soapBodyElement.addChildElement("b").setValue("33");


        System.out.println("invoke.....");
        SOAPMessage invokeAddResponse = myServiceServiceDispatch.invoke(addSOAPMessage);
        invokeAddResponse.writeTo(System.out);
        System.out.println();

        Document document = invokeAddResponse.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        String addResult = document.getElementsByTagName("addResult").item(0).getTextContent();
        System.out.println(addResult);
    }



    @Test
    public void testName003_UserLogin() throws Exception {

        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
        SOAPBody soapEnvelopeBody = soapEnvelope.getBody();

        QName loginQName = new QName(namespaceURL, "login", "ns");
        SOAPBodyElement soapBodyElement = soapEnvelopeBody.addBodyElement(loginQName);
        soapBodyElement.addChildElement("username").setValue("admin");
        soapBodyElement.addChildElement("password").setValue("admin");
        soapMessage.writeTo(System.out);
        System.out.println();


        Service myServiceService = Service.create(new URL(wsdlURL), new QName(namespaceURL, "MyServiceService"));
        Dispatch<SOAPMessage> soapMessageDispatch = myServiceService.createDispatch(new QName(namespaceURL, "MyServicePort"), SOAPMessage.class, Service.Mode.MESSAGE);
        SOAPMessage soapMessageResponse = soapMessageDispatch.invoke(soapMessage);
        soapMessageResponse.writeTo(System.out);
        System.out.println();

        SOAPBody soapBody = soapMessageResponse.getSOAPPart().getEnvelope().getBody();
        Document document = soapBody.extractContentAsDocument();
        String textContent = document.getElementsByTagName("user").item(0).getTextContent();
        System.out.println(textContent);
    }


    @Test
    public void testName004() throws Exception {
        //1、创建服务(Service)
        Service myServiceService = Service.create(new URL(wsdlURL), new QName(namespaceURL, "MyServiceService"));
        //2、创建Dispatch(通过 source 源数据的方式传递)
        Dispatch<Source> sourceDispatch = myServiceService.createDispatch(new QName(namespaceURL, "MyServicePort"), Source.class, Service.Mode.PAYLOAD);


        StringWriter stringWriter = new StringWriter();
        //3、根据 user对象，创建相应的xml字符串，使用JAXBContext
        User user = new User(2, "zhangsan", "123456", "张三");
        Marshaller marshaller = JAXBContext.newInstance(User.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(user, stringWriter);
        System.out.println(stringWriter);


        //4、封装相应的 part addUser
        String payload = "<ns:addUser xmlns:ns=\"" + namespaceURL + "\">" + stringWriter + "</ns:addUser>";
        System.out.println(payload);


        //5、通过，sourceDispatch 传递payload
        StreamSource payloadStreamSource = new StreamSource(new StringReader(payload));
        Source sourceResponse = (Source) sourceDispatch.invoke(payloadStreamSource);


        //6、将Source 转换为 Dom进行操作，使用 Transformer.transform(sourceResponse,domResult)进行转换
        DOMResult domResult = new DOMResult();
        TransformerFactory.newInstance().newTransformer().transform(sourceResponse, domResult);

        //7、处理，响应信息  使用xPath来处理
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.evaluate("//user", domResult.getNode(), XPathConstants.NODESET);

        // 进行反编排
        Unmarshaller unmarshaller = JAXBContext.newInstance(User.class).createUnmarshaller();
        for (int i = 0; i < nodeList.getLength(); i++) {
            User unmarshaUser = (User) unmarshaller.unmarshal(nodeList.item(i));
            System.out.println(unmarshaUser);
        }

    }
}