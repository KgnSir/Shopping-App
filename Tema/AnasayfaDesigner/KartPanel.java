package WinForms.Tema.AnasayfaDesigner;
import java.awt.*;

import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class KartPanel extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static Font ButtonFont =  new Font("Verdana", 0, 16);

    public KartPanel() 
    {
        super(DarkBackColor, DarkForeColor,WhiteBackColor, WhiteForeColor,ButtonFont);
    }
    
}