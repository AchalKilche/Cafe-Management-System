/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author kilch
 */
public class ConnectionProvider {
    public static Connection getCon(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","Aditya@12345");
                return con;
            }
                  
    catch(Exception e){
        return null;
    }
    }
    
}
