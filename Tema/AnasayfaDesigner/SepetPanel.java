package WinForms.Tema.AnasayfaDesigner;
import java.awt.*;

import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class SepetPanel extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor2;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor2;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static Font ButtonFont =  new Font("Verdana", 0, 16);

    public SepetPanel() 
    {
        super(DarkBackColor, DarkForeColor,WhiteBackColor, WhiteForeColor,ButtonFont);
    }
    
}