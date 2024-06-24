/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;




import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kilch
 */
public class DbOperations {
   
    
    public static void setDataOrDelete(String Query,String msg){
        try{
            var con = ConnectionProvider.getCon();
                var st = con.createStatement();
                st.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.ERROR_MESSAGE);
        
        }
    }

    /**
     *
     * @param query
     * @return
     */
    public static java.sql.ResultSet getData(String query){
       try{
                var con = ConnectionProvider.getCon();
                var st = con.createStatement();
                var rs=st.executeQuery(query);
                return rs;
       }
       catch(Exception e){
       JOptionPane.showMessageDialog(null,e, "Message", JOptionPane.ERROR_MESSAGE);
       return null;
       }
    }

    private static class ResultSet {

        public ResultSet() {
        }
    }
    }
    

