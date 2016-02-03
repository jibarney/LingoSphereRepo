/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingosphere2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.JPanel;

public class SelfTestPage  {
    
    public SelfTestPage() {}
    
    
    public JPanel buildSelfTestGui() 
    {  
      
       JPanel panel = new JPanel() ;
       BoxLayout b1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
       panel.setLayout(b1);
      
       JLabel buttonSetLabel = new JLabel("German alphabet extensions");
       buttonSetLabel.setFont(new Font("Serif", Font.BOLD, 24));
       JPanel germanChars = new JPanel() ;
       JButton a = new JButton("\u00e4");
       JButton o = new JButton("\u00f6");
       JButton u = new JButton("\u00fc") ;
       JButton B = new JButton("\u00df");
       
       germanChars.add(a);
       germanChars.add(o);
       germanChars.add(u);
       germanChars.add(B);
       
      buttonSetLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      germanChars.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(buttonSetLabel);
      panel.add(germanChars) ;
      
   /*   try{
            FileInputStream fis = new FileInputStream("engToGer.txt") ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = " " ;
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            reader.close();
            fis.close();
      }
       catch (FileNotFoundException ex) {} 
       catch (IOException ex){}    */
       return panel ;
    }
}
