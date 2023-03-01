package Omer;
import javax.swing.*;

public class MessageBox 
{
    private static boolean sysoutKullan = false;

    public static final int Error = 0;
    public static final int Information = 1;
    public static final int Warning = 2;
    public static final int Questions = 3;
    public static final int Plain = -1;

    public static void Show(String Message)
    {
        MessageBox.Show(Message, "Omer", Plain);
    }
    public static void Show(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Özel bir hata oluştu.\n"+e.getMessage()+"\n"+e.getClass(), "Omer", Plain);
    }
    public static void Show(String Message, String Title)
    {
        MessageBox.Show(Message, Title, Plain);
    }
    public static void Show(String Message, String Title, int Icon)
    {
        if (sysoutKullan)
            System.out.println("["+Title+"] "+Message);
        else
            JOptionPane.showMessageDialog(null, Message, Title, Icon);
    }
}
