/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.CustomerDetails;
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
public class CustomerDetailsDao {
     public List<List<String>> ListofCustomerDetailsList = new ArrayList<List<String>>();
     public boolean addCustomer( CustomerDetails customer) throws SQLException, ParseException {
         String customerId = customer.getCustomerId();
     String customerName= customer.getCustomerName();
     String customerNic= customer.getCustomerNic();
     String customerBusinessPlace= customer.getCustomerBusinessPlace();
     String customerRegNo= customer.getCustomerRegNo();
     String customerPersonalAddress= customer.getCustomerPersonalAddress();
     String customerEmail = customer.getCustomerEmail();
     int customerTelephoneNo = customer.getCustomerTelephoneNo();
     Date customerAddedDate= customer.getCustomerAddedDate();

        PreparedStatement stm = null;
        Connection connection = null;

        try {
            String sql = "insert into Customer values(?,?,?,?,?,?,?,?)";
            connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, customerId);
            stm.setObject(2, customerName);
            stm.setObject(3, customerBusinessPlace);
            stm.setObject(4, customerRegNo);
            stm.setObject(5, customerPersonalAddress);
            stm.setObject(6, customerEmail);
            stm.setObject(7, customerTelephoneNo);
            stm.setObject(8, customerAddedDate);
            
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
     
     public List ViewCustomerDetails(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select * from Customer";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> customerDetails = new ArrayList<String>();
                    for (int i = 1; i < 9 ; i++){
                            customerDetails.add(rst.getString(i));
                    }

                ListofCustomerDetailsList.add(customerDetails);
               
               
            }
            return ListofCustomerDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofCustomerDetailsList;
    } 
     
     public String nextCustomerId(){
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Customer_id from Customer";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "C00"+last;
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

     
    

