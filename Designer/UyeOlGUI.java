package WinForms.Designer;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;

import Omer.MessageBox;
import WinForms.WinFormApp;
import WinForms.Items.ButtonUI;
import WinForms.Tema.TemaKontrol;
import java.awt.event.*;
import java.awt.*;

public class UyeOlGUI extends WinFormApp{
    public static void main(String[] args) {
        
        UyeOlGUI app = new UyeOlGUI(null);
        app.Show();
    }
    GirisGUI giris;
    Boolean IsGirisYapti = false;
    public UyeOlGUI(GirisGUI giris)
    {
        super("Otomasyon paneli");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        init();
        this.giris =giris;
    }

    JLabel btnDark;
    public void init()
    {
        panelCenter();
        panelSouth();
        ActionListener();
    }
    JPanel sabitPanel, ortaPanel;
    JLabel lblImg, lblAdSoyad, lblKullanici, lblSifre, lblSifreTekrar, lblAdres, lblMail, lblTelNo;
    JTextField txtAdSoyad,txtKullanici, txtAdres, txtMail, txtTelNo;
    JPasswordField txtSifre, txtSifreTekrar;
    ButtonUI btnUyeol, btnGeri;
    private void panelCenter()
    {
        sabitPanel = super.addPanel(new GridBagLayout());
        ortaPanel = addRoundedPanel(new GridBagLayout(),35, new WinForms.Tema.JPanelKutusu());
        ortaPanel.setBorder(new EmptyBorder(0,20,20,20));

        sabitPanel.setPreferredSize(new Dimension(800,600));
        ortaPanel.setPreferredSize(new Dimension(800,600));
        super.frame.setMinimumSize(sabitPanel.getSize());

        lblImg = super.addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/logo.png");
        ekleTablo(ortaPanel,lblImg, 0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        lblAdSoyad = (JLabel) super.addItem(new JLabel("Adı Soyadı:"));
        ekleTablo(ortaPanel,lblAdSoyad, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtAdSoyad = (JTextField) super.addItem(new JTextField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtAdSoyad, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        lblKullanici = (JLabel) super.addItem(new JLabel("Kullanıcı Adı: "));
        ekleTablo(ortaPanel,lblKullanici, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtKullanici = (JTextField) super.addItem(new JTextField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtKullanici, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        lblSifre = (JLabel) super.addItem(new JLabel("Şifre: "));
        ekleTablo(ortaPanel,lblSifre, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtSifre = (JPasswordField) super.addItem(new JPasswordField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtSifre, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        lblSifreTekrar = (JLabel) super.addItem(new JLabel("Tekrar şifre: "));
        ekleTablo(ortaPanel,lblSifreTekrar, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtSifreTekrar = (JPasswordField) super.addItem(new JPasswordField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtSifreTekrar, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        lblAdres = (JLabel) super.addItem(new JLabel("Adres: "));
        ekleTablo(ortaPanel,lblAdres, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtAdres = (JTextField) super.addItem(new JTextField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtAdres, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        lblMail = (JLabel) super.addItem(new JLabel("E-Posta: "));
        ekleTablo(ortaPanel,lblMail, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        txtMail = (JTextField) super.addItem(new JTextField(), new WinForms.Tema.JTextField());
        ekleTablo(ortaPanel,txtMail, 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        lblTelNo = (JLabel) super.addItem(new JLabel("Tel numarası: "));
        ekleTablo(ortaPanel,lblTelNo, 0, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        try {
            MaskFormatter fmt = new MaskFormatter("0(###)### ## ##");
            txtTelNo = (JTextField) super.addItem(new JFormattedTextField(fmt), new WinForms.Tema.JTextField());
            ekleTablo(ortaPanel,txtTelNo, 1, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        } catch (Exception e) {}
        
        btnGeri = addButtonUI("Geri dön");
        ekleTablo(ortaPanel,btnGeri, 0, 8, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
        btnUyeol = addButtonUI("Üye ol");
        ekleTablo(ortaPanel,btnUyeol, 1, 8, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        
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
        btnDark = addImage("src/com/omer/siparisuygulamasi/WinForms/Img/Giris/darkmode.png", new Dimension(50,50));        
        panelsouth.add(btnDark);
        frame.getContentPane().add(panelsouth, BorderLayout.SOUTH);
    }
    private void ActionListener()
    {
        btnUyeol.setClick(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e) 
            {
                UyeKontrol();
                ((Timer)e.getSource()).stop();
            }
        });
        btnGeri.setClick(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e) 
            {
                GeriDon();
                ((Timer)e.getSource()).stop();
            }
        });
        txtTelNo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c))
                {
                    e.consume();
                }
            }
         });
    }
    private void ekleTablo(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx ,gridy, gridwidth, gridheight, 1.0, 1.0, anchor, fill,new Insets(5,0,5,0) , 0, 0);
        container.add(component, gbc);
    }

    private void UyeKontrol()
    {
        // Girilen metinler topla
        String adSoyad = txtAdSoyad.getText(),
        kullaniciAdi = txtKullanici.getText(),
        sifre = String.valueOf(txtSifre.getPassword()),
        sifreTekrar = String.valueOf(txtSifreTekrar.getPassword()),
        adres = txtAdres.getText(),
        mail = txtMail.getText(),
        telNo = txtTelNo.getText();

        // Boşluk doldurmayan uyarısı
        if (adSoyad.equals("") ||
        kullaniciAdi.equals("") ||
        sifre.equals("") ||
        sifreTekrar.equals("") ||
        adres.equals("") ||
        mail.equals("") ||
        telNo.equals(""))
        {
            MessageBox.Show("Lütfen boş alanları doldurunuz.", "Uyarı.",MessageBox.Warning );
            return; 
        }
        // Şifre eşit olmayan uyarısı
        if (!sifre.equals(sifreTekrar))
        {
            MessageBox.Show("Şifre eşit değil.", "Uyarı.",MessageBox.Warning );
            return; 
        }
        // E-Posta geçerisiz uyarısı 
        String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!mail.matches(EMAIL_PATTERN)) 
        {
            MessageBox.Show("E-Posta geçerisizdir.", "Uyarı.",MessageBox.Warning );
            return; 
        }
        // Telefon numarası geçerisiz uyarısı
        if (telNo.length()!= 15)
        {
            MessageBox.Show("Telefon numarası geçerisizdir.", "Uyarı.",MessageBox.Warning );
            return; 
        }
        // Yeni müşteri kaydedilecek
        if (SQL.VeritabanIslemleri.vt == null)
            SQL.VeritabanIslemleri.vt = new SQL.VeritabanIslemleri();
        Boolean IsTamam = SQL.VeritabanIslemleri.vt.UyeOl(adSoyad, kullaniciAdi, sifre, sifreTekrar, adres, mail, telNo);
        if (!IsTamam)
            return;
        MessageBox.Show("Hesabı başarıyla oluşturuldu.", "Başarılı", MessageBox.Information);
        GeriDon();
    }
    private void GeriDon()
    {
        Hide();
        if (giris == null)
            giris = new GirisGUI();
        giris.Show();     
    }
}
