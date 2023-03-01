package WinForms;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import WinForms.Animations.TimerMod;
import WinForms.Items.*;
import WinForms.Items.ButtonUI;
import WinForms.Items.AnasayfaDesigner.Kart;
import WinForms.Items.AnasayfaDesigner.Urun;
import WinForms.Tema.*;

public class WinFormApp
{
    public JFrame frame;
    public Container Design;
    Image icon = Omer.Util.getImage("src/com/omer/siparisuygulamasi/WinForms/Img/WinFormApp/icon.png");
    public WinFormApp(String WinBaslik)
    {
        frame = new JFrame(WinBaslik);
        frame.setIconImage(icon);
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Design = frame.getContentPane();
        Design.setBackground(TemaKontrol.getBackColor());
        design = new Design(Design);
    }
    public void Show()
    {
        frame.setLocation(Omer.Util.getLocationThisPC(frame.getSize()));
        frame.setVisible(true);
    }
    public void Hide()
    {
        frame.setVisible(false);
    }
    public class Panels
    {
        public JPanel Item;
        public WinForms.Tema.TemaRenkleri Colors = new WinForms.Tema.JPanel();
        public TimerMod timerback, timerfore;
        Panels(JPanel Item){this.Item = Item;}
        public Panels(JPanel Item, WinForms.Tema.TemaRenkleri Colors){this.Item = Item; this.Colors = Colors;}
    }
    public class Items
    {
        public Container Item;
        public JLabel label;
        public WinForms.Tema.TemaRenkleri Colors;
        public TimerMod timerback, timerfore;
        public Items(Container Item){this.Item = Item;this.Colors = new WinForms.Tema.Items();}
        public Items(Container Item, WinForms.Tema.TemaRenkleri Colors){this.Item = Item;this.Colors = Colors;}
        public Items(Container Item, JLabel label, WinForms.Tema.TemaRenkleri Colors){this.Item = Item;this.label = label;this.Colors = Colors;}
        public Items(Container Item, JLabel label) {this.Item = Item;this.label = label;}
    }
    public class Images
    {
        public WinForms.Tema.TemaRenkleri Colors = new WinForms.Tema.ImageKart();
        public JLabel label;
        Images(JLabel label){this.label = label;}
        Images(JLabel label, WinForms.Tema.TemaRenkleri Colors){this.label = label;this.Colors = Colors;}
    }
    public class Design
    {
        public Container Item;
        public WinForms.Tema.TemaRenkleri Colors = new WinForms.Tema.JPanel();
        public TimerMod timerback, timerfore;
        Design(Container Item){this.Item = Item;}
    }
    protected ArrayList<Panels> panels = new ArrayList<Panels>();
    ArrayList<Items> items = new ArrayList<Items>();
    ArrayList<Images> images = new ArrayList<Images>();
    Design design;
    public void ChangeMode()
    {
        TemaKontrol.setIsDarkMode(!TemaKontrol.IsDarkMode);
        //AnimatedColor.setBackground(design);
        design.Item.setBackground(design.Colors.getBackColor());
        for (Panels panel : panels) 
        {
            if (Omer.Util.isInOzelMetin(panel.Item, "Kart"))
            {
                Kart kart = ((Kart) panel.Item);
                /*kart.btnArt.setBackground(kart.btnui.getBackColor());
                kart.btnArt.lbl.setForeground(kart.btnui.getForeColor());
                kart.btnArt.setBorder(new LineBorder(kart.btnui.getLineColor()));

                kart.btnCikar.setForeground(kart.btnui.getBackColor());
                kart.btnCikar.lbl.setForeground(kart.btnui.getForeColor());
                kart.btnCikar.setBorder(new LineBorder(kart.btnui.getLineColor()));

                //kart.btnSepetEkle.setForeground(kart.btnui.getBackColor());
                kart.btnSepetEkle.lbl.setForeground(kart.btnui.getForeColor());
                kart.btnSepetEkle.setBorder(new LineBorder(kart.btnui.getLineColor()));*/
                kart.setBackground(kart.panelui.getBackColor());
                kart.btnArt.ChangeMode();
                kart.btnCikar.ChangeMode();
                kart.btnSepetEkle.ChangeMode();

                continue;
            }
            panel.Item.setBackground(panel.Colors.getBackColor());
            panel.Item.setForeground(panel.Colors.getForeColor());

        }
        for (Items item : items) 
        {
            if (Omer.Util.isInOzelMetin(item.Item, "ToggleButtonUI"))
            {
                WinForms.Items.ToggleButtonUI btn = (WinForms.Items.ToggleButtonUI) item.Item;
                //btn.ChangeMode();
                btn.setBackground(item.Colors.getBackColor());
                btn.lbl.setForeground(item.Colors.getForeColor());
            }
            else if (Omer.Util.isInOzelMetin(item.Item, "ButtonUI"))
            {
                WinForms.Items.ButtonUI btn = (WinForms.Items.ButtonUI) item.Item;
                //btn.ChangeMode();
                btn.setBackground(item.Colors.getBackColor());
                btn.lbl.setForeground(item.Colors.getForeColor());
            }
            else if (Omer.Util.isInOzelMetin(item.Item,"JScrollPane"))
            {
                ((JScrollPane) item.Item).setBorder(new LineBorder(item.Colors.getBackColor())); 
            }
            else if (Omer.Util.isInOzelMetin(item.Item,"JTextField") ||Omer.Util.isInOzelMetin(item.Item,"JPasswordField"))
            {
                ((JTextField) item.Item).setBackground(item.Colors.getBackColor());
                ((JTextField) item.Item).setForeground(item.Colors.getForeColor());
                
            }
            else
            {
                //AnimatedColor.setForeground(item);
                item.Item.setForeground(item.Colors.getForeColor());
            }  
        }
        SwingUtilities.updateComponentTreeUI(Design);
    }


    protected JPanel addPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(TemaKontrol.getBackColor());
        panels.add(new Panels(panel));
        return panel;
    }
    public JPanel addPanel(TemaRenkleri colors)
    {
        JPanel pn = new JPanel();
        Panels panel = new Panels(pn, colors);
        pn.setBackground(panel.Colors.getBackColor());
        //pn.setBorder(new LineBorder(panel.Colors.getBackColor()));
        panels.add(panel);
        return pn;
    }
    public JPanel addPanel(TemaRenkleri colors,JPanel pn)
    {
        pn = new JPanel();
        Panels panel = new Panels(pn, colors);
        pn.setBackground(panel.Colors.getBackColor());
        panels.add(panel);
        return pn;
    }
    public JPanel addPanel(LayoutManager layout, TemaRenkleri colors)
    {
        JPanel pn = new JPanel(layout);
        Panels panel = new Panels(pn, colors);
        pn.setBackground(panel.Colors.getBackColor());
        panels.add(panel);
        return pn;
    }
    public JPanel addPanel(LayoutManager layout)
    {
        JPanel panel = new JPanel(layout);
        panel.setBackground(TemaKontrol.getBackColor());
        panels.add(new Panels(panel));
        return panel;
    }
    protected JPanel addRoundedPanel(LayoutManager layout, int radius)
    {   //class WinForms.Items.RoundedPanel
        JPanelKutusu pcol = new JPanelKutusu(); 
        JPanel pn = new RoundedPanel(layout,radius, pcol.getBackColor());
        pn.setBorder(new EmptyBorder(0,20,20,20)); // margin
        Panels panel = new Panels(pn, pcol);
        panels.add(panel);
        return pn;
    }
    public JPanel addRoundedPanel(LayoutManager layout, int radius, TemaRenkleri tema)
    {   //class WinForms.Items.RoundedPanel
        TemaRenkleri pcol = tema;
        JPanel pn = new RoundedPanel(layout,radius, pcol.getBackColor());
        pn.setBackground(tema.getBackColor());
        pn.setBorder(new EmptyBorder(0,20,20,20)); // margin
        Panels panel = new Panels(pn, pcol);
        panels.add(panel);
        return pn;
    }
    protected JPanel addRoundedPanel(int radius)
    {   //class WinForms.Items.RoundedPanel
        JPanelKutusu pcol = new JPanelKutusu(); 
        JPanel pn = new RoundedPanel(radius, pcol.getBackColor());
        pn.setBorder(new EmptyBorder(0,20,20,20)); // margin
        Panels panel = new Panels(pn, pcol);
        panels.add(panel);
        return pn;
    }
    public JPanel addRoundedPanel(int radius, WinForms.Tema.TemaRenkleri tema)
    {   //class WinForms.Items.RoundedPanel
        if (tema == null)
            tema = new WinForms.Tema.JPanelKutusu();
        TemaRenkleri ui = tema;
        JPanel pn = new RoundedPanel(radius, ui.getBackColor());
        pn.setBorder(new EmptyBorder(0,20,20,20)); // margin
        Panels panel = new Panels(pn, ui);
        panels.add(panel);
        return pn;
    }
    public JPanel addRoundedPanel(int radius, WinForms.Tema.TemaRenkleri tema, Border border )
    {   //class WinForms.Items.RoundedPanel
        if (tema == null)
            tema = new WinForms.Tema.JPanelKutusu();
        TemaRenkleri ui = tema;
        JPanel pn = new RoundedPanel(radius, ui.getBackColor());
        pn.setBorder(border); // margin
        Panels panel = new Panels(pn, ui);
        panels.add(panel);
        return pn;
    }
    public JPanel addRoundedPanel(int radius, WinForms.Tema.TemaRenkleri tema, Boolean noBackColor )
    {   //class WinForms.Items.RoundedPanel
        if (tema == null)
            tema = new WinForms.Tema.JPanelKutusu();
        TemaRenkleri ui = tema;
        JPanel pn = new RoundedPanel(radius);
        Panels panel = new Panels(pn, ui);
        panels.add(panel);
        return pn;
    }
    public JScrollPane addScrollPane(JPanel panel)
    {
        JScrollPane panels = new JScrollPane(panel);
        panels.setBackground(TemaKontrol.getBackColor());
        panels.setBorder(new LineBorder(TemaKontrol.getBackColor()));
        items.add(new Items(panels));
        return panels;
    }
    public JScrollPane addScrollPane(JPanel panel, WinForms.Tema.TemaRenkleri tema)
    {
        JScrollPane panels = new JScrollPane(panel);
        panels.setBackground(tema.getBackColor());
        panels.setBorder(new LineBorder(tema.getBackColor()));
        items.add(new Items(panels, tema));
        return panels;
    }
    public Kart addKart(Urun urun, JPanel altpanel)
    {
        Kart kart = new Kart(this,urun, altpanel);
        panels.add(new Panels(kart, kart.panelui));
        kart.setBorder(new EmptyBorder(10,10,10,10));
        return kart;
    }
    public JLabel addImage(String ImgPath)
    {
        Image logo = Omer.Util.getImage(ImgPath);
        logo = Omer.Util.fixImageSize(logo, frame, new Dimension(0,0));
        JLabel lblimg = new JLabel(new ImageIcon(logo));
        WinForms.Tema.TemaRenkleri tema = new WinForms.Tema.ImageKart();
        lblimg.setBackground(tema.getBackColor());
        lblimg.setForeground(tema.getForeColor());
        images.add(new Images(lblimg, tema));
        return lblimg;
    }
    public JLabel addImage(String ImgPath, Dimension Size)
    {
        Image logo = Omer.Util.getImage(ImgPath);
        logo = Omer.Util.fixImageSize(logo, Size);
        JLabel lblimg = new JLabel(new ImageIcon(logo));
        WinForms.Tema.TemaRenkleri tema = new WinForms.Tema.ImageKart();
        lblimg.setBackground(tema.getBackColor());
        lblimg.setForeground(tema.getForeColor());
        images.add(new Images(lblimg, tema));
        return lblimg;
    }
    public JLabel addImage(String ImgPath, Boolean AutoSize)
    {
        Image logo = Omer.Util.getImage(ImgPath);
        java.awt.image.BufferedImage bimg;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(ImgPath));
            logo = Omer.Util.fixImageSize(logo, new Dimension((int)(bimg.getWidth()*0.15), (int)(bimg.getHeight()*0.15))); //new Dimension((int)(298*0.25),(int)(343*0.25))
        } catch (IOException e) {}
        JLabel lblimg = new JLabel(new ImageIcon(logo));
        WinForms.Tema.TemaRenkleri tema = new WinForms.Tema.ImageKart();
        lblimg.setBackground(tema.getBackColor());
        lblimg.setForeground(tema.getForeColor());
        images.add(new Images(lblimg, tema));
        return lblimg;
    }
    public JLabel addImage(String ImgPath, Double BolW, Double BolH)
    {
        Image logo = Omer.Util.getImage(ImgPath);
        java.awt.image.BufferedImage bimg;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(ImgPath));
            logo = Omer.Util.fixImageSize(logo, new Dimension((int)(bimg.getWidth()*BolW), (int)(bimg.getHeight()*BolH))); //new Dimension((int)(298*0.25),(int)(343*0.25))
        } catch (IOException e) {}
        JLabel lblimg = new JLabel(new ImageIcon(logo));
        WinForms.Tema.TemaRenkleri tema = new WinForms.Tema.ImageKart();
        lblimg.setBackground(tema.getBackColor());
        lblimg.setForeground(tema.getForeColor());
        images.add(new Images(lblimg, tema));
        return lblimg;
    }
    public Container addItem(Container ItemType)
    {
        items.add(new Items(ItemType));
        ItemType.setBackground(TemaKontrol.getBackColor());
        ItemType.setForeground(TemaKontrol.getForeColor());
        ItemType.setFont(TemaKontrol.font);
        ItemType.setSize(10, 25);
        return ItemType;
    }
    public Container addItem(Container ItemType, TemaRenkleri tema) {
        items.add(new Items(ItemType, tema));
        ItemType.setBackground(tema.getBackColor());
        ItemType.setForeground(tema.getForeColor());
        if (tema.getLineColor() != null && !Omer.Util.isInOzelMetin(ItemType, "JTextField") && !Omer.Util.isInOzelMetin(ItemType, "JPasswordField"))
        {
            Border line = BorderFactory.createLineBorder(tema.getLineColor());
            ((JLabel) ItemType).setBorder(line);
        }
        ItemType.setFont(tema.getFont());
        ItemType.setSize(10, 25);
        return ItemType;
    }
    public ButtonUI addButtonUI(String Baslik)
    {
        WinForms.Tema.ButtonUI btntema =new WinForms.Tema.ButtonUI();
        ButtonUI btnui = new ButtonUI(Baslik,btntema);
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui,btnui.lbl, btntema));
        return btnui;
    }
    protected ButtonUI addButtonUI(String Baslik, WinForms.Tema.TemaRenkleri tema)
    {
        ButtonUI btnui = new ButtonUI(Baslik,tema);
        if (tema.getFont() != null)
            btnui.setFont(tema.getFont());
        else
            btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui,btnui.lbl,tema));
        return btnui;
    }
    public ButtonUI addButtonUI(String Baslik, WinForms.Tema.TemaRenkleri tema, Dimension Size)
    {
        ButtonUI btnui = new ButtonUI(Baslik,tema);
        if (tema.getFont() != null)
            btnui.setFont(tema.getFont());
        else
            btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(Size);
        items.add(new Items(btnui,btnui.lbl,tema));
        return btnui;
    }
    public ButtonUI addButtonUI(ButtonUI btnUI, Dimension Size)
    {
        ButtonUI btnui = btnUI;
        if (btnui.ui.getFont() != null)
            btnui.setFont(btnui.ui.getFont());
        else
            btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(Size);
        items.add(new Items(btnui,btnui.lbl,btnui.ui));
        return btnui;
    }
    protected ButtonUI addButtonUI(String Baslik, Color renk)
    {
        ButtonUI btnui = new ButtonUI(Baslik,renk);
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui,btnui.lbl, btnui.ui));
        return btnui;
    }
    public ButtonUI addButtonUI(String ImgPath, Dimension ImgSize)
    {
        Image logo = Omer.Util.getImage(ImgPath);
        logo = Omer.Util.fixImageSize(logo, ImgSize);
        ButtonUI btnui = new ButtonUI(new ImageIcon(logo));
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(ImgSize); //new Dimension(10*10,(int)(25*1.5))
        items.add(new Items(btnui));
        return btnui;
    }
    protected WinForms.Items.ToggleButtonUI addToggleButtonUI(String Baslik) 
    {
        WinForms.Tema.ToggleButtonUI btntema =new WinForms.Tema.ToggleButtonUI();
        WinForms.Items.ToggleButtonUI btnui = new WinForms.Items.ToggleButtonUI(Baslik);
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui, btntema));
        return btnui;
    }
    protected WinForms.Items.ToggleButtonUI addToggleButtonUI(String Baslik, WinForms.Tema.ToggleButtonUI Colors) 
    {
        WinForms.Tema.ToggleButtonUI btntema =new WinForms.Tema.ToggleButtonUI();
        WinForms.Items.ToggleButtonUI btnui = new WinForms.Items.ToggleButtonUI(Baslik,Colors);
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui, btntema));
        return btnui;
    }
    protected WinForms.Items.ToggleButtonUI addToggleButtonUI(String Baslik, WinForms.Tema.TemaRenkleri Colors) 
    {
        WinForms.Tema.ToggleButtonUI btntema =new WinForms.Tema.ToggleButtonUI();
        WinForms.Items.ToggleButtonUI btnui = new WinForms.Items.ToggleButtonUI(Baslik,Colors);
        btnui.setFont(TemaKontrol.font);
        btnui.setPreferredSize(new Dimension(10*10,(int)(25*1.5)));
        items.add(new Items(btnui, btntema));
        return btnui;
    }
    public JLabel addLabel(String Baslik) 
    {
        JLabel lbl = new JLabel(Baslik);
        WinForms.Tema.Items tema = new WinForms.Tema.Items();
        items.add(new Items(lbl,tema));
        lbl.setForeground(tema.getForeColor());
        return lbl;
    }
    public void addRoundedPanel(Kart kart, TemaRenkleri tema) 
    {
        TemaRenkleri ui = tema;
        JPanel pn = kart;
        pn.setBorder(new EmptyBorder(0,20,0,20)); // margin
        pn.setBackground(ui.getBackColor());
        Panels panel = new Panels(pn, ui);
        panels.add(panel);
    }
  
}