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
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class OutstandingDao {
    
    public boolean MakePaymentsOutstanding(){
        return true;
    }
    
    public List GetOrdersToBeOutstanded(){
        
        Date date = new Date();
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rst = null;
//        int last = 0;
//
//        try {
//
//            String sql = "Select o.Purchase_id,cust.Customer_id,cust.Customer_name, rb.Receivable_amount,rb.Due_date\n" +
//"from Purchase_details o, Customer cust, Payment_receivable rb\n" +
//"where o.Customer_id = cust.Customer_id and o.Purchase_id = rb.Purchase_id and rb.Payment_received_id IS NULL and rb.Isoutstanding =1 and rb.Due_date< '2019.01.10'";
//            Connection connection = DBConnection.getDBConnection().getConnection();
//            stm = connection.prepareStatement(sql);
//            rst = stm.executeQuery();
//
//            while (rst.next()) {
//                List<String> supplierPaymentReturnedDetails = new ArrayList<String>();
//                for (int i = 1; i < 7; i++) {
//                    supplierPaymentReturnedDetails.add(rst.getString(i));
//
//                }
//
//                ListofSupplierPaymentReturnedDetailsList.add(supplierPaymentReturnedDetails);
//
//            }
//            return ListofSupplierPaymentReturnedDetailsList;
//        } catch (SQLException e) {
//            System.out.println("error@ " + e.getMessage());
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return ListofSupplierPaymentReturnedDetailsList;
//    }
//
//        
//        
   return null;
//
//
//
}
    
}
