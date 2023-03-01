package WinForms.Designer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;

import Omer.MessageBox;
import SQL.Hesabim;
import WinForms.WinFormApp;
import WinForms.Items.ButtonUI;
import WinForms.Tema.TemaKontrol;
public class GirisGUI extends WinFormApp
{
    Giris login;
    UyeOlGUI uye;
    Boolean IsGirisYapti = false;
    AnasayfaGUI ana;
    public GirisGUI()
    {
        super("Otomasyon paneli");
        frame.setSize(1280,720);
        login = new Giris();
        init();
    }

    JLabel btnDark;
    public void init()
    {
        panelCenter();
        panelSouth();
        ActionListener();
    }
    JPanel sabitPanel, ortaPanel;
    JLabel lblImg, lblKullanici, lblSifre;
    JTextField txtKullanici;
    JPasswordField txtSifre;
    ButtonUI btnGiris;
    ButtonUI btnUye;
    private void panelCenter()
    {
        JPanel sabitPanel = addPanel(new GridBagLayout(), new WinForms.Tema.AnasayfaDesigner.PanelMenusuArkaPlan());
        JPanel ortaPanel = addRoundedPanel(new GridBagLayout(),35,  new WinForms.Tema.AnasayfaDesigner.PanelMenusu());
        ortaPanel.setBackground(TemaKontrol.DarkBackColor);
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        sabitPanel.setPreferredSize(new Dimension(800,400));
        ortaPanel.setPreferredSize(new Dimension(800,400));
        super.frame.setMinimumSize(sabitPanel.getSize());

        lblImg = super.addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel,lblImg, 0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        lblKullanici = (JLabel) super.addItem(new JLabel("Kullanıcı Adı: "));
        ekleTablo(ortaPanel,lblKullanici, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        txtKullanici = (JTextField) super.addItem(new JTextField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtKullanici, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        lblSifre = (JLabel) super.addItem(new JLabel("Şifre: "));
        ekleTablo(ortaPanel,lblSifre, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        txtSifre = (JPasswordField) super.addItem(new JPasswordField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtSifre, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        btnUye = addButtonUI("Üye ol");
        ekleTablo(ortaPanel,btnUye, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        btnGiris = addButtonUI("Giriş yap");
        ekleTablo(ortaPanel,btnGiris, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        sabitPanel.add(ortaPanel);
        frame.add(sabitPanel);
    }
    JPanel panelsouth;
    private void panelSouth()
    {
        GridBagConstraints southduzen = new GridBagConstraints();
        southduzen.fill = GridBagConstraints.VERTICAL;
        southduzen.insets = new Insets(10,10,10,10);
        panelsouth = addPanel(new WinForms.Tema.JPanelKutusu());
        panelsouth.getLayout();
        panelsouth.setBackground(TemaKontrol.DarkBackColor2);
        panelsouth.setBorder(new EmptyBorder(0,15,0,15));
        btnDark = addImage("WinForms/Img/Login/darkmode.png", new Dimension(50,50));        
        panelsouth.add(btnDark);
        frame.getContentPane().add(panelsouth, BorderLayout.SOUTH);
    }
    private void ActionListener()
    {
        btnDark.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                ChangeMode();
            }
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
            @Override public void mouseDragged(MouseEvent e) {}
            @Override public void mouseMoved(MouseEvent e) {}
            
        });
        btnUye.setClick(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e) 
            {
                UyeOl();
                ((Timer)e.getSource()).stop();
            }
        });
        btnGiris.setClick(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e) 
            {
                GirisKontrol();
                ((Timer)e.getSource()).stop();
            }
        });
        txtSifre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   btnGiris.doClick();
                }
            }
    
        });
    }
    private void ekleTablo(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx ,gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,new Insets(5,0,5,0) , 0, 0);
        container.add(component, gbc);
    }

    private void GirisKontrol()
    {
        String kullanici = txtKullanici.getText(), sifre = new String(txtSifre.getPassword());
        IsGirisYapti = login.GirisYap(kullanici, sifre); 
        
        if (IsGirisYapti)
        {
            Hesabim hesabi = login.getHesabim(kullanici);
            if (hesabi == null)
            {
                MessageBox.Show("Hesabı bulunmadı!", "Yasadışı?", MessageBox.Error);
                return;
            }
            hesabi.updateKrediKarti();
            ana = new AnasayfaGUI(this, hesabi);
            ana.Show();
            Hide();
        }
    }
    private void UyeOl()
    {
        if (uye == null)
            uye = new UyeOlGUI(this);
        Hide();
        uye.Show();
    }
}
