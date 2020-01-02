package com.mo.tools;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/12/28
 * Time: 2:35
 */
public class SendMail {
    /**
     * 发送邮件工具..
     * @param email
     * @param code
     */
    public static void sendMail(String email,String code){
        //收信人的email
        String to = email;
        //邮件发送的email
        String from = "806754563@qq.com";
        //主机名
        String host = "smtp.qq.com";
        //创建连接对象，连接到邮箱服务器
        Properties properties = System.getProperties();
        //设置邮件服务器主机名
        properties.setProperty("mail.smtp.host", host);
        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");
        //发送服务器需要身份验证
        properties.put("mail.smtp.auth", "true");

        Session session  = Session.getDefaultInstance(properties,new  Authenticator() {

            public PasswordAuthentication getPasswordAuthentication()
            {
                //发件人邮件用户名、密码
                return new PasswordAuthentication("806754563", "aotouyjnpkuvbbjj");
            }
        });

        try {
            //创建邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置自定义发件人昵称
            String mailName="sunlife";
            try {
                mailName=javax.mail.internet.MimeUtility.encodeText("Sunlife的投递员");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //设置发件者
            message.setFrom(new InternetAddress(mailName+"<"+from+">"));
            //设置收件者
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            //设置邮件主题
            message.setSubject("欢迎您注册SunLife博客!");
            //设置邮件的正文
			message.setText("This is actual message");
            message.setContent("<h1>请点击<a href='http://127.0.0.1:8080/Blog/activate?code="+code+"'>此链接</a>以激活账号</h1>", "text/html;charset=utf-8");
            //发送邮件
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("发送成功");
    }
}
