/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jose.junnon.servicebean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jose.junnon.dao.EventDao;
import jose.junnon.managedbean.EventManagedBean;
import jose.junnon.model.Event;
import josh.junoon.listener.SystemFunctionUtil;

/**
 *
 * @author SONY
 */
@ManagedBean
@SessionScoped
public class EventServiceBean {
     
   @ManagedProperty(value="#{eventManagedBean}")
   private EventManagedBean eventManagedBean;
   private Long eventId;
    public EventServiceBean() {
    }

    public EventServiceBean(EventManagedBean eventManagedBean) {
        this.eventManagedBean = eventManagedBean;
    }

    public EventManagedBean getEventManagedBean() {
        return eventManagedBean;
    }

    public void setEventManagedBean(EventManagedBean eventManagedBean) {
        this.eventManagedBean = eventManagedBean;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

   

   

   
   public void addEvent() throws IOException, ParseException{
           Event event=new Event();
      SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
      Date startDate=dateFormat.parse(eventManagedBean.getStartdate());
       event.setTitle(eventManagedBean.getTitle());
//       event.setStartdate(eventManagedBean.getStartdate());
//       String string = eventManagedBean.getStartdate();
//        Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(string);
        event.setStartdate(startDate);
//       
        SimpleDateFormat  enddateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date endDate=enddateFormat.parse(eventManagedBean.getEnddate());
        event.setEnddate(endDate);
//       event.setEnddate(date);
       event.setDescription(eventManagedBean.getDescription());
       event.setPlace(eventManagedBean.getPlace());
       if(eventManagedBean.getPhoto()==null){
        event.setPhoto("c:\\image\\other\\default.jpg");   
       }else
       {
       event.setPhoto(eventManagedBean.getPhoto());
       }
       EventDao eventDao=new EventDao();
       eventDao.addEvent(event);
       eventManagedBean.setDescription("");
       eventManagedBean.setEnddate(null);
       eventManagedBean.setStartdate(null);
       eventManagedBean.setTitle("");
       eventManagedBean.setPlace("");
       
   }
    public List<Event> retriveEvent(){
       EventDao dao=new EventDao();
       List<Event> l1=dao.retriveAllEvent();
       return l1;
       
   }
   public void deleteEvent(){
       EventDao dao=new EventDao();
       System.out.println("delete event");
       dao.deleteEvent(eventId);
   }
   public void deleteUploadedFileinEvent(){
//       SystemFunctionUtil functionUtil=new SystemFunctionUtil();
        eventManagedBean.setDescription("");
        eventManagedBean.setStartdate(null);
        eventManagedBean.setEnddate(null);
        eventManagedBean.setTitle("");
        eventManagedBean.setPlace("");
       SystemFunctionUtil.deleteFile(eventManagedBean.getPhoto());
   }
}
