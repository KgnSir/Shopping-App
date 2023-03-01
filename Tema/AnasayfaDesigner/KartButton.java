package WinForms.Tema.AnasayfaDesigner;
import java.awt.*;

import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class KartButton extends TemaRenkleri
    {
        private static Color DarkBackColor = TemaKontrol.DarkBackColor;
        private static Color DarkBackEnteredColor = TemaKontrol.DarkBackColor.brighter();
        private static Color DarkBackPressedColor = TemaKontrol.DarkBackColor.brighter().brighter();
        private static Color DarkLineColor = TemaKontrol.DarkForeColor;
        private static Color DarkForeColor = TemaKontrol.DarkForeColor;
        private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
        private static Color WhiteBackEnteredColor = TemaKontrol.WhiteBackColor.darker();
        private static Color WhiteBackPressedColor = TemaKontrol.WhiteBackColor.darker().darker();
        private static Color WhiteLineColor = TemaKontrol.WhiteForeColor;
        private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
        private static Font ButtonFont =  new Font("Verdana", 0, 16);

        public KartButton() 
        {
            super(DarkBackColor, DarkBackEnteredColor, DarkBackPressedColor,DarkForeColor,DarkLineColor,
            WhiteBackColor, WhiteBackEnteredColor, WhiteBackPressedColor, WhiteForeColor,WhiteLineColor,
            ButtonFont, 1);
        }
        
    }
