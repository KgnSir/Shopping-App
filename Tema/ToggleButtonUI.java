package WinForms.Tema;
import java.awt.*;
public class ToggleButtonUI extends TemaRenkleri
{
  
    /*public static Color color = new Color(0, 0, 139);
    public static Color btnColor = TemaKontrol.DarkBackColor3;
    public static Color btnSelectingColor = color.darker();
    public static Color btnSelectedColor = color.brighter();
    public static Color btnEnteredColor = color;
    public static Color btnForeColor = Color.white;*/
    /*public class Sidebar
    {
        public static Color color = new Color(0, 0, 139);
        //public static Color btnColor = TemaKontrol.DarkBackColor3;
        //public static Color btnSelectingColor = color.darker();
        //public static Color btnSelectedColor = color.brighter();
        //public static Color btnEnteredColor = color;

        private static Color DarkBackColor = TemaKontrol.DarkBackColor2;
        private static Color DarkBackEnteredColor = color;
        private static Color DarkBackPressedColor = color.darker();
        private static Color DarkBackSelectedColor = color.brighter();
        private static Color DarkForeColor = color;
        private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
        private static Color WhiteBackEnteredColor = color;
        private static Color WhiteBackPressedColor =  color.darker();
        private static Color WhiteBackSelectedColor = color.brighter();
        private static Color WhiteForeColor = color;
    }*/
     /*void UseSidebar()
    {
        new TemaRenkleri(
            Sidebar.DarkBackColor, Sidebar.DarkBackEnteredColor, Sidebar.DarkBackPressedColor,Sidebar.DarkBackSelectedColor, Sidebar.DarkForeColor, 
            Sidebar.WhiteBackColor, Sidebar.WhiteBackEnteredColor,Sidebar.WhiteBackPressedColor,Sidebar.WhiteBackSelectedColor,Sidebar.WhiteForeColor);
    }*/
    
    private static Color DarkBackColor = new Color(32,32,32);
    private static Color DarkBackEnteredColor = new Color(45,45,45);
    private static Color DarkBackPressedColor = new Color(41,41,41);
    private static Color DarkBackSelectedColor = new Color(0,0,139).brighter();
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    //private static Color DarkLineColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = new Color(204,204,204);
    private static Color WhiteBackEnteredColor = new Color(234,234,234);
    private static Color WhiteBackPressedColor = new Color(153,153,153);
    private static Color WhiteBackSelectedColor = new Color(0,0,139);
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    //private static Color WhiteLineColor = TemaKontrol.WhiteForeColor;

    /*private static Color DarkBackColor = TemaKontrol.DarkBackColor2;
    private static Color DarkBackEnteredColor = TemaKontrol.DarkBackColor.brighter();
    private static Color DarkBackPressedColor = TemaKontrol.DarkBackColor.darker();
    private static Color DarkBackSelectedColor = TemaKontrol.DarkBackColor.brighter().brighter();
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteBackEnteredColor = TemaKontrol.WhiteBackColor.darker();
    private static Color WhiteBackPressedColor = TemaKontrol.WhiteBackColor.darker().darker();
    private static Color WhiteBackSelectedColor = TemaKontrol.DarkBackColor.brighter().brighter();
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;*/
    public ToggleButtonUI() 
    {
        super(
            DarkBackColor, DarkBackEnteredColor, DarkBackPressedColor,DarkBackSelectedColor, DarkForeColor, 
            WhiteBackColor, WhiteBackEnteredColor,WhiteBackPressedColor,WhiteBackSelectedColor,WhiteForeColor, TemaKontrol.font);
    }
   

}
