/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package josh.junoon.listener;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import jose.junnon.dao.PhotogalleryDao;

/**
 *
 * @author mpritmani
 */
public class SystemFunctionUtil {

    public static Date convertToStartDate(Date date) {
        Calendar calDate = Calendar.getInstance();
        if (date != null) {
            calDate.setTime(date);
        }
        calDate.set(Calendar.HOUR_OF_DAY, 0);
        calDate.set(Calendar.MINUTE, 0);
        calDate.set(Calendar.SECOND, 0);
        calDate.set(Calendar.MILLISECOND, 0);
        return calDate.getTime();
    }

    public static Date convertToEndDate(Date date) {
        Calendar calDate = Calendar.getInstance();
        if (date != null) {
            calDate.setTime(date);
        }
        calDate.set(Calendar.HOUR_OF_DAY, 23);
        calDate.set(Calendar.MINUTE, 59);
        calDate.set(Calendar.SECOND, 59);
        calDate.set(Calendar.MILLISECOND, 999);
        return calDate.getTime();
    }

    /**
     * 
     * @param content
     * @return name of the created file, if could not be created, returns null
     */
    public static String createFile(byte[] content, String filePath, String extension) {
        System.out.println("time is " + new Date().getTime());
        String fileName = null;
        if (filePath != null) {
            try {
//                fileName = new Date().getTime() + extension;
//                System.out.println("this is file path before apend" + filePath);
//                filePath += fileName;
                System.out.println("this is file path after apend" + filePath);
                File newFile = new File(filePath);

                System.out.println("file path is " + filePath);

                System.out.println("exists " + newFile.exists());
                if (newFile.exists()) {
                }
                newFile.createNewFile();
                if (newFile.exists()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                    fileOutputStream.write(content);
                    fileOutputStream.close();
                    

                } else {
                    fileName = null;
                }
            } catch (Exception exception) {
                System.out.println("Exception is " + exception.getMessage());
                exception.printStackTrace();
                fileName = null;
            }
        } else {
            System.out.println("path v got is null");
        }
        return fileName;
    }

    public static void deleteFile(String file) {
        if (file != null && !file.isEmpty()) {
            File f1 = new File(file);
            boolean success = f1.delete();
        }
    }
}
