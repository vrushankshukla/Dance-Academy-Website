/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jose.junnon.dao.AchievementDao;
import jose.junnon.managedbean.AchievementManagedBean;
import jose.junnon.model.Achievement;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class AchievementServiceBean {
    
   @ManagedProperty(value="#{achievementManagedBean}")
   private AchievementManagedBean achievementManagedBean;
   private Long achievementId;
    public AchievementServiceBean() {
    }

    public AchievementServiceBean(AchievementManagedBean achievementManagedBean) {
        this.achievementManagedBean = achievementManagedBean;
    }

    public AchievementManagedBean getAchievementManagedBean() {
        return achievementManagedBean;
    }

    public void setAchievementManagedBean(AchievementManagedBean achievementManagedBean) {
        this.achievementManagedBean = achievementManagedBean;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    
   public void addAchievement() throws IOException{
            Achievement achievement=new Achievement();
     
       achievement.setDescription(achievementManagedBean.getDescription());

       if(achievementManagedBean.getPhoto()==null){
        achievement.setPhoto("c:\\image\\other\\default.jpg");   
       }else
       {
       achievement.setPhoto(achievementManagedBean.getPhoto());
       }
       AchievementDao achievementDao=new AchievementDao();
       achievementDao.addAchievement(achievement);
       achievementManagedBean.setDescription("");
       
   }
   public List<Achievement> retriveAchievement(){
       AchievementDao achievementDao=new  AchievementDao();
       List<Achievement> l1=achievementDao.retriveAllAchievment();
       return l1;
       
   }
   public void deleteAchievement(){
       AchievementDao  achievementDao=new AchievementDao();
       achievementDao.deleteAchievement(achievementId);
   }
//   public String init() throws IOException{
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//       System.out.println(usermainManagedBean.isIsLoggedin());
//        System.out.println("inside check session");
//        if(usermainManagedBean.isIsLoggedin()==true){
//            System.out.println("inside condition");
//            
////             context.redirect("page1.xhtml"); 
//             return null;
//       }
//        else{
//            System.out.println("outside condition");
//            context.redirect("login.xhtml"); 
//            return null;
//        }
//   }
    
}
