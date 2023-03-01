package WinForms.Tema;
import java.awt.*;
public class JPanel extends TemaRenkleri
{
    private static Color DarkBackColor = TemaKontrol.DarkBackColor;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;

    public JPanel()
    {
        super(DarkBackColor,DarkForeColor, WhiteBackColor, WhiteForeColor);
    }
}