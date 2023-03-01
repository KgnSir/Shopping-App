package WinForms.Items;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import Omer.MessageBox;

import java.awt.event.*;
import WinForms.Animations.AnimatedColor2;
import WinForms.Tema.TemaRenkleri;

import java.awt.*;
import java.awt.event.MouseEvent;
public class ToggleButtonUI extends JPanel
{
    JPanel kutu;
    public JLabel lbl;
    private WinForms.Tema.ToggleButtonUI ui;
    public ToggleButtonUI(String Baslik)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        add(lbl, BorderLayout.CENTER);

        kutu = this;
        ui = new WinForms.Tema.ToggleButtonUI();
        System.out.println(ui.ToString());
        updateColors(ui);
        mouseListener();
        
    }
    public ToggleButtonUI(String Baslik, WinForms.Tema.ToggleButtonUI Colors)
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        add(lbl, BorderLayout.CENTER);

        kutu = this;
        ui = Colors;
        updateColors(ui);
        mouseListener();
    }
    public ToggleButtonUI(String Baslik, TemaRenkleri tema) 
    {
        super(new BorderLayout(0, 0));
        lbl = new JLabel(Baslik,SwingConstants.CENTER);
        add(lbl, BorderLayout.CENTER);

        kutu = this;
        updateColors(tema);
        mouseListener();
    }
    private void updateColors(TemaRenkleri tema) 
    {
        if (tema != null)
        {
            ui = new WinForms.Tema.ToggleButtonUI();
            ui.setDarkBackColor(tema.getDarkBackColor());
            ui.setDarkBackEnteredColor(tema.getDarkBackEnteredColor());
            ui.setDarkBackPressedColor(tema.getDarkBackPressedColor());
            ui.setDarkBackSelectedColor(tema.getDarkBackSelectedColor());
            ui.setDarkForeColor(tema.getDarkForeColor());

            ui.setDarkLineColor(tema.getDarkLineColor());

            ui.setWhiteBackColor(tema.getWhiteBackColor());
            ui.setWhiteBackEnteredColor(tema.getWhiteBackEnteredColor());
            ui.setWhiteBackPressedColor(tema.getWhiteBackPressedColor());
            ui.setWhiteBackSelectedColor(tema.getWhiteBackSelectedColor());
            ui.setWhiteForeColor(tema.getWhiteForeColor());

            ui.setDarkLineColor(tema.getWhiteLineColor());


            kutu = this;
            setBackground(ui.getBackColor());
            if (ui.getLineColor() != null)
                setBorder(new LineBorder(ui.getLineColor()));
            lbl.setForeground(ui.getForeColor());
        }
    }
    void mouseListener()
    {

        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                setDurumu("mouseClicked");
               
            }
            @Override
            public void mousePressed(MouseEvent e){
                Released = false;
                Pressed = true;
                setDurumu("mousePressed");
                if (Disable)
                    return;
                if (e.getButton() != 1) // Sol tıklama
                    return;
                /*if (Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getSelectedColor(),ui.getPressedColor());
                else if (!Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getBackColor(),ui.getPressedColor());*/
            }
            @Override
            public void mouseReleased(MouseEvent e){
                Released = true;
                Pressed = false;
                setDurumu("mouseReleased");
                if (Disable)
                    return;
                if (e.getButton() != 1) // Sol tıklama
                    return;
                setSecildi(!Secildi);
                /*if (Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getPressedColor(), ui.getSelectedColor());
                else if (!Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getPressedColor(), ui.getBackColor());*/
                if (Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getBackColor(), ui.getSelectedColor());
                else if (!Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getSelectedColor(), ui.getBackColor());
               
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setDurumu("mouseEntered");
                UIEntered = true;
                /*if (Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getSelectedColor(), ui.getEnteredColor());
                else
                    AnimatedColor2.setBack(timerback, kutu, ui.getBackColor(), ui.getEnteredColor());*/
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setDurumu("mouseExited");
                UIEntered = false;
                /*if (!Secildi)
                    AnimatedColor2.setBack(timerback, kutu, ui.getEnteredColor(), ui.getBackColor());*/
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });
    }
    private void updateColors(WinForms.Tema.ToggleButtonUI tema)
    {
        if (tema != null)
        {
            ui = tema;
            kutu = this;
            setBackground(ui.getBackColor());
            setBorder(new LineBorder(ui.getLineColor()));
            lbl.setForeground(ui.getForeColor());
            lbl.setFont(ui.getFont());
            ui.setDarkBackSelectedColor(new Color(0,0,139));
            ui.setWhiteBackSelectedColor(new Color(0,0,139));
        }
    }
    boolean Disable = false,Secildi = false,Pressed = false,Released = false,UIEntered = false;
    public void setSecildi(boolean secildi) {
        Secildi = secildi;
        if (setClick != null && Secildi)
            setClick.start();
        else if (setClick != null && !Secildi)
            setClick.stop();
        //System.out.println("Sec:"+secildi);
    }
    String Durumu = "";
    public void setDurumu(String durumu) {
        Durumu = durumu;
        //System.out.println(durumu +" "+Secildi);
    }
    public String getDurumu() {
        return Durumu;
    }
    Timer timerfore, timerback;
    public void ChangeMode() 
    {
        //#region setback
        //AnimatedColor2.setBack(timerback, kutu, kutu.getBackground(), (Secildi ? ui.getSelectedColor() : ui.getBackColor()));
        kutu.setBackground((Secildi ? ui.getSelectedColor() : ui.getBackColor()));
        //#endregion
        //#region setfore
        //AnimatedColor2.setFore(timerback, lbl, ui.getForeColorTers(), ui.getForeColor());
        lbl.setForeground( ui.getForeColor());

        //#endregion
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
    public String getText() 
    {
        return lbl.getText();
    }

    public void UpdateUI()
    {
        if (Secildi)
            AnimatedColor2.setBack(timerback, kutu, kutu.getBackground(), ui.getSelectedColor());
        else
            AnimatedColor2.setBack(timerback, kutu, kutu.getBackground(), ui.getBackColor());
    }
}
