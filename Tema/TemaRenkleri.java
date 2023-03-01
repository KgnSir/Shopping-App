package WinForms.Tema;
import java.awt.*;

public class TemaRenkleri 
{
    Color 
    DarkBackColor,
    DarkBackEnteredColor,DarkBackPressedColor,DarkBackSelectedColor,
    DarkForeColor,DarkLineColor,
    
    WhiteBackColor,
    WhiteBackEnteredColor,WhiteBackPressedColor,WhiteBackSelectedColor,
    WhiteForeColor,WhiteLineColor;

    Font Font;
    protected TemaRenkleri(Color DarkBackColor, Color DarkForeColor, Color WhiteBackColor, Color WhiteForeColor)
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkBackEnteredColor = DarkBackColor.brighter();
        this.DarkBackPressedColor = DarkBackColor.darker();
        this.DarkForeColor = DarkForeColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteBackEnteredColor = WhiteBackColor.darker();
        this.WhiteBackPressedColor = WhiteBackColor.brighter();
        this.WhiteForeColor = WhiteForeColor;
        this.DarkLineColor = DarkForeColor;
        this.WhiteLineColor = WhiteForeColor;
    }
    TemaRenkleri(Color DarkBackColor, Color DarkBackEnteredColor, Color DarkBackPressedColor,
            Color DarkForeColor, Color WhiteBackColor, Color WhiteBackEnteredColor, Color WhiteBackPressedColor,
            Color WhiteForeColor) 
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkBackEnteredColor = DarkBackEnteredColor;
        this.DarkBackPressedColor = DarkBackPressedColor;
        this.DarkForeColor = DarkForeColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteBackEnteredColor = WhiteBackEnteredColor;
        this.WhiteBackPressedColor = WhiteBackPressedColor;
        this.WhiteForeColor = WhiteForeColor;
        this.DarkLineColor = DarkForeColor;
        this.WhiteLineColor = WhiteForeColor;
    }
    TemaRenkleri(Color DarkBackColor, Color DarkBackEnteredColor, Color DarkBackPressedColor,
    Color DarkForeColor,Color DarkLineColor, Color WhiteBackColor, Color WhiteBackEnteredColor, Color WhiteBackPressedColor,
    Color WhiteForeColor,Color WhiteLineColor) 
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkBackEnteredColor = DarkBackEnteredColor;
        this.DarkBackPressedColor = DarkBackPressedColor;
        this.DarkForeColor = DarkForeColor;
        this.DarkLineColor = DarkLineColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteBackEnteredColor = WhiteBackEnteredColor;
        this.WhiteBackPressedColor = WhiteBackPressedColor;
        this.WhiteForeColor = WhiteForeColor;
        this.WhiteLineColor = WhiteLineColor;
    }
    TemaRenkleri(
    Color DarkBackColor, Color DarkBackEnteredColor, Color DarkBackPressedColor, Color DarkBackSelectedColor,Color DarkForeColor,Color DarkLineColor, 
    Color WhiteBackColor, Color WhiteBackEnteredColor, Color WhiteBackPressedColor,Color WhiteBackSelectedColor, Color WhiteForeColor,Color WhiteLineColor)
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkBackEnteredColor = DarkBackEnteredColor;
        this.DarkBackPressedColor = DarkBackPressedColor;
        this.DarkBackSelectedColor = DarkBackSelectedColor;
        this.DarkForeColor = DarkForeColor;
        this.DarkLineColor = DarkLineColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteBackEnteredColor = WhiteBackEnteredColor;
        this.WhiteBackPressedColor = WhiteBackPressedColor;
        this.WhiteBackSelectedColor = WhiteBackSelectedColor;
        this.WhiteForeColor = WhiteForeColor;
        this.WhiteLineColor = WhiteLineColor;
    }
    protected TemaRenkleri(
        Color DarkBackColor, Color DarkBackEnteredColor, Color DarkBackPressedColor, Color DarkBackSelectedColor,Color DarkForeColor,
        Color WhiteBackColor, Color WhiteBackEnteredColor, Color WhiteBackPressedColor,Color WhiteBackSelectedColor, Color WhiteForeColor,
        Font Font)
        {
            this.DarkBackColor = DarkBackColor;
            this.DarkBackEnteredColor = DarkBackEnteredColor;
            this.DarkBackPressedColor = DarkBackPressedColor;
            this.DarkBackSelectedColor = DarkBackSelectedColor;
            this.DarkForeColor = DarkForeColor;
            this.WhiteBackColor = WhiteBackColor;
            this.WhiteBackEnteredColor = WhiteBackEnteredColor;
            this.WhiteBackPressedColor = WhiteBackPressedColor;
            this.WhiteBackSelectedColor = WhiteBackSelectedColor;
            this.WhiteForeColor = WhiteForeColor;
            this.Font = Font;
        }
    public TemaRenkleri(Color DarkBackColor, Color DarkBackEnteredColor, Color DarkBackPressedColor, Color DarkBackSelectedColor,Color DarkForeColor,Color DarkLineColor, 
                        Color WhiteBackColor, Color WhiteBackEnteredColor, Color WhiteBackPressedColor,Color WhiteBackSelectedColor, Color WhiteForeColor,
                        Font Font) {
            this.DarkBackColor = DarkBackColor;
            this.DarkBackEnteredColor = DarkBackEnteredColor;
            this.DarkBackPressedColor = DarkBackPressedColor;
            this.DarkBackSelectedColor = DarkBackSelectedColor;
            this.DarkForeColor = DarkForeColor;
            this.WhiteBackColor = WhiteBackColor;
            this.WhiteBackEnteredColor = WhiteBackEnteredColor;
            this.WhiteBackPressedColor = WhiteBackPressedColor;
            this.WhiteBackSelectedColor = WhiteBackSelectedColor;
            this.WhiteForeColor = WhiteForeColor;
            this.Font = Font;
    }
    public TemaRenkleri(Color DarkBackColor, Color DarkForeColor,Color WhiteBackColor, Color WhiteForeColor, java.awt.Font Font) 
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkForeColor = DarkForeColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteForeColor = WhiteForeColor;
        this.Font = Font;
    }
    public TemaRenkleri(Color DarkBackColor,Color  DarkBackEnteredColor,Color  DarkBackPressedColor,Color DarkForeColor,Color DarkLineColor,
    Color WhiteBackColor,Color  WhiteBackEnteredColor,Color  WhiteBackPressedColor,Color  WhiteForeColor,Color WhiteLineColor,
    Font ButtonFont,int karticin) 
    {
        this.DarkBackColor = DarkBackColor;
        this.DarkBackEnteredColor = DarkBackEnteredColor;
        this.DarkBackPressedColor = DarkBackPressedColor;
        this.DarkForeColor = DarkForeColor;
        this.DarkLineColor = DarkLineColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteBackEnteredColor = WhiteBackEnteredColor;
        this.WhiteBackPressedColor = WhiteBackPressedColor;
        this.WhiteForeColor = WhiteForeColor;
        this.WhiteLineColor = WhiteLineColor;
        this.Font = ButtonFont;
    }
    public TemaRenkleri(Color DarkBackColor, Color DarkForeColor, Color DarkLineColor, Color WhiteBackColor,
            Color WhiteForeColor, Color WhiteLineColor, java.awt.Font buttonFont) {
        this.DarkBackColor = DarkBackColor;
        this.DarkForeColor = DarkForeColor;
        this.DarkLineColor = DarkLineColor;
        this.WhiteBackColor = WhiteBackColor;
        this.WhiteForeColor = WhiteForeColor;
        this.WhiteLineColor = WhiteLineColor;
    }
    public Color getBackColor() 
    {
        return (TemaKontrol.IsDarkMode ? DarkBackColor : WhiteBackColor);
    }
    public Color getEnteredColor() 
    {
        return (TemaKontrol.IsDarkMode ? DarkBackEnteredColor : WhiteBackEnteredColor);
    }
    public Color getPressedColor() 
    {
        return (TemaKontrol.IsDarkMode ? DarkBackPressedColor : WhiteBackPressedColor);
    }
    public Color getSelectedColor()
    {
        return (TemaKontrol.IsDarkMode ? DarkBackSelectedColor : WhiteBackSelectedColor);
    }
    public Color getForeColor()
    {
        return (TemaKontrol.IsDarkMode ? DarkForeColor : WhiteForeColor);
    }
    public Color getLineColor()
    {
        return (TemaKontrol.IsDarkMode ? DarkLineColor : WhiteLineColor);
    }
    public Color getLineColorTers() 
    {
        return (!TemaKontrol.IsDarkMode ? DarkLineColor : WhiteLineColor);
    }
    public Color getBackColorTers() 
    {
        return (!TemaKontrol.IsDarkMode ? DarkBackColor : WhiteBackColor);
    }
    public Color getForeColorTers()
    {
        return (!TemaKontrol.IsDarkMode ? DarkForeColor : WhiteForeColor);
    }
    public void setBackColor(Color BackColor) 
    {
        if (TemaKontrol.IsDarkMode)
            DarkBackColor = BackColor;
        else
            WhiteBackColor = BackColor;
    }
    public void setForeColor(Color ForeColor) {
        if (TemaKontrol.IsDarkMode)
            DarkForeColor = ForeColor;
        else
            WhiteForeColor = ForeColor;
    }
  

    public Color getDarkBackColor() {
        return DarkBackColor;
    }
    public void setDarkBackColor(Color darkBackColor) {
        DarkBackColor = darkBackColor;
    }
    public Color getDarkBackEnteredColor() {
        return DarkBackEnteredColor;
    }
    public void setDarkBackEnteredColor(Color darkBackEnteredColor) {
        DarkBackEnteredColor = darkBackEnteredColor;
    }
    public Color getDarkBackPressedColor() {
        return DarkBackPressedColor;
    }
    public void setDarkBackPressedColor(Color darkBackPressedColor) {
        DarkBackPressedColor = darkBackPressedColor;
    }
    public Color getDarkBackSelectedColor() {
        return DarkBackSelectedColor;
    }
    public void setDarkBackSelectedColor(Color darkBackSelectedColor) {
        DarkBackSelectedColor = darkBackSelectedColor;
    }
    public Color getDarkForeColor() {
        return DarkForeColor;
    }
    public void setDarkForeColor(Color darkForeColor) {
        DarkForeColor = darkForeColor;
    }
    public Color getDarkLineColor() {
        return DarkLineColor;
    }
    public void setDarkLineColor(Color darkLineColor) {
        DarkLineColor = darkLineColor;
    }
    
    public Color getWhiteBackColor() {
        return WhiteBackColor;
    }
    public void setWhiteBackColor(Color whiteBackColor) {
        WhiteBackColor = whiteBackColor;
    }
    public Color getWhiteBackEnteredColor() {
        return WhiteBackEnteredColor;
    }
    public void setWhiteBackEnteredColor(Color whiteBackEnteredColor) {
        WhiteBackEnteredColor = whiteBackEnteredColor;
    }
    public Color getWhiteBackPressedColor() {
        return WhiteBackPressedColor;
    }
    public void setWhiteBackPressedColor(Color whiteBackPressedColor) {
        WhiteBackPressedColor = whiteBackPressedColor;
    }
    public Color getWhiteBackSelectedColor() {
        return WhiteBackSelectedColor;
    }
    public void setWhiteBackSelectedColor(Color whiteBackSelectedColor) {
        WhiteBackSelectedColor = whiteBackSelectedColor;
    }
    public Color getWhiteForeColor() {
        return WhiteForeColor;
    }
    public void setWhiteForeColor(Color whiteForeColor) {
        WhiteForeColor = whiteForeColor;
    }
    public Color getWhiteLineColor() {
        return WhiteLineColor;
    }
    public void setWhiteLineColor(Color whiteLineColor) {
        WhiteLineColor = whiteLineColor;
    }
    
    public Font getFont() {
        return Font;
    }
    public void setFont(Font font) {
        Font = font;
    }

    public String ToString()
    {
        return "DarkBackColor: " + DarkBackColor+"\n"+
        "DarkBackEnteredColor: " + DarkBackEnteredColor+"\n"+
        "DarkBackPressedColor: " + DarkBackPressedColor+"\n"+
        "DarkBackSelectedColor: "+DarkBackSelectedColor+"\n"+
        "DarkForeColor: " + DarkForeColor+"\n"+
        "DarkLineColor: " + DarkLineColor+"\n"+
        "WhiteBackColor: " + WhiteBackColor+"\n"+
        "WhiteBackEnteredColor: "+WhiteBackEnteredColor+"\n"+
        "WhiteBackPressedColor: "+WhiteBackPressedColor+"\n"+
        "WhiteBackSelectedColor: "+WhiteBackSelectedColor+"\n"+
        "WhiteForeColor: "+WhiteForeColor+"\n"+
        "WhiteLineColor: "+WhiteLineColor;
    }

}
