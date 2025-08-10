import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendingEmail {  // ✅ Class name must match file name

    public static void main(String[] args) {
        String to = "receiver@gmail.com"; // 🔁 Replace with recipient's actual email
        String subject = "Library Book Return Reminder";
        String message = "Dear Student,\n\nYour book is due soon. Please return it on time to avoid penalties.\n\nRegards,\nLibrary System";

        sendEmail(to, subject, message);
    }

    public static void sendEmail(String to, String subject, String text) {
        final String from = "12akirtikushwaha@gmail.com";      // 🔁 Your Gmail address
        final String password = "8585";           // 🔁 App password, not Gmail password

        // Gmail SMTP configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server
        props.put("mail.smtp.port", "587");            // TLS port
        props.put("mail.smtp.auth", "true");           // Enable auth
        props.put("mail.smtp.starttls.enable", "true");// Enable TLS

        // Create authenticated session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Construct email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            // Send the email
            Transport.send(message);
            System.out.println("✅ Email sent successfully to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
