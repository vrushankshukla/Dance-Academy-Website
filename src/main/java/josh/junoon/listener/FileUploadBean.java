/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package josh.junoon.listener;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
 
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
 
/**
 *
 * @author krunal
 */
@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {
    public ArrayList<UploadedImage> files = new ArrayList<UploadedImage>();
  private byte[] imageData;

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
  
    public void paint(OutputStream stream, Object object) throws IOException {
        stream.write(getFiles().get((Integer) object).getData());
        stream.close();
    }
 
    
  public void drawImage(OutputStream out, Object data) throws IOException {
//        System.out.println("in draw image method....................");
        if ((data instanceof String) && data != null) {
            String imageName1 = data.toString();
//            System.out.println("in first if image name " + imageName);
            BufferedImage img = null;
            if (imageName1 == null || imageName1.trim().length() <= 0) {
                System.out.println("Image Name not found");
            } else {
                String extension = imageName1.substring(imageName1.lastIndexOf(".") + 1);
                java.io.File file = new java.io.File(imageName1);
                if (file != null && file.exists()) {
                    img = ImageIO.read(file);
                    ImageIO.write(img, extension, out);
                } else {
                    System.out.println("file not found....");
                }
            }
        } else {
//            System.out.println("in else........." + imageData);
            if (this.imageData != null && imageData.length > 0) {
                out.write(imageData);
            }
        }
    }
    public String clearUploadData() {
        files.clear();
        return null;
    }
 
    public int getSize() {
        if (getFiles().size() > 0) {
            return getFiles().size();
        } else {
            return 0;
        }
    }
 
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
 
    public ArrayList<UploadedImage> getFiles() {
        return files;
    }
 
    public void setFiles(ArrayList<UploadedImage> files) {
        this.files = files;
    }
    public String init() throws IOException{
       
     files.clear();
     return null;
    }
}