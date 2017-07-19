package cn.assupg.ws.soap.service.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

/**
 * Created by supeng on 11/23/2016.
 */
public class MyHandler implements SOAPHandler<SOAPMessageContext> {

    private static String ns = "http://www.assupg.cn/webservice";

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean out = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        try {
            if (out) {
                SOAPMessage message = context.getMessage();
                //1、判断message中是否存在Header
                SOAPEnvelope soapEnvelope = message.getSOAPPart().getEnvelope();
                SOAPHeader header = soapEnvelope.getHeader();
                if (header == null) {
                    header = soapEnvelope.addHeader();
                }

                QName licenseInfoQName = new QName(ns, "licenseInfo", "ns");
                header.addHeaderElement(licenseInfoQName).setValue("123123");
            }
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("error");
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
