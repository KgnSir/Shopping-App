package WinForms.Tema.AnasayfaDesigner;

import java.awt.*;

import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class SidebarPanel extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    public static Font font = new Font("Verdana", 0, 16);
    
    public SidebarPanel()
    {
        super(DarkBackColor, DarkForeColor, WhiteBackColor, WhiteForeColor);
    }
    

}

