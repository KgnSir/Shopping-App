package WinForms.Animations;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AnimatedColor2 
{
    static boolean DisableAnimation = true;
    //#region ToggleButtonUI ve ButtonUI
    public static void setBack(Timer timer,JPanel kutu, Color oldCol, Color newCol)
    {
        if (DisableAnimation)
        {
            if (timer != null)
                timer.stop();
            kutu.setBackground(newCol);
            return;
        }
        if (timer != null && timer.isRunning())
        {
            timer.stop();
            if (kutu != null)
                kutu.setBackground(oldCol);
        }
        timer = new Timer(1, new ActionListener()
        {
            Color oldColor = oldCol, newColor = newCol;
            int rold = oldColor.getRed(), gold=oldColor.getGreen(),bold=oldColor.getBlue();
            int rnew = newColor.getRed(), gnew=newColor.getGreen(),bnew=newColor.getBlue();
    
            boolean rart = (rold<rnew ? true : false), 
            gart = (gold<gnew ? true : false),
            bart = (bold<bnew ? true : false);
            int rcur = rold, gcur = gold, bcur = bold;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (rcur != rnew && rart)
                    rcur += 1;
                else if (rcur != rnew && !rart)
                    rcur -= 1;
                if (gcur != gnew && gart )
                    gcur += 1;
                else if (gcur != gnew && !gart)
                    gcur -= 1;
                if (bcur != bnew && bart)
                    bcur += 1;
                else if (bcur != bnew && !bart)
                    bcur -= 1;
                
                Color renk = new Color(rcur, gcur, bcur);
                kutu.setBackground(renk);
                if (renk.getRGB() == newColor.getRGB())
                    ((Timer)e.getSource()).stop();
            }

        });
        timer.start();
    } 
    public static void setFore(Timer timer,JLabel lbl, Color oldCol, Color newCol)
    {
        if (DisableAnimation)
        {
            if (timer != null)
                timer.stop();
            lbl.setForeground(newCol);
            return;
        }
        if (timer != null && timer.isRunning())
        {
            timer.stop();
            lbl.setForeground(oldCol);
        }
        timer = new Timer(1, new ActionListener()
        {
            Color oldColor = oldCol, newColor = newCol;
            int rold = oldColor.getRed(), gold=oldColor.getGreen(),bold=oldColor.getBlue();
            int rnew = newColor.getRed(), gnew=newColor.getGreen(),bnew=newColor.getBlue();
    
            boolean rart = (rold<rnew ? true : false), 
            gart = (gold<gnew ? true : false),
            bart = (bold<bnew ? true : false);
            int rcur = rold, gcur = gold, bcur = bold;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (rcur != rnew && rart)
                    rcur += 1;
                else if (rcur != rnew && !rart)
                    rcur -= 1;
                if (gcur != gnew && gart )
                    gcur += 1;
                else if (gcur != gnew && !gart)
                    gcur -= 1;
                if (bcur != bnew && bart)
                    bcur += 1;
                else if (bcur != bnew && !bart)
                    bcur -= 1;
                
                Color renk = new Color(rcur, gcur, bcur);
                lbl.setForeground(renk);
                if (renk.getRGB() == newColor.getRGB())
                    ((Timer)e.getSource()).stop();
            }

        });
        timer.start();
    }
    
    static Timer timerfore;
    public static void mouseFore(JLabel lbl, Color oldColor, Color newColor) 
    {
        if (DisableAnimation)
        {
            if (timerfore != null)
                timerfore.stop();
            lbl.setForeground(newColor);
            return;
        }
        if (timerfore != null && timerfore.isRunning())
            timerfore.stop();
        timerfore = new Timer(1, new ActionListener()
        {
            int rold = oldColor.getRed(), gold=oldColor.getGreen(),bold=oldColor.getBlue();
            int rnew = newColor.getRed(), gnew=newColor.getGreen(),bnew=newColor.getBlue();
    
            boolean rart = (rold<rnew ? true : false), 
            gart = (gold<gnew ? true : false),
            bart = (bold<bnew ? true : false);
            int rcur = rold, gcur = gold, bcur = bold;
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (rcur != rnew && rart)
                    rcur += 1;
                else if (rcur != rnew && !rart)
                    rcur -= 1;
                if (gcur != gnew && gart )
                    gcur += 1;
                else if (gcur != gnew && !gart)
                    gcur -= 1;
                if (bcur != bnew && bart)
                    bcur += 1;
                else if (bcur != bnew && !bart)
                    bcur -= 1;
                
                Color renk = new Color(rcur, gcur, bcur);
                lbl.setForeground(renk);
                if (renk.getRGB() == newColor.getRGB())
                    ((Timer)e.getSource()).stop();
            }

        });
        timerfore.start();
    }
    //#endregion
}
