package WinForms.Testler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import SQL.Hesabim;
import WinForms.WinFormApp;
import WinForms.Items.ButtonUI;

public class HesabimPanel {
    public static void main(String[] args) {
        WinFormApp asd = new WinFormApp("asd");
        HesabimPanel gfg = new HesabimPanel(asd, new Hesabim("1", "TestAdso", "Testkullanicadi", "Sifre", "adresi", "mail","telno"));
        gfg.asd();
        asd.frame.setSize(300, 300);
        asd.Show();

    }
    ButtonUI btnDuzenle, btnDegistir, btnCikis;
    void asd(){}
    public HesabimPanel(WinFormApp winapp, Hesabim hesabi) 
    {


        JPanel sabitPanel = winapp.addPanel(new GridBagLayout());
        JPanel ortaPanel = winapp.addRoundedPanel(new GridBagLayout(),35,  new WinForms.Tema.JPanelKutusu());
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        //sabitPanel.setPreferredSize(new Dimension(800,400));
        ortaPanel.setPreferredSize(new Dimension(800,600));
        sabitPanel.add(ortaPanel);
        winapp.frame.add(sabitPanel);
        
        JLabel lblBaslik = (JLabel) winapp.addItem(new JLabel("Hesabım", JLabel.CENTER));
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 25));
        lblBaslik.setBorder(new EmptyBorder(25,0,25,0));
        ekleTablo(ortaPanel, lblBaslik, 0, 0, 3, 1);

        JLabel lblBilgiBaslik = (JLabel) winapp.addItem(new JLabel("Kullanıcı Bilgileri"));
        ekleTablo(ortaPanel, lblBilgiBaslik, 0,1, 1, 1);

        btnDuzenle = winapp.addButtonUI("Düzenle");
        ekleTablo(ortaPanel, btnDuzenle, 1, 1, 1, 1);

        WinForms.Tema.AnasayfaDesigner.KartLabel tema   = new WinForms.Tema.AnasayfaDesigner.KartLabel();
        tema.setFont(new Font("Verdana", Font.PLAIN, 16));
        tema.setDarkLineColor(null); tema.setWhiteLineColor(null);
        JLabel lblBilgileri = (JLabel) winapp.addItem(new JLabel("Adı Soyadı: " + hesabi.getAdSoyad()),tema);
        JLabel lblBilgileri2 = (JLabel) winapp.addItem(new JLabel( "Telefon: " + hesabi.getTelNo()),tema);
        JLabel lblBilgileri3 = (JLabel) winapp.addItem(new JLabel("Adres: " +  hesabi.getAdres()),tema);
        JLabel lblBilgileri4 = (JLabel) winapp.addItem(new JLabel("Bakiye: " +  hesabi.getAdres()),tema);

        ekleTablo(ortaPanel, lblBilgileri, 0,2, 1,1);
        ekleTablo(ortaPanel, lblBilgileri2, 0,3, 1,1);
        ekleTablo(ortaPanel, lblBilgileri3, 0,4, 1,1);
        ekleTablo(ortaPanel, lblBilgileri4, 0,5, 1,1);

        JLabel lblKulislem = (JLabel) winapp.addItem(new JLabel("Kullanıcı İşlemleri"));
        ekleTablo(ortaPanel, lblKulislem, 0,6, 1,1);
        JLabel lblSifreDegis = (JLabel) winapp.addItem(new JLabel("Giriş yaparken Kullandığınız Şifreyi değiştirin"),tema);
        ekleTablo(ortaPanel, lblSifreDegis, 0,7, 1,1);
        btnDegistir = winapp.addButtonUI("Değiştir");
        ekleTablo(ortaPanel, btnDegistir, 1,6, 1,1);

        JLabel lblimg = winapp.addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel, lblimg, 0,8, 2,1);

        btnCikis = winapp.addButtonUI("Hesabınızdan Çıkış Yapın");
        ekleTablo(ortaPanel, btnCikis, 0,9, 2,1);
        ActionListener(winapp);
    }
    private void ekleTablo(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints(gridx ,gridy, gridwidth, gridheight, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(5,0,5,0) , 0, 0);
        container.add(component, gbc);
    }

    private void ActionListener(WinFormApp winapp)
    {
        btnDuzenle.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer)e.getSource()).stop();
            }});
    }
}
