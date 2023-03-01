package WinForms.Tema;
import java.awt.*;
public class Items extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor2;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor2;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;

    public Items()
    {
        super(DarkBackColor,DarkForeColor, WhiteBackColor, WhiteForeColor);
    }
}
