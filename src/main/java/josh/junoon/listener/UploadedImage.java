/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package josh.junoon.listener;

/**
 *
 * @author krunal
 */
public class UploadedImage {
    public int Length;
    public String Name;
    public byte[] Data;

    public UploadedImage() {
    }

    public UploadedImage(int Length, String Name, byte[] Data) {
        this.Length = Length;
        this.Name = Name;
        this.Data = Data;
    }

    public byte[] getData() {
        return Data;
    }

    public int getLength() {
        return Length;
    }

    public String getName() {
        return Name;
    }

    public void setData(byte[] Data) {
        this.Data = Data;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }
    
}
