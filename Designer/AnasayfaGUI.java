package WinForms.Designer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

import Omer.MessageBox;
import SQL.Hesabim;
import SQL.VeritabanIslemleri;
import WinForms.WinFormApp;
import WinForms.Config.AnasayfaDesigner.Urunler;
import WinForms.Items.*;
import WinForms.Items.AnasayfaDesigner.BilgiDuzenle;
import WinForms.Items.AnasayfaDesigner.CikisMesaji;
import WinForms.Items.AnasayfaDesigner.Kart;
import WinForms.Items.AnasayfaDesigner.KrediKart;
import WinForms.Items.AnasayfaDesigner.SifreDegistirme;
import WinForms.Tema.AnasayfaDesigner.Sepetim;

public class AnasayfaGUI extends WinFormApp
{
    /*public static void main(String[] args) {
        AnasayfaGUI ana = new AnasayfaGUI(null, new Hesabim("1","asd asd","asdsad","asdasfaf", "asdsafeqwe", "qwdqq@asdasd.qdwq", "123213"));
        ana.init();
        ana.Show();
    }*/
    Hesabim hesabi;
    GirisGUI giris;
    AnasayfaGUI(GirisGUI giris,Hesabim hesabi)
    {
        super("Otomasyon paneli");
        frame.setSize(1600,900);
        this.hesabi = hesabi;
        this.giris = giris;
        init();
    }
    protected void init()
    {
        Center();
        UstPanel();
        SidePanel();
        SidebarNorth();
        SidebarSouth();
        AltPanel();

        ModaPanel();
        EvPanel();
        MobilyaPanel();
        KozmetikPanel();
        TeknolojiPanel();
        HesabimPanel();
        SepetPanel();
        AyarlarPanel();
        kartlayout.show(Center,"Moda");
        try {SwingUtilities.updateComponentTreeUI(frame);} catch (Exception e) {}
    }
    JPanel Center, Ekran;
    void Center()
    {
        Center = addPanel();
        Center.setLayout(kartlayout);
        Ekran= addPanel();
        Ekran.setLayout(new BorderLayout());
        frame.add(Ekran, BorderLayout.CENTER);
        Ekran.add(Center, BorderLayout.CENTER);
    }

    JPanel sidebar,sidebarnorth, sidebarsouth;
    GridBagConstraints gbc = new GridBagConstraints();
    void SidePanel() 
    {
        sidebar = addPanel(new GridBagLayout(), new WinForms.Tema.AnasayfaDesigner.SidebarPanel());
        sidebarnorth = addPanel(new WinForms.Tema.AnasayfaDesigner.SidebarPanel());
        sidebarsouth = addPanel(new WinForms.Tema.AnasayfaDesigner.SidebarPanel());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.90;
        gbc.fill = GridBagConstraints.BOTH;

        sidebar.add(sidebarnorth, gbc);
        gbc.gridy++;
        gbc.weighty = 0.10;
        sidebar.add(sidebarsouth, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(sidebar, BorderLayout.WEST);
    }
    void SidebarNorth()
    {
        GridBagConstraints ogeduzen = new GridBagConstraints();
        ogeduzen.fill = GridBagConstraints.VERTICAL;
        ogeduzen.insets = new Insets(5,10,5,10);
        ogeduzen.ipadx = 150;
        sidebarnorth.setLayout(new GridBagLayout());
        sidebarnorth.setBorder(new EmptyBorder(15,-10,15,-10));

        ButtonUI btnModa = addButtonUI("Moda",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        ogeduzen.gridy++;
        sidebarnorth.add(btnModa, ogeduzen);
        
        ButtonUI btnEv = addButtonUI("Ev",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        ogeduzen.gridy++;
        sidebarnorth.add(btnEv, ogeduzen);

        ButtonUI btnMobilya = addButtonUI("Mobilya",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        ogeduzen.gridy++;
        sidebarnorth.add(btnMobilya, ogeduzen);

        ButtonUI btnKozmetik = addButtonUI("Kozmetik",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        ogeduzen.gridy++;
        sidebarnorth.add(btnKozmetik, ogeduzen);

        ButtonUI btnTeknoloji = addButtonUI("Teknoloji",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        ogeduzen.gridy++;
        sidebarnorth.add(btnTeknoloji, ogeduzen);
        
        btnModa.setClick(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Moda");
                altpanel.setVisible(true);
                ((Timer)e.getSource()).stop();
            }
        });
        btnEv.setClick(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Ev");
                altpanel.setVisible(true);
                ((Timer)e.getSource()).stop();
            }
        });
        btnMobilya.setClick(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Mobilya");
                altpanel.setVisible(true);
                ((Timer)e.getSource()).stop();
            }
        });
        btnKozmetik.setClick(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Kozmetik");
                altpanel.setVisible(true);
                ((Timer)e.getSource()).stop();
            }
        });
        btnTeknoloji.setClick(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Teknoloji");
                altpanel.setVisible(true);
                ((Timer)e.getSource()).stop();
            }
        });

    }
    void SidebarSouth()
    {
        GridBagConstraints southduzen = new GridBagConstraints();
        southduzen.fill = GridBagConstraints.VERTICAL;
        southduzen.insets = new Insets(5,10,5,10);
        southduzen.ipadx = 150;
        sidebarsouth.setLayout(new GridBagLayout());
        sidebarsouth.setBorder(new EmptyBorder(15,-10,15,-10));

        ButtonUI btnHesabim = addButtonUI("Hesab??m",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        southduzen.gridy++;
        sidebarsouth.add(btnHesabim, southduzen);

        ButtonUI btnSepet = addButtonUI("Sepet",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        southduzen.gridy++;
        sidebarsouth.add(btnSepet, southduzen);

        ButtonUI btnAyarlar = addButtonUI("Ayarlar",new WinForms.Tema.AnasayfaDesigner.ToggleButtonUI());
        southduzen.gridy++;
        sidebarsouth.add(btnAyarlar, southduzen);

        btnHesabim.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Hesabim");
                altpanel.setVisible(false);
                BakiyeYenile();
                ((Timer) e.getSource()).stop();
            }
        });
        btnSepet.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Sepet");
                altpanel.setVisible(false);
                SepetKontrol();
                ((Timer) e.getSource()).stop();
            }
        });
        btnAyarlar.setClick(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "Ayarlar");
                altpanel.setVisible(false);
                ((Timer) e.getSource()).stop();
            }
        });

    }
    JPanel altpanel, ??stpanel;
    ButtonUI btnSiparisVer;
    void AltPanel() 
    {
        gbc.fill = GridBagConstraints.BOTH;
        altpanel = addPanel(new FlowLayout(FlowLayout.RIGHT));
        gbc.gridy++;
        gbc.weighty = 0;
        gbc.insets = new Insets(10,10,10,10);

        btnSiparisVer = new ButtonUI("Sipari?? ver");
        btnSiparisVer.setPreferredSize(new Dimension(100,50));
        btnSiparisVer.setVisible(false);
        altpanel.add(btnSiparisVer, 0);

        //altpanel.setBorder(new LineBorder(Color.red));
        Ekran.add(altpanel, BorderLayout.SOUTH);
        btnSiparisVer.setClick(new ActionListener(){   
            @Override public void actionPerformed(ActionEvent e) {
                if (((Timer)e.getSource()).isRunning())
                    ((Timer)e.getSource()).stop();
                ArrayList<String> list = new ArrayList<String>();
                String topla = "";
                for (Kart kart : kartlar) {
                    if (kart.sepetSayisi != 0)
                    {
                        topla += "\nMarka:"+kart.urun.getMarka() + " ??r??n ad??: " + kart.urun.get??sim() + " Siparis Sayisi: " + kart.sepetSayisi + " \n";
                    }
                }
                if (topla == "")
                {
                    return;
                }
                for (String str : list) {
                    System.out.println(str);
                }
                JOptionPane.showMessageDialog(null, "Sipari?? ba??ar??yla ger??ek verildi." + topla);

            }});
    }  
    void UstPanel() 
    {
        GridBagConstraints gbc = new GridBagConstraints();
        ??stpanel = addPanel(new FlowLayout(),new WinForms.Tema.AnasayfaDesigner.SidebarPanel());
        gbc.fill = GridBagConstraints.VERTICAL;
        frame.add(??stpanel, BorderLayout.NORTH);

        ??stpanel.setBorder(new EmptyBorder(15,15,15,15));
        GridBagConstraints northduzen = new GridBagConstraints();
        northduzen.fill = GridBagConstraints.VERTICAL;
        northduzen.insets = new Insets(10,10,10,10);
        JLabel lbltitle = (JLabel) addItem(new JLabel("Sipari?? Uygulamas??"));
        JLabel lblimg = (JLabel) addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Anasayfa/logo.png", true);
        //lblimg.setBorder(new LineBorder(Color.red));
        //??stpanel.setBorder(new LineBorder(Color.red));
        northduzen.gridx = 0;
        northduzen.gridy = 0;
        ??stpanel.add(lbltitle);
        ??stpanel.add(lblimg);

    }

    CardLayout kartlayout = new CardLayout();
    JPanel ModaPanel, EvPanel, MobilyaPanel, KozmetikPanel, TeknolojiPanel;
    JScrollPane ModaPanelS, EvPanelS, MobilyaPanelS, KozmetikPanelS, TeknolojiPanelS;
    //ArrayList<JPanel> paneller = new ArrayList<JPanel>();
    ArrayList<Kart> kartlar = new ArrayList<Kart>();
    void ModaPanel()
    {
        WrapLayout wrap = new WrapLayout();
        wrap.setHgap(25);
        wrap.setVgap(25);
        ModaPanel = addPanel(wrap, new WinForms.Tema.JPanelKutusu());
        ModaPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin
        for (int i=0;i<Urunler.Moda.length;i++)
        {
            Kart kutu1 = addKart(Urunler.Moda[i], altpanel);
            kartlar.add(kutu1);
            ModaPanel.add(kutu1); 
        }
        //ModaPanel.add(addItem(new JLabel("ModaPanel paneldir.")));
        ModaPanelS = addScrollPane(ModaPanel, new WinForms.Tema.JPanelKutusu());
        ModaPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ModaPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ModaPanelS.setBorder(new LineBorder(Color.black));
        Center.add(ModaPanelS, "Moda");
    }
    void EvPanel()
    {
        WrapLayout wrap = new WrapLayout();
        wrap.setHgap(25);
        wrap.setVgap(25);
        EvPanel = addPanel(wrap, new WinForms.Tema.JPanelKutusu());
        EvPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin
        for (int i=0;i<Urunler.Ev.length;i++)
        {
            Kart kutu1 = addKart(Urunler.Ev[i], altpanel);
            kartlar.add(kutu1);
            EvPanel.add(kutu1); 
        }
        EvPanelS = addScrollPane(EvPanel, new WinForms.Tema.JPanelKutusu());
        EvPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        EvPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        EvPanelS.setBorder(new LineBorder(Color.black));
        Center.add(EvPanelS, "Ev");
    }
    void MobilyaPanel()
    {
        WrapLayout wrap = new WrapLayout();
        wrap.setHgap(25);
        wrap.setVgap(25);
        MobilyaPanel = addPanel(wrap, new WinForms.Tema.JPanelKutusu());
        MobilyaPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin
        for (int i=0;i<Urunler.Mobilya.length;i++)
        {
            Kart kutu1 = addKart(Urunler.Mobilya[i], altpanel);
            kartlar.add(kutu1);
            MobilyaPanel.add(kutu1); 
        }
        MobilyaPanelS = addScrollPane(MobilyaPanel, new WinForms.Tema.JPanelKutusu());
        MobilyaPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        MobilyaPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MobilyaPanelS.setBorder(new LineBorder(Color.black));
        Center.add(MobilyaPanelS, "Mobilya");

    }
    void KozmetikPanel()
    {
        WrapLayout wrap = new WrapLayout();
        wrap.setHgap(25);
        wrap.setVgap(25);
        KozmetikPanel = addPanel(wrap, new WinForms.Tema.JPanelKutusu());
        KozmetikPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin
        for (int i=0;i<Urunler.Kozmetik.length;i++)
        {
            Kart kutu1 = addKart(Urunler.Kozmetik[i], altpanel);
            kartlar.add(kutu1);
            KozmetikPanel.add(kutu1); 
        }
        KozmetikPanelS = addScrollPane(KozmetikPanel, new WinForms.Tema.JPanelKutusu());
        KozmetikPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        KozmetikPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        KozmetikPanelS.setBorder(new LineBorder(Color.black));
        Center.add(KozmetikPanelS, "Kozmetik");
    }
    void TeknolojiPanel()
    {
        WrapLayout wrap = new WrapLayout();
        wrap.setHgap(25);
        wrap.setVgap(25);
        TeknolojiPanel = addPanel(wrap, new WinForms.Tema.JPanelKutusu());
        TeknolojiPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin
        for (int i=0;i<Urunler.Mobilya.length;i++)
        {
            Kart kutu1 = addKart(Urunler.Teknoloji[i], altpanel);
            kartlar.add(kutu1);
            TeknolojiPanel.add(kutu1); 
        }
        TeknolojiPanelS = addScrollPane(TeknolojiPanel, new WinForms.Tema.JPanelKutusu());
        TeknolojiPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        TeknolojiPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        TeknolojiPanelS.setBorder(new LineBorder(Color.black));
        Center.add(TeknolojiPanelS, "Teknoloji");
    }
    
    JPanel HesabimPanel, SepetPanel, AyarlarPanel;
    ButtonUI btnDuzenle, btnDegistir, btnCikis;
    ButtonUI btnYukle;
    JLabel lblBakiye;
    void HesabimPanel()
    {
        JPanel sabitPanel = addPanel(new GridBagLayout(), new WinForms.Tema.AnasayfaDesigner.PanelMenusuArkaPlan());
        JPanel ortaPanel = addRoundedPanel(new GridBagLayout(),35,  new WinForms.Tema.AnasayfaDesigner.PanelMenusu());
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        ortaPanel.setPreferredSize(new Dimension(800,700));
        sabitPanel.add(ortaPanel);
        
        JLabel lblBaslik = (JLabel) addItem(new JLabel("Hesab??m", JLabel.CENTER));
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 25));
        lblBaslik.setBorder(new EmptyBorder(25,0,25,0));
        ekleTablo(ortaPanel, lblBaslik, 0, 0, 3, 1);

        JLabel lblBilgiBaslik = (JLabel) addItem(new JLabel("Kullan??c?? Bilgileri"));
        ekleTablo(ortaPanel, lblBilgiBaslik, 0,1, 1, 1);

        btnDuzenle = addButtonUI("D??zenle");
        ekleTablo(ortaPanel, btnDuzenle, 1, 1, 1, 1);

        WinForms.Tema.AnasayfaDesigner.KartLabel tema   = new WinForms.Tema.AnasayfaDesigner.KartLabel();
        tema.setFont(new Font("Verdana", Font.PLAIN, 16));
        tema.setDarkLineColor(null); tema.setWhiteLineColor(null);
        JLabel lblBilgileri = (JLabel) addItem(new JLabel("Ad?? Soyad??: " + hesabi.getAdSoyad()),tema);
        JLabel lblBilgileri2 = (JLabel) addItem(new JLabel( "Telefon: " + hesabi.getTelNo()),tema);
        JLabel lblBilgileri3 = (JLabel) addItem(new JLabel("Adres: " +  hesabi.getAdres()),tema);
        lblBakiye = (JLabel) addItem(new JLabel("Bakiye: " +  hesabi.getBakiye()),tema);

        ekleTablo(ortaPanel, lblBilgileri, 0,2, 1,1);
        ekleTablo(ortaPanel, lblBilgileri2, 0,3, 1,1);
        ekleTablo(ortaPanel, lblBilgileri3, 0,4, 1,1);
        ekleTablo(ortaPanel, lblBakiye, 0,5, 1,1);

        btnYukle = addButtonUI("TL Y??kle");
        ekleTablo(ortaPanel, btnYukle, 1,5, 1,1);

        JLabel lblKulislem = (JLabel) addItem(new JLabel("Kullan??c?? ????lemleri"));
        ekleTablo(ortaPanel, lblKulislem, 0,6, 1,1);
        JLabel lblSifreDegis = (JLabel) addItem(new JLabel("Giri?? yaparken Kulland??????n??z ??ifreyi de??i??tirin"),tema);
        ekleTablo(ortaPanel, lblSifreDegis, 0,7, 1,1);
        btnDegistir = addButtonUI("De??i??tir");
        ekleTablo(ortaPanel, btnDegistir, 1,6, 1,1);

        JLabel lblimg = addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel, lblimg, 0,8, 2,1);

        btnCikis = addButtonUI("Hesab??n??zdan ????k???? Yap??n");
        ekleTablo(ortaPanel, btnCikis, 0,9, 2,1);

        Center.add(sabitPanel, "Hesabim");

        btnDuzenle.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MusteriGuncelle();
                ((Timer)e.getSource()).stop();
            }});
        btnDegistir.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SifreDegistir();
                ((Timer)e.getSource()).stop();
            }});
        btnCikis.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer)e.getSource()).stop();
                CikisYap();
            }});
        btnYukle.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer)e.getSource()).stop();
                KrediKart dialog = new KrediKart(frame, hesabi);
                dialog.setVisible(true);
            }
        });

    }
    private void ekleTablo(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints(gridx ,gridy, gridwidth, gridheight, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(5,0,5,0) , 0, 0);
        container.add(component, gbc);
    }
    void BakiyeYenile()
    {
        lblBakiye.setText("Bakiye: " +  hesabi.getBakiye());
    }
    private void SifreDegistir()
    {
        SifreDegistirme dialog = new SifreDegistirme(frame, hesabi);
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowListener()
           {@Override public void windowClosing(WindowEvent e) {}
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosed(WindowEvent e) {GeriDon();}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) { }
            @Override public void windowDeactivated(WindowEvent e) {}});
    }
    private void MusteriGuncelle()
    {
        BilgiDuzenle dialog = new BilgiDuzenle(frame, hesabi);
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowListener()
           {@Override public void windowClosing(WindowEvent e) {}
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosed(WindowEvent e) {GeriDon();}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) { }
            @Override public void windowDeactivated(WindowEvent e) {}});
    }
    void CikisYap()
    {
        CikisMesaji dialog = new CikisMesaji(frame);
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowListener()
        {@Override public void windowClosing(WindowEvent e) {}
         @Override public void windowOpened(WindowEvent e) {}
         @Override public void windowClosed(WindowEvent e) {CikisYap(dialog.IsCikisEvet);}
         @Override public void windowIconified(WindowEvent e) {}
         @Override public void windowDeiconified(WindowEvent e) {}
         @Override public void windowActivated(WindowEvent e) { }
         @Override public void windowDeactivated(WindowEvent e) {}});
    }
    void CikisYap(boolean IsCikisEvet)
    {
        if (IsCikisEvet)
            GeriDon();
    }
    void GeriDon()
    {
        if (giris == null)
            giris = new GirisGUI();
        giris.Show();
        Hide(); 
    }
    JPanel ??stPanel, ortaPanel, altPanel;
    JLabel lblToplamHesap;
    void SepetPanel()
    {
        // Centerpanel;
        SepetPanel = addPanel(new BorderLayout());
        // ??st Panel
        ??stPanel = addPanel();
        SepetPanel.add(??stPanel, BorderLayout.NORTH);

        JLabel lblText = (JLabel) addItem(new JLabel("Sepetim", JLabel.CENTER));
        lblText.setFont(new Font("Verdana", Font.BOLD, 25));
        lblText.setBorder(new EmptyBorder(25,0,25,0));
        ??stPanel.add(lblText);

        // Orta Panel
        ortaPanel = addPanel(new GridBagLayout());
        ortaPanel.setLayout(new GridLayout(0, 1));
        JScrollPane ortaPanelS = addScrollPane(ortaPanel);
        ortaPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ortaPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SepetPanel.add(ortaPanelS, BorderLayout.CENTER);
        // Alt Panel
        altPanel = addPanel(new FlowLayout(FlowLayout.RIGHT));
        SepetPanel.add(altPanel, BorderLayout.SOUTH);
        lblToplamHesap = (JLabel) addItem(new JLabel("Toplam fiyat: 0"));
        altPanel.add(lblToplamHesap);
        btnSepetSiparisVer = addButtonUI("Sipari?? ver");
        altPanel.add(btnSepetSiparisVer);

        Center.add(SepetPanel, "Sepet");

        btnSepetSiparisVer.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sipari??Ver();
                ((Timer)e.getSource()).stop();
            }
        });
    }
    Boolean IsKrediKartiGuncellendi = false;
    void Sipari??Ver()
    {
        if (hesabi.getBakiye() > toplamFiyat)
        {
            Boolean sonuc = hesabi.Harca(toplamFiyat);
            if (sonuc)
                {MessageBox.Show("Ba??ar??yla sipari?? verildi.","Sipari??", MessageBox.Information);
                sepetTemizle();}
            else
                MessageBox.Show("Sipari?? ba??ar??s??z oldu.","hesabim.harca()", MessageBox.Information);
        }
        else
        {
            MessageBox.Show("Bakiye yetersiz. Bakiyeniz: " + hesabi.getBakiye(),"Uyar??s??", MessageBox.Information);
            KrediKart dialog = new KrediKart(frame, hesabi);
            dialog.setVisible(true);
            dialog.addWindowListener(new WindowListener()
            {@Override public void windowClosing(WindowEvent e) {}
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosed(WindowEvent e) {IsKrediKartiGuncellendi = dialog.IsGuncellendi;}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) { }
            @Override public void windowDeactivated(WindowEvent e) {}});

        }
        
    }
    ArrayList<Kart> SiparisVerilenKartlar;
    JLabel SepetUyarisi;
    ButtonUI btnSepetSiparisVer;
    double toplamFiyat;
    private void SepetKontrol()
    {
        if (SepetUyarisi == null)
            SepetUyarisi = (JLabel) addItem(new JLabel("Sipari?? bulunmamaktad??r.", JLabel.CENTER));
        ortaPanel.removeAll();

        SiparisVerilenKartlar = new ArrayList<Kart>();
        toplamFiyat = 0;
        for (Kart kart : kartlar) {
            if (kart.sepetSayisi != 0)
            {
                SiparisVerilenKartlar.add(kart);
                toplamFiyat += kart.urun.getFiyat()*kart.sepetSayisi;
            }
        }
        if (SiparisVerilenKartlar.size() == 0)
        {
            ortaPanel.add(SepetUyarisi);
            altPanel.setVisible(false);
            btnSepetSiparisVer.setVisible(false);
            lblToplamHesap.setVisible(false);
        }
        else
        {
            altPanel.setVisible(true);
            btnSepetSiparisVer.setVisible(true);
            lblToplamHesap.setVisible(true);
            lblToplamHesap.setText("Toplam fiyat: " + toplamFiyat + " TL");
        }
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        for (int i=0;i<SiparisVerilenKartlar.size();i++)
        {
            c.gridy++;
            ortaPanel.add(SepetKart(SiparisVerilenKartlar.get(i)),c);
        }
      
    }
    private JPanel SepetKart(Kart kart)
    {
        JPanel ortaPanel =  addPanel(new BorderLayout(), new WinForms.Tema.AnasayfaDesigner.SepetPanel());
        JLabel lblUrunLogo = addImage(kart.urun.getFotograf(), new Dimension(150,150));
        lblUrunLogo.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5) );
        JLabel notify = (JLabel) addItem(new JLabel(String.valueOf(kart.sepetSayisi), JLabel.CENTER));
        notify.setBackground(Color.red);
        notify.setOpaque(true);
        notify.setForeground(Color.white);
        notify.setFont(new Font("Verdana", Font.PLAIN, 15));
        notify.setPreferredSize(new Dimension(35,35));
        lblUrunLogo.add(notify);

        JPanel panelCenter = addPanel(new WinForms.Tema.AnasayfaDesigner.SepetPanel());
        BoxLayout boxlayout = new BoxLayout(panelCenter, BoxLayout.PAGE_AXIS);
        panelCenter.setLayout(boxlayout);

        JLabel lblMarka = (JLabel)addItem(new JLabel(kart.urun.getMarka(), JLabel.LEFT));
        lblMarka.setFont(Sepetim.lblAnaFont);
        panelCenter.add(lblMarka);

        JLabel lblisim = (JLabel)addItem(new JLabel(kart.urun.get??sim(), JLabel.LEFT));
        lblisim.setFont(Sepetim.lblAnaFont);
        panelCenter.add(lblisim);

        JLabel lblAciklama = (JLabel)addItem(new JLabel(kart.urun.getAciklama(), JLabel.LEFT));
        lblAciklama.setFont(Sepetim.lblAciklamaFont);
        lblAciklama.setPreferredSize(new Dimension(100,50));
        panelCenter.add(lblAciklama);

        JPanel panelEast = addPanel( new WinForms.Tema.AnasayfaDesigner.SepetPanel());
        JLabel lblFiyat = (JLabel)addItem(new JLabel(kart.urun.getFiyatt(), JLabel.LEFT));
        lblFiyat.setFont(Sepetim.lblFiyat);
        panelEast.add(lblFiyat);

        ortaPanel.add(lblUrunLogo, BorderLayout.WEST);
        ortaPanel.add(panelCenter, BorderLayout.CENTER);
        ortaPanel.add(panelEast, BorderLayout.EAST);

        return ortaPanel;
    }
    void sepetTemizle()
    {
        for (int i=0;i<kartlar.size();i++)
            kartlar.get(i).sepetTemizle();
        SepetKontrol();    
    }
    ButtonUI btnDark, btnSifirla, btnKapat;
    void AyarlarPanel()
    {
        WinForms.Tema.AnasayfaDesigner.KartLabel tema   = new WinForms.Tema.AnasayfaDesigner.KartLabel();
        tema.setFont(new Font("Verdana", Font.PLAIN, 16));
        tema.setDarkLineColor(null); tema.setWhiteLineColor(null);
        
        JPanel sabitPanel = addPanel(new GridBagLayout(), new WinForms.Tema.AnasayfaDesigner.PanelMenusuArkaPlan());
        JPanel ortaPanel = addRoundedPanel(new GridBagLayout(),35,  new WinForms.Tema.AnasayfaDesigner.PanelMenusu());
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        //sabitPanel.setPreferredSize(new Dimension(800,400));
        ortaPanel.setPreferredSize(new Dimension(800,600));
        sabitPanel.add(ortaPanel);
        
        JLabel lblBaslik = (JLabel) addItem(new JLabel("Ayarlar", JLabel.CENTER));
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 25));
        lblBaslik.setBorder(new EmptyBorder(25,0,25,0));
        ekleTablo(ortaPanel, lblBaslik, 0, 0, 3, 1);

        JLabel lblBirinciBaslik = (JLabel) addItem(new JLabel("Kullan??c?? Bilgileri"));
        ekleTablo(ortaPanel, lblBirinciBaslik, 0,1, 1, 1);

        btnDark = addButtonUI("Degistir");
        ekleTablo(ortaPanel, btnDark, 1, 1, 1, 1);


        JLabel lblBirinciAciklamasi = (JLabel) addItem(new JLabel("Uygulaman??n Temas??n?? A????k Renk yada Koyu Renk olacak ??ekilde de??i??tirir."),tema);
        ekleTablo(ortaPanel, lblBirinciAciklamasi, 0,2, 1,1);

        JLabel lbl??kinciBaslik = (JLabel) addItem(new JLabel("Veri Taban??"));
        ekleTablo(ortaPanel, lbl??kinciBaslik, 0,6, 1,1);
        JLabel lbl??kinciAciklamasi = (JLabel) addItem(new JLabel("SQL Veri taban??n?? s??f??rlar."),tema);
        ekleTablo(ortaPanel, lbl??kinciAciklamasi, 0,7, 1,1);
        
        btnSifirla = addButtonUI("S??f??rla");
        ekleTablo(ortaPanel, btnSifirla, 1,6, 1,1);

        JLabel lblimg = addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel, lblimg, 0,8, 2,1);

        btnKapat = addButtonUI("Uygulamay?? kapat");
        ekleTablo(ortaPanel, btnKapat, 0,9, 2,1);
        Center.add(sabitPanel, "Ayarlar");

        btnDark.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeMode();
                ((Timer)e.getSource()).stop();
            }});
        btnKapat.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UygulamaKapat();
                ((Timer)e.getSource()).stop();
            }});
        btnSifirla.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                S??f??rla();
                ((Timer)e.getSource()).stop();
            }});
    }
    void UygulamaKapat()
    { 
        int result = JOptionPane.showConfirmDialog(frame,"????kmak istedi??inden emin misin?", "Uygulama kapat",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
            giris.frame.dispose();
            frame.dispose();
        }
    
    }
    void S??f??rla()
    {
        Boolean sonuc = VeritabanIslemleri.vt.VeritabanSifirla();
        if (sonuc)
        {
            MessageBox.Show("Veritaban s??f??rland??. L??tfen uygulama tekrar ??al????t??r??n.","Veritaban s??f??rlama", MessageBox.Information);
            giris.frame.dispose();
            frame.dispose();
        }
    }
}
