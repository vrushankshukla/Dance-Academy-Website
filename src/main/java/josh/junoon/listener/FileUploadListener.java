/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package josh.junoon.listener;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import jose.junnon.managedbean.AchievementManagedBean;
import jose.junnon.managedbean.AlbumManagedBean;
import jose.junnon.managedbean.BranchManagedBean;
import jose.junnon.managedbean.EventManagedBean;
import jose.junnon.managedbean.FacultyManagedBean;
import jose.junnon.managedbean.PhotoGalleryManagedBean;
import jose.junnon.model.Branch;
import jose.junnon.servicebean.EditFacultyData;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
//import org.primefaces.event.FileUploadEvent;
//import org.primefaces.model.StreamedContent;
//import org.primefaces.model.UploadedFile;

/**
 *
 * @author ncontractor
 */
@ManagedBean
@ViewScoped
public class FileUploadListener {
//    private StreamedContent chart;  

    public String retriveimagePath;

    public FileUploadListener() {
    }
    @ManagedProperty(value = "#{fileUploadBean}")
    private FileUploadBean fileUploadBean;
    @ManagedProperty(value = "#{photoGalleryManagedBean}")
    private PhotoGalleryManagedBean photoGalleryManagedBean;
    @ManagedProperty(value = "#{eventManagedBean}")
    private EventManagedBean eventManagedBean;
    @ManagedProperty(value = "#{facultyManagedBean}")
    private FacultyManagedBean facultyManagedBean;
     @ManagedProperty(value = "#{editFacultyData}")
    private EditFacultyData editFacultyData;
    @ManagedProperty(value="#{albumManagedBean}")
    private AlbumManagedBean albumManagedBean;
     @ManagedProperty(value="#{branchManagedBean}")
    private BranchManagedBean branchManagedBean;
      @ManagedProperty(value="#{achievementManagedBean}")
    private AchievementManagedBean achievementManagedBean;
    public String getRetriveimagePath() {
        System.out.println("this is image path. in other gfilr.." + retriveimagePath);
        return retriveimagePath;
    }

    public void setPhotoGalleryManagedBean(PhotoGalleryManagedBean photoGalleryManagedBean) {
        this.photoGalleryManagedBean = photoGalleryManagedBean;
    }

    public PhotoGalleryManagedBean getPhotoGalleryManagedBean() {
        return photoGalleryManagedBean;
    }

    public void setAchievementManagedBean(AchievementManagedBean achievementManagedBean) {
        this.achievementManagedBean = achievementManagedBean;
    }

    public AchievementManagedBean getAchievementManagedBean() {
        return achievementManagedBean;
    }

    public AlbumManagedBean getAlbumManagedBean() {
        return albumManagedBean;
    }

    public void setAlbumManagedBean(AlbumManagedBean albumManagedBean) {
        this.albumManagedBean = albumManagedBean;
    }

    public void setEditFacultyData(EditFacultyData editFacultyData) {
        this.editFacultyData = editFacultyData;
    }

    public EditFacultyData getEditFacultyData() {
        return editFacultyData;
    }

    
    public EventManagedBean getEventManagedBean() {
        return eventManagedBean;
    }

    public void setEventManagedBean(EventManagedBean eventManagedBean) {
        this.eventManagedBean = eventManagedBean;
    }

    public FacultyManagedBean getFacultyManagedBean() {
        return facultyManagedBean;
    }

    public void setFacultyManagedBean(FacultyManagedBean facultyManagedBean) {
        this.facultyManagedBean = facultyManagedBean;
    }

    public BranchManagedBean getBranchManagedBean() {
        return branchManagedBean;
    }

    public void setBranchManagedBean(BranchManagedBean branchManagedBean) {
        this.branchManagedBean = branchManagedBean;
    }

    
    public FileUploadBean getFileUploadBean() {
        return fileUploadBean;
    }

    public void setFileUploadBean(FileUploadBean fileUploadBean) {
        this.fileUploadBean = fileUploadBean;
    }

    public void setRetriveimagePath(String retriveimagePath) {

        this.retriveimagePath = retriveimagePath;

    }

    public void imageUploadListenerforPhotoGallery(FileUploadEvent event) throws Exception {
String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/photos/";
        System.out.println("this is java file upload.............");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        photoGalleryManagedBean.setPhoto(item.getName());
        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        SystemFunctionUtil.createFile(item.getData(), path + item.getName(), ".jpg");
    }

    public void imageUploadListenerforFaculty(FileUploadEvent event) throws Exception {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/faculty/";
        
        System.out.println("this is java file upload............."+path);
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
//        facultyManagedBean.setPhoto("c:\\image\\faculty\\" + item.getName());
        facultyManagedBean.setPhoto(item.getName());

        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        System.out.println(path);
        SystemFunctionUtil.createFile(item.getData(), path+ item.getName(), ".jpg");
    }
     public void imageUploadListenerforFacultyEdit(FileUploadEvent event) throws Exception {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/faculty/";
        
        System.out.println("this is java file upload............."+path);
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
//        facultyManagedBean.setPhoto("c:\\image\\faculty\\" + item.getName());
        editFacultyData.setEditPhotopath(item.getName());

        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        System.out.println(path);
        SystemFunctionUtil.createFile(item.getData(), path+ item.getName(), ".jpg");
    }

    public void imageUploadListenerforEvent(FileUploadEvent event) throws Exception {
String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/event/";
        System.out.println("this is java file upload.............");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());

        eventManagedBean.setPhoto(item.getName());

        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        SystemFunctionUtil.createFile(item.getData(), path + item.getName(), ".jpg");
    }

    public void imageUploadListenerforAchievment(FileUploadEvent event) throws Exception {
String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/achievement/";
        System.out.println("this is java file upload.............");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        achievementManagedBean.setPhoto(item.getName());
        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        SystemFunctionUtil.createFile(item.getData(), path+ item.getName(), ".jpg");
    }

     public void imageUploadListenerforAlbum(FileUploadEvent event) throws Exception {
String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/album/";
        System.out.println("this is java file upload.............");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        albumManagedBean.setPhoto(item.getName());
        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        SystemFunctionUtil.createFile(item.getData(), path+ item.getName(), ".jpg");
    }
 public void imageUploadListenerforBranch(FileUploadEvent event) throws Exception {
String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+"images/branch/";
        System.out.println("this is java file upload.............");
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        branchManagedBean.setPhoto(item.getName());
        file.setData(item.getData());
        fileUploadBean.files.add(file);
        System.out.println("\n\t----> in file uplload " + item.getName());
        SystemFunctionUtil.createFile(item.getData(), path+ item.getName(), ".jpg");
    }
    
    public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        fileUploadBean.files.add(file);
    }
//
//    public void imageUploadListener1(FileUploadEvent event) throws Exception {
//        UploadedFile item = event.getUploadedFile();
//        systemResultSessionUtil.setImgData(item.getData());
//        systemResultSessionUtil.setImgName(item.getName());
//        String name = item.getName();
////        System.out.println("uploaded file name is " + name);
//        systemResultViewUtil.setIsFileUploaded(true);
//    }
//
//    public void pdfUploadListener(FileUploadEvent event) throws Exception {
//        UploadedFile item = event.getUploadedFile();
//        systemResultViewUtil.setFileData(item.getData());
//        systemResultViewUtil.setFileName(item.getName());
//        String name = item.getName();
////        System.out.println("uploaded file name is " + name);
//    }
//
//    public void videoUploadListener(FileUploadEvent event) throws Exception {
//        UploadedFile item = event.getUploadedFile();
//        systemResultViewUtil.setFileData(item.getData());
//        systemResultViewUtil.setFileName(item.getName());
//        String name = item.getName();
////        System.out.println("uploaded file name is " + name);
//        systemResultViewUtil.setIsFileUploaded(Boolean.TRUE);
//    }
}
