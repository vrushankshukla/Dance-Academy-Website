/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import jose.junnon.dao.BranchDao;
import jose.junnon.managedbean.BranchManagedBean;
import jose.junnon.model.Branch;
import josh.junoon.listener.SystemFunctionUtil;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class BranchServiceBean {
    @ManagedProperty(value="#{branchManagedBean}")
    private BranchManagedBean branchManagedBean;
    private Long branchID;

    public BranchServiceBean() {
    }

    public BranchServiceBean(BranchManagedBean branchManagedBean, Long branchID) {
        this.branchManagedBean = branchManagedBean;
        this.branchID = branchID;
    }

    public BranchManagedBean getBranchManagedBean() {
        return branchManagedBean;
    }

    public void setBranchManagedBean(BranchManagedBean branchManagedBean) {
        this.branchManagedBean = branchManagedBean;
    }
    
    
    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }
    
     
   public void addBranch() throws IOException, ParseException{
           Branch branch = new Branch();
           branch.setBranchName(branchManagedBean.getBranchName());
           branch.setLine1(branchManagedBean.getLine1());
           branch.setLine2(branchManagedBean.getLine2());
           branch.setLine3(branchManagedBean.getLine3());
           branch.setLine4(branchManagedBean.getLine4());
           branch.setLatitude(branchManagedBean.getLatitude());
           branch.setLongitude(branchManagedBean.getLongitude());
          
       if(branchManagedBean.getPhoto()==null){
        branch.setPhoto("c:\\image\\other\\default.jpg");   
       }else
       {
       branch.setPhoto(branchManagedBean.getPhoto());
       }
       BranchDao  branchDao=new BranchDao();
       branchDao.addBranch(branch);
       branchManagedBean.setBranchName("");
       branchManagedBean.setLine1("");
       branchManagedBean.setLine2("");
       branchManagedBean.setLine3("");
       branchManagedBean.setLine4("");
       branchManagedBean.setLatitude("");
       branchManagedBean.setLongitude("");
       
   }
    public List<Branch> retriveBranch(){
       BranchDao dao=new BranchDao();
       List<Branch> l1=dao.retriveAllBranch();
       return l1;
       
   }
   public void deleteBranch(){
       BranchDao dao=new BranchDao();
       dao.deleteBranch(branchID);
   }
   public void deleteUploadedFileinBranch(){
//       SystemFunctionUtil functionUtil=new SystemFunctionUtil();
        branchManagedBean.setBranchName("");
        branchManagedBean.setLine1("");
       branchManagedBean.setLine2("");
       branchManagedBean.setLine3("");
       branchManagedBean.setLine4("");
       branchManagedBean.setLatitude("");
       branchManagedBean.setLongitude("");
       SystemFunctionUtil.deleteFile(branchManagedBean.getPhoto());
   }
     
}
