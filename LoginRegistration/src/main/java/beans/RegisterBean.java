package beans;

//import java.sql.SQLException;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@RequestScoped
@Named
public class RegisterBean {


    @Resource
	private UserTransaction utx;

    

    private String userName;
    private String password;
    private String emailAddress;
    private String residentialAddress;
    private String contactNo;
    private String msg;
    

    @PersistenceContext(unitName = "LoginRegistrationPU")
    private EntityManager em;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RegisterBean() {
        //em=emf.createEntityManager();
    }

    public void checkUsername() {
          
         try{
          
            Tbluser user =  (Tbluser)em.createNamedQuery("Tbluser.findByUsername").setParameter("username", userName).getSingleResult();
           if(user !=null){
                msg = "<div style = 'color:red'>Username already exists</div>";
                System.out.println(msg);
            }
            else{
                msg = "<div style = 'color:green'>Username is available</div>";
            }

        }
        catch(Exception ex){
             msg = "<div style = 'color:green'>Username is available</div>";
           // ex.printStackTrace();
        }
        finally{
        }

    }

     public void checkEmail() {
       
         try{

              Tbluser user =  (Tbluser)em.createNamedQuery("Tbluser.findByEmailAddress").setParameter("emailAddress", emailAddress).getSingleResult();
            if(user != null){
                msg = "<div style = 'color:red'>Email address already exists</div>";
                System.out.println(msg);
            }
            else{
               msg = "<div style = 'color:green'>Email address is available</div>";
            }

        }
        catch(Exception ex){
             msg = "<div style = 'color:green'>Email address is available</div>";
            //ex.printStackTrace();
        }
        finally{
           
        }

    }

    public String register()  {

         try{
           
           Tbluser user = new Tbluser();
           user.setUsername(userName);
           user.setContactNo(contactNo);
           user.setEmailAddress(emailAddress);
           user.setPassword(password);
           user.setResidentialAddress(residentialAddress);

           try{
               utx.begin();
              //  em.getTransaction().begin();
           
                em.persist(user);
            
              //  em.getTransaction().commit();
            utx.commit();
            
             return "index";
             }
             catch(Exception insert){
                  msg = "Error occured while registering. Make sure that Username and Email address are unique.";
                    insert.printStackTrace();
             }
        }
        catch(Exception ex){
            msg = ex.getMessage();
            ex.printStackTrace();
        }
        finally{
           
        }

        return null;
    }
}
