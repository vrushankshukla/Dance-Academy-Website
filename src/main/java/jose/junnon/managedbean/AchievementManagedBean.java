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
public class AchievementManagedBean {
    private long id;
     private String title;
     private String photo;
     private String description;

    public AchievementManagedBean() {
    }

    public AchievementManagedBean(long id, String title, String photo, String description) {
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.description = description;
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
}
