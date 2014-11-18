/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import jose.junnon.dao.PhotogalleryDao;
import jose.junnon.managedbean.PhotoGalleryManagedBean;
import jose.junnon.model.Album;
import jose.junnon.model.Photogallery;
import josh.junoon.listener.SystemFunctionUtil;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class PhotoGalleryServiceBean {
    @ManagedProperty(value="#{photoGalleryManagedBean}")
    private PhotoGalleryManagedBean photoGalleryManagedBean;
    private Long photoId;
    private Long albumId;
    public PhotoGalleryServiceBean() {
    }

    public void setPhotoGalleryManagedBean(PhotoGalleryManagedBean photoGalleryManagedBean) {
        this.photoGalleryManagedBean = photoGalleryManagedBean;
    }

    public PhotoGalleryManagedBean getPhotoGalleryManagedBean() {
        return photoGalleryManagedBean;
    }


    public Long getPhotoId() {
        return photoId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

   
    
    public void addPhoto(){
        PhotogalleryDao dao=new PhotogalleryDao();
        Photogallery p=new Photogallery();
        p.setDescription(photoGalleryManagedBean.getDescription());
        if(photoGalleryManagedBean.getPhoto()==null){
            p.setPhoto("c:\\image\\other\\default.jpg");
        }else{
        p.setPhoto(photoGalleryManagedBean.getPhoto());
        }
        Album a=new Album(photoGalleryManagedBean.getId());
        p.setAlbum(a);
        dao.addPhoto(p);
        photoGalleryManagedBean.setDescription("");
    }
    public void deletePhoto(){
       PhotogalleryDao dao=new PhotogalleryDao();
       dao.deletePhoto(photoId);
    }
   public void deleteUploadedFile(){
       System.out.println("image path at the time of delete file"+photoGalleryManagedBean.getPhoto());
//       SystemFunctionUtil functionUtil=new SystemFunctionUtil();
        photoGalleryManagedBean.setDescription("");
       SystemFunctionUtil.deleteFile(photoGalleryManagedBean.getPhoto());
   }
    public List<Photogallery> retriveAllPhoto(){
        PhotogalleryDao dao=new PhotogalleryDao();
        List<Photogallery> l1=dao.retriveAll();
        for(Photogallery p:l1){
            System.out.println("from database"+p.getDescription());
        } 
        return l1;
                
    }
    public List<Photogallery> retrivePhotoByAlbum(){
        PhotogalleryDao dao=new PhotogalleryDao();
        return dao.retrivePhotoByAlblumId(new Album(getAlbumId()));
    }
}
