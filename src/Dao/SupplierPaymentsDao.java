/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.CustomerPaymentDTO;
import DTO.SupplierPaymentDTO;
import Models.PaymentReceived;
import database.DBConnection;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class SupplierPaymentsDao {

    List<String> supplierIds = new ArrayList<String>();
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rst = null;

    SupplierPaymentDTO supply = new SupplierPaymentDTO();
    public List<List<String>> ListofSupplierDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentpaidDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentPayableDetailsList = new ArrayList<List<String>>();

    public SupplierPaymentDTO getSupplyDetails() {
        try {
            String sql = "select s.Supply_id, supplier.Supplier_name, pb.Payable_amount from Supplier supplier, Supply_details s, Payable pb where s.Supplier_id= supplier.Supplier_id and s.Supply_id = pb.Supply_details_id";
            Connection connection = DBConnection.getDBConnection().getConnection();// database connection
            con = DBConnection.getDBConnection().getConnection();
            stm = con.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> supplyDetails = new ArrayList<String>(); //  create supplier details array                  
                supplierIds.add(rst.getString(1)); //orderId list

                for (int i = 1; i < 4; i++) {
                    supplyDetails.add(rst.getString(i));
                }

                ListofSupplierDetailsList.add(supplyDetails);

            }

            supply.supplyDetails = ListofSupplierDetailsList;
            supply.supplyIds = supplierIds;

            return supply;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return supply;
    }

    public boolean addpaymentPaid(PaymentReceived PaymentReceived) throws SQLException {
      String orderid = PaymentReceived.getOrderId();
        String paymentReceivedId = PaymentReceived.getPaymentReceivedId();
        Date ReceivedDate = PaymentReceived.getReceivedDate();
        Double totalAmount = PaymentReceived.getTotalAmount();
        Double discount = PaymentReceived.getDiscount();
        Double netAmount = PaymentReceived.getReceivedAmount();
        

        Connection connection = null;

        try {
            connection = DBConnection.getDBConnection().getConnection();

            int finalRes = 0;

            String sqlPaymentReceived = "insert into Payment_Received values(?,?,?,?,?,?)";
            PreparedStatement stmpaymentreceived = connection.prepareStatement(sqlPaymentReceived);
            
            

            stmpaymentreceived.setObject(1, paymentReceivedId);
            stmpaymentreceived.setObject(2, netAmount);
            stmpaymentreceived.setObject(3, ReceivedDate);
             stmpaymentreceived.setObject(4, null);
            stmpaymentreceived.setObject(5, totalAmount);
            stmpaymentreceived.setObject(6, discount);
            

           String sqlupdate = "update Payment_receivable set Payment_received_id = ? where Purchase_id=?";
        PreparedStatement stmupdate= connection.prepareStatement(sqlupdate);
        stmupdate.setObject(1, paymentReceivedId);
        stmupdate.setString(2, orderid);

            
           

           

            
                int res = stmpaymentreceived.executeUpdate();
                int res1 = stmupdate.executeUpdate();
               

                if (res == 1 && res1 == 1 ) {
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
    public String nextPaymentReceivedId(){
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Payment_received_id from Payment_Received";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "RD00"+last;
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
    
    
    public List ViewPaymentReceived(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select o.Purchase_id,cust.Company_name,cust.Customer_name,Rd.Total_amount,Rd.Discount,Rd.Received_date,Rd.Received_amount from Customer cust, Purchase_details o,Payment_Received Rd, Payment_receivable Re where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id and Rd.Payment_received_id = Re.Payment_received_id";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> paymentReceivedDetails = new ArrayList<String>();
                    for (int i = 1; i < 8; i++){
                            paymentReceivedDetails.add(rst.getString(i));
                            
                            
                    }

                ListofPaymentpaidDetailsList.add(paymentReceivedDetails);
               
               
            }
            return ListofPaymentpaidDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofPaymentpaidDetailsList;
    } 
   public List ViewPaymentReceivable(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select o.Purchase_id,cust.Company_name,cust.Customer_name,Re.Receivable_amount,Re.Due_date,Re.Isoutstanding"
                    +" from Customer cust, Purchase_details o, Payment_receivable Re where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> paymentReceivableDetails = new ArrayList<String>();
                    for (int i = 1; i < 7; i++){
                        
                        if(i==6 && Integer.parseInt(rst.getString(6))==1){
                            paymentReceivableDetails.add(rst.getString(4));
                        }
                        else{
                        paymentReceivableDetails.add(rst.getString(i));
                        }
                            
                            
                          
                    }

                ListofPaymentPayableDetailsList.add(paymentReceivableDetails);
               
               
            }
            return ListofPaymentPayableDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofPaymentPayableDetailsList;
    } 
   


    }


