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
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class FacultyManagedBean {
     private long id;
     private String name;
     private String photo;
     private String description;
     private String designation;

    public FacultyManagedBean() {
    }

    public FacultyManagedBean(long id, String name, String photo, String description, String designation) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
        this.designation = designation;
    }

   
     
      public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
