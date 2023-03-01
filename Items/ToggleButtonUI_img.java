package WinForms.Items;

import java.awt.BorderLayout;
import java.awt.Color;

import WinForms.Tema.TemaKontrol;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class ToggleButtonUI_img extends JPanel
{    
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Button UI Test by Ömer22");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750,350);
        frame.setLocation(160,90); //1920-1600/2=160  1080-900/2=90
        JPanel btn = new ToggleButtonUI_img();
        btn.setBorder(new LineBorder(Color.red));
        btn.setBounds(0,0,200,200);
        frame.add(btn);

        JPanel btn2 = new ToggleButtonUI_img();
        btn2.setBorder(new LineBorder(Color.red));
        btn2.setBounds(200,0,200,200);
        frame.add(btn2);
        frame.setVisible(true);
    }



    static String imgPath = "Design/Items/ButtonUI/";
    class img
    {
        static ImageIcon Click = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"ClickDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
        static ImageIcon Clicking = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"ClickingDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
        static ImageIcon Selected = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"SelectedDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
        static ImageIcon EnteredSelected = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"EnteredSelectedDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
        static ImageIcon EnteredClick = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"EnteredClickDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
        static ImageIcon Disabled = new ImageIcon(TemaKontrol.IsDarkMode ? Omer.Util.getImage(imgPath+"DisabledDark.png") : Omer.Util.getImage(imgPath+"ClickWhite.png"));
    }

    public String Durumu;
    public void setDurumu(String durumu) {
        this.Durumu = durumu;
        System.out.println(Durumu + " Secildimi: " + Secildi);
    }
    public String getDurumu() {
        return Durumu;
    }
    boolean Disable = false;
    boolean Secildi = false;
    boolean Pressed = false;
    boolean Released = false;
    boolean UIEntered = false;
    public void setSecildi(boolean secildi) {
        this.Secildi = secildi;
    }
    JLabel TBtn;
    JPanel kutu;
    Color EnteredCol = new Color(0,0,139);
    Color ExitedCol = new Color(18,18,18);

    public ToggleButtonUI_img()
    {
        super();
        kutu = this;
        TBtn = new JLabel("test bir düğmesi");
        TBtn.setLayout(new BorderLayout());
        /*setBounds(setBounds);
        TBtn.setBounds(setBounds);*/
        setLayout(new BorderLayout());
        add(TBtn, BorderLayout.CENTER);
        /*Refresh();*/
        TBtn.addMouseListener(new MouseListener()
            {

                @Override
                public void mouseClicked(MouseEvent e) {
                    /*setDurumu("mouseClicked");
                    if (Disable)
                        return;
                    if (e.getButton() != 1) // Sol tıklama
                        return;

                    Click();*/
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //setDurumu("mousePressed");

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //setDurumu("mouseReleased");
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //setDurumu("mouseEntered");
                    UIEntered = true;
                    kutu.setBackground(ExitedCol);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //setDurumu("mouseExited");
                    UIEntered = false;
                    //Refresh();
                    kutu.setBackground(ExitedCol);
                }

                /*public void Click()
                {
                    setDurumu("mouseClicked");
                    if (!Secildi)
                        setIcon(Images.Selected);       
                    else
                        setIcon(Images.Click);     
                    setSecildi(!Secildi);  
                    Pressed = false;
                }
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    Click();
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    setDurumu("mousePressed");
                    Pressed = true;
                    Released = false;
                    setIcon(Images.Clicking);       
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    //System.out.println("released"); 
                    // Tuturken pencere dışında başka yere bırakırsa released yazdırılır. clicked yazdırılmaz.
                    Pressed = false;
                    Released = true;
                    if (!UIEntered)
                        setDurumu("mouseReleased/outUI");
                    else
                    {
                        setDurumu("mouseReleased/inUI");
                        //Click();
                        //ButtonUI.setIcon(new ImageIcon(Omer.Util.getImage("Design/Items/ButtonUI/Selected.png")));
                    }
                    if (Secildi)
                        setIcon(Images.Selected);       
                    else
                        setIcon(Images.Click);       
                    
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    //System.out.println("Entered"); // UI giriş
                    UIEntered = true;
                    if (!Secildi && !Pressed)
                    {
                        setIcon(Images.Entered);
                        setDurumu("mouseEntered/noClicking");
                        //üst.setText("Entered/UIGiriş");
                    }
                    else if (Pressed && !Released)  
                    {
                        setDurumu("mouseEntered/Clicking");
                        setIcon(Images.Clicking);       
                    }
                        
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    //System.out.println("Exited"); // UI çıkış
                    setDurumu("mouseExited");
                    UIEntered = false;
                    if (Secildi)
                    {
                        setIcon(Images.Selected);
                    }
                    else
                    {
                        setIcon(Images.Click);
                    }
                }*/
            });

    }
    /*public void EnteredTest()
    {
        if (AnimatedColor.backtimer != null)
            AnimatedColor.backtimer.stop();
        AnimatedColor.setBackground(this, TemaKontrol.DarkBackColor, TemaKontrol.WhiteBackColor);
        if (AnimatedColor.foretimer != null)
            AnimatedColor.foretimer.stop();
        AnimatedColor.setForeground(TBtn, TemaKontrol.DarkForeColor, TemaKontrol.WhiteForeColor);
    }
    public void ExitedTest()
    {
        if (AnimatedColor.HasExited == false)
            AnimatedColor.HasExited = true;
        AnimatedColor.setBackground(this, TemaKontrol.WhiteBackColor, TemaKontrol.DarkBackColor);
        if (AnimatedColor.foretimer != null)
            AnimatedColor.foretimer.stop();
        AnimatedColor.setForeground(TBtn, TemaKontrol.WhiteForeColor, TemaKontrol.DarkForeColor);

    }*/
    public void Click()
    {
        setSecildi(!Secildi);
        Refresh();
    }
    public void Refresh()
    {
        if (UIEntered && Secildi) // UI giriş ile tıkla
            kutu.setBackground(Color.blue.brighter());
        else if (UIEntered && !Secildi)
            //TBtn.setIcon(img.EnteredClick);
            kutu.setBackground(Color.blue.darker());

    }
    public void setSelected(boolean Selected)
    {
        if (!Selected)
            TBtn.setIcon(img.Click);
        else if (Selected)
            TBtn.setIcon(img.Selected);
        setSecildi(Selected);
    }
    public boolean getSelected()
    {
        return Secildi;
    }
    public void setDisabled(boolean disable)
    {
        this.Disable = disable;
    }
    public boolean getDisable()
    {
        return Disable;
    }
}
