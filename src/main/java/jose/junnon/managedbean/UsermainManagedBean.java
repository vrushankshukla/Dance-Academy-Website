/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class UsermainManagedBean {
    
    
     private long id;
     private String username;
     private String password1;
     private boolean  isLoggedin=false;
    public UsermainManagedBean() {
    }

    public UsermainManagedBean(long id, String username, String password1) {
        this.id = id;
        this.username = username;
        this.password1 = password1;
    }

    public boolean isIsLoggedin() {
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }
    
     
     
    
     public long getId() {
        return id;
    }

    public String getPassword1() {
        return password1;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
