/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class SearchDao {
    public List<List<String>> ListofEmployeeList = new ArrayList<List<String>>();
     public List<List<String>> ListofInventoryList = new ArrayList<List<String>>();
    public List<List<String>> ListofCustomerDetailsList = new ArrayList<List<String>>();
     public List<List<String>> ListofSupplierDetailsList = new ArrayList<List<String>>();
    public List EmployeeSearch(String EmployeeId){
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        {           
              String sql = "select emp.Employee_name,emp.Dateofbirth,emp.Personal_adress,emp.TeleNo,emp.Department,emp.Role_id,emp.Hireddate"
      +" from Employee emp where emp.Employee_id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
             stm = connection.prepareStatement(sql);
            
            
            stm.setObject(1, EmployeeId);
            rst = stm.executeQuery(); 
            
           
              while(rst.next())
            {  
                  List<String> employeedetails = new ArrayList<String>();
                  employeedetails.add(EmployeeId);
                    for (int i = 1; i < 8 ; i++){
                            employeedetails.add(rst.getString(i));
                    }

                ListofEmployeeList.add(employeedetails);
               
               
            }
            return ListofEmployeeList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofEmployeeList;
    }
    public List CustomerSearch(String CustomerId){
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        {           
              String sql = "select * from Customer where Customer_id= ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
             stm = connection.prepareStatement(sql);
            
            
            stm.setObject(1, CustomerId);
            rst = stm.executeQuery(); 
            
           
               while(rst.next())
            {  
                  List<String> customerDetails = new ArrayList<String>();
                  customerDetails.add(CustomerId);
                    for (int i = 1; i < 8 ; i++){
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
    
    public List SupplierSearch(String SupplierId){
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        {           
              String sql = "select * from Supplier where Supplier_id= ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
             stm = connection.prepareStatement(sql);
            
            
            stm.setObject(1, SupplierId);
            rst = stm.executeQuery(); 
            
           
              while(rst.next())
            {  
                  List<String> supplierDetails = new ArrayList<String>();
                   supplierDetails.add(SupplierId);
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
    public List InventorySearchByItemId(String itemId){
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        {           
              String sql = "select i.item_name,i.Item_id,sup.Supplier_name, c.Category_id,c.Category_name, s.Unit_price, s.Quantity from Items i, Category c, Supply_details s, Supplier sup where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and i.Item_id =?";
            Connection connection = DBConnection.getDBConnection().getConnection();
             stm = connection.prepareStatement(sql);
            
            
            stm.setObject(1, itemId);
            rst = stm.executeQuery(); 
            
           
              while(rst.next())
            {  
                  List<String> inventoryDetails = new ArrayList<String>();
                   String status ="Sufficient";
                    for (int i = 1; i < 8; i++){
                            inventoryDetails.add(rst.getString(i));
                            
                            if(i==7 && rst.getString(7)!= null){
                            if(Integer.parseInt(rst.getString(7))<100){
                            status ="Low";
                            }
                            inventoryDetails.add(status);
                            }
                    }
                     ListofInventoryList.add(inventoryDetails);
            }
            return ListofInventoryList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofInventoryList;
    }
}
    



