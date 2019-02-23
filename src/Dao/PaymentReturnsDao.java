/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.CustomerPaymentReturned;
import Models.SupplierPaymentReturned;
import database.DBConnection;
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
public class PaymentReturnsDao {

    public String nextPaymentReturnId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String crid = "";

        try {
            String sql = "select Payment_received_returned_id from Payment_received_return";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            crid = "PRR00" + last;
            return crid;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return crid;
    }

    public String nextSupplierPaymentReturnId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Supplier_payment_return_id from supplier_payment_return";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "SPR00" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean isPaymentReceived(String orderId) {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";
        boolean val = false;

        try {
            String sql = "select * \n"
                    + "from  Payment_receivable rb, Purchase_details o\n"
                    + "where o.Purchase_id = ? and o.Purchase_id = rb.Purchase_id and  rb.Payment_received_id IS NOT NULL OR rb.Payment_received_id = ''";
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderId);

            rst = preparedStatement.executeQuery();
            //stm = connection.createStatement();

            while (rst.next()) {
                val = true;

            }

            return val;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return val;

    }

    public boolean isPaymentReceivable(String supplyId) {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";
        boolean val = false;

        try {
            String sql = "select *\n"
                    + "from  Supplier_payments pd ,Supply_details sup,payable pb\n"
                    + "where sup.Supply_id = ? and sup.Supply_id = pb.Supply_details_id and  pb.Paid_id IS NOT NULL OR  pb.Paid_id = ''";
            Connection connection = DBConnection.getDBConnection().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supplyId);

            rst = preparedStatement.executeQuery();
            //stm = connection.createStatement();

            while (rst.next()) {
                val = true;

            }

            return val;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return val;

    }

    public Boolean AddCustomerpaymentReturn(CustomerPaymentReturned paymentReturn) throws SQLException {
        String orderId = paymentReturn.getOrderId();
        String customerPaymentReturnId = paymentReturn.getPaymentReturnedId();
        Double amount = paymentReturn.getReturnedAmount();
        Date returnedDate = paymentReturn.getReturnedDate();
        int paymentReceivedId = paymentReturn.getPaymentReceived();
        int paymentReceivableId = paymentReturn.getPaymentReceivable();
        int quantity = paymentReturn.getReturnedQuantity();

        String ReceivedId = null;
        String ReceivableId = null;

        PreparedStatement stm = null;
        Connection connection = null;

        try {
            if (paymentReceivedId == 1) {
                String sql = "select rd.Payment_received_id\n"
                        + "from Payment_Received rd , Payment_receivable rb\n"
                        + "where rd.Payment_received_id = rb.Payment_received_id and rb.Purchase_id =?";
                connection = DBConnection.getDBConnection().getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, orderId);

                ResultSet rst = preparedStatement.executeQuery();
                //stm = connection.createStatement();

                while (rst.next()) {
                   
                        ReceivedId = rst.getString(1);
                    

                }
            }

            if (paymentReceivableId == 1) {
                String sql = "select rb.Payment_receivable_id\n"
                        + "from Payment_receivable rb\n"
                        + "where rb.Purchase_id = ?";
                connection = DBConnection.getDBConnection().getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, orderId);

                ResultSet rst = preparedStatement.executeQuery();
                //stm = connection.createStatement();

                while (rst.next()) {
                    for (int i = 1; i < 2; i++) {
                        ReceivableId = rst.getString(i);
                    }

                }
            }

            String sql = "insert into Payment_received_return values(?,?,?,?,?,?)";
            connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, customerPaymentReturnId);
            stm.setObject(2, amount);
            stm.setObject(3, returnedDate);
            stm.setObject(4, ReceivedId);
            stm.setObject(5, ReceivableId);
            stm.setObject(6, quantity);

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

    public List ViewCustomerPaymentReturned() {
        List<List<String>> ListofCustomerPaymentReturnedDetailsList = new ArrayList<List<String>>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        Connection con1 = null;
        PreparedStatement stm1 = null;
        ResultSet rst1 = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,cust.Company_name,\n"
                    + "                    Prr.Amount, prr.Returned_date, prr.ReturnedQuantity\n"
                    + "                    from Customer cust, Purchase_details o,Payment_Received Rd, Payment_receivable Re , Payment_received_return Prr\n"
                    + "                    where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id\n"
                    + "                    and re.Payment_receivable_id = Prr.Payment_receivable_id ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> customerPaymentReturnedDetails = new ArrayList<String>();
                for (int i = 1; i < 8; i++) {
                    customerPaymentReturnedDetails.add(rst.getString(i));

                }

                ListofCustomerPaymentReturnedDetailsList.add(customerPaymentReturnedDetails);

            }

            String sql1 = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,cust.Company_name,\n"
                    + "                    Prr.Amount, prr.Returned_date, prr.ReturnedQuantity\n"
                    + "                    from Customer cust, Purchase_details o,Payment_Received Rd, Payment_receivable Re , Payment_received_return Prr\n"
                    + "                    where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id\n"
                    + "                    and Re.Payment_received_id =Rd.Payment_received_id and  Rd.Payment_received_id = Payment_rececived_Id  ";

            stm1 = connection.prepareStatement(sql1);
            rst1 = stm1.executeQuery();

            while (rst1.next()) {
                List<String> customerPaymentReturnedDetails1 = new ArrayList<String>();
                for (int i = 1; i < 8; i++) {
                    customerPaymentReturnedDetails1.add(rst1.getString(i));

                }

                ListofCustomerPaymentReturnedDetailsList.add(customerPaymentReturnedDetails1);

            }
            return ListofCustomerPaymentReturnedDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofCustomerPaymentReturnedDetailsList;
    }

    public Boolean AddSupplierpaymentReturn(SupplierPaymentReturned s_paymentReturn) throws SQLException {
        String supplyId = s_paymentReturn.getSupplyId();
        String supplierPaymentReturnId = s_paymentReturn.getPaymentReturnedId();
        Double supamount = s_paymentReturn.getReturnedAmount();
        Date supreturnedDate = s_paymentReturn.getReturnedDate();
        int paymentPaid = s_paymentReturn.getPaymentPaid();
        int payable = s_paymentReturn.getPaymentPayable();
        int quantity = s_paymentReturn.getQuantity();

        String PaidId = null;
        String PayableId = null;

        PreparedStatement stm = null;
        Connection connection = null;

        try {
            if (paymentPaid == 1) {
                String sql = "select pd.Paid_id\n"
                        + "from Supplier_payments pd, Payable pb\n"
                        + "where pd.Paid_id = pb.Paid_id  and pb.Supply_details_id=?";
                connection = DBConnection.getDBConnection().getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, supplyId);

                ResultSet rst = preparedStatement.executeQuery();
                //stm = connection.createStatement();

                while (rst.next()) {

                    PaidId = rst.getString(1);

                }
            }

            if (payable == 1) {
                String sql = "select pb.Payable_id\n"
                        + "from Payable pb\n"
                        + "where pb.Supply_details_id =?";
                connection = DBConnection.getDBConnection().getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, supplyId);

                ResultSet rst = preparedStatement.executeQuery();
                //stm = connection.createStatement();

                while (rst.next()) {
                    for (int i = 1; i < 2; i++) {
                        PayableId = rst.getString(i);
                    }

                }
            }

            String sql = "insert into supplier_payment_return values(?,?,?,?,?,?)";
            connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, supplierPaymentReturnId);
            stm.setObject(2, supamount);
            stm.setObject(3, supreturnedDate);
            stm.setObject(4, PaidId);
            stm.setObject(5, PayableId);
            stm.setObject(6, quantity);

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

    public List ViewSupplierPaymentReturned() {
        List<List<String>> ListofSupplierPaymentReturnedDetailsList = new ArrayList<List<String>>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        Connection con1 = null;
        PreparedStatement stm1 = null;
        ResultSet rst1 = null;

        int last = 0;

        try {

            String sql = "select distinct sup.Supply_id,supplier.Supplier_id,supplier.Supplier_name,Srr.Returned_amount,Srr.Returned_date,Srr.Quantity\n"
                    + "from Supplier supplier, Supply_details sup,Supplier_payments pd, Payable pb , supplier_payment_return Srr \n"
                    + "where sup.Supplier_id =supplier.Supplier_id and sup.Supply_id= pb.Supply_details_id\n"
                    + "and pb.Payable_id = Srr.Payable_id";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> supplierPaymentReturnedDetails = new ArrayList<String>();
                for (int i = 1; i < 7; i++) {
                    supplierPaymentReturnedDetails.add(rst.getString(i));

                }

                ListofSupplierPaymentReturnedDetailsList.add(supplierPaymentReturnedDetails);

            }

            String sql1 = "select distinct sup.Supply_id,supplier.Supplier_id,supplier.Supplier_name,Srr.Returned_amount,Srr.Returned_date,Srr.Quantity\n"
                    + "from Supplier supplier, Supply_details sup,Supplier_payments pd, Payable pb , supplier_payment_return Srr \n"
                    + "where sup.Supplier_id =supplier.Supplier_id and sup.Supply_id= pb.Supply_details_id\n"
                    + "and pb.Paid_id =pd.Paid_id and pd.Paid_id =Srr.Paid_id";

            stm1 = connection.prepareStatement(sql1);
            rst1 = stm1.executeQuery();

            while (rst1.next()) {
                List<String> supplierPaymentReturnedDetails1 = new ArrayList<String>();
                for (int i = 1; i < 7; i++) {
                    supplierPaymentReturnedDetails1.add(rst1.getString(i));

                }

                ListofSupplierPaymentReturnedDetailsList.add(supplierPaymentReturnedDetails1);

            }
            return ListofSupplierPaymentReturnedDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofSupplierPaymentReturnedDetailsList;
    }

}
