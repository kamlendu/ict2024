
package beans;

import java.io.IOException;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

//@SessionScoped
@RequestScoped
@Named
public class IndexBean {

    

    private String userName;
    private String password;
    private String msg;
   
   @PersistenceContext
    private EntityManager em;
	
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   
    public IndexBean() {
   
    }

    public String login() throws SQLException{
        
           
         try{
              
            Tbluser user =  (Tbluser)em.createNamedQuery("Tbluser.findByUsername").setParameter("username", userName).getSingleResult();
             if((user != null) && user.getPassword().equals(password)){

                HttpSession objHttpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                //since we know we have logged in.now store a flag in session
                objHttpSession.setAttribute("username", userName);

                //mapped to faces-config.xml... As such from JSF 2.0 no need to write navigation cases
                //in faces-config.xml you can directly redirect, but this is to show how can you do it using faces-config.xml
                return "/Restricted/Home";
            }
            else{
                msg = "Username and/or password is incorrect";
            }
           
        }
        catch(Exception ex){
                 msg = "Username and/or password is incorrect";
        
            ex.printStackTrace();
        }
        finally{
            
        }
       return null;
    }

    public void Logout() throws IOException{
        HttpSession objHttpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        objHttpSession.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
}
