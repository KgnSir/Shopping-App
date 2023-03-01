package WinForms.Tema;
import java.awt.*;

public class TemaKontrol
{
    public static boolean IsDarkMode = true;
    public static void setIsDarkMode(boolean isDarkMode) {
        IsDarkMode = isDarkMode;
    }
    public static Color DarkBackColor = new Color(18,18,18);
    public static Color DarkBackColor2 = new Color(24,24,24);
    public static Color DarkBackColor3 = new Color(40,40,40);
    public static Color DarkBackColor4 = new Color(64,64,64);
    public static Color DarkForeColor = Color.white;
    //public static Color WhiteBackColor = new Color(255, 255, 255);
    public static Color WhiteBackColor = new Color(246,246,246);
    public static Color WhiteBackColor2 = new Color(216,215,215);
    public static Color WhiteBackColor3 = new Color(179,179,179);
    public static Color WhiteForeColor = new Color(30,30,30);
    public static Color HoverColor = DarkBackColor3.brighter();
    public static Color ClickingColor = DarkBackColor2.darker();
    public static Font  font = new Font("Verdana", Font.BOLD, 24);
    public static Color getBackColor(){return IsDarkMode ? DarkBackColor : WhiteBackColor;}
    public static Color getBackColorTers(){return !IsDarkMode ? WhiteBackColor : DarkBackColor;}
    public static Color getForeColor(){return IsDarkMode ? DarkForeColor : WhiteForeColor;}
    public static Color getForeColorTers(){return !IsDarkMode ? WhiteForeColor : DarkForeColor;}
}