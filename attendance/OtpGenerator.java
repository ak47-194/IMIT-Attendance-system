

package IMIT;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.*;


 public class OtpGenerator
{

    //SETUP MAIL SERVER PROPERTIES
    //DRAFT AN EMAIL
    //SEND EMAIL

    Session newSession = null;
    MimeMessage mimeMessage = null;


    public static void main(String args[]) throws AddressException, MessagingException, IOException
    {
//            OtpGenerator mail = new OtpGenerator();
//            mail.setupServerProperties();
//            mail.draftEmail(mail.generateOTP());
//            mail.sendEmail();

    }


    private static final String OTP_CHARS = "0123456789";
    private static final int OTP_LENGTH = 6;

    public String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(OTP_CHARS.charAt(random.nextInt(OTP_CHARS.length())));
        }
        return otp.toString();
    }

    public void sendEmail() throws MessagingException {
        String fromUser = "bishalgocnqr2000@gmail.com";  //Enter sender email id
        String fromUserPassword = "kejk gnxy iyjj nlid";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    public MimeMessage draftEmail(String GenOTP, String email) throws AddressException, MessagingException {
        String[] emailReceipients = {"randomlyspoken000@gmail.com"};  //Enter list of email recepients
        String emailSubject = "Verification code for authentication"; //Subject of the email
        String emailBody = "Your One Time Password(OTP) for verification is " + GenOTP +"\n Thank You \n Institute of Management and Information Technology, Cuttack."; //Content of the body
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(emailBody);
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    public void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
    }
}
