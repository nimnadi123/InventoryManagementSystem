
import Dao.EmployeeDetailsDao;
import Dao.SearchDao;
import Models.EmployeeDetails;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
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
public class Employeedetails extends javax.swing.JFrame {

    /**
     * Creates new form Employeedetails
     */
    public Employeedetails() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setBounds(0,0,screenSize.width, screenSize.height);
        loadEmployeeDetails();
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

        jMenu1 = new javax.swing.JMenu();
        viewEmployeePanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        employeeNameField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        teleNoField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        departmentField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        personalAddressField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nicField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        genderField = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        positionField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        employeeIdField = new javax.swing.JTextField();
        hiredDateField = new com.toedter.calendar.JDateChooser();
        dateOfBirthField = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        mailAddressField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeDetailsTable = new javax.swing.JTable();
        searchempIDbutton = new javax.swing.JButton();
        searchempIDfield = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMPLOYEE DETAILS");
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));

        viewEmployeePanel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewEmployeePanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Name");

        employeeNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameFieldActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Tele No");

        teleNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teleNoFieldActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Personal Address");

        departmentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentFieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("NIC");

        personalAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalAddressFieldActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Hired Date");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("Personal Details");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setText("Date of Birth");

        nicField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicFieldActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setText("Gender");

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Department");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Position");

        positionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Age");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Employee ID(Username)");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        passwordField.setText("jPasswordField1");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Mail Address");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Job Details");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel19))
                                .addGap(130, 130, 130)
                                .addComponent(mailAddressField))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(personalAddressField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(employeeNameField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateOfBirthField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nicField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(genderField, javax.swing.GroupLayout.Alignment.LEADING, 0, 76, Short.MAX_VALUE)
                                            .addComponent(ageField, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(teleNoField)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(employeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(hiredDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(positionField)
                                    .addComponent(departmentField))))
                        .addGap(50, 50, 50))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(teleNoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(personalAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mailAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(nicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(dateOfBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hiredDateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(resetButton))
                .addContainerGap())
        );

        jLabel9.setIcon(new javax.swing.ImageIcon("D:\\Academic\\IMGT 3+34\\54bca79e04d3110a6e8b02931cba7608.jpg")); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 482, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 240, Short.MAX_VALUE))
        );

        viewEmployeePanel.addTab("Add a new Employee", jPanel1);

        employeeDetailsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Date of Birth", "Address", "Tele No", "Department", "Service since"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeDetailsTable);

        searchempIDbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchempIDbutton.setText("Search Employee ID");
        searchempIDbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchempIDbuttonActionPerformed(evt);
            }
        });

        searchempIDfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchempIDfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchempIDbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchempIDfield, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchempIDbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchempIDfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewEmployeePanel.addTab("View of Existing Employees", jPanel3);

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewEmployeePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         this.setVisible(false);
        homepage h = new homepage();
        h.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void nicFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicFieldActionPerformed

    private void personalAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalAddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personalAddressFieldActionPerformed

    private void departmentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentFieldActionPerformed

    private void teleNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teleNoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teleNoFieldActionPerformed

    private void employeeNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameFieldActionPerformed

    private void searchempIDfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchempIDfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchempIDfieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void positionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        String Tele =teleNoField.getText();
        boolean validatednull = true;
        boolean validated =true;
         if(employeeNameField.getText().equals("")||personalAddressField.getText().equals("")||nicField.getText().equals("")||dateOfBirthField.getDate().equals(null)||departmentField.getText().equals(null)||positionField.getText().equals(null)||hiredDateField.getDate().equals("")||employeeIdField.getText().equals("")||passwordField.getPassword().equals("")||
              mailAddressField.getText().equals("")  ){
              validatednull = false;
            JOptionPane.showMessageDialog(this, "Please fill up all the Fields ");
            
        }
          if((Tele.matches("[0-9]+")==false)|| (Tele.length()!=10)){
                 JOptionPane.showMessageDialog(this,"Telephone Number should be numbers without spaces and should have at least 10 numbers");
                validated = false;
                 }

         if(validatednull==true && validated==true)
         {
      
        String employeeName = employeeNameField.getText();
        int teleNo = Integer.parseInt(teleNoField.getText());
        String personalAddress = personalAddressField.getText();
        String nic = nicField.getText();
        Date dateOfBirth = dateOfBirthField.getDate();
        int age = Integer.parseInt(ageField.getText());
        String gender = (String) genderField.getSelectedItem();
        String department = departmentField.getText();
        String position = positionField.getText();
        Date hiredDate = hiredDateField.getDate();
        String employeeId = employeeIdField.getText();
        String password = new String((passwordField.getPassword()));
        String mailAddress = mailAddressField.getText();
        
         Date date = new Date();
         
        
            if ( employeeName.length() > 60 || personalAddress.length() > 60|| department.length() > 60 || position.length() > 60) {
                validated = false;
              JOptionPane.showMessageDialog(this, "Maximum length exceeds allows less than 60 characters");
         }
         
            if(password.length()<6){
                JOptionPane.showMessageDialog(this,"Password should equal or more than 6 characters");
                 validated = false;
            } 
            
            if(-1!=password.indexOf(" ")){
               JOptionPane.showMessageDialog(this,"Password cannot have spaces");   
                validated = false;
            } 
              
                 if((nic.length()!=10)){
                 JOptionPane.showMessageDialog(this,"nic should have at least 10 numbers");
                validated = false;
                 }
               
                                
                if((-1!=mailAddress.indexOf(" "))||(-1==mailAddress.indexOf("@"))){
                JOptionPane.showMessageDialog(this,"Enter a valid email address without spaces");
                validated = false;
            }
    
                if(!date.after(dateOfBirth)  ){
                JOptionPane.showMessageDialog(this,"Date of birth is not valid");
                validated = false;
            }
                
                if(!date.after(hiredDate) ){
                   JOptionPane.showMessageDialog(this,"Hired Date is not valid");
                validated = false;
                }
                
                if(password.length()<6){
                JOptionPane.showMessageDialog(this,"Password should equal or more than 6 characters");
                 validated = false;
         }
        if(validated == true)
        {
            EmployeeDetails emp = new EmployeeDetails();
        emp.setEmployeeName(employeeName);
        emp.setAge(age);
        emp.setDateOfBirth(dateOfBirth);
        emp.setDepartment(department);
        emp.setEmployeeId(employeeId);
        emp.setGender(gender);
        emp.setHiredDate(hiredDate);
        emp.setMailAddress(mailAddress);
        emp.setNic(nic);
        emp.setPersonalAddress(personalAddress);
        emp.setPosition(position);
        emp.setHiredDate(hiredDate);
        emp.setPassWord(password);
        emp.setTelephoneNo(teleNo);

        EmployeeDetailsDao employeeDetail = new EmployeeDetailsDao();
        try {
            boolean res = employeeDetail.addEmployee(emp);
            if (res == true) {
                JOptionPane.showMessageDialog(this, "Employee added sucessfully");
                ClearFields();
                loadEmployeeDetails();
                generateId();
            } else {
                JOptionPane.showMessageDialog(this, "Error occur in adding Employee");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employeedetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Employeedetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
                
        
    }//GEN-LAST:event_submitButtonActionPerformed

    }
    
    private void ClearFields() {
        employeeNameField.setText(null);
        teleNoField.setText(null);
        personalAddressField.setText(null);
        nicField.setText(null);
        dateOfBirthField.setDate(null);
        ageField.setText(null);
        genderField.setSelectedItem(1);
        departmentField.setText(null);
        positionField.setText(null);
        hiredDateField.setDate(null);
        employeeIdField.setText(null);
        passwordField.setText(null);
        mailAddressField.setText(null);
    }
    private void searchempIDbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchempIDbuttonActionPerformed
        // TODO add your handling code here:
        
        SearchDao empDetailSearchDao = new SearchDao();
        String Empid = searchempIDfield.getText();
        List<List<String>> res = empDetailSearchDao.EmployeeSearch(Empid);
        addRowToJTable(res);
    }//GEN-LAST:event_searchempIDbuttonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        ClearFields();
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Employeedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employeedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employeedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employeedetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employeedetails().setVisible(true);
            }
        });

    }

    public void loadEmployeeDetails() {
        EmployeeDetailsDao empDao = new EmployeeDetailsDao();
        List<List<String>> res = empDao.ViewEmployeeDetails();
        addRowToJTable(res);
    }

    public void addRowToJTable(List res) {
        employeeDetailsTable.setShowGrid(true);
        DefaultTableModel model = (DefaultTableModel) employeeDetailsTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[7];
        for (Iterator it = res.iterator(); it.hasNext();) {
            List<String> innerList = (List<String>) it.next();
            rowData[0] = innerList.get(0);
            rowData[1] = innerList.get(1);
            rowData[2] = innerList.get(2);
            rowData[3] = innerList.get(3);
            rowData[4] = innerList.get(4);
            rowData[5] = innerList.get(5);
            rowData[6] = innerList.get(6);
            

            model.addRow(rowData);

        }

    }
    public void generateId(){
          EmployeeDetailsDao employeeDetail = new EmployeeDetailsDao();
          String id =employeeDetail.nextEmployeeId();
          employeeIdField.setText(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private com.toedter.calendar.JDateChooser dateOfBirthField;
    private javax.swing.JTextField departmentField;
    private javax.swing.JTable employeeDetailsTable;
    private javax.swing.JTextField employeeIdField;
    private javax.swing.JTextField employeeNameField;
    private javax.swing.JComboBox<String> genderField;
    private com.toedter.calendar.JDateChooser hiredDateField;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mailAddressField;
    private javax.swing.JTextField nicField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField personalAddressField;
    private javax.swing.JTextField positionField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton searchempIDbutton;
    private javax.swing.JTextField searchempIDfield;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField teleNoField;
    private javax.swing.JTabbedPane viewEmployeePanel;
    // End of variables declaration//GEN-END:variables
}
