package WinForms.Tema.AnasayfaDesigner;
import java.awt.*;
import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class KartLabel extends TemaRenkleri
    {
        private static Color DarkBackColor = TemaKontrol.DarkBackColor;
        private static Color DarkForeColor = TemaKontrol.DarkForeColor;
        private static Color DarkLineColor = TemaKontrol.DarkForeColor;
        private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
        private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
        private static Color WhiteLineColor = TemaKontrol.WhiteForeColor;
        private static Font ButtonFont =  new Font("Verdana", 0, 16);

        public KartLabel() 
        {
            super(DarkBackColor, DarkForeColor,DarkLineColor,WhiteBackColor, WhiteForeColor,WhiteLineColor,ButtonFont);
        }
        
    }