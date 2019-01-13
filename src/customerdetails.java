
import Dao.CustomerDetailsDao;
import Dao.EmployeeDetailsDao;
import Dao.SearchDao;
import Models.CustomerDetails;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class customerdetails extends javax.swing.JFrame {

    /**
     * Creates new form customerdetails
     */
    public customerdetails() {
        initComponents();
        loadCustomerDetails();
        generateId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customnameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        busplaceField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        busregField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        personaladdField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        telenoField = new javax.swing.JTextField();
        submitbutton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        customerID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerdetailsTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        custIDradbox = new javax.swing.JRadioButton();
        searchbutton = new javax.swing.JButton();
        backbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CUSTOMER DETAILS");
        setPreferredSize(new java.awt.Dimension(1336, 768));

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1200, 648));

        jPanel1.setPreferredSize(new java.awt.Dimension(850, 657));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Customer Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("NIC No");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Business Place");

        busplaceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busplaceFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Business Reg No");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Personal Address");

        personaladdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personaladdFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Tele No");

        submitbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        submitbutton.setText("SUBMIT");
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });

        resetbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resetbutton.setText("RESET");
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Customer ID");

        customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Date");

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Academic\\IMGT 3+34\\customer.jpg")); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setPreferredSize(new java.awt.Dimension(1318, 720));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitbutton))
                            .addComponent(customnameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nicField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busplaceField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busregField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personaladdField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telenoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(653, 653, 653)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(customerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(busplaceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(busregField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(personaladdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(telenoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetbutton)
                            .addComponent(submitbutton)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(278, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add a new customer", jPanel1);

        customerdetailsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        customerdetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "NIC", "Business Place", "Company Address", "Email", "Tele No", "Business Reg No"
            }
        ));
        jScrollPane1.setViewportView(customerdetailsTable);

        custIDradbox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        custIDradbox.setText("Customer ID");

        searchbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchbutton.setText("Search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
                .addGap(79, 79, 79))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(custIDradbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custIDradbox)
                    .addComponent(searchbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View of Existing Customers", jPanel2);

        backbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void busplaceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busplaceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busplaceFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        // TODO add your handling code here:
        ClearFields();
        loadCustomerDetails();
               generateId();
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
         this.setVisible(false);
        homepage h=new homepage();
        h.setVisible(true);
    }//GEN-LAST:event_backbuttonActionPerformed

    private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
    
         boolean validatednull = true;
        boolean validated =true;
        
        
          if(customnameField.getText().equals("")||nicField.getText().equals("")||busplaceField.getText().equals("")||busregField.getText().equals("")||
              personaladdField.getText().equals("")||emailField.getText().equals("")||telenoField.getText().equals("")||date.getDate()== null)
              {
              validatednull = false;
           JOptionPane.showMessageDialog(this,"Please fill up all the Fields ");           
        }
          
          
          
          
         
         if( validatednull==true)
         {
             Date currentdate = new Date();
             
               if ( customnameField.getText().length() > 60 ||busplaceField.getText().length() > 60|| busregField.getText().length() > 60 ||  personaladdField.getText().length() > 60||
                       emailField.getText().length() > 60) {
                validated = false;
              JOptionPane.showMessageDialog(this, "Maximum length exceeds allows less than 60 characters");
         }
         
             
              if((telenoField.getText().matches("[0-9]+")==false)|| (telenoField.getText().length()!=10)){
                 JOptionPane.showMessageDialog(this,"Telephone Number should be numbers without spaces and should have at least 10 numbers");
                validated = false;
                 }
              
                if((nicField.getText().length()!=12|| nicField.getText().length()!=10)){
                 JOptionPane.showMessageDialog(this,"nic should have at least 10 numbers");
                validated = false;
                 }
               
                                
                if((-1!=emailField.getText().indexOf(" "))||(-1==emailField.getText().indexOf("@"))){
                JOptionPane.showMessageDialog(this,"Enter a valid email address without spaces");
                validated = false;
            }
    
                if(!currentdate.after(date.getDate())  ){
                JOptionPane.showMessageDialog(this,"Customer added date is not valid");
                validated = false;
            }
                
                if(validated ==true)
                {
                      String customerId = customerID.getText();
     String customerName= customnameField.getText();
     String customerNic= nicField.getText();
     String customerBusinessPlace= busplaceField.getText();
     String customerRegNo= busregField.getText();
     String customerPersonalAddress= personaladdField.getText();
     String customerEmail = emailField.getText();
     int customerTelephoneNo = Integer.parseInt(telenoField.getText());
     Date customerAddedDate= date.getDate();
        
        
        CustomerDetails customer = new CustomerDetails();
        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerNic(customerNic);
      customer.setCustomerPersonalAddress(customerPersonalAddress);
      customer.setCustomerRegNo(customerRegNo);
      customer.setCustomerEmail(customerEmail);
      customer.setCustomerBusinessPlace(customerBusinessPlace);
      customer.setCustomerAddedDate(customerAddedDate);
       CustomerDetailsDao customerDetail = new CustomerDetailsDao();
        try {
            boolean res = customerDetail.addCustomer(customer);
            if(res == true){
                JOptionPane.showMessageDialog(this, "Customer added sucessfully");
                ClearFields();
               loadCustomerDetails();
               generateId();
            }
            else{
                JOptionPane.showMessageDialog(this, "Error occur in adding Customer");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Employeedetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Employeedetails.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
           
         }

        
        
        
        
        
        
        
        
                      // TODO add your handling code here:
    }//GEN-LAST:event_submitbuttonActionPerformed

    private void ClearFields()
    {
        customerID.setText(null);
     customnameField.setText(null);
     nicField.setText(null);
     busplaceField.setText(null);
     busregField.setText(null);
    personaladdField.setText(null);
  emailField.setText(null);
    telenoField.setText(null);
    date.setDate(null);
    }
    private void personaladdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personaladdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personaladdFieldActionPerformed

    private void customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
        String customerId =searchField.getText();
         SearchDao empDetailSearchDao = new SearchDao();
      
        List<List<String>> res = empDetailSearchDao.CustomerSearch(customerId);
        addRowToJTable(res);
    }//GEN-LAST:event_searchbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(customerdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerdetails().setVisible(true);
            }
        });
    }
    
     public void loadCustomerDetails(){
        CustomerDetailsDao customerDao = new CustomerDetailsDao();
        List<List<String>> res = customerDao.ViewCustomerDetails();
        addRowToJTable(res);
    }
     public void addRowToJTable(List res)
    {
        customerdetailsTable.setShowGrid(true);
        DefaultTableModel model = (DefaultTableModel) customerdetailsTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[8];
        for (Iterator it = res.iterator(); it.hasNext();) {
            List<String> innerList = (List<String>) it.next();
            rowData[0] = innerList.get(0);
            rowData[1] = innerList.get(1);
            rowData[2] = innerList.get(2);
            rowData[3] = innerList.get(3);
            rowData[4] = innerList.get(4);
            rowData[5] = innerList.get(5);
            rowData[6] = innerList.get(6);
            rowData[7] = innerList.get(7);
           
            
            
           
           
            model.addRow(rowData);
        
        }
    }
     
     public void generateId(){
          CustomerDetailsDao customer = new CustomerDetailsDao();
          String id =customer.nextCustomerId();
          customerID.setText(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JTextField busplaceField;
    private javax.swing.JTextField busregField;
    private javax.swing.JRadioButton custIDradbox;
    private javax.swing.JTextField customerID;
    private javax.swing.JTable customerdetailsTable;
    private javax.swing.JTextField customnameField;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nicField;
    private javax.swing.JTextField personaladdField;
    private javax.swing.JButton resetbutton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchbutton;
    private javax.swing.JButton submitbutton;
    private javax.swing.JTextField telenoField;
    // End of variables declaration//GEN-END:variables
}
