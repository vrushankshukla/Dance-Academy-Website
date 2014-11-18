/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.managedbean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class EventManagedBean {
    
     private long id;
     private String title;
     private String startdate;
     private String enddate;
     private String description;
     private String photo;
     private String place;


    public EventManagedBean() {
    }

    public EventManagedBean(long id, String title, String startdate, String enddate, String description, String photo, String place) {
        this.id = id;
        this.title = title;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
        this.photo = photo;
        this.place = place;
    }

    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
   
    public String getDescription() {
        return this.description;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
     
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
}
