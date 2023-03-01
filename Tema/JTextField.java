package WinForms.Tema;

import java.awt.Color;

public class JTextField extends TemaRenkleri
{

    private static Color DarkBackColor = TemaKontrol.DarkBackColor;
    private static Color DarkForeColor = TemaKontrol.DarkForeColor;
    private static Color WhiteBackColor = TemaKontrol.WhiteBackColor;
    private static Color WhiteForeColor = TemaKontrol.WhiteForeColor;
    private static java.awt.Font font = TemaKontrol.font;
    public JTextField()
    {
        super(DarkBackColor,DarkForeColor, WhiteBackColor, WhiteForeColor, font);
    }
}
    