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
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jose.junnon.dao.FacultyDao;
import jose.junnon.managedbean.FacultyManagedBean;
import jose.junnon.model.Faculty;

/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class EditFacultyData {
     @ManagedProperty(value="#{facultyManagedBean}")
    private FacultyManagedBean facultyManagedBean;
    private Long facultyEditId; 
    public  List<FacultyManagedBean> facultyList = new ArrayList<FacultyManagedBean>();
    public String editPhotopath;
    public EditFacultyData() {
    }

    public Long getFacultyEditId() {
        return facultyEditId;
    }

    public List<FacultyManagedBean> getFacultyList() {
        return facultyList;
    }

    public void setFacultyManagedBean(FacultyManagedBean facultyManagedBean) {
        this.facultyManagedBean = facultyManagedBean;
    }

    public FacultyManagedBean getFacultyManagedBean() {
        return facultyManagedBean;
    }

    public void setFacultyEditId(Long facultyEditId) {
        this.facultyEditId = facultyEditId;
    }

    public void setFacultyList(List<FacultyManagedBean> facultyList) {
        this.facultyList = facultyList;
    }

    public String getEditPhotopath() {
        return editPhotopath;
    }

    public void setEditPhotopath(String editPhotopath) {
        this.editPhotopath = editPhotopath;
    }
      
      
      
      
        public void retriveFacultyById(){
          FacultyDao facultyDao=new FacultyDao();
          System.out.println("inside retrive id method");
//         facultyList = facultyDao.retriveById(facultyEditId);
//          if(facultyList.size() > 0 && facultyList != null)
          for(Faculty faculty1 : facultyDao.retriveById(facultyEditId)){
              FacultyManagedBean faculty = new FacultyManagedBean();
              System.out.println("faculty data by id"+faculty1.getName());
          faculty.setId(faculty1.getId());
          faculty.setName(faculty1.getName());
          faculty.setDesignation(faculty1.getDesignation());
          faculty.setDescription(faculty1.getDescription());
          faculty.setPhoto(faculty1.getPhoto());
          facultyList.add(faculty);
          }
          
      }
      public void updateFaculty() throws IOException{
           ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
           FacultyDao facultyDao=new FacultyDao();
          Faculty  faculty=new Faculty();
          System.out.println(facultyList);
          System.out.println("edited image is"+editPhotopath+getEditPhotopath()); 
          for(FacultyManagedBean f:facultyList){
           faculty.setDescription(f.getDescription());
           faculty.setDesignation(f.getDesignation());
           faculty.setName(f.getName());
           if(editPhotopath==null){ 
            faculty.setPhoto(f.getPhoto());   
           }else{
           faculty.setPhoto(getEditPhotopath());
           }
              System.out.println("faculty data is"+faculty.getName()+faculty.getDescription());
              System.out.println("faculty image is"+f.getPhoto()+getEditPhotopath());
         System.out.println("before:"+f.getName()+"/n its id now \n"+facultyEditId);
//           faculty.setId(facultyID);
//           System.out.println("after"+faculty.getId()+faculty.getName());
           facultyDao.updateFaculty(faculty,facultyEditId);
           
           
      }
           setEditPhotopath(null);
            context.redirect("adminHome.xhtml");
}
      public void init(){
          facultyList.clear();
      }
}