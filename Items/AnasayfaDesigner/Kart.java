package WinForms.Items.AnasayfaDesigner;

import WinForms.WinFormApp;
import WinForms.Items.ButtonUI;
import WinForms.Items.RoundedPanel;
import WinForms.Tema.TemaRenkleri;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.awt.*;

public class Kart extends RoundedPanel
{
    public WinFormApp win;
    public static void main(String[] args) 
    {
        WinFormApp asd = new WinFormApp("TOOL_TIP_TEXT_KEY");
        asd.frame.setSize(300,300);
        JPanel altpanel = asd.addPanel(new FlowLayout(FlowLayout.RIGHT));
        asd.frame.setLayout(new FlowLayout());
        asd.frame.add(altpanel, BorderLayout.SOUTH);

        Kart list = new Kart(asd, new Urun(1,"asd","asd","longname asdasd asd qweqeqwewq wqeqwewq qwewqewq qweqe", "WinForms/Img/Mobilya/4 Kişilik Yemek Masası.png",19999.9,"TL","asdasdsa"), altpanel);
        list.win= asd;
        list.setBorder(new LineBorder(Color.red));
        asd.frame.setSize(500,500);
        asd.frame.add(list, BorderLayout.CENTER);
        asd.Show();
    }

    public Kart(WinFormApp winapp)
    {
        super(50);
        winapp.addRoundedPanel(this, panelui);
        setLayout(new BorderLayout());
        setSize(new Dimension(500,125));
        JLabel lbl = (JLabel) winapp.addItem(new JLabel("4DFWD PULSE",SwingConstants.CENTER));
        add(lbl, BorderLayout.NORTH);

        JPanel panelcenter = winapp.addPanel(panelui);
        panelcenter.setLayout(new BoxLayout(panelcenter, BoxLayout.PAGE_AXIS));
        JLabel img = winapp.addImage("WinForms/Img/DownloadedFiles/Sipariş Uygulaması/ev/6'Lı Kadeh Seti.jpg", new Dimension(150,150));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(img, BorderLayout.CENTER);

        JLabel lblFiyat = (JLabel) winapp.addItem(new JLabel("159 TL",SwingConstants.CENTER));
        lblFiyat.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(lblFiyat, BorderLayout.CENTER);
        add(panelcenter, BorderLayout.CENTER);

        btnSepetEkle = winapp.addButtonUI("Sepete ekle", btnui, new Dimension(125,30));
        btnArt = winapp.addButtonUI("+", btnui, new Dimension(30,30));
        btnCikar = winapp.addButtonUI("-", btnui, new Dimension(30,30));
        txtSay = (JLabel) winapp.addItem(new JLabel("0"),new WinForms.Tema.AnasayfaDesigner.KartLabel());
        txtSay.setBorder(new EmptyBorder(5,5,5,5));
        btnArt.setVisible(false);
        btnCikar.setVisible(false);
        txtSay.setVisible(false);

        JPanel panelsouth = winapp.addPanel(panelui);
        panelsouth.add(btnArt);
        panelsouth.add(txtSay);
        panelsouth.add(btnCikar);
        panelsouth.add(btnSepetEkle);
        add(panelsouth, BorderLayout.SOUTH);

        lbl.setBorder(BorderFactory.createCompoundBorder((debug ? new LineBorder(Color.blue) : null), new EmptyBorder(20,20,20,20)));
        img.setBorder(BorderFactory.createCompoundBorder((debug ? new LineBorder(Color.green) : null), new EmptyBorder(0,0,0,0)));
        lblFiyat.setBorder(BorderFactory.createCompoundBorder((debug ? new LineBorder(Color.yellow) : null), new EmptyBorder(10,0,10,0)));
        panelsouth.setBorder(BorderFactory.createCompoundBorder(debug ? new LineBorder(Color.yellow) : null, new EmptyBorder(10,0,10,0)));
        setBorder(debug ? new LineBorder(Color.red) : null);

        btnArt.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi++;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
                ((Timer)e.getSource()).stop();
            }
        });
        btnCikar.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi--;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
                ((Timer)e.getSource()).stop();
            }
        });
        btnSepetEkle.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi = 1;
                txtSay.setText("1");
                btnArt.setVisible(true);
                btnCikar.setVisible(true);
                txtSay.setVisible(true);
                btnSepetEkle.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
    }
    public Kart()
    {
        super(50, Color.gray);
        setLayout(new BorderLayout());

        JLabel lbl = new JLabel("4DFWD PULSE");
        lbl.setBorder(new EmptyBorder(20,0,0,0));
        add(lbl, BorderLayout.NORTH);

        JPanel panelcenter = new JPanel();
        panelcenter.setLayout(new BoxLayout(panelcenter, BoxLayout.PAGE_AXIS));
        JLabel img = new JLabel(new ImageIcon(Omer.Util.fixImageSize(Omer.Util.getImage("WinForms/Img/Testler/elma1.png"),new Dimension(100,100))));
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(img, BorderLayout.CENTER);

        JLabel lblFiyat = new JLabel("159 TL");
        lblFiyat.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(lblFiyat, BorderLayout.CENTER);
        add(panelcenter, BorderLayout.CENTER);

        JButton btnSepetEkle = new JButton("Sepete ekle");
        JButton btnArt = new JButton("+");
        JButton btnCikar = new JButton("-");
        JLabel txtSay = new JLabel("0");
        txtSay.setBorder(new EmptyBorder(5,5,5,5));
        btnArt.setVisible(false);
        btnCikar.setVisible(false);
        txtSay.setVisible(false);

        JPanel panelsouth = new JPanel();
        panelsouth.add(btnArt);
        panelsouth.add(txtSay);
        panelsouth.add(btnCikar);
        panelsouth.add(btnSepetEkle);
        add(panelsouth, BorderLayout.SOUTH);
        panelsouth.setBorder(new EmptyBorder(0,0,20,0));

        panelcenter.setBackground(Color.gray);
        panelsouth.setBackground(Color.gray);
        setBackground(Color.gray
        );
        btnArt.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi++;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
            }
        });
        btnCikar.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi--;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
            }
        });
        btnSepetEkle.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                sepetSayisi = 1;
                txtSay.setText("1");
                btnArt.setVisible(true);
                btnCikar.setVisible(true);
                txtSay.setVisible(true);
                btnSepetEkle.setVisible(false);
            }
        });
    }   
    public Kart(boolean TestDenemesi)
    {
        super(50, Color.gray);
        setBackground(Color.gray);
        add(new JLabel("Test bir kutu."));
        setBorder(new LineBorder(Color.red));
        //setPreferredSize(new Dimension(100,100));
    }
   
    Boolean debug = false;
    JPanel kart;
    public TemaRenkleri btnui = new WinForms.Tema.AnasayfaDesigner.KartButton()
    ,panelui = new WinForms.Tema.AnasayfaDesigner.KartPanel();
    public int sepetSayisi = 0;
    public boolean IsSepetEkledi = false;
    public Urun urun;
    public ButtonUI btnArt, btnCikar, btnSepetEkle;
    JLabel txtSay;
    JPanel altpanel;
    WinFormApp winapp;
    public Kart(WinFormApp winapp, Urun urun, JPanel altpanel)
    {
        super(50);
        this.urun = urun;
        this.altpanel = altpanel;
        this.winapp = winapp;
        winapp.addRoundedPanel(this, panelui);
        setLayout(new BorderLayout());
        setSize(new Dimension(500,125));
        //lbl Ürün isim
        JLabel lbl = (JLabel) winapp.addItem(new JLabel(urun.getİsim(),SwingConstants.CENTER));
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbl, BorderLayout.NORTH);
        
        JPanel panelcenter = winapp.addPanel(panelui);
        panelcenter.setLayout(new BoxLayout(panelcenter, BoxLayout.PAGE_AXIS));

        //img Ürün fotoğraf
        JLabel img = winapp.addImage(urun.getFotograf(), urun.getFotografBoyutu());
        img.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(img, BorderLayout.CENTER);

        //lblFiyat Ürün fiyat
        JLabel lblFiyat = (JLabel) winapp.addItem(new JLabel(urun.getFiyatt(),SwingConstants.CENTER));
        lblFiyat.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelcenter.add(lblFiyat, BorderLayout.CENTER);
        add(panelcenter, BorderLayout.CENTER);

        //Buttonlar
        sepetKartinit();
        btnSepetEkle = new ButtonUI("Sepete ekle", btnui){
            @Override
            public void ClickedEvent()
            {
                sepetSayisi = 1;
                txtSay.setText("1");
                btnArt.setVisible(true);
                btnCikar.setVisible(true);
                txtSay.setVisible(true);
                btnSepetEkle.setVisible(false);
                //SepetKontrol();
                sepetKart();
            }
        };
        winapp.addButtonUI(btnSepetEkle,new Dimension(125,30));
        btnArt = new ButtonUI("+", btnui){
            @Override
            public void ClickedEvent()
            {
                sepetSayisi++;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
                sepetKart();
            }
        };
        winapp.addButtonUI(btnArt,new Dimension(30,30));
        btnCikar = new ButtonUI("-", btnui){
            @Override
            public void ClickedEvent()
            {
                sepetSayisi--;
                txtSay.setText(String.valueOf(sepetSayisi));
                SepetKontrol();
                sepetKart();
            }
        };
        winapp.addButtonUI(btnCikar,new Dimension(30,30));

        txtSay = (JLabel) winapp.addItem(new JLabel("0"),new WinForms.Tema.AnasayfaDesigner.KartLabel());
        txtSay.setBorder(new EmptyBorder(5,5,5,5));
        btnArt.setVisible(false);
        btnCikar.setVisible(false);
        txtSay.setVisible(false);

        JPanel panelsouth = winapp.addPanel(panelui);
        panelsouth.add(btnArt);
        panelsouth.add(txtSay);
        panelsouth.add(btnCikar);
        panelsouth.add(btnSepetEkle);
        add(panelsouth, BorderLayout.SOUTH);

        lbl.setBorder(new EmptyBorder(10,10,10,10));
        img.setBorder(BorderFactory.createCompoundBorder((debug ? new LineBorder(Color.green) : null), new EmptyBorder(0,0,0,0)));
        lblFiyat.setBorder(BorderFactory.createCompoundBorder((debug ? new LineBorder(Color.yellow) : null), new EmptyBorder(10,0,10,0)));
        panelsouth.setBorder(BorderFactory.createCompoundBorder(debug ? new LineBorder(Color.yellow) : null, new EmptyBorder(10,0,10,0)));
        setBorder(debug ? new LineBorder(Color.red) : null);
    }
    void SepetKontrol()
    {
        if (sepetSayisi == 0)
        {
            IsSepetEkledi = false;
            btnArt.setVisible(false);
            btnCikar.setVisible(false);
            txtSay.setVisible(false);
            btnSepetEkle.setVisible(true);
        }
        else if (sepetSayisi <= -1)
        {
            IsSepetEkledi = true;
            btnArt.setVisible(false);
            btnCikar.setVisible(false);
            txtSay.setVisible(false);
            btnSepetEkle.setVisible(true);
        }
    }
    JPanel sepetKart;
    JLabel notify;
    void sepetKartinit()
    {
        sepetKart = winapp.addRoundedPanel(25, new WinForms.Tema.AnasayfaDesigner.KartSepet(), new EmptyBorder(5,5,5,5));
        sepetKart.setLayout(new BorderLayout());

        JLabel img = winapp.addImage(urun.getFotograf(), new Dimension(50,50));
        img.setLayout(new FlowLayout(FlowLayout.RIGHT, -1, -1) );
        notify = new JLabel("0", JLabel.CENTER);
        notify.setBackground(Color.red);
        notify.setOpaque(true);
        notify.setForeground(Color.white);
        notify.setFont(new Font("Verdana", Font.PLAIN, 15));
        notify.setPreferredSize(new Dimension(20,20));
        img.add(notify);





        /*JPanel closepanel = winapp.addRoundedPanel(10, new WinForms.Tema.AnasayfaDesigner.KartSepet().CloseButton(), true); 
        closepanel.add(winapp.addImage("/WinForms/Img/Testler/cop.png", new Dimension(10,10)));
        closepanel.add(new JLabel("Close"));
        closepanel.setPreferredSize(new Dimension(25,25));
        //JPanel closepanel = winapp.addPanel(new BorderLayout(), new WinForms.Tema.AnasayfaDesigner.KartSepet());
        img.add(closepanel);*/

        sepetKart.add(img, BorderLayout.CENTER);
        sepetKart.setVisible(false);
        altpanel.add(sepetKart, 0);
        //SwingUtilities.updateComponentTreeUI(altpanel);
    }
    void sepetKart()
    {
        notify.setText(String.valueOf(sepetSayisi));
        if (sepetSayisi == 0)
        {
            sepetKart.setVisible(false);;
        }        
        else if (sepetSayisi >= 1)
        {
            sepetKart.setVisible(true);
        }        
       
    }
    public void sepetTemizle()
    {
        sepetSayisi = 0;
        SepetKontrol();
        sepetKart();
    }
}
