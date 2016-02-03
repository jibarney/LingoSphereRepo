
package lingosphere2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import javax.swing.border.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LoginPage {

private JRadioButton CU = new JRadioButton("Existing Account",true);
private JRadioButton NU = new JRadioButton("New Account",false);

// private JRadioButton guestAcct = new JRadioButton("Guest",false);
private JLabel headerLogo = new JLabel() ;
private String[] allClasses = {"GER103","SPN200","KLG405","FRN320"};
private String[] allUserTypes = {"STUDENT","INSTRUCTOR"} ;
private JComboBox classNum = new JComboBox(allClasses) ; 
private JComboBox accountType = new JComboBox(allUserTypes);
private JTextField curUserField = new JTextField(10);
private JTextField curPsswdField = new JTextField(10);
private JTextField newUserField = new JTextField(10);
private JTextField newPsswdField = new JTextField(10);
private JTextArea systemMessages = new JTextArea("System messages here",3,25) ;
private JButton submitButton = new JButton("Submit");

JPanel newLoginInfo1 = new JPanel(new GridLayout(5,2,2,2)) ;
JPanel loginPanel = new JPanel(new GridLayout(5,2,5,5));
 
static String logInMsg = "\nWelcome to Lingo Sphere, the language learning "+
        "tool developed by team JTA to facilitate foreign language learning and lesson "+
 "planning.\n\n"+
        "The program is intended for use by language students who need to review predetermined"+
        " vocabulary lists, instructors who need to set up language drills for class,  "
        + "and the casual user interested in looking for quick translation and proper"
        + " pronunciation of a particular"
        + " word.  ";

static String newAcctMsg = "\n\n New to Lingo Sphere? \n"
        + "Please setup a new account" ;
 
String userDataFilename = "userdata.txt" ;

private ArrayList<User> userList = new ArrayList<>();
private boolean newUserFlag = false ;

public LoginPage() 
    { 
       
       
    }
    
 public JPanel buildLoginGui()
    {
     //Outermost container
       JPanel panel = new JPanel();
       BoxLayout b1 = new BoxLayout(panel,BoxLayout.Y_AXIS);
       panel.setLayout(b1);
       
     // Logo and welcome message at top of half of GUI
       JPanel imagePanel = new JPanel() ;
       BoxLayout b2 = new BoxLayout(imagePanel,BoxLayout.X_AXIS) ;
       imagePanel.setLayout(b2);
       imagePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
       headerLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("LSlogo2.jpg")));
       JTextArea textArea = new JTextArea(logInMsg,8,45) ;
       JScrollPane scrollPane = new JScrollPane(textArea ) ;
       textArea.setFont(new Font("Serif", Font.ITALIC, 24));  
       textArea.setLineWrap(true);
       textArea.setWrapStyleWord(true);
       textArea.setEditable(false); 
       imagePanel.add(headerLogo);
       imagePanel.add(Box.createRigidArea(new Dimension(20,40)));
       imagePanel.add(scrollPane);
       
     // Bottom panel contains several subpanels for login input and feedback
       
       JPanel userPanel = new JPanel() ;
       BoxLayout b3 = new BoxLayout(userPanel,BoxLayout.X_AXIS) ;
       userPanel.setLayout(b3);
       userPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
       
      // System subpanel -  New/Existing User buttons + output text area
      
       JPanel systemPanel = new JPanel(new GridLayout(2,1)) ;
       TitledBorder systemBorder = BorderFactory.createTitledBorder("Login with: ");
       systemBorder.setTitlePosition(TitledBorder.TOP);
       ButtonGroup maybeNewUserType = new ButtonGroup();
       maybeNewUserType.add(NU);
       maybeNewUserType.add(CU) ;
       JPanel buttonPanel = new JPanel(new GridLayout(1,2));
       buttonPanel.add(CU,true);
       buttonPanel.add(NU,false);
       CU.addActionListener(new buttonListener());
       NU.addActionListener(new buttonListener());
       
       JScrollPane scrollPane1 = new JScrollPane(systemMessages ) ;
       systemMessages.setEditable(false); 
       systemMessages.setFont(new Font("Serif", Font.BOLD, 14)); 
       systemMessages.setForeground(Color.RED);
       systemMessages.setLineWrap(true);
       systemMessages.setWrapStyleWord(true);
       systemPanel.setBorder(systemBorder);
       systemPanel.add( buttonPanel);
       systemPanel.add(scrollPane1) ;
       
// Existing user subpanel - username and login fields
       
       TitledBorder currentUserBorder = BorderFactory.createTitledBorder("Current User");
       currentUserBorder.setTitlePosition(TitledBorder.TOP);
       loginPanel.setBorder(currentUserBorder) ;
       loginPanel.add(new JLabel(""))   ;
       loginPanel.add(new JLabel(""))   ;
       loginPanel.add(new JLabel("Please log in: "));
       loginPanel.add(new JLabel(""))   ;
       loginPanel.add(new JLabel("Username:")) ;
       loginPanel.add(curUserField) ;
       loginPanel.add(new JLabel("Password:")) ;
       loginPanel.add(curPsswdField) ;
       loginPanel.add(new JLabel(""))   ;
       loginPanel.add(new JLabel(""))   ;
       
 // New User Subpanel - New account setup infof
       
       TitledBorder newUserBorder = BorderFactory.createTitledBorder("New User");
       newUserBorder.setTitlePosition(TitledBorder.TOP);
       newLoginInfo1.setBorder(newUserBorder);
       newLoginInfo1.add( new JLabel("Please create an account: "));
       newLoginInfo1.add(new JLabel(""));
       newLoginInfo1.add(new JLabel("New Username:"));
       newLoginInfo1.add(newUserField);     
       newLoginInfo1.add(new JLabel("New Password:"));
       newLoginInfo1.add(newPsswdField);
       newLoginInfo1.add(new JLabel("Class enrolled"));
       newLoginInfo1.add(classNum) ;
       newLoginInfo1.add(new JLabel("Account type"));
       newLoginInfo1.add(accountType) ;
      
   // Add subpanels to the outer container
       userPanel.add(Box.createRigidArea(new Dimension(30,0)));
       userPanel.add(systemPanel);
       userPanel.add(Box.createRigidArea(new Dimension(30,0)));
       userPanel.add(loginPanel);
       userPanel.add(Box.createRigidArea(new Dimension(30,0)));
       userPanel.add(newLoginInfo1);
       userPanel.add(Box.createRigidArea(new Dimension(30,0)));
       
    // Add top panel, bottom panel, and  'Submit' button to outermost panel
       
       panel.add(imagePanel) ;
       panel.add(Box.createRigidArea(new Dimension(0,15)));
       panel.add(userPanel);
       panel.add(Box.createRigidArea(new Dimension(0,15)));
       panel.add(submitButton);
       panel.add(Box.createRigidArea(new Dimension(0,15)));
       
       buttonListener bl = new buttonListener() ;
       submitButton.addActionListener(new submitListener());
   
       //Initially, current user area enabled, new user disabled.
       Component[] comNU = newLoginInfo1.getComponents();
       Component[] comCU = loginPanel.getComponents();  
       for (int a = 0; a < comCU.length; a++) comCU[a].setEnabled(true);
       for (int a = 0; a < comNU.length; a++) comNU[a].setEnabled(false);
       
       return panel;
    }
    
    private class buttonListener implements ActionListener{
         
        public void actionPerformed(ActionEvent e)
        {   
            if (CU.isSelected())
            {
              enablePanel(loginPanel,true);
              enablePanel(newLoginInfo1,false);
              newUserFlag = false;
            }
            
            if (NU.isSelected())
            {
              enablePanel(loginPanel,false);
              enablePanel(newLoginInfo1,true);
              newUserFlag = true;
            }                               
        }
        }
    
     private class submitListener implements ActionListener{
         
        public void actionPerformed(ActionEvent e)
        {   
            boolean validLogin = false;
            User userFound = new User();
            
            if (newUserFlag)
            {
                String newUsername = newUserField.getText() ;
                String newPsswd = newPsswdField.getText() ;
                if ((newUsername.length() < 5) || (newPsswd.length() < 5))
                {
                    systemMessages.setText("Password and username must be at least 5 characters");
                }
                else
                {
                    userFound = addUser(userDataFilename) ;
                    systemMessages.setText(userFound.welcomeUser()); 
                    enablePanel(newLoginInfo1,false);
                }
            }
            else  // Look for existing user
            {
               userList = getUsers(userDataFilename);
               for (User user: userList){
               if (user.checkValidUser(curUserField.getText(),curPsswdField.getText()))  
                { 
                   validLogin = true;
                   userFound = new User(user);
                   break;
                }      
               }
               if (!validLogin)
                   systemMessages.setText(" Invalid login. Please try again.");
               else
               {
                   systemMessages.setText(userFound.welcomeUser()); 
                   enablePanel(loginPanel,false);
               }
           }
     }
    }
    
 // Read in all user accounts
     
    ArrayList<User> getUsers(String userFile)
    {
        ArrayList<User> userList = new ArrayList<>() ;
        FileInputStream fis = null ;
        BufferedReader reader = null ;
        File file =new File(userFile);
        
        if (!file.exists())return userList ;
        
        try{
            fis = new FileInputStream(userFile) ;
            reader = new BufferedReader(new InputStreamReader(fis));
            
    // For now, we're assuming the file is in the correct format so 
    // there are no error checks.
            
         String line = " " ;
         while (line != null)
          {
            line = reader.readLine() ;

            if (line != null){ 
                String username = line;
                String psswd = reader.readLine();
                String userType = reader.readLine() ;
                String className = reader.readLine() ; 
                
                line = reader.readLine() ;  //placeholders 
                line = reader.readLine() ;
                line = reader.readLine() ;
                line = reader.readLine() ;
                line = reader.readLine() ;
                line = reader.readLine() ;
                
                User UserToAdd = new User(username,psswd,userType, className);
                userList.add(UserToAdd); 
            }      
            }
        } 
        catch (FileNotFoundException ex) {} 
        catch (IOException ex){}
        finally 
        {
          try {
                reader.close();
                fis.close();
            } 
          catch(IOException ex){}
         };
        return userList;
    }
    
    User addUser(String userFile)
    {
        try{
    		File file =new File(userFile);
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fw = new FileWriter(file.getName(),true);
    	        BufferedWriter writer = new BufferedWriter(fw);
                writer.write(newUserField.getText()+" \n") ;
    	        writer.write(newPsswdField.getText()+" \n");
                writer.write(accountType.getSelectedItem().toString()+" \n");
                writer.write(classNum.getSelectedItem().toString()+" \n");
                writer.write("*\n");
                writer.write("*\n");
                writer.write("*\n");
                writer.write("*\n");
                writer.write("*\n");
                writer.write("*\n");
    	        writer.close();
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
        
        return new User(newUserField.getText(),newPsswdField.getText(),
                                accountType.getSelectedItem().toString(),
                                classNum.getSelectedItem().toString());
    }
    
   // Utility to disable/enable all components in a panel
    void enablePanel(JPanel panel, boolean enabled)
    {
          Component[] panelIO = panel.getComponents();
          for (int a = 0; a < panelIO.length; a++) {
                     panelIO[a].setEnabled(enabled);
          }
    }
    
   }
