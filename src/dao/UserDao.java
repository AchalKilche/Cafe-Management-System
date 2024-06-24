/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kilch
 */
public class UserDao {

    public static void save(User user) {
        String query = "insert into user(name,email,mobilenumber,address,password,securityquestion,answer,status)values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobilenumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityquestion() + "','" + user.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! wait for Admin Approval!");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user email='" + email + "'");
            while(rs.next()){
            user=new user(0);
            user.setSecurityquestion(rs.getString("SecurityQuestion"));
            user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return user;
    }
    
    public static void Update(String email,String newpassword){
            String query="update user set password='"+newpassword+"'where email='" +email+"'";
            DbOperations.setDataOrDelete(query,"Password Changed Successfully");
            
}
    public static ArrayList<User>getAllRecords(String email){
    ArrayList<User>arrayList=new ArrayList<>();
    try{
    ResultSet rs=DbOperations.getData("select *from user where email like '%"+email+"%'");
    while(rs.next()){
    User user=new User();
    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));
    user.setEmail(rs.getString("email"));
    user.setMobilenumber(rs.getString("mobilenumber"));
    user.setAddress(rs.getString("address"));
    user.setSecurityquestion(rs.getString("securityquestion"));
    user.setStatus(rs.getString("status"));
    arrayList.add(user);
    
    }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
      return arrayList;
    }
    public static void changestatus(String email,String status){
    String query="update user set status'"+status+"'where email='"+email+"'";
    DbOperations.setDataOrDelete(query,"Status Changed Successfully");
    }

    public static void changePassword(String userEmail, String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void changeSecurityQuestion(String userEmail, String password, String securityquestion, String answer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private static class user extends User {

        private static void update(String email, String newPassword, String answer) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void update(String email, String newPassword) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public user(int i) {
        }
        
        public static void changePassword(String email,String oldPassword,String newPassword){
        try{
        ResultSet rs=DbOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
        if(rs.next()){
        update(email,newPassword);
        }
            else{
                    JOptionPane.showMessageDialog(null,"Old Password is Wrong");
                    }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, email);
            
        }
        }
        
        public static void ChangeSecurityQuestion(String email,String password,String securityquestion,String answer){
        try{
        ResultSet rs=DbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
        if(rs.next()){
        update(email, securityquestion, answer);
        }
            else{
                  JOptionPane.showMessageDialog(null, "Password is Wromg");
                    }
            
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
      }
    
    }
    
    public static void update(String email,String securityquestion,String answer){
        String query="update user set securityquestion='"+securityquestion+"',answer ='"+answer+"'";
        DbOperations.setDataOrDelete(query,"Security Question Changed Successfully");
                                                                                       
    
    }
}
