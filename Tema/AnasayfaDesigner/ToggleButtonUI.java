package WinForms.Tema.AnasayfaDesigner;
import java.awt.*;
import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

public class ToggleButtonUI extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor;
    private static Color DarkBackEnteredColor = TemaKontrol.DarkBackColor.brighter();
    private static Color DarkBackPressedColor = TemaKontrol.DarkBackColor.brighter().brighter();
    private static Color DarkBackSelectedColor = TemaKontrol.DarkBackColor.brighter();
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteBackEnteredColor = TemaKontrol.WhiteBackColor.darker();
    private static Color WhiteBackPressedColor = TemaKontrol.WhiteBackColor.darker().darker();
    private static Color WhiteBackSelectedColor = TemaKontrol.WhiteBackColor.darker();
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static Font ButtonFont =  new Font("Verdana", 0, 16);

    public ToggleButtonUI() 
    {
        super(DarkBackColor, DarkBackEnteredColor, DarkBackPressedColor, DarkBackSelectedColor, DarkForeColor,
                WhiteBackColor, WhiteBackEnteredColor, WhiteBackPressedColor, WhiteBackSelectedColor, WhiteForeColor,
                ButtonFont);
    }
}
