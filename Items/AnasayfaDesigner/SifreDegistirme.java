package WinForms.Items.AnasayfaDesigner;
import javax.swing.*;

import Omer.MessageBox;
import SQL.Hesabim;

import java.awt.*;

public class SifreDegistirme extends JDialog {
    private JPasswordField gecerliPassword;
    private JPasswordField yeniPassword;
    private JPasswordField tekrarPassword;
    private JButton btnSifreDegistir;
    private JButton btniptal;
    public SifreDegistirme(Frame parent, Hesabim hesabi)
    {
        super(parent, "Şifre değiştir", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblgecerlipas = new JLabel("Geçerli şifre:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(lblgecerlipas, constraints);

        gecerliPassword = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(gecerliPassword, constraints);

        JLabel lblyenisifre = new JLabel("Yeni şifre:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(lblyenisifre, constraints);

        yeniPassword = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(yeniPassword, constraints);

        JLabel lbltekrarsifre = new JLabel("Tekrar şifre:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lbltekrarsifre, constraints);

        tekrarPassword = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(tekrarPassword, constraints);

        btnSifreDegistir = new JButton("Değiştir");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(btnSifreDegistir, constraints);

        btniptal = new JButton("İptal et");
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(btniptal, constraints);

        btnSifreDegistir.addActionListener(e -> {
            // burada şifre değiştirme işlemleri yapılır
            // örneğin:
            String currentPassword = new String(gecerliPassword.getPassword());
            String newPassword = new String(yeniPassword.getPassword());
            String confirmPassword = new String(tekrarPassword.getPassword());
            if (newPassword.equals(confirmPassword)) {
                    IsSifreDegistirdi = hesabi.setPassword(currentPassword,newPassword);
            } else {
                MessageBox.Show("Şifre eşit değil.", "Uyarı", MessageBox.Warning);
            }
            if (IsSifreDegistirdi)
                dispose();
        });

        btniptal.addActionListener(e -> setVisible(false));
    }
    public Boolean IsSifreDegistirdi = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        Hesabim hesabi =  new Hesabim("1", "Eneskel24", "Eneskel24", "eneskel24", "asdad", "asdsada", "null");
        SifreDegistirme dialog = new SifreDegistirme(frame,hesabi);
        dialog.setVisible(true);
    }
}
