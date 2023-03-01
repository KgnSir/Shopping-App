package WinForms.Items.AnasayfaDesigner;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import WinForms.WinFormApp;

public class Liste extends WinFormApp
{
    public static void main(String[] args) {
        Liste asd = new Liste();
        asd.Show();
        asd.ShowDebug();
        asd.Center();
        //asd.DebugPanels();
    }
    JFrame debug;
    Liste()
    {
        super("Kartlar listesi testi by Ömer");
        frame.setSize(250,750);
    } 
    void ShowDebug()
    {
        debug = new JFrame("Debug");
        debug.setLayout(new FlowLayout());
        debug.setLocation(0,0);
        debug.setSize(400, 300);
        debug.setVisible(true);
        debug.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn1 = new JButton("1 geçiş");
        JButton btn2 = new JButton("2 geçiş");
        btn1.setBounds(0,0,100,25);
        btn2.setBounds(100,0,100,25);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "card1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kartlayout.show(Center, "card2");                
            }
        });
        debug.add(btn1);
        debug.add(btn2);
        
    }
    void DebugPanels()
    {
        Center.setBorder(new LineBorder(Color.blue));
        ModaPanel.setBorder(new LineBorder(Color.red));
    }
    
    CardLayout kartlayout = new CardLayout();;
    void Center()
    {
        Center = addPanel();
        Center.setLayout(kartlayout);
        frame.add(Center);
        siralamaLayout.setVgap(25);
        siralamaLayout.setHgap(25);

        ModaPanel();
        EvPanel();

    }
    JPanel Center, ModaPanel,EvPanel;
    JScrollPane ModaPanelS, EvPanelS;
    GridLayout siralamaLayout = new GridLayout(0,3);
    void ModaPanel()
    {
        ModaPanel = addPanel(siralamaLayout, new WinForms.Tema.JPanelKutusu());
        ModaPanel.setBorder(new EmptyBorder(20,20,20,20)); // margin
        for (int i=0;i<7;i++)
        {
            JPanel kutu1 = new Kart(this);
            ModaPanel.add(kutu1); 
        }
        ModaPanelS = new JScrollPane(ModaPanel);
        ModaPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ModaPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Center.add(ModaPanelS, "card1");
    }
    void EvPanel()
    {
        EvPanel = addPanel(siralamaLayout, new WinForms.Tema.JPanelKutusu());
        EvPanel.setBorder(new EmptyBorder(20,20,20,20)); // margin
        for (int i=0;i<4;i++)
        {
            JPanel kutu1 = new Kart(this);
            EvPanel.add(kutu1); 
        }
        EvPanelS = new JScrollPane(EvPanel);
        EvPanelS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        EvPanelS.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Center.add(EvPanelS, "card2");
    }
}
