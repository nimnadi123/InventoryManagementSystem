/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.CategoryDetailsDTO;
import DTO.CustomerDetailsDTO;
import DTO.InventoryDetailsDTO;
import DTO.ItemDetailsDTO;
import DTO.PurchaseAddViewDTO;
import DTO.PurchaseDetailsDTO;
import DTO.SupplierDetailsDTO;
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
public class PurchaseDetailsDao {
     public List<List<String>> ListofCustomerDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofItemDetailsList = new ArrayList<List<String>>();
     public List<List<String>> ListofPurchaseDetailsList = new ArrayList<List<String>>();
     public List<List<String>> ListofHoldPurchaseDetailsList = new ArrayList<List<String>>();
   
    List<String> customerIds = new ArrayList<String>();
    List<String> customerNames = new ArrayList<String>();
    List<String> itemIds = new ArrayList<String>();
    List<String> itemNames = new ArrayList<String>();
    
    ItemDetailsDTO item = new ItemDetailsDTO();
    CustomerDetailsDTO customer = new CustomerDetailsDTO();
    PurchaseDetailsDTO purchase =new PurchaseDetailsDTO(); 

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rst = null;

    public PurchaseDetailsDTO getPurchaseDetails() {
        
        purchase.customerDetails = getCustomerDetails();
        purchase.itemDetails = getItemDetails();
        
        return purchase;
    }
    public ItemDetailsDTO getItemDetails() {

        try {
            String sql = "select Item_id, item_name from Items";
            Connection connection = DBConnection.getDBConnection().getConnection();// database connection
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> itemDetails = new ArrayList<String>(); //  create supplier details array                  
                itemIds.add(rst.getString(1));
                itemNames.add(rst.getString(2));

                for (int i = 1; i < 3; i++) {
                    itemDetails.add(rst.getString(i));
                }

                ListofItemDetailsList.add(itemDetails);

            }

            item.itemDetails = ListofItemDetailsList;
            item.itemIds = itemIds;
            item.itemNames = itemNames;
            return item;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return item;
    }
    public CustomerDetailsDTO getCustomerDetails() {

        try {
            String sql = "select Customer_id, Customer_name from Customer";
            Connection connection = DBConnection.getDBConnection().getConnection();// database connection
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> customerDetails = new ArrayList<String>(); //  create supplier details array                  
                customerIds.add(rst.getString(1));
                customerNames.add(rst.getString(2));

                for (int i = 1; i < 3; i++) {
                    customerDetails.add(rst.getString(i));
                }

                ListofCustomerDetailsList.add(customerDetails);

            }

            customer.customerDetails = ListofCustomerDetailsList;
            customer.customerIds = customerIds;
            customer.customerNames = customerNames;
            return customer;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }
   public String nextOrderId(){
        //Connection con = null;
        Statement stm = null;
        //ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Purchase_id from Purchase_details";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "OD00"+last;
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
   
   public boolean addNewInventory(PurchaseAddViewDTO purchaseDetail) throws SQLException, ParseException {
        String customerId = purchaseDetail.getCustomerId();
        Date orderedDate = purchaseDetail.getOrderedDate();// string, char, int int -number, string- word, char -single letter
        String orderId = purchaseDetail.getPurchaseId();
        Double unitPrice = purchaseDetail.getUnitValue();
        int soldQuantity = purchaseDetail.getSoldQuantity();
        Double receivableAmount = purchaseDetail.getReceivableAmount();
        String itemId = purchaseDetail.getItemId();
        Date dueDate = purchaseDetail.getDueDate();
        int isOutstanding = purchaseDetail.getIsOutStanding();
        String paymentReceivableId = nextPaymentReceivableId();
        int isHold = purchaseDetail.getIsHold();
        

        Connection connection = null;

        try {
            connection = DBConnection.getDBConnection().getConnection();

            int finalRes = 0;

            String sqlPurchase = "insert into Purchase_details values(?,?,?,?,?,?,?)";
            PreparedStatement stmpurchase = connection.prepareStatement(sqlPurchase);
            
            

            stmpurchase.setObject(1, orderId);
            stmpurchase.setObject(2, unitPrice);
            stmpurchase.setObject(3, soldQuantity);
             stmpurchase.setObject(4, itemId);
            stmpurchase.setObject(5, customerId);
            stmpurchase.setObject(6, orderedDate);
            stmpurchase.setObject(7, isHold);

           String sqlPaymentReceivable = "insert into Payment_receivable values(?,?,?,?,?,?)";
          PreparedStatement stmPaymentReceivable = connection.prepareStatement(sqlPaymentReceivable);
            stmPaymentReceivable.setObject(1, paymentReceivableId);
            stmPaymentReceivable.setObject(2, receivableAmount);
            stmPaymentReceivable.setObject(3, dueDate);
            stmPaymentReceivable.setObject(4, isOutstanding);
            stmPaymentReceivable.setObject(5, orderId);
            stmPaymentReceivable.setObject(6, null);
                       

            
           

           

            
                int res = stmpurchase.executeUpdate();
                int resPaymentReceivable = stmPaymentReceivable.executeUpdate();
               

                if (res == 1 && resPaymentReceivable == 1 ) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            }
          catch (SQLException e) {
            connection.rollback();
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
            System.out.println("error@ " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }
   
   public String nextPaymentReceivableId(){
        //Connection con = null;
        Statement stm = null;
        //ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Payment_receivable_id from Payment_receivable";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "PR00"+last;
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
   public List ViewPurchaseDetails(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date, p.Due_date  from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =0";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> purchaseDetails = new ArrayList<String>();
                    for (int i = 1; i < 11; i++){
                            purchaseDetails.add(rst.getString(i));
                            
                            
                    }

                ListofPurchaseDetailsList.add(purchaseDetails);
               
               
            }
            return ListofPurchaseDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofPurchaseDetailsList;
    } 
   
   
   public List ViewHoldPurchaseDetails(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =1";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> purchaseDetails = new ArrayList<String>();
                    for (int i = 1; i < 10; i++){
                            purchaseDetails.add(rst.getString(i));
                            
                            
                    }

                ListofHoldPurchaseDetailsList.add(purchaseDetails);
               
               
            }
            return ListofHoldPurchaseDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofHoldPurchaseDetailsList;
    } 
   
   public Boolean IsPaymentOutstanding(String customerId) {
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
       try{
            String sql = "select Pr.Isoutstanding from Payment_receivable Pr, Purchase_details o, Customer cust where cust.Customer_id = o.Customer_id and o.Purchase_id=Pr.Purchase_id and cust.Customer_id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            
            stm = connection.prepareStatement(sql);
        stm.setObject(1, customerId);
            rst = stm.executeQuery(); 
            Boolean Isoutstanding = false;
           
            while(rst.next())
            {  
                 for (int i = 1; i < 2; i++){
                            
                       if(Integer.parseInt(rst.getString(i))==1)     
                       {
                       Isoutstanding = true;
                       }
                    }
            }
   return true;
       }
       catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return true;
   }
}
