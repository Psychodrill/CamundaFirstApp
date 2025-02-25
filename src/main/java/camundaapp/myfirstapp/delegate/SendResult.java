package camundaapp.myfirstapp.delegate;

//import java.awt.*;

import javax.mail.*;

import javax.mail.internet.*;

import javax.swing.*;

import java.awt.Desktop;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.camunda.bpm.engine.delegate.*;

import org.springframework.stereotype.Component;

import camundaapp.myfirstapp.config.ConfigProperties;

@Component(value ="sendResult")
public class SendResult implements JavaDelegate{
    
    private final ConfigProperties prop;

    public SendResult (ConfigProperties prop){
        this.prop = prop;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {


    //     // Properties prop = new Properties();
    //     // prop.put("mail.smtp.auth", true);
    //     // prop.put("mail.smtp.starttls.enable", "true");
    //     // prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
    //     // prop.put("mail.smtp.port", "25");
    //     // prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
    //     // Session session = Session.getInstance(prop, new Authenticator() {
    //     //     @Override
    //     //     protected PasswordAuthentication getPasswordAuthentication() {
    //     //         return new PasswordAuthentication(props.getUsername(), props.getPassword());
    //     //     }
    //     // });

    //     Properties props = new Properties();
    //     props.put("mail.imap.ssl.enable", "true"); // required for Gmail
    //     props.put("mail.smtp.starttls.enable", "true");
    //     props.put("mail.smtp.host", "smtp.gmail.com");
    //     props.put("mail.smtp.port", "587");

    //     System.out.println(prop.getUsername());
    //    Session session = Session.getInstance(props, new Authenticator() {
    //         @Override
    //         protected PasswordAuthentication getPasswordAuthentication() {
    //             return new PasswordAuthentication(prop.getUsername(), prop.getPassword());
    //         }
    //     });

    //     MimeMessage message = new MimeMessage(session);
    //     message.setFrom(new InternetAddress("strauszloy23062020@gmail.com"));
    //     message.setRecipients(
    //     Message.RecipientType.TO, InternetAddress.parse("zhiganovtaras@gmail.com"));
    //     message.setSubject("Mail Subject");

    //     String msg = "This is my first email using JavaMailer";

    //     MimeBodyPart mimeBodyPart = new MimeBodyPart();
    //     mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

    //     Multipart multipart = new MimeMultipart();
    //     multipart.addBodyPart(mimeBodyPart);

    //     message.setContent(multipart);

    //     Transport.send(message);
    // // String resultLink =(String)execution.getVariable("resultLink");
    // // System.out.println(resultLink);
    // //          Desktop desktop=Desktop.getDesktop();
    // //  URI url = new URI("microsoft.com");
    // //  desktop.browse(url);

    // System.out.println(Desktop.isDesktopSupported());
    // System.out.println(Desktop.getDesktop().isSupported(Desktop.Action.BROWSE));
    // if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
    // Desktop.getDesktop().browse(new URI("http://www.example.com"));


//}
        //BufferedInputStream in = new BufferedInputStream(new URL((String)execution.getVariable("resultLink")).openStream());

        // try (BufferedInputStream in = new BufferedInputStream(new URL((String)execution.getVariable("resultLink")).openStream());
        // FileOutputStream fileOutputStream = new FileOutputStream("download.jpg")) {
        //     byte dataBuffer[] = new byte[4096];
        //     int bytesRead;
        //     while ((bytesRead = in.read(dataBuffer, 0, 4096)) != -1) {
        //         fileOutputStream.write(dataBuffer, 0, bytesRead);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        String url = (String)execution.getVariable("resultLink");
       // String encoded = URLEncoder.encode(url);
        System.out.println("Start download file...");
        InputStream in = new URL(url).openStream();
        Files.copy(in, Paths.get("download.jpg"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File downloaded!");

     }

}
