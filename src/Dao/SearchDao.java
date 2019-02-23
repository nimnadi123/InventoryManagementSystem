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
   
    public List<List<String>> ListofCustomerDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofSupplierDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentReceivedDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentReceiveableDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentpaidDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPaymentPayableDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPurchaseDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofPurchaseDetailsList1 = new ArrayList<List<String>>();
    public List<List<String>> ListofPurchaseDetailsList2 = new ArrayList<List<String>>();
    public List<List<String>> ListofHoldPurchaseDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofHoldPurchaseDetailsList1 = new ArrayList<List<String>>();
    public List<List<String>> ListofHoldPurchaseDetailsList2 = new ArrayList<List<String>>();
    public List<List<String>> ListofCustomerPaymentReturnedDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofSupplierPaymentReturnedDetailsList = new ArrayList<List<String>>();

    public List EmployeeSearch(String EmployeeId) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {
            String sql = "select distinct emp.Employee_name,emp.Dateofbirth,emp.Personal_adress,emp.TeleNo,emp.Department,emp.Role_id,emp.Hireddate"
                    + " from Employee emp where emp.Employee_id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, EmployeeId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> employeedetails = new ArrayList<String>();
                employeedetails.add(EmployeeId);
                for (int i = 1; i < 8; i++) {
                    employeedetails.add(rst.getString(i));
                }

                ListofEmployeeList.add(employeedetails);

            }
            return ListofEmployeeList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofEmployeeList;
    }

    public List CustomerSearch(String CustomerId) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {
            String sql = "select * from Customer where Customer_id= ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, CustomerId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> customerDetails = new ArrayList<String>();
                //customerDetails.add(CustomerId);
                for (int i = 1; i < 9; i++) {
                    customerDetails.add(rst.getString(i));
                }

                ListofCustomerDetailsList.add(customerDetails);

            }
            return ListofCustomerDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofCustomerDetailsList;
    }

    public List SupplierSearch(String SupplierId) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {
            String sql = "select * from Supplier where Supplier_id= ?"; //*-all
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, SupplierId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> supplierDetails = new ArrayList<String>();
                //supplierDetails.add(SupplierId);
                for (int i = 1; i < 6; i++) {
                    supplierDetails.add(rst.getString(i));
                }

                ListofSupplierDetailsList.add(supplierDetails);

            }
            return ListofSupplierDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofSupplierDetailsList;
    }

    public List InventorySearchByItemId(String itemId) {
          List<List<String>> ListofInventoryList = new ArrayList<List<String>>();
//        Connection con = null;
//        PreparedStatement stm = null;
//        PreparedStatement stm1 = null;
//        ResultSet rst = null;
//        ResultSet rst1 = null;
//
//        int last = 0;
//
//        try {
//
//            String sql = "select i.item_name,i.Item_id,sup.Supplier_name, c.Category_id,c.Category_name, s.Unit_price,Sum(s.Quantity) from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and i.Item_id =? group by i.Item_id,"
//                    + "sup.Supplier_name,c.Category_id,c.Category_name, s.Unit_price,i.item_name,s.Supplier_id";
//            Connection connection = DBConnection.getDBConnection().getConnection();
//            stm = connection.prepareStatement(sql);
//            stm.setObject(1, itemId);
//            rst = stm.executeQuery();
//
//            while (rst.next()) {
//                int suuplyquantity = 0;
//                int orderedquantity = 0;
//                int availablequantity = 0;
//
//                String sql1 = "select Sum(o.Quantity) from Purchase_details o where o.Item_id = ? group by o.Item_id";
//
//                Connection connection1 = DBConnection.getDBConnection().getConnection();
//                stm1 = connection.prepareStatement(sql1);
//                stm1.setObject(1, rst.getString(2));
//                rst1 = stm1.executeQuery();
//                suuplyquantity = Integer.parseInt(rst.getString(7));
//                if (rst1.next()) {
//                    orderedquantity = Integer.parseInt(rst1.getString(1));
//
//                }
//
//                availablequantity = suuplyquantity - orderedquantity;
//                List<String> inventoryDetails = new ArrayList<String>();
//                String status = "Sufficient";
//                for (int i = 1; i < 8; i++) {
//                    if (i == 7 && rst.getString(7) != null) {
//                        inventoryDetails.add(Integer.toString(availablequantity));
//                        if (availablequantity < 100) {
//                            status = "Low";
//                        }
//                        inventoryDetails.add(status);
//                    } else {
//                        inventoryDetails.add(rst.getString(i));
//                    }
//                }


Connection con = null;

        int last = 0;

        try {
            PreparedStatement stm = null;
            ResultSet rst = null;
            String sql = "select distinct i.item_name,i.Item_id, c.Category_id,c.Category_name from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and i.Item_id =? group by  i.item_name,i.Item_id,c.Category_id,c.Category_name";

            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
             stm.setObject(1, itemId);
            rst = stm.executeQuery();

            while (rst.next()) {
               
                int suuplyquantity = 0;
                int orderedquantity = 0;
                int availablequantity = 0;

                String sql1 = "select Sum(o.Quantity) from Purchase_details o where o.Item_id = ?";
                ResultSet rst1 = null;
                PreparedStatement stm1 = null;
                Connection connection1 = DBConnection.getDBConnection().getConnection();
                stm1 = connection.prepareStatement(sql1);
                stm1.setObject(1, itemId);
                rst1 = stm1.executeQuery();

                if (rst1.next()) {
                    String q = rst1.getString(1);
                    if (q != null) {
                        orderedquantity = Integer.parseInt(q);
                    }

                }

                String sql2 = "select Sum(s.Quantity) from Supply_details s where s.Item_id = ?";

                PreparedStatement stm2 = null;
                ResultSet rst2 = null;
                stm2 = connection.prepareStatement(sql2);
                stm2.setObject(1, itemId);
                rst2 = stm2.executeQuery();

                if (rst2.next()) {
                    suuplyquantity = Integer.parseInt(rst2.getString(1));

                }

                availablequantity = suuplyquantity - orderedquantity;
                List<String> inventoryDetails = new ArrayList<String>();
                String status = "Sufficient";
                for (int i = 1; i < 6; i++) {
                    if (i == 5) {
                        inventoryDetails.add(Integer.toString(availablequantity));
                        if (availablequantity < 100) {
                            status = "Low";
                        }
                        inventoryDetails.add(status);
                    } else {
                        inventoryDetails.add(rst.getString(i));
                    }
                }

                ListofInventoryList.add(inventoryDetails);
            }
            return ListofInventoryList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofInventoryList;
    }

    public List InventorySearchBystatus(String state) {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rst = null;
//        int last = 0;
//        String sql = "";
//        try {
//
//            if (state.equalsIgnoreCase("Sufficient")) {
//                sql = "select i.item_name,i.Item_id,sup.Supplier_name, c.Category_id,c.Category_name, s.Unit_price,Sum(s.Quantity)-Sum(o.Quantity) from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and o.Item_id = i.Item_id group by i.Item_id,"
//                        + "sup.Supplier_name,c.Category_id,c.Category_name, s.Unit_price,i.item_name,s.Supplier_id and Sum(s.Quantity)-Sum(o.Quantity)>100";
//            }
//
//            if (state.equalsIgnoreCase("Low")) {
//                sql = "select i.item_name,i.Item_id,sup.Supplier_name, c.Category_id,c.Category_name, s.Unit_price,Sum(s.Quantity)-Sum(o.Quantity) from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and o.Item_id = i.Item_id group by i.Item_id,"
//                        + "sup.Supplier_name,c.Category_id,c.Category_name, s.Unit_price,i.item_name,s.Supplier_id and Sum(s.Quantity)-Sum(o.Quantity)<100";
//            }
//
//            Connection connection = DBConnection.getDBConnection().getConnection();
//            stm = connection.prepareStatement(sql);
//
//            rst = stm.executeQuery();
//
//            while (rst.next()) {
//                List<String> inventoryDetails = new ArrayList<String>();
//                String status = "Sufficient";
//                for (int i = 1; i < 8; i++) {
//                    inventoryDetails.add(rst.getString(i));
//
//                    if (i == 7 && rst.getString(7) != null) {
//                        if (Integer.parseInt(rst.getString(7)) < 100) {
//                            status = "Low";
//                        }
//                        inventoryDetails.add(status);
//                    }
//                }
//                ListofInventoryList.add(inventoryDetails);
//            }
List<List<String>> ListofInventoryList = new ArrayList<List<String>>();
        

        int last = 0;

        try {
            if (state.equalsIgnoreCase("Sufficient")) {
                 PreparedStatement stm = null;
            ResultSet rst = null;
            String sql = "select distinct i.item_name,i.Item_id, c.Category_id,c.Category_name from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id   group by  i.item_name,i.Item_id,c.Category_id,c.Category_name";

            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
               String itemID = rst.getString(2).trim();
                int suuplyquantity = 0;
                int orderedquantity = 0;
                int availablequantity = 0;

                String sql1 = "select Sum(o.Quantity) from Purchase_details o where o.Item_id = ?";
                ResultSet rst1 = null;
                PreparedStatement stm1 = null;
                Connection connection1 = DBConnection.getDBConnection().getConnection();
                stm1 = connection.prepareStatement(sql1);
                stm1.setObject(1, itemID);
                rst1 = stm1.executeQuery();

                if (rst1.next()) {
                    String q = rst1.getString(1);
                    if (q != null) {
                        orderedquantity = Integer.parseInt(q);
                    }

                }

                String sql2 = "select Sum(s.Quantity) from Supply_details s where s.Item_id = ?";

                PreparedStatement stm2 = null;
                ResultSet rst2 = null;
                stm2 = connection.prepareStatement(sql2);
                stm2.setObject(1, itemID);
                rst2 = stm2.executeQuery();

                if (rst2.next()) {
                    suuplyquantity = Integer.parseInt(rst2.getString(1));

                }

                    availablequantity = suuplyquantity - orderedquantity;
                    List<String> inventoryDetails = new ArrayList<String>();
                    String status = "Sufficient";
                    if (availablequantity > 100) {
                        for (int i = 1; i < 6; i++) {
                            if (i == 5) {
                                inventoryDetails.add(Integer.toString(availablequantity));
                                inventoryDetails.add(status);
                            } else {
                                inventoryDetails.add(rst.getString(i));
                            }
                        }

                        ListofInventoryList.add(inventoryDetails);
                    }

                }
            }

            if (state.equalsIgnoreCase("Low")) {
                PreparedStatement stm = null;
            ResultSet rst = null;
            String sql = "select distinct i.item_name,i.Item_id, c.Category_id,c.Category_name from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id group by  i.item_name,i.Item_id,c.Category_id,c.Category_name";

            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
               String itemID = rst.getString(2).trim();
                int suuplyquantity = 0;
                int orderedquantity = 0;
                int availablequantity = 0;

                String sql1 = "select Sum(o.Quantity) from Purchase_details o where o.Item_id = ?";
                ResultSet rst1 = null;
                PreparedStatement stm1 = null;
                Connection connection1 = DBConnection.getDBConnection().getConnection();
                stm1 = connection.prepareStatement(sql1);
                stm1.setObject(1, itemID);
                rst1 = stm1.executeQuery();

                if (rst1.next()) {
                    String q = rst1.getString(1);
                    if (q != null) {
                        orderedquantity = Integer.parseInt(q);
                    }

                }

                String sql2 = "select Sum(s.Quantity) from Supply_details s where s.Item_id = ?";

                PreparedStatement stm2 = null;
                ResultSet rst2 = null;
                stm2 = connection.prepareStatement(sql2);
                stm2.setObject(1, itemID);
                rst2 = stm2.executeQuery();

                if (rst2.next()) {
                    suuplyquantity = Integer.parseInt(rst2.getString(1));

                }

                    availablequantity = suuplyquantity - orderedquantity;
                    List<String> inventoryDetails = new ArrayList<String>();
                    String status = "Low";
                    if (availablequantity < 100) {
                        for (int i = 1; i < 6; i++) {
                            if (i == 5) {
                                inventoryDetails.add(Integer.toString(availablequantity));
                                inventoryDetails.add(status);
                            } else {
                                inventoryDetails.add(rst.getString(i));
                            }
                        }


                        ListofInventoryList.add(inventoryDetails);
                    }

                }
            }

            return ListofInventoryList;

        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofInventoryList;
    }

    public List SearchPaymentReceivedbyOrderId(String orderId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Company_name,cust.Customer_name,Rd.Total_amount,Rd.Discount,Rd.Received_date,Rd.Received_amount from Customer cust, Purchase_details o,Payment_Received Rd, Payment_receivable Re where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id and Rd.Payment_received_id = Re.Payment_received_id and o.Purchase_id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, orderId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> paymentReceivedDetails = new ArrayList<String>();
                for (int i = 1; i < 8; i++) {
                    paymentReceivedDetails.add(rst.getString(i));

                }

                ListofPaymentReceivedDetailsList.add(paymentReceivedDetails);

            }
            return ListofPaymentReceivedDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPaymentReceivedDetailsList;
    }

    public List PaymentReceivableSearchByOrderId(String orderId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Company_name,cust.Customer_name,Re.Receivable_amount,Re.Due_date,Re.Isoutstanding"
                    + " from Customer cust, Purchase_details o, Payment_receivable Re where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id and o.Purchase_id = ?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, orderId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> paymentReceivableDetails = new ArrayList<String>();
                for (int i = 1; i < 7; i++) {

                    if (i == 6 && Integer.parseInt(rst.getString(6)) == 1) {
                        paymentReceivableDetails.add(rst.getString(4));
                    } else {
                        paymentReceivableDetails.add(rst.getString(i));
                    }

                }

                ListofPaymentReceiveableDetailsList.add(paymentReceivableDetails);

            }
            return ListofPaymentReceiveableDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPaymentReceiveableDetailsList;
    }

    public List PaymentPaidSearchBySupplyId(String Supply_id) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct Sd.Supply_id ,supplier.Supplier_name ,Pd.Total_amount, Pd.Discount,Pd.Net_amount,Pd.Paid_date "
                    + "from Supplier_payments Pd, Supplier supplier,Supply_details Sd, Payable Pb where Sd.Supplier_id  =supplier.Supplier_id and Sd.Supply_id = Pb.Supply_details_id and Pd.Paid_id = Pb.Paid_id and Sd.Supply_id =?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, Supply_id);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> paymentReceivedDetails = new ArrayList<String>();
                for (int i = 1; i < 7; i++) {
                    paymentReceivedDetails.add(rst.getString(i));

                }

                ListofPaymentpaidDetailsList.add(paymentReceivedDetails);

            }
            return ListofPaymentpaidDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPaymentpaidDetailsList;
    }

    public List SearchPaymentPayablebySupplyId(String Supply_id) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct Sd.Supply_id , supplier.Supplier_id, supplier.Supplier_name ,Pb.Payable_amount\n"
                    + "from Supplier supplier ,Supply_details Sd, Payable Pb where Sd.Supplier_id  =supplier.Supplier_id and Sd.Supply_id = Pb.Supply_details_id and Sd.Supplier_id =?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, Supply_id);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> paymentReceivableDetails = new ArrayList<String>();
                for (int i = 1; i < 5; i++) {

                    paymentReceivableDetails.add(rst.getString(i));

                }

                ListofPaymentPayableDetailsList.add(paymentReceivableDetails);

            }
            return ListofPaymentPayableDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPaymentPayableDetailsList;
    }

    public List SearchPurchaseDetailsByOrderId(String OrderId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date, p.Due_date  from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =0 and o.Purchase_id=? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, OrderId);

            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 11; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofPurchaseDetailsList.add(purchaseDetails);

            }
            return ListofPurchaseDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPurchaseDetailsList;
    }

    public List SearchHoldPurchaseDetailsByOrderId(String OrderId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =1 and o.Purchase_id =? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, OrderId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 10; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofHoldPurchaseDetailsList.add(purchaseDetails);

            }
            return ListofHoldPurchaseDetailsList;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofHoldPurchaseDetailsList;
    }

    public List SearchPurchaseDetailsByCustomerId(String CustomerId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date, p.Due_date  from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =0 and cust.Customer_id=? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, CustomerId);

            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 11; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofPurchaseDetailsList1.add(purchaseDetails);

            }
            return ListofPurchaseDetailsList1;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPurchaseDetailsList1;
    }

    public List SearchHoldPurchaseDetailsByCustomerId(String CustomerId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =1 and cust.Customer_id =? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, CustomerId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 10; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofHoldPurchaseDetailsList1.add(purchaseDetails);

            }
            return ListofHoldPurchaseDetailsList1;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofHoldPurchaseDetailsList1;
    }

    public List SearchPurchaseDetailsByorderedDate(String Date) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date, p.Due_date  from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =0 and o.Orderd_date=? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, Date);

            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 11; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofPurchaseDetailsList2.add(purchaseDetails);

            }
            return ListofPurchaseDetailsList2;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofPurchaseDetailsList2;
    }

    public List SearchHoldPurchaseDetailsByOrderedDate(String OrderedDate) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,i.item_name,o.Item_id, o.Unit_value, p.Receivable_amount, o.Quantity, o.Orderd_date from Items i, Customer cust, Purchase_details o,Payment_receivable p where i.Item_id = o.Item_id and o.Customer_id =cust.Customer_id and o.Purchase_id = p.Purchase_id and o.IsHold =1 and o.Orderd_date =? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, OrderedDate);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> purchaseDetails = new ArrayList<String>();
                for (int i = 1; i < 10; i++) {
                    purchaseDetails.add(rst.getString(i));

                }

                ListofHoldPurchaseDetailsList2.add(purchaseDetails);

            }
            return ListofHoldPurchaseDetailsList2;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ListofHoldPurchaseDetailsList2;
    }

    public List SearchSupplierPaymentReturnedBySupplyId(String SearchId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct sup.Supply_id,supplier.Supplier_id,supplier.Supplier_name,Srr.Returned_amount,Srr.Returned_date,Srr.Quantity\n"
                    + "from Supplier supplier, Supply_details sup,Supplier_payments pd, Payable pb , supplier_payment_return Srr \n"
                    + "where sup.Supplier_id =supplier.Supplier_id and sup.Supply_id= pb.Supply_details_id\n"
                    + "and pb.Payable_id = Srr.Payable_id or pd.Paid_id =Srr.Paid_id and sup.Supply_id =? ";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, SearchId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> supplierPaymentReturnedDetails = new ArrayList<String>();
                for (int i = 1; i < 7; i++) {
                    supplierPaymentReturnedDetails.add(rst.getString(i));

                }

                ListofSupplierPaymentReturnedDetailsList.add(supplierPaymentReturnedDetails);

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

    public List SearchCustomerPaymentReturnedbyOrderId(String SearchId) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select distinct o.Purchase_id,cust.Customer_id,cust.Customer_name,cust.Company_name,\n"
                    + "                    Prr.Amount, prr.Returned_date, prr.ReturnedQuantity\n"
                    + "                    from Customer cust, Purchase_details o,Payment_Received Rd, Payment_receivable Re , Payment_received_return Prr\n"
                    + "                    where o.Customer_id =cust.Customer_id and o.Purchase_id = Re.Purchase_id\n"
                    + "                    and re.Payment_receivable_id = Prr.Payment_receivable_id or Rd.Payment_received_id = Prr.Payment_rececived_Id and o.Purchase_id=?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            stm.setObject(1, SearchId);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> customerPaymentReturnedDetails = new ArrayList<String>();
                for (int i = 1; i < 8; i++) {
                    customerPaymentReturnedDetails.add(rst.getString(i));

                }

                ListofCustomerPaymentReturnedDetailsList.add(customerPaymentReturnedDetails);

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

}
