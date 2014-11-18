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
import javax.transaction.RollbackException;
import jose.junnon.dao.FacultyDao;
import jose.junnon.managedbean.FacultyManagedBean;
import jose.junnon.model.Faculty;
import josh.junoon.listener.SystemFunctionUtil;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class FacultyServiceBean {
    @ManagedProperty(value="#{facultyManagedBean}")
    private FacultyManagedBean facultyManagedBean;
    private  Long facultyID;
    private Long facultyEditId; 
//    private Faculty faculty = new Faculty();
     List<FacultyManagedBean> facultyList = new ArrayList<FacultyManagedBean>();
    public FacultyServiceBean() {
        
    }

    public FacultyServiceBean(FacultyManagedBean facultyManagedBean) {
        this.facultyManagedBean = facultyManagedBean;
    }

    public FacultyManagedBean getFacultyManagedBean() {
        return facultyManagedBean;
    }

    public void setFacultyManagedBean(FacultyManagedBean facultyManagedBean) {
        this.facultyManagedBean = facultyManagedBean;
    }

    public Long getFacultyEditId() {
        return facultyEditId;
    }

    public void setFacultyEditId(Long facultyEditId) {
        this.facultyEditId = facultyEditId;
    }
 
    
    public Long getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Long facultyID) {
        this.facultyID = facultyID;
    }

    public List<FacultyManagedBean> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<FacultyManagedBean> facultyList) {
        this.facultyList = facultyList;
    }

  

    
     public void addFaculty() throws IOException, RollbackException{
          
       Faculty faculty = new Faculty();
      faculty.setName(facultyManagedBean.getName());
      faculty.setDesignation(facultyManagedBean.getDesignation());
      faculty.setDescription(facultyManagedBean.getDescription());
      if(facultyManagedBean.getPhoto()==null){
          faculty.setPhoto("c:\\image\\other\\default.jpg");
      }
      else{
      faculty.setPhoto(facultyManagedBean.getPhoto());
      }
       FacultyDao facultyDao=new FacultyDao();
       facultyDao.addFaculty(faculty);
      facultyManagedBean.setDescription("");
      facultyManagedBean.setDesignation("");
      facultyManagedBean.setName("");
       
   }
     public List<Faculty> retriveFaculty(){
       FacultyDao facultyDao=new FacultyDao();
       List<Faculty> l1=facultyDao.retriveAllFaculty();
       return l1;
}
      public void deleteFaculty(){
       FacultyDao fd=new FacultyDao();
       fd.deleteFaculty(facultyID);
   }
      public void deleteUploadedFileinFaculty(){
//       SystemFunctionUtil functionUtil=new SystemFunctionUtil();
        facultyManagedBean.setDescription("");
        facultyManagedBean.setName(null);
        
       SystemFunctionUtil.deleteFile(facultyManagedBean.getPhoto());
   }
    
}
