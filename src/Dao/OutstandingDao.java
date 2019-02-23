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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class OutstandingDao {

    public List<List<String>> ListofoutstandingPaymentDetailsList = new ArrayList<List<String>>();

    public boolean MakePaymentsOutstanding(List<List<String>> res) {

        for (int i = 0; i < res.size(); i++) {
            try {
                String orderId = (res.get(i).get(0));
                Connection connection = DBConnection.getDBConnection().getConnection();
                String sqlupdate = "update Payment_receivable set Isoutstanding = 1 where Purchase_id=?";

                PreparedStatement stmupdate = connection.prepareStatement(sqlupdate);
                stmupdate.setString(1, orderId);

                int res1 = stmupdate.executeUpdate();
                if (res1 == 1) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println("error@ " + e.getMessage());
                e.printStackTrace();
                System.out.println("error@ " + e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return true;
    }

    public List GetOrdersToBeOutstanded() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;
//
        try {

            String sql = "Select o.Purchase_id,cust.Customer_id,cust.Customer_name, rb.Receivable_amount,rb.Due_date\n"
                    + "from Purchase_details o, Customer cust, Payment_receivable rb\n"
                    + "where o.Customer_id = cust.Customer_id and o.Purchase_id = rb.Purchase_id and rb.Payment_received_id IS NULL and rb.Isoutstanding =0 and rb.Due_date< ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);

            rst = preparedStatement.executeQuery();

            while (rst.next()) {
                List<String> outstandingPaymentDetails = new ArrayList<String>();
                for (int i = 1; i < 6; i++) {
                    outstandingPaymentDetails.add(rst.getString(i));

                }

                ListofoutstandingPaymentDetailsList.add(outstandingPaymentDetails);

            }
            return ListofoutstandingPaymentDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofoutstandingPaymentDetailsList;
    }
}
