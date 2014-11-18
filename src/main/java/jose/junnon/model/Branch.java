package jose.junnon.model;
// Generated 30 Oct, 2013 3:53:29 PM by Hibernate Tools 3.2.1.GA



/**
 * Branch generated by hbm2java
 */
public class Branch  implements java.io.Serializable {


     private long id;
     private String branchName;
     private String line1;
     private String line2;
     private String line3;
     private String line4;
     private String photo;
     private String latitude;
     private String longitude;

    public Branch() {
    }

	
    public Branch(long id) {
        this.id = id;
    }
    public Branch(long id, String branchName, String line1, String line2, String line3, String line4, String photo, String latitude, String longitude) {
       this.id = id;
       this.branchName = branchName;
       this.line1 = line1;
       this.line2 = line2;
       this.line3 = line3;
       this.line4 = line4;
       this.photo = photo;
       this.latitude = latitude;
       this.longitude = longitude;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getBranchName() {
        return this.branchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getLine1() {
        return this.line1;
    }
    
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public String getLine2() {
        return this.line2;
    }
    
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public String getLine3() {
        return this.line3;
    }
    
    public void setLine3(String line3) {
        this.line3 = line3;
    }
    public String getLine4() {
        return this.line4;
    }
    
    public void setLine4(String line4) {
        this.line4 = line4;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }




}

