package WinForms.Testler;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import WinForms.WinFormApp;
import WinForms.Items.ButtonUI;

public class AyarlarPanel 
{
    public static void main(String[] args) {
        WinFormApp asd = new WinFormApp("asd");
        AyarlarPanel gfg = new AyarlarPanel(asd);
        gfg.asd();
        asd.frame.setSize(300, 300);
        asd.Show();

    }
    ButtonUI btnDark, btnSifirla, btnKapat;
    void asd(){}
    public AyarlarPanel(WinFormApp winapp) 
    {
        WinForms.Tema.AnasayfaDesigner.KartLabel tema   = new WinForms.Tema.AnasayfaDesigner.KartLabel();
        tema.setFont(new Font("Verdana", Font.PLAIN, 16));
        tema.setDarkLineColor(null); tema.setWhiteLineColor(null);
        
        JPanel sabitPanel = winapp.addPanel(new GridBagLayout());
        JPanel ortaPanel = winapp.addRoundedPanel(new GridBagLayout(),35,  new WinForms.Tema.JPanelKutusu());
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        //sabitPanel.setPreferredSize(new Dimension(800,400));
        ortaPanel.setPreferredSize(new Dimension(800,600));
        sabitPanel.add(ortaPanel);
        winapp.frame.add(sabitPanel);
        
        JLabel lblBaslik = (JLabel) winapp.addItem(new JLabel("Ayarlar", JLabel.CENTER));
        lblBaslik.setFont(new Font("Verdana", Font.BOLD, 25));
        lblBaslik.setBorder(new EmptyBorder(25,0,25,0));
        ekleTablo(ortaPanel, lblBaslik, 0, 0, 3, 1);

        JLabel lblBirinciBaslik = (JLabel) winapp.addItem(new JLabel("Kullanıcı Bilgileri"));
        ekleTablo(ortaPanel, lblBirinciBaslik, 0,1, 1, 1);

        btnDark = winapp.addButtonUI("Degistir");
        ekleTablo(ortaPanel, btnDark, 1, 1, 1, 1);


        JLabel lblBirinciAciklamasi = (JLabel) winapp.addItem(new JLabel("Uygulamanın Temasını Açık Renk yada Koyu Renk olacak şekilde değiştirir."),tema);
        ekleTablo(ortaPanel, lblBirinciAciklamasi, 0,2, 1,1);

        JLabel lblİkinciBaslik = (JLabel) winapp.addItem(new JLabel("Veri Tabanı"));
        ekleTablo(ortaPanel, lblİkinciBaslik, 0,6, 1,1);
        JLabel lblİkinciAciklamasi = (JLabel) winapp.addItem(new JLabel("SQL Veri tabanını sıfırlar."),tema);
        ekleTablo(ortaPanel, lblİkinciAciklamasi, 0,7, 1,1);
        
        btnSifirla = winapp.addButtonUI("Sıfırla");
        ekleTablo(ortaPanel, btnSifirla, 1,6, 1,1);

        JLabel lblimg = winapp.addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel, lblimg, 0,8, 2,1);

        btnKapat = winapp.addButtonUI("Uygulamayı kapat");
        ekleTablo(ortaPanel, btnKapat, 0,9, 2,1);

        btnDark.setClick(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                winapp.ChangeMode();
                ((Timer)e.getSource()).stop();
            }});
        
    }
    private void ekleTablo(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints gbc = new GridBagConstraints(gridx ,gridy, gridwidth, gridheight, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(5,0,5,0) , 0, 0);
        container.add(component, gbc);
    }

}
