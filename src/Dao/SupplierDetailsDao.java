/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.EmployeeDetails;
import Models.SupplierDetails;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class SupplierDetailsDao {
     public List<List<String>> ListofSupplierDetailsList = new ArrayList<List<String>>();
     public boolean addSupplier( SupplierDetails supplier) throws SQLException, ParseException {
        String supplierId= supplier.getSupplierId();
        String supplierName= supplier.getSupplierName();
        int teleNo = supplier.getTelephoneNo();
        String businessPlaceAddress = supplier.getBusinessPlaceAddress();
        Date addedDate = supplier.getAddedDate();
        String mailAddress = supplier.getMailAddress();

        PreparedStatement stm = null;
        Connection connection = null;

        try {
            String sql = "insert into Supplier values(?,?,?,?,?,?)";
            connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, supplierId);
            stm.setObject(2, supplierName);
            stm.setObject(3, teleNo);
            stm.setObject(4, mailAddress);
            stm.setObject(5, businessPlaceAddress);
            stm.setObject(6, addedDate);
            
            int res = stm.executeUpdate();

            if (res == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }
            return res > 0;

        } catch (SQLException e) {
            connection.rollback();
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
            System.out.println("error@ " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;

    }
     
     public List ViewSupplierDetails(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select sup.Supplier_id, sup.Supplier_name,sup.Supplier_address,sup.Email_address,sup.Telephone_no\n" +
"  from Supplier sup";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> supplierDetails = new ArrayList<String>();
                    for (int i = 1; i < 6 ; i++){
                            supplierDetails.add(rst.getString(i));
                    }

                ListofSupplierDetailsList.add(supplierDetails);
               
               
            }
            return ListofSupplierDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofSupplierDetailsList;
    }
     public String nextSupplierId(){
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Supplier_id from Supplier";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "S00"+last;
            return id;
        }
        catch(SQLException e)
        {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
        return id;
    }
}

     
    

