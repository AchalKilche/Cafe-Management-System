/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.text.SimpleDateFormat;
import common.OpenPdf;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import java.lang.*;
import model.Product;

/**
 *
 * @author kilch
 */
public class PlaceOrder extends javax.swing.JFrame {

    public int billid = 1;
    public int grandtotal = 0;
    public int productprice = 0;
    public int producttotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobilenumberPattern = "^[0-9]*$";
    public String userEmail;
  //  private Object PdfWriter;
    private int i;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();

    }

    public PlaceOrder(String userEmail) {
        initComponents();
        txtproname.setEditable(false);
        txtproprice.setEditable(false);
        txtprototal.setEditable(false);
        btnaddtocart.setEnabled(false);
        btngeneratebillprint.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        String email = null;
        userEmail = email;

    }

    public void productNameByCategory(String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void filterProductByName(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByName(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void clearProductField() {
        txtproname.setText("");
        txtproprice.setText("");
        jSpinner1.setValue(1);
        txtprototal.setText("");
        btnaddtocart.setEnabled(false);
    }

    public void validateField() {
        String customername = txtcustname.getText();
        String customermobilenumber = txtcustmobileno.getText();
        String customeremail = txtcustemail.getText();
        if (!customeremail.equals("") && customermobilenumber.matches(mobilenumberPattern) && customermobilenumber.length() == 10 && customeremail.matches(emailPattern) && grandtotal > 0) {
            btngeneratebillprint.setEnabled(true);
        } else {
            btngeneratebillprint.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcustname = new javax.swing.JTextField();
        txtcustmobileno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcustemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtproname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtproprice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        txtprototal = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        btnaddtocart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lblgrandtotal = new javax.swing.JLabel();
        btngeneratebillprint = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bill ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 102, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 30, 30, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("--");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 102, 61, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Details :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 149, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 207, 60, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mobile Number ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 307, 133, -1));

        txtcustname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcustname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcustnameKeyReleased(evt);
            }
        });
        getContentPane().add(txtcustname, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 254, 250, -1));

        txtcustmobileno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcustmobileno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcustmobilenoKeyReleased(evt);
            }
        });
        getContentPane().add(txtcustmobileno, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 352, 250, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 406, 54, -1));

        txtcustemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcustemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcustemailKeyReleased(evt);
            }
        });
        getContentPane().add(txtcustemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 454, 250, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 102, 78, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Search");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 207, 69, -1));

        txtsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 254, 251, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 146, 251, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 307, 251, 357));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 102, 43, -1));

        txtproname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtproname, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 146, 250, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1057, 102, 43, -1));

        txtproprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtproprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1057, 146, 250, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 207, 73, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 255, 250, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1057, 207, 43, -1));

        txtprototal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtprototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1057, 254, 250, -1));

        btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 307, -1, -1));

        btnaddtocart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnaddtocart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnaddtocart.setText("Add To Cart");
        btnaddtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtocartActionPerformed(evt);
            }
        });
        getContentPane().add(btnaddtocart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 307, -1, -1));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 376, 566, 288));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Grand Total Rs.");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 690, 150, -1));

        lblgrandtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblgrandtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblgrandtotal.setText("000");
        getContentPane().add(lblgrandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 690, 43, -1));

        btngeneratebillprint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btngeneratebillprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btngeneratebillprint.setText("Generate Bill & Print");
        btngeneratebillprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeneratebillprintActionPerformed(evt);
            }
        });
        getContentPane().add(btngeneratebillprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 680, 210, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/full-page-background.PNG"))); // NOI18N
        jLabel16.setText("jLabel16");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btngeneratebillprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeneratebillprintActionPerformed
        // TODO add your handling code here:
        String customerName = txtcustname.getText();
        String customerMobileNumber = txtcustmobileno.getText();
        String customerEmail = txtcustemail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String total = String.valueOf(grandtotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billid);
        bill.setName(customerName);
        bill.setMobilenumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todaydate);
        bill.setTotal((total));
        bill.setCreateBy(createdBy);
        BillDao.save(bill);

        //creating document
        String path = "E:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {

            Pdfwriter.getInstance(doc,new FileOutputStream(path + ""+ billid +".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                     LifeWin Cafe Management System\\n");
            doc.add(cafeName);
            Paragraph startLine = new Paragraph("*************************************************************************************************************************************************");
            doc.add(startLine);
            Paragraph paragraph3 = new Paragraph("\tBill ID:" + billid + "\nCustomer Name: " + customerName + "\nTotal Paid:" + grandtotal + "");
            doc.add(paragraph3);
            doc.add(startLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String n = jTable2.getValueAt(i, 0).toString();
                String d = jTable2.getValueAt(i, 1).toString();
                String r = jTable2.getValueAt(i, 2).toString();
                String q = jTable2.getValueAt(1, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);

            }
            doc.add(tb1);
            doc.add(startLine);
            Paragraph thanksMsg=new Paragraph("Thank You Please Visit Again.");
            doc.add(thanksMsg);
            
            OpenPdf.openBy(String.valueOf(billid));

        } catch (Exception e) {
            String q = jTable2.getValueAt(i, 0).toString();

            JOptionPane.showMessageDialog(null, e);
        }
       doc.close();
       setVisible(false);
       new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btngeneratebillprintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billid = Integer.parseInt(BillDao.getId());
        jLabel3.setText(BillDao.getId());
        ArrayList<Category> list = CategoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);


    }//GEN-LAST:event_formComponentShown

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String name = txtsearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByName(name, category);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String ProductName = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByname(ProductName);
        txtproname.setText(product.getName());
        txtproprice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txtprototal.setText(product.getPrice());
        productprice = Integer.parseInt(product.getPrice());
        producttotal = Integer.parseInt(product.getPrice());
        btnaddtocart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <= 1) {
            jSpinner1.setValue(1);
            quantity = 1;

        }
        producttotal = productprice * quantity;
        txtprototal.setText(String.valueOf(producttotal));

    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnaddtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtocartActionPerformed
        // TODO add your handling code here:
        String name = txtproname.getText();
        String price = txtproprice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name, price, quantity, producttotal});
        grandtotal = grandtotal + producttotal;
        lblgrandtotal.setText(String.valueOf(grandtotal));

        clearProductField();
        validateField();
    }//GEN-LAST:event_btnaddtocartActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        clearProductField();
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtcustnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcustnameKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtcustnameKeyReleased

    private void txtcustmobilenoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcustmobilenoKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtcustmobilenoKeyReleased

    private void txtcustemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcustemailKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtcustemailKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index=jTable2.getSelectedRow();
        int a=JOptionPane.showConfirmDialog(null, "Do You Want to remove this product","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
        TableModel model=jTable2.getModel();
        String total=model.getValueAt(index, 3).toString();
        grandtotal=grandtotal - Integer.parseInt(total);
        lblgrandtotal.setText(String.valueOf(grandtotal));
        ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddtocart;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btngeneratebillprint;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblgrandtotal;
    private javax.swing.JTextField txtcustemail;
    private javax.swing.JTextField txtcustmobileno;
    private javax.swing.JTextField txtcustname;
    private javax.swing.JTextField txtproname;
    private javax.swing.JTextField txtproprice;
    private javax.swing.JTextField txtprototal;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    private static class Pdfwriter {

        private static void getInstance(Document doc, FileOutputStream fileOutputStream) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Pdfwriter() {
        }
    }

    
            

    
}