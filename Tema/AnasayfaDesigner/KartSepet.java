package WinForms.Tema.AnasayfaDesigner;
import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;
import java.awt.*;
public class KartSepet extends TemaRenkleri 
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor.brighter();
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor.darker();
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static Font ButtonFont =  new Font("Verdana", 0, 16);

    public KartSepet() 
    {
        super(DarkBackColor, DarkForeColor,WhiteBackColor, WhiteForeColor,ButtonFont);
    }

    public TemaRenkleri CloseButton() 
    {
        return new CloseButton();
    }
    public class CloseButton extends TemaRenkleri
    {
        private static Color DarkBackColor = new Color(255,0,0).darker();
        private static Color DarkForeColor = Color.white;
        private static Color WhiteBackColor = new Color(255,0,0);
        private static Color WhiteForeColor = Color.black;
        private static Font ButtonFont =  new Font("Verdana", 0, 16);
    
        public CloseButton() 
        {
            super(DarkBackColor, DarkForeColor,WhiteBackColor, WhiteForeColor,ButtonFont);
        }
    }
}
