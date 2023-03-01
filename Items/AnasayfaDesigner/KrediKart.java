package WinForms.Items.AnasayfaDesigner;
import java.awt.*;
import javax.swing.*;
//import javax.swing.text.MaskFormatter;

import Omer.MessageBox;
import SQL.Hesabim;

public class KrediKart extends JDialog
{
    private JTextField txtkredino, txtkrediadsoyad, txtay, txtyil, txtcvv;
    private JTextField txtYüklemeMiktari;
    private JButton btnGuncelle,btniptal;
    public KrediKart(Frame parent, Hesabim hesabi)
    {
        super(parent, "Kredi kartı ile bakiye yükleme", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblAdsoyad = new JLabel("Kredi Kartı numarası: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(lblAdsoyad, constraints);

        txtkredino = new JTextField(20);
        txtkredino.setText(hesabi.getKrediKartiNo());
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(txtkredino, constraints);

        JLabel lblKullaniciAd = new JLabel("Kredi Adı Soyadı:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(lblKullaniciAd, constraints);

        txtkrediadsoyad = new JTextField(20);
        txtkrediadsoyad.setText(hesabi.getKrediadsoyad());
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(txtkrediadsoyad, constraints);

        JLabel lblAdres = new JLabel("Ay:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lblAdres, constraints);

        txtay = new JTextField(20);
        txtay.setText(hesabi.getAy());
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(txtay, constraints);

        JLabel lblMail = new JLabel("Yıl:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(lblMail, constraints);

        txtyil = new JTextField(20);
        txtyil.setText(hesabi.getYil());
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(txtyil, constraints);


        JLabel lblTelno = new JLabel("CVV:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        add(lblTelno, constraints);

        txtcvv = new JTextField(20);
        txtcvv.setText(hesabi.getCVV());
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(txtcvv, constraints);


        JLabel lblYukle = new JLabel("TL yüklenecek miktarı:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(lblYukle, constraints);

        txtYüklemeMiktari = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(txtYüklemeMiktari, constraints);


        btnGuncelle = new JButton("Bakiye yükle");
        constraints.gridx = 0;
        constraints.gridy = 6;
        add(btnGuncelle, constraints);

        btniptal = new JButton("İptal et");
        constraints.gridx = 1;
        constraints.gridy = 6;
        add(btniptal, constraints);

        btnGuncelle.addActionListener(e -> {
            String no = txtkredino.getText(), adsoy = txtkrediadsoyad.getText(), ay = txtay.getText(), yil = txtyil.getText(), cvv = txtcvv.getText();

            // Boşluk doldurmayan uyarısı
            if (no.equals("") ||
            adsoy.equals("") ||
            ay.equals("") ||
            yil.equals("") ||
            cvv.equals(""))
            {
                MessageBox.Show("Lütfen boş alanları doldurunuz.", "Uyarı.",MessageBox.Warning );
                return; 
            }
            if(txtYüklemeMiktari.getText().contains("-"))
            {
                MessageBox.Show("Eksi miktarı yüklemez.", "Uyarı.",MessageBox.Warning );
                return;
            }
            IsGuncellendi = hesabi.KrediKartiGuncelle(no,adsoy,ay,yil,cvv);
            hesabi.BakiyeYukle(txtYüklemeMiktari.getText());
            if (IsGuncellendi)
            {
                MessageBox.Show("Bakiye başarıyla yükledi. Güncel bakiyeniz: " + hesabi.getBakiye(), "Kredi kartı ile bakiye yükleme.",MessageBox.Information );
                dispose();
            }
        });

        btniptal.addActionListener(e -> setVisible(false));
    }
    public Boolean IsGuncellendi = false;
}
