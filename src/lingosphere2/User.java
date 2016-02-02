/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingosphere2;

import java.util.ArrayList;
enum UserType { STUDENT, INSTRUCTOR};
   
public class User {
     private String username;
     private String psswd ;
     private String classid ;
     private String usertype;
     private int grade ;
     
     public User() { };
     public User(String username,String psswd,String classid, String usertype)
     {
         this.username = username;
         this.psswd = psswd;
         this.classid = classid;
         this.usertype = usertype;
     }
     public Boolean checkValidUser(String usernameInput, String psswdInput)
     { 
         if ((usernameInput.trim().equals(username))&&
                 psswdInput.trim().equals(psswd))
                 return true ;
         return false ;
     };
     public void setUsername(String username){ this.username = username ; }
     public void setPsswd(String psswd){ this.psswd = psswd ; }
     public void setClass(String classid) { this.classid = classid ; }
     public void setType(String userType) { this.usertype = usertype; }
  
     
}
