/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class GmailInbox {

//    public static ClientResponse SendSimpleMessage() {
//        Client client = Client.create();
//        client.addFilter(new HTTPBasicAuthFilter("api", "55a3ed887966e0a4ac4241f48836418b-90ac0eb7-d9f5f00a"));
//        WebResource webResource = client.resource("https://api.mailgun.net/v3/sandbox7a3923ce2d284a79acae8bf39a564a38.mailgun.org/messages");
//        MultivaluedMapImpl formData = new MultivaluedMapImpl();
//        formData.add("from", "Mailgun Sandbox <postmaster@sandbox7a3923ce2d284a79acae8bf39a564a38.mailgun.org>");
//        formData.add("to", "Phạm va Minh <hesaclocon@gmail.com>");
//        formData.add("subject", "Hello Phạm va Minh");
//        formData.add("text", "Congratulations Phạm va Minh, you just sent an email with Mailgun!  You are truly awesome!");
//        return webResource.type(MediaType.).
//                post(ClientResponse.class, formData);
//    }

    public static void main(String[] args) {
        GmailInbox gmail = new GmailInbox();
        gmail.read();
    }

    public void read() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("C:\\smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "*************@gmail.com", "your_password");

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();

            System.out.println("Total Messages:- " + messageCount);

            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
            for (int i = 0; i < 10; i++) {
                System.out.println("Mail Subject:- " + messages[i].getSubject());
            }
            inbox.close(true);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
