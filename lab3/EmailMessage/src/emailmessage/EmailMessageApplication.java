package emailmessage;

import javax.mail.*;

public class EmailMessageApplication {
    public static void main(String[] argv) throws MessagingException {
        try {
            EmailMessage email = new EmailMessage.EmailMessageBuilder()
                //.from("mail adresata")
                .to("mail odbiorcy")
                .subject("Hello")
                .content("test")
                .mimeType("text/html")
                .build();
            email.send();
        } catch (IllegalArgumentException exc) {
            System.out.println("Błąd: " + exc.getMessage());
        }
    }
}