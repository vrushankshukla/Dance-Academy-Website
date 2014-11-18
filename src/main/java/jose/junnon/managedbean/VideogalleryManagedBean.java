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
public class VideogalleryManagedBean {
    
     private long id;
     private String video;

    public VideogalleryManagedBean() {
    }

    public VideogalleryManagedBean(long id, String video) {
        this.id = id;
        this.video = video;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
         this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
   

}
