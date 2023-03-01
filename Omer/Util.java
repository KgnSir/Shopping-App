package Omer;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Util 
{
    public static boolean IsNullOrEmpty(String metin)
    {
        /*String asd = "";
        asd.isEmpty();*/
        if(metin == null || metin.equals(null) || metin.trim().isEmpty())
            return true;
        else
            return false;
    }
    public static String SplitLast(String metin, Character Hedef)
    {
        return metin.substring(metin.lastIndexOf(Hedef) + 1);
    }
    public static String[][] ArrayStringToString(ArrayList<String[]> arraystr)
    {
        String[][] satirlar = new String[arraystr.size()][];
        for (int i=0;i<satirlar.length;i++)
        {
            satirlar[i] = arraystr.get(i);
        }
        return satirlar;
    }
    static int ImageCozunurlugu = java.awt.Image.SCALE_SMOOTH;
    public static Image getImage(String filePath)
    {
        return Toolkit.getDefaultToolkit().getImage(filePath);
    }
    public static Image fixImageSize(Image img, JFrame frame)
    {
        int imgw = (int)Math.round(frame.getWidth()*0.52083);
        int imgh = (int)Math.round(frame.getHeight()*0.55555);
        return img.getScaledInstance(imgw, imgh,  ImageCozunurlugu);
    }
    public static Image fixImageSize(Image img, JFrame frame, Dimension manualAddSize)
    {
        int imgw = (int)Math.round(frame.getWidth()*0.25)+(int)manualAddSize.getWidth();
        int imgh = (int)Math.round(frame.getHeight()*0.25)+(int)manualAddSize.getHeight();
        return img.getScaledInstance(imgw, imgh,  ImageCozunurlugu);
    }
    public static Image fixImageSize(Image img, Dimension size)
    {
        return img.getScaledInstance((int)size.getWidth(), (int)size.getHeight(),  ImageCozunurlugu);
    }
    public static Image fixImageSize(Image image, double d, double e) {
        return null;
    }
    public static boolean isInJTextField(Component comp)
    {
        if (comp.getClass().equals(JTextField.class)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isInOzelMetin(Component itemType, String itemName)
    {
        String classname = itemType.getClass().toString();
        if (classname.contains(itemName)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isInOzelMetinS(Component itemType, String itemName)
    {
        String classname = itemType.getClass().toString();
        String itemTypeName = classname.substring(classname.lastIndexOf('.') + 1);
        return itemTypeName == itemName;
        /*if (classname.contains(itemName)) {
            return true;
        } else {
            return false;
        }*/
    }
    public static Point getLocationThisPC(Dimension frameSize)
    {
        int width = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-frameSize.getWidth())/2,
            height = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-frameSize.getHeight())/2;
        return new Point(width, height);
    }
 
}
