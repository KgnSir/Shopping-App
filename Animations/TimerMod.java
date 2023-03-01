package WinForms.Animations;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class TimerMod extends javax.swing.Timer
{
    public JPanel item;
    public Color setCol, oldCol;
    public TimerMod(JPanel item,Color oldCol, Color setCol,int delay, ActionListener actionListener) 
    {
        super(delay, actionListener);
        this.item = item;
        this.setCol = setCol;
        this.oldCol = oldCol;
    }
    public JLabel lbl;
    public TimerMod(JLabel lbl,Color oldCol, Color setCol) 
    {
        super(1, null);
        this.lbl = lbl;
        this.setCol = setCol;
        this.oldCol = oldCol;
    }
    public Container ozelitem;
    public TimerMod(Container ozelitem,Color oldCol, Color setCol,int delay, ActionListener actionListener) 
    {
        super(delay, actionListener);
        this.ozelitem = ozelitem;
        this.setCol = setCol;
        this.oldCol = oldCol;
    }
}
