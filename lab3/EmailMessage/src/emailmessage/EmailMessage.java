package emailmessage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional
    private static Properties serverProperties;
    private static Session mailSession;
    private static MimeMessage message;
    
    private EmailMessage() {
        
    }

    private EmailMessage(EmailMessageBuilder builder){
        if (builder == null)
            throw new NullPointerException("podany obiekt nie istnieje");
        this.from=builder.from;
        this.to=builder.to;
        this.subject=builder.subject;
        this.content=builder.content;
        this.mimeType=builder.mimeType;
        this.cc=builder.cc;
        this.bcc=builder.bcc;

    }

    public static class EmailMessageBuilder{
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional

        public EmailMessageBuilder(){
            to = new LinkedList<>();
            cc = new LinkedList<>();
            bcc = new LinkedList<>();
        }


        public EmailMessageBuilder from(String from){
            this.from = from;
            return this;
        }

        public EmailMessageBuilder to(LinkedList<String> to){
            if (!to.isEmpty())
                this.to.addAll(to);
            return this;
        }

        public EmailMessageBuilder to(String to){
            this.to.add(to);
            return this;
        }
        
        public EmailMessageBuilder subject(String subject){
            this.subject=subject;
            return this;
        }

        public EmailMessageBuilder content(String content){
            this.content=content;
            return this;
        }

        public EmailMessageBuilder mimeType(String mimeType){
            this.mimeType=mimeType;
            return this;
        }

        public EmailMessageBuilder cc(LinkedList<String> cc){
            if (!cc.isEmpty())
                this.to.addAll(cc);
            return this;
        }

        public EmailMessageBuilder bcc(LinkedList<String> bcc){
            if (!bcc.isEmpty())
                this.to.addAll(bcc);
            return this;
        }

        public EmailMessage build(){
            if(from == null || from.isEmpty()){
                throw new IllegalArgumentException(
                        "nie podano wartości dla zmiennej from");
            }

            if(to.size()<1){
                throw new IllegalArgumentException(
                        "zmienna to musi posiadać przynajmnej jedną wartość");
            }

            if(subject==null){
                subject="";
            }

            if(content==null){
                content="";
            }

            if(mimeType==null){
                mimeType="";
            }


            return new EmailMessage(this);
        }
        
    }

    public void send() throws AddressException, MessagingException {

        //mailSession.setDebug(true);
        
        serverProperties = System.getProperties();
        serverProperties.put("mail.smtp.port", "587");
        serverProperties.put("mail.smtp.auth", "true");
        serverProperties.put("mail.smtp.starttls.enable", "true");

        mailSession = Session.getDefaultInstance(serverProperties, null);
        
        mailSession.setDebug(true); //ustawienie debugowania
        
        message = new MimeMessage(mailSession);
        for(String i:to){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(i));
        }
        message.setSubject(subject);
        message.setContent(content, mimeType);

        Transport transport = mailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", from, "hasło");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        
        System.out.println("Wysłano");
    }


}