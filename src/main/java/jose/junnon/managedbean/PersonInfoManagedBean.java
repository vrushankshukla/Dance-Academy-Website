/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class PersonInfoManagedBean {
     
     private long id;
     private String name;
     private String phoneNumber;
     private String emailId;
   
    public PersonInfoManagedBean() {
    }

    public PersonInfoManagedBean(long id, String name, String phoneNumber, String emailId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
