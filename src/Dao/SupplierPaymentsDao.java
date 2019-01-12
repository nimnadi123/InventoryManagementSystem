/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.CustomerPaymentDTO;
import DTO.SupplierPaymentDTO;
import Models.PaymentPaid;
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

    public boolean addpaymentPaid(PaymentPaid Paymentpaid) throws SQLException {
      String Supplyid = Paymentpaid.getSupplyId();
        String paymentPaidId = Paymentpaid.getPaymentPaidId();
        Date PaidDate = Paymentpaid.getPaidDate();
        Double totalAmount = Paymentpaid.getTotalAmount();
        Double discount = Paymentpaid.getDiscount();
        Double netAmount = Paymentpaid.getPaidAmount();
        

        Connection connection = null;

        try {
            connection = DBConnection.getDBConnection().getConnection();

            int finalRes = 0;

            String sqlPaymentpaid = "insert into Supplier_payments values(?,?,?,?,?)";
            PreparedStatement stmpaymentpaid = connection.prepareStatement(sqlPaymentpaid);
            
            

            stmpaymentpaid.setObject(1, paymentPaidId);
            stmpaymentpaid.setObject(2, netAmount);
            stmpaymentpaid.setObject(3, discount);
             stmpaymentpaid.setObject(4, totalAmount);
            stmpaymentpaid.setObject(5, PaidDate);
           

           String sqlupdate = "update Payable set Paid_id = ? where Supply_details_id=?";
        PreparedStatement stmupdate= connection.prepareStatement(sqlupdate);
        stmupdate.setObject(1, paymentPaidId);
        stmupdate.setString(2, Supplyid);

            
           

           

            
                int res = stmpaymentpaid.executeUpdate();
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
    public String nextPaymentPaidId(){
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last=0;
        String id ="";
        
        try
        {           
            String sql = "select Paid_id from Supplier_payments";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);  
            
            rst.last();
            last = rst.getRow()+1;
             id = "PD00"+last;
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
    
    
    public List ViewPaymentPaid(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select Sd.Supply_id ,supplier.Supplier_name ,Pd.Total_amount, Pd.Discount,Pd.Net_amount,Pd.Paid_date "+
                    "from Supplier_payments Pd, Supplier supplier,Supply_details Sd, Payable Pb where Sd.Supplier_id  =supplier.Supplier_id and Sd.Supply_id = Pb.Supply_details_id and Pd.Paid_id = Pb.Paid_id";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> paymentReceivedDetails = new ArrayList<String>();
                    for (int i = 1; i < 7; i++){
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
   public List ViewPaymentPayable(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select Sd.Supply_id , supplier.Supplier_id, supplier.Supplier_name ,Pb.Payable_amount\n" +
"                    from Supplier supplier ,Supply_details Sd, Payable Pb where Sd.Supplier_id  =supplier.Supplier_id and Sd.Supply_id = Pb.Supply_details_id";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery(); 
            
           
            while(rst.next())
            {  
                  List<String> paymentReceivableDetails = new ArrayList<String>();
                    for (int i = 1; i < 5; i++){
                        
                        
                        paymentReceivableDetails.add(rst.getString(i));
                        
                            
                            
                          
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


