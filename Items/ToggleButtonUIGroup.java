package WinForms.Items;
import java.util.ArrayList;

public class ToggleButtonUIGroup
{
    private ArrayList<ToggleButtonUI> buttonlar;
    public ToggleButtonUIGroup()
    {
        buttonlar = new ArrayList<ToggleButtonUI>();
    }

    public void add(ToggleButtonUI toggle)
    {
        buttonlar.add(toggle);
    }

    public void remove(ToggleButtonUI toggle)
    {
        for (int i=0;i<buttonlar.size();i++)
        {
            if (buttonlar.get(i).getText() == toggle.getText())
                buttonlar.remove(i);
        }
    }

    public void update(ToggleButtonUI toggle)
    {
        for (ToggleButtonUI btn : buttonlar)
        {
            if (toggle.getText() == btn.getText())
            {
                btn.setSecildi(true);
                btn.UpdateUI();
            }
            else
            {
                btn.setSecildi(false);
                btn.UpdateUI();
            }
        }
    }

}
