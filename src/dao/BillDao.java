/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author kilch
 */
public class BillDao {
    public static String getId(){
    int id=1;
    try{
    var rs=DbOperations.getData("select max(id) from bill");
    if(rs.next()){
    id=rs.getInt(1);
    id=id + 1;
    }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    return String.valueOf(id);
    }
    
    public static void save(Bill bill){
    String query="insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobilenumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreateBy()+"')";
    DbOperations.setDataOrDelete(query,"Bill Details Added Successfully");
    }
    public static ArrayList<Bill>getAllRecordsByInc(String date)
    {
    ArrayList<Bill> arrayList = new ArrayList<>();
    try{
        ResultSet rs=(ResultSet) DbOperations.getData("select *from bill where date like '%"+date+"%'");
        while(rs.next()){
        Bill bill=new Bill();
        bill.setId(rs.getInt("id"));
        bill.setName(rs.getString("name"));
        bill.setMobilenumber(rs.getString("mobilenumber"));
        bill.setEmail(rs.getString("email"));
        bill.setDate(rs.getString("date"));
        bill.setTotal(rs.getString("total"));
        bill.setCreateBy(rs.getString("createdby"));
        arrayList.add(bill);
        
        }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
    }

    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class ResultSet {

        public ResultSet() {
        }

        private int getInt(String id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getString(String name) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean next() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
          public static ArrayList<Bill>getAllRecordsByDesc(String date)
    {
    ArrayList<Bill> arrayList = new ArrayList<>();
    try{
        ResultSet rs=(ResultSet) DbOperations.getData("select *from bill where date like '%"+date+"%' order By id DESC");
        while(rs.next()){
        Bill bill=new Bill();
        bill.setId(rs.getInt("id"));
        bill.setName(rs.getString("name"));
        bill.setMobilenumber(rs.getString("mobilenumber"));
        bill.setEmail(rs.getString("email"));
        bill.setDate(rs.getString("date"));
        bill.setTotal(rs.getString("total"));
        bill.setCreateBy(rs.getString("createdby"));
        arrayList.add(bill);
        
        }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    
    }
    return arrayList;
    }
    }
    
    

    }

