/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ictqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecieverBean implements MessageListener {
    
    public RecieverBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        if(message instanceof TextMessage)
        {
            try {
                String msg = ((TextMessage)message).getText();
           
            System.out.println("Reciever Bean has got message : "+msg);
            
            Properties p = new Properties();
            p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");
        
            InitialContext ic = new InitialContext(p);
            
            ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/sampleFactory");
            Queue queue = (Queue) ic.lookup("jms/sample");
            Connection con = cf.createConnection();
            Session session = con.createSession();
            MessageProducer mp = session.createProducer(queue);
            TextMessage tm = session.createTextMessage();
            tm.setText(msg + "----The message is send by Reciever module");
            mp.send(tm);
            
            
            
            
            
            } catch (NamingException|JMSException ex) {
                Logger.getLogger(RecieverBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
}
