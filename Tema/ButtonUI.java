package WinForms.Tema;
import java.awt.*;
public class ButtonUI extends TemaRenkleri
{
    private static Color DarkBackColor = new Color(32,32,32);
    private static Color DarkBackEnteredColor = new Color(45,45,45);
    private static Color DarkBackPressedColor = new Color(41,41,41);
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color DarkLineColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = new Color(204,204,204);
    private static Color WhiteBackEnteredColor = new Color(234,234,234);
    private static Color WhiteBackPressedColor = new Color(153,153,153);
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static Color WhiteLineColor = TemaKontrol.WhiteForeColor;
    public ButtonUI()
    {
        super(DarkBackColor,DarkBackEnteredColor,DarkBackPressedColor, DarkForeColor,DarkLineColor, WhiteBackColor,WhiteBackEnteredColor,WhiteBackPressedColor,WhiteForeColor,WhiteLineColor);
    }
}
