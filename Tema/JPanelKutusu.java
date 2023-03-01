package WinForms.Tema;
import java.awt.*;
public class JPanelKutusu extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor2;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor2;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;

    public JPanelKutusu()
    {
        super(DarkBackColor,DarkForeColor, WhiteBackColor, WhiteForeColor);
    }
}