
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author root
 */
public class MyListeners implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    public void contextInitialized(ServletContextEvent sce) {
        
        sce.getServletContext().setAttribute("company","ABC Pvt Ltd.");
  
            System.out.println(" The context is initialized......");
    }

    public void contextDestroyed(ServletContextEvent sce) {
          System.out.println(" The context is destroyed......"); 
    }

    public void attributeAdded(ServletContextAttributeEvent event) {
           System.out.println(" Added An attribute with name "+ event.getName() + "and value "+ event.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
          System.out.println("Removed An attribute with name "+ event.getName() + "and value "+ event.getValue());
 
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0) {
          System.out.println("Replaced An attribute with name "+ arg0.getName() + "and value "+ arg0.getValue());
 
    }

    public void sessionCreated(HttpSessionEvent se) {
       
            System.out.println(" The Session is created......");
            se.getSession().setAttribute("host", new Long(se.getSession().getCreationTime()));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(" The Session is destroyed......");
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
              System.out.println(" Added An attribute with name "+ event.getName() + "and value "+ event.getValue());
       
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
       
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
       
    }
}
