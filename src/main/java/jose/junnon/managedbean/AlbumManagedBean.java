/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class AlbumManagedBean {
     private long id;
     private String title;
     private String photo;

    public AlbumManagedBean() {
    }

    public AlbumManagedBean(long id, String title, String photo) {
        this.id = id;
        this.title = title;
        this.photo = photo;
    }

    
    public long getId() {
        return id;
    }

    
    public String getPhoto() {
        return photo;

    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
     
}
