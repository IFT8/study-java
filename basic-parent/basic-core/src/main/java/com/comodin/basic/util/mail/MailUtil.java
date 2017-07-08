package com.comodin.basic.util.mail;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtil {

    public static void send(final String host, final String username, final String password, final Mail mail) throws MessagingException, IOException {
        send(host, "465", "SMTP", username, password, mail);
    }

    /**
     * 发送指定的邮件
     *
     * @param host     Mail 服务地址
     * @param port     Mail port
     * @param protocol Mail 协议
     * @param username 发件者，邮箱账号
     * @param password 发件者，邮箱密码
     * @param mail     邮件信息封装对象
     *
     * @throws MessagingException
     * @throws IOException
     */
    public static void send(final String host, final String port, final String protocol, final String username, final String password, final Mail mail) throws MessagingException, IOException {

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", protocol);  //发送邮件协议名称
        props.setProperty("mail.smtp.host", host);               //设置邮件服务器主机名
        props.put("mail.smtp.auth", "true");             //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
        //try {
        //    MailSSLSocketFactory sf = new MailSSLSocketFactory();
        //    sf.setTrustAllHosts(true);
        //    props.setProperty("mail.smtp.ssl.enable", "true");
        //    props.put("mail.smtp.ssl.socketFactory", sf);
        //    props.setProperty("mail.smtp.port", port);             // 指定主机
        //} catch (GeneralSecurityException e) {
        //    e.printStackTrace();
        //}

        // 获取session对象
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        session.setDebug(true);//设置打开调试状态

        MimeMessage msg = new MimeMessage(session);// 创建邮件对象
        msg.setFrom(new InternetAddress(mail.getFrom()));// 设置发件人
        msg.addRecipients(RecipientType.TO, mail.getToAddress());// 设置收件人

        // 设置抄送
        String cc = mail.getCcAddress();
        if (!cc.isEmpty()) {
            msg.addRecipients(RecipientType.CC, cc);
        }
        // 设置暗送
        String bcc = mail.getBccAddress();
        if (!bcc.isEmpty()) {
            msg.addRecipients(RecipientType.BCC, bcc);
        }

        msg.setSubject(mail.getSubject());// 设置主题

        MimeMultipart parts = new MimeMultipart();// 创建部件集对象
        MimeBodyPart part = new MimeBodyPart();// 创建一个部件
        part.setContent(mail.getContent(), "text/html;charset=utf-8");// 设置邮件文本内容
        parts.addBodyPart(part);// 把部件添加到部件集中
        ///////////////////////////////////////////

        // 添加附件
        List<AttachBean> attachBeanList = mail.getAttachs();// 获取所有附件
        if (attachBeanList != null && !attachBeanList.isEmpty()) {
            for (AttachBean attach : attachBeanList) {
                MimeBodyPart attachPart = new MimeBodyPart();// 创建一个部件
                attachPart.attachFile(attach.getFile());// 设置附件文件
                attachPart.setFileName(MimeUtility.encodeText(attach.getFileName(), "UTF-8", null));// 设置附件文件名
                String cid = attach.getCid();
                if (cid != null) {
                    attachPart.setContentID(cid);
                }
                parts.addBodyPart(attachPart);
            }
        }
        msg.setContent(parts);// 给邮件设置内容
        Transport.send(msg);// 发邮件
    }

    public static void main(String[] args) throws IOException, MessagingException {

        Mail mail = new Mail("supeng@comodin.cn", "assupg@126.com,124502703@qq.com", "测试邮件标题啊 assupg", "邮件内容啊");
        mail.addCcAddress("442083981@qq.com");
        mail.addBccAddress("assupg@126.com");
        for (int i = 0; i < 1; i++) {
            File file = new File("D:\\data\\comodinToSio\\20170111\\20170116 收钱，完成 任务.zip");
            AttachBean attachBean = new AttachBean();
            //attachBean.setCid(String.valueOf(1));
            attachBean.setFileName(file.getName());
            attachBean.setFile(file);
            mail.addAttach(attachBean);
        }

        //发送
        MailUtil.send("smtp.exmail.qq.com", "supeng@comodin.cn", "Fabcd6688.", mail);
    }
}