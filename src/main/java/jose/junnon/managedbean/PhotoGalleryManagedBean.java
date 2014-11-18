/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import jose.junnon.model.Album;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class PhotoGalleryManagedBean {
      private long id;
     private String photo;
     private String description;
     private Album album;
    public PhotoGalleryManagedBean() {
    }

    public PhotoGalleryManagedBean(long id, String photo, String description) {
        this.id = id;
        this.photo = photo;
        this.description = description;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

   
}
