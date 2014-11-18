/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import jose.junnon.managedbean.VideogalleryManagedBean;
import jose.junnon.model.Videogallery;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jose.junnon.dao.VideogalleryDao;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class VideogalleryServiceBean {

    @ManagedProperty(value="#{videogalleryManagedBean}")
    private VideogalleryManagedBean videogalleryManagedBean;
    private Long videoId;

    public VideogalleryServiceBean() {
    }

    public VideogalleryServiceBean(VideogalleryManagedBean videogalleryManagedBean) {
        this.videogalleryManagedBean = videogalleryManagedBean;
    }

    public VideogalleryManagedBean getVideogalleryManagedBean() {
        return videogalleryManagedBean;
    }

    public void setVideogalleryManagedBean(VideogalleryManagedBean videogalleryManagedBean) {
        this.videogalleryManagedBean = videogalleryManagedBean;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
    
    public void addVideo() throws IOException{
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       Videogallery videogallery=new Videogallery();
       VideogalleryServiceBean bean=new VideogalleryServiceBean();
       String finalURL=bean.makeYouTubeUrl(videogalleryManagedBean.getVideo());
       videogallery.setVideo(finalURL);
       VideogalleryDao videogalleryDao=new VideogalleryDao();
       videogalleryDao.addVideo(videogallery);
       context.redirect("Home.xhtml");
       
   }
    public String makeYouTubeUrl(String originalURL) {
        System.out.println(originalURL);
        String url = originalURL;
        url = url.substring(url.lastIndexOf("=")+1);
        System.out.println(url);
        String finalUrl = "http://www.youtube.com/embed/"+url;
        System.out.println(finalUrl);
        return finalUrl;
        
    }
     public List<Videogallery> retriveVideos(){
      VideogalleryDao videogalleryDao=new VideogalleryDao();
       List<Videogallery> l1=videogalleryDao.retriveAllVideos();
       return l1;
       
   }
   public void deleteVideo(){
       VideogalleryDao videogalleryDao=new VideogalleryDao();
       videogalleryDao.deleteVideo(videoId);
   }
}
