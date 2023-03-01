package WinForms.Items.AnasayfaDesigner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class CikisMesaji extends JDialog
{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        CikisMesaji dialog = new CikisMesaji(frame);
        dialog.setVisible(true);
    }
    JButton btniptal, btnCikis;
    public boolean IsCikisEvet = false;
    public CikisMesaji(JFrame parent)
    {
        super(parent, "Çıkış onayı mesaji", true);
        setSize(300, 100);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JLabel lblAdsoyad = new JLabel("Çıkış yapma işlemi onaylıyor musunuz?", JLabel.CENTER);
        lblAdsoyad.setBorder(new EmptyBorder(5,5,5,5));
        add(lblAdsoyad, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new FlowLayout());
        add(btnPanel, BorderLayout.CENTER);
        btnCikis = new JButton("Evet");
        btnPanel.add(btnCikis);
        
        btniptal = new JButton("Hayır");
        btnPanel.add(btniptal);

  

        btniptal.addActionListener(e -> setVisible(false));
        btnCikis.addActionListener(e -> {IsCikisEvet = true; dispose();});
    }
}
