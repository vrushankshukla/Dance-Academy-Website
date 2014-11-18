/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jose.junnon.dao.UsermainDao;
import jose.junnon.managedbean.UsermainManagedBean;
import jose.junnon.model.Usermain;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import jose.junnon.dao.LoginSendMail;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class UsermainServiceBean {
    
   @ManagedProperty(value="#{usermainManagedBean}")
   private UsermainManagedBean usermainManagedBean;
   private String checkLogin="";
    public UsermainServiceBean() {
    }

    public void setCheckLogin(String checkLogin) {
        this.checkLogin = checkLogin;
    }

    public String getCheckLogin() {
        return checkLogin;
    }

    public UsermainServiceBean(UsermainManagedBean usermainManagedBean) {
        this.usermainManagedBean = usermainManagedBean;
    }

    public UsermainManagedBean getUsermainManagedBean() {
        return usermainManagedBean;
    }

    public void setUsermainManagedBean(UsermainManagedBean usermainManagedBean) {
        this.usermainManagedBean = usermainManagedBean;
    }
   public void addUsermain() throws IOException{
           ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       Usermain usermain=new Usermain();
       usermain.setUsername(usermainManagedBean.getUsername());
       usermain.setPassword1(usermainManagedBean.getPassword1());
       UsermainDao dao=new UsermainDao();
       dao.addUsermain(usermain);
       context.redirect("Home.xhtml");
       
   }
   
   public void doLogin() throws IOException{
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        FacesContext facesContext = FacesContext.getCurrentInstance();
         
        usermainManagedBean.setUsername(usermainManagedBean.getUsername().toLowerCase());
        String userId = this.usermainManagedBean.getUsername();
       usermainManagedBean.setPassword1(usermainManagedBean.getPassword1().toLowerCase());
        String password=this.usermainManagedBean.getPassword1();
        System.out.println("User id in dologin method : " + userId);
//        System.out.println("User password dologin method : " + loginDataBean.getPassword());
        UsermainDao  dao=new UsermainDao();
        List<Usermain>  usermainList=dao.doLogin(userId, password);
        if(usermainList.isEmpty()){
           
            usermainManagedBean.setPassword1(null);
                   context.redirect("login.xhtml"); 
//                   messageDataBean.setIsSuccess(false);
                   setCheckLogin("Username And Password Are Not Valid");
//                   return "Username And Password Are Not Valid";
               }
               else{
                   usermainManagedBean.setIsLoggedin(true);
                   context.redirect("adminHome.xhtml");
//                   return "";
               }
//     
   }
   public void logOut() throws IOException{
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

//        FacesContext facesContext = FacesContext.getCurrentInstance();
        usermainManagedBean.setIsLoggedin(false);
        usermainManagedBean.setPassword1("");
       setCheckLogin("");
        usermainManagedBean.setUsername("");
        context.redirect("login.xhtml"); 
   }
   public String init() throws IOException{
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       System.out.println(usermainManagedBean.isIsLoggedin());
        System.out.println("inside check session");
        if(usermainManagedBean.isIsLoggedin()==true){
            System.out.println("inside condition");
            
//             context.redirect("page1.xhtml"); 
             return null;
       }
        else{
            System.out.println("outside condition");
            context.redirect("login.xhtml"); 
            return null;
        }
   }
   public void sendMail1(){
       System.out.println("this is my ffksdjfpskmfslrksrlk");
   LoginSendMail loginSendMail=new LoginSendMail();
   loginSendMail.ForgotPasswordSendMail();
   }
   
   

//
//    public static void main(String[] args) {
//        UsermainServiceBean bean=new UsermainServiceBean();
//        bean.sendMail1();
//    }
}