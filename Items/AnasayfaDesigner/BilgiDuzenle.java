package WinForms.Items.AnasayfaDesigner;
import Omer.MessageBox;
import SQL.Hesabim;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class BilgiDuzenle extends JDialog
{
    private JTextField txtAdsoyad, txtKullaniciad, txtAdres, txtMail, txtTelno;
    private JButton btnGuncelle,btniptal;
    public BilgiDuzenle(Frame parent, Hesabim hesabi)
    {
        super(parent, "Müşteri bilgileri güncelle", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblAdsoyad = new JLabel("Adı Soyadı: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(lblAdsoyad, constraints);

        txtAdsoyad = new JTextField(20);
        txtAdsoyad.setText(hesabi.getAdSoyad());
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(txtAdsoyad, constraints);

        JLabel lblKullaniciAd = new JLabel("Kullanıcı Adı:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(lblKullaniciAd, constraints);

        txtKullaniciad = new JTextField(20);
        txtKullaniciad.setText(hesabi.getKullaniciAd());
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(txtKullaniciad, constraints);

        JLabel lblAdres = new JLabel("Adres:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lblAdres, constraints);

        txtAdres = new JTextField(20);
        txtAdres.setText(hesabi.getAdres());
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(txtAdres, constraints);

        JLabel lblMail = new JLabel("E-Posta:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(lblMail, constraints);

        txtMail = new JTextField(20);
        txtMail.setText(hesabi.getMail());
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(txtMail, constraints);


        JLabel lblTelno = new JLabel("Adres:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(lblTelno, constraints);

        try {
            MaskFormatter fmt = new MaskFormatter("0(###)### ## ##");
            txtTelno = (JTextField) new JFormattedTextField(fmt);
        } catch (Exception e) {}
        txtTelno.setText(hesabi.getTelNo());
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(txtTelno, constraints);


        btnGuncelle = new JButton("Değiştir");
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(btnGuncelle, constraints);

        btniptal = new JButton("İptal et");
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(btniptal, constraints);

        btnGuncelle.addActionListener(e -> {
            // txtAdsoyad, txtKullaniciad, txtAdres, txtMail, txtTelno;
            String adSoyad = txtAdsoyad.getText(), 
            kullaniciAdi = txtKullaniciad.getText(), 
            adres = txtAdres.getText(), 
            mail = txtMail.getText(), 
            telNo = txtTelno.getText();

            // Boşluk doldurmayan uyarısı
            if (adSoyad.equals("") ||
            kullaniciAdi.equals("") ||
            adres.equals("") ||
            mail.equals("") ||
            telNo.equals(""))
            {
                MessageBox.Show("Lütfen boş alanları doldurunuz.", "Uyarı.",MessageBox.Warning );
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
            IsGuncellendi = hesabi.guncelle(adSoyad, kullaniciAdi, adres, mail, telNo);
            if (IsGuncellendi)
                dispose();

        });

        btniptal.addActionListener(e -> setVisible(false));
    }
    public Boolean IsGuncellendi = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Hesabim hesabi =  new Hesabim("1", "Eneskel24", "Eneskel24", "eneskel24", "asdad", "asdsada", "null");
        BilgiDuzenle dialog = new BilgiDuzenle(frame,hesabi);
        dialog.setVisible(true);
    }
}
