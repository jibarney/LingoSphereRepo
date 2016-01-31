package lingosphere2;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TranslatePage {

    public TranslatePage(){}
    
    public JPanel buildXlateGui() 
    {
        JPanel panel = new JPanel();
        JLabel dummy = new JLabel("Quick Translation");
        dummy.setHorizontalAlignment(JLabel.CENTER);
        //   setPreferredSize(new Dimension(400,50));
        panel.setDoubleBuffered(false);
        panel.add(dummy);
        return panel;
    }
}
