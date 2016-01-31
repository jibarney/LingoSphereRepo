/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingosphere2;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelfTestPage  {
    
    public SelfTestPage() {}
    
    public JPanel buildSelfTestGui() 
    {
       JPanel panel = new JPanel() ;
       JLabel dummy = new JLabel("Self Test");
       dummy.setHorizontalAlignment(JLabel.CENTER);
      // setPreferredSize(new Dimension(400,50));
       panel.setDoubleBuffered(false)  ;
       panel.add(dummy) ;
       return panel ;
    }
}
