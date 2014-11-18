/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import jose.junnon.dao.AlbumDao;
import jose.junnon.managedbean.AlbumManagedBean;
import jose.junnon.model.Album;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class AlbumServiceBean {
     @ManagedProperty(value="#{albumManagedBean}")
   private AlbumManagedBean albumManagedBean;
     private Long albumId;

    public AlbumServiceBean() {
    }

    public AlbumServiceBean(AlbumManagedBean albumManagedBean) {
        this.albumManagedBean = albumManagedBean;
    }

    public AlbumManagedBean getAlbumManagedBean() {
        return albumManagedBean;
    }

    public void setAlbumManagedBean(AlbumManagedBean albumManagedBean) {
        this.albumManagedBean = albumManagedBean;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

   
 
    
    public void addAlbum(){
        AlbumDao dao=new AlbumDao();
        Album a=new Album();
        a.setTitle(albumManagedBean.getTitle());
        if(albumManagedBean.getPhoto()==null){
            a.setPhoto("c:\\image\\other\\default.jpg");
        }else{
        a.setPhoto(albumManagedBean.getPhoto());
        }
        dao.addAlbum(a);
        albumManagedBean.setTitle("");
    }
    public List<Album> retriveAllAlbum(){
         AlbumDao dao=new AlbumDao();
       
         return  dao.retriveAlbum();
    }
    public void deleteAlbum(){
       AlbumDao dao=new AlbumDao();
       dao.deleteAlbum(albumId);
    }
}