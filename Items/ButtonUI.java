package WinForms.Items;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import Omer.MessageBox;
import WinForms.Animations.AnimatedColor2;
import WinForms.Tema.TemaKontrol;
import WinForms.Tema.TemaRenkleri;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class ButtonUI extends JPanel
{
    public static void main(String[] args) {
        ButtonUI btUi = new ButtonUI("Test Button")
        {
            @Override
            public void ClickedEvent()
            {
                System.out.println("modlanmış");
            }
        };
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(btUi);
        frame.pack();
        frame.setVisible(true);
    }
    public void ClickedEvent() {}


    public WinForms.Tema.ButtonUI ui;
    private JPanel kutu;
    public JLabel lbl = new JLabel();
    private void updateColors()
    {
        ui = new WinForms.Tema.ButtonUI();
        kutu = this;
        setBackground(ui.getBackColor());
        setBorder(new LineBorder(ui.getLineColor()));
    }
    private void updateColors(Color CustomColor)
    {
        ui = new WinForms.Tema.ButtonUI();
        ui.setDarkBackColor(CustomColor);
        ui.setDarkBackEnteredColor(CustomColor.brighter());
        ui.setDarkBackPressedColor(CustomColor.darker().darker());
        ui.setDarkLineColor(CustomColor.brighter());
        ui.setWhiteBackColor(CustomColor);
        ui.setWhiteBackEnteredColor(CustomColor.brighter());
        ui.setWhiteBackPressedColor(CustomColor.darker().darker());
        ui.setWhiteLineColor(CustomColor.brighter());

        setBackground(ui.getBackColor());
        setBorder(new LineBorder(ui.getLineColor()));
    }
    private void updateColors(WinForms.Tema.ButtonUI ButtonUITema)
    {
        if (ButtonUITema != null)
        {
            ui = ButtonUITema;
            kutu = this;
            setBackground(ui.getBackColor());
            setBorder(new LineBorder(ui.getLineColor()));
        }
    }
    private void updateColors(TemaRenkleri tema)
    {
        if (tema != null)
        {
            ui = new WinForms.Tema.ButtonUI();
            ui.setDarkBackColor(tema.getDarkBackColor());
            ui.setDarkBackEnteredColor(tema.getDarkBackEnteredColor());
            ui.setDarkBackPressedColor(tema.getDarkBackPressedColor());
            ui.setDarkLineColor(tema.getDarkLineColor());
            ui.setWhiteBackColor(tema.getWhiteBackColor());
            ui.setWhiteBackEnteredColor(tema.getWhiteBackEnteredColor());
            ui.setWhiteBackPressedColor(tema.getWhiteBackPressedColor());
            ui.setWhiteLineColor(tema.getWhiteLineColor());
            ui.setFont(tema.getFont());
            kutu = this;
            setBackground(ui.getBackColor());
            lbl.setForeground(ui.getForeColor());
            if (ui.getLineColor() != null)
                setBorder(new LineBorder(ui.getLineColor()));
            if (ui.getFont() != null)
                setFont(ui.getFont());
            
        }
    }
    private void MouseListener()
    {
        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e){

            }
            @Override
            public void mousePressed(MouseEvent e){
                ClickedEvent();
                AnimatedColor2.setBack(timerback, kutu, ui.getEnteredColor(), ui.getPressedColor());
                AnimatedColor2.mouseFore(lbl,ui.getForeColor(),ui.getForeColor().darker());
                if (ui.getLineColor() != null)
                    kutu.setBorder(new LineBorder((!TemaKontrol.IsDarkMode ? ui.getLineColor().brighter() : ui.getLineColor().darker()))); 
            }
            @Override
            public void mouseReleased(MouseEvent e){
                setBackground(ui.getPressedColor());
                AnimatedColor2.setBack(timerback, kutu, ui.getPressedColor(), ui.getEnteredColor());
                AnimatedColor2.mouseFore(lbl,ui.getForeColor().darker(),ui.getForeColor());
                if (ui.getLineColor() != null)
                    kutu.setBorder(new LineBorder(ui.getLineColor())); 
                setClick.start();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                AnimatedColor2.setBack(timerback, kutu, ui.getBackColor(), ui.getEnteredColor());
                if (ui.getLineColor() != null)
                    kutu.setBorder(new LineBorder(ui.getLineColor().brighter())); 
            }
            @Override
            public void mouseExited(MouseEvent e) {
                AnimatedColor2.setBack(timerback, kutu, ui.getEnteredColor(), ui.getBackColor());
                if (ui.getLineColor() != null)
                    kutu.setBorder(new LineBorder(ui.getLineColor())); 
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });
    }
    public ButtonUI(String Baslik, Color CustomColor)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        lbl.setForeground(Color.white);
        add(lbl, BorderLayout.CENTER);
        kutu = this;
        updateColors(CustomColor);
        MouseListener();
    }
    public ButtonUI(String Baslik, WinForms.Tema.ButtonUI ButtonUITema)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        lbl.setForeground(Color.white);
        add(lbl, BorderLayout.CENTER);
        kutu = this;
        updateColors(ButtonUITema);
        MouseListener();
    }
    public ButtonUI(String Baslik)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        lbl.setForeground(Color.white);
        add(lbl, BorderLayout.CENTER);
        updateColors(new WinForms.Tema.ButtonUI());
        MouseListener();
    }
    public ButtonUI(ImageIcon icon)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(icon,SwingConstants.CENTER);
        lbl.setForeground(Color.white);
        add(lbl, BorderLayout.CENTER);
        updateColors();
        MouseListener();
    }
    public ButtonUI(String Baslik, TemaRenkleri tema)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        lbl.setForeground(Color.white);
        add(lbl, BorderLayout.CENTER);
        kutu = this;
        updateColors(tema);
        MouseListener();
    }
    private void Clicked(MouseEvent e){
        //AnimatedColor.setBackground(kutu, btnEnteredCol, btnClickedCol);
        if (setClick != null)
            setClick.start();
    }
    public void setFont(Font font)
    {
        if (lbl == null || font == null)
            return;
        lbl.setFont(font);
    }
    public void doClick() 
    {
        Clicked(null);
    }
    private Timer setClick = new Timer(0, null);
    public void setClick(ActionListener action)
    {
        if (setClick == null)
            return;
        if (setClick.isRunning())
        {
            MessageBox.Show("İşlemi devam ediyor...","Busy", MessageBox.Warning);
            return;
        }
        setClick = new Timer(1, action);
    }

    public void Debug()
    {
        System.out.println(ui.ToString());
    }
    Timer timerfore, timerback;
    public void ChangeMode() 
    {
        //#region setback
        //AnimatedColor2.setBack(timerback, kutu, ui.getBackColorTers(), ui.getBackColor());
        //#endregion
        //#region setfore
        //AnimatedColor2.setFore(timerback, lbl, ui.getForeColorTers(), ui.getForeColor());
        //#endregion

        kutu.setBackground(ui.getBackColor());
        lbl.setForeground( ui.getForeColor());
        if (ui.getLineColor() != null)
        {
            kutu.setBorder(new LineBorder(ui.getLineColor()));
        }
    }
}
