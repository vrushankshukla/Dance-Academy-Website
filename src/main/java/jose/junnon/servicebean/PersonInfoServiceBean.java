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
import jose.junnon.dao.PersonInfoDao;
import jose.junnon.managedbean.PersonInfoManagedBean;
import jose.junnon.model.PersonInfo;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class PersonInfoServiceBean {
    @ManagedProperty(value="#{personInfoManagedBean}")
    private PersonInfoManagedBean personInfoManagedBean;
    private Long infoId;

    public PersonInfoServiceBean() {
    }

    public PersonInfoServiceBean(PersonInfoManagedBean personInfoManagedBean, Long infoId) {
        this.personInfoManagedBean = personInfoManagedBean;
        this.infoId = infoId;
    }

    public PersonInfoManagedBean getPersonInfoManagedBean() {
        return personInfoManagedBean;
    }

    public void setPersonInfoManagedBean(PersonInfoManagedBean personInfoManagedBean) {
        this.personInfoManagedBean = personInfoManagedBean;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }
     public void addPersonInfo() throws IOException, ParseException{
           PersonInfo personInfo=new PersonInfo();
     personInfo.setName(personInfoManagedBean.getName());
     personInfo.setPhoneNumber(personInfoManagedBean.getPhoneNumber()); 
     personInfo.setEmailId(personInfoManagedBean.getEmailId());
 
     
       PersonInfoDao personInfoDao=new PersonInfoDao();
       personInfoDao.addPersonInfo(personInfo);
       personInfoManagedBean.setName("");
       personInfoManagedBean.setPhoneNumber("");
       personInfoManagedBean.setEmailId("");
   }
    public List<PersonInfo> retrivePersonInfo(){
       PersonInfoDao dao=new PersonInfoDao();
       List<PersonInfo> l1=dao.retriveAllPersonInfo();
       return l1;
       
   }
   public void deletePersonInfo(){
       PersonInfoDao dao=new PersonInfoDao();
       dao.deletePersonInfo(infoId);
   }
  
}


