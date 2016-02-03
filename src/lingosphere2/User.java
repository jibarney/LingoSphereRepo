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
     
     public User() 
     { 
         this.username = "GUEST";
         this.psswd = "guest";
         this.classid = "whatever";
         this.usertype = "student";
     };
     public User(String username,String psswd,String usertype, String classid)
     {
         this.username = username;
         this.psswd = psswd;
         this.classid = classid;
         this.usertype = usertype;
     }
     
     // Copy constructor 
     public User(User origUser )
     {
         this(origUser.getUsername(), 
              origUser.getPsswd(),
              origUser.getType(), 
              origUser.getClassname());
     }
     
     public Boolean checkValidUser(String usernameInput, String psswdInput)
     { 
         if ((usernameInput.trim().equals(username.trim()))&&
                 psswdInput.trim().equals(psswd.trim()))
                 return true ;
         return false ;
     };
     
     public void setUsername(String username){ this.username = username ; }
     public void setPsswd(String psswd){ this.psswd = psswd ; }
     public void setClass(String classid) { this.classid = classid ; }
     public void setType(String userType) { this.usertype = usertype; }
     public String getUsername() { return username ; } 
     public String getPsswd() { return psswd ;} 
     public String getClassname() { return classid;}
     public String getType() { return usertype ;}
     
     public String welcomeUser(){
        return  "   Welcome user "+username +"!\n"+
                "   You have "+usertype+" access for class "+classid ;
     }
     
}
