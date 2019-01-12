/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.CategoryDetailsDTO;
import DTO.InventoryAddViewDTO;
import DTO.InventoryDetailsDTO;
import DTO.ItemDetailsDTO;
import DTO.SupplierDetailsDTO;
import Models.CustomerDetails;
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
public class InventoryDetailsDao {

    public List<List<String>> ListofSupplierDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofItemDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofCategoryDetailsList = new ArrayList<List<String>>();
    public List<List<String>> ListofInventoryDetailsList = new ArrayList<List<String>>();
    List<String> supplierIds = new ArrayList<String>();
    List<String> supplierNames = new ArrayList<String>();
    List<String> itemIds = new ArrayList<String>();
    List<String> itemNames = new ArrayList<String>();
    List<String> categoryIds = new ArrayList<String>();
    List<String> categoryNames = new ArrayList<String>();
    InventoryDetailsDTO inventory = new InventoryDetailsDTO();
    SupplierDetailsDTO supDetail = new SupplierDetailsDTO();
    ItemDetailsDTO item = new ItemDetailsDTO();
    CategoryDetailsDTO category = new CategoryDetailsDTO();

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rst = null;

    public InventoryDetailsDTO getInventoryDetails() {
        inventory.supplierDetails = getSupplierDetails();
        inventory.categoryDetails = getCategoryDetails();
        inventory.itemDetails = getItemDetails();

        return inventory;

    }

    public SupplierDetailsDTO getSupplierDetails() {

        try {
            String sql = "select Supplier_id, Supplier_name from Supplier";
            Connection connection = DBConnection.getDBConnection().getConnection();// database connection
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> supplierDetails = new ArrayList<String>(); //  create supplier details array                  
                supplierIds.add(rst.getString(1));
                supplierNames.add(rst.getString(2));

                for (int i = 1; i < 3; i++) {
                    supplierDetails.add(rst.getString(i));
                }

                ListofSupplierDetailsList.add(supplierDetails);

            }

            supDetail.supplierDetails = ListofSupplierDetailsList;
            supDetail.supplierIds = supplierIds;
            supDetail.supplierNames = supplierNames;
            return supDetail;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return supDetail;
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

    public CategoryDetailsDTO getCategoryDetails() {

        try {
            String sql = "select Category_id, Category_name from Category";
            Connection connection = DBConnection.getDBConnection().getConnection();// database connection
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> categoryDetails = new ArrayList<String>(); //  create supplier details array                  
                categoryIds.add(rst.getString(1));
                categoryNames.add(rst.getString(2));

                for (int i = 1; i < 3; i++) {
                    categoryDetails.add(rst.getString(i));
                }

                ListofCategoryDetailsList.add(categoryDetails);

            }

            category.categoryDetails = ListofCategoryDetailsList;
            category.categoryIds = categoryIds;
            category.categoryNames = categoryNames;
            return category;
        } catch (SQLException e) {
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return category;
    }

    public String nextItemId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Item_id from Items";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "I00" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public String nextCategoryId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Category_id from Category";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "Cat00" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public String nextInventoryId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Supplier_id from Supply_details";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "SD00" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

     public String nextPayableId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Payable_id from Payable";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "SP001" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean addNewInventory(InventoryAddViewDTO inventory, int val) throws SQLException, ParseException {
        String itemId = inventory.getItemId(); // string, char, int int -number, string- word, char -single letter
        String itemName = inventory.getItemName();
        Double unitPrice = inventory.getUnitPrice();
        int quantity = inventory.getQuantity();
        String netAmount = inventory.getNetAmount();
        Date newInventoryDate = inventory.getNewInventoryDate();
        String categoryId = inventory.getCategoryId();
        String categoryName = inventory.getCategoryName();
        String supplierId = inventory.getSupplierId();
        String supplierName = inventory.getSupplierName();
        String supplyId = inventory.getSupplyId();
        String payableId = nextPayableId();

        Connection connection = null;

        try {
            connection = DBConnection.getDBConnection().getConnection();

            int finalRes = 0;

            String sqlitem = "insert into Items values(?,?,?)";
            PreparedStatement stmitem = connection.prepareStatement(sqlitem);
            
            

            stmitem.setObject(1, itemId);
            stmitem.setObject(2, itemName);
            stmitem.setObject(3, categoryId);

           String sqlSupplier = "insert into Supply_details values(?,?,?,?,?,?,?)";
          PreparedStatement stmSupplier = connection.prepareStatement(sqlSupplier);
            stmSupplier.setObject(1, supplyId);
            stmSupplier.setObject(2, itemId);
            stmSupplier.setObject(3, supplierId);
            stmSupplier.setObject(4, unitPrice);
            stmSupplier.setObject(5, quantity);
            stmSupplier.setObject(6, newInventoryDate);
            stmSupplier.setObject(7, null);

            String sqlCategory = "insert into Category values(?,?)";
           PreparedStatement stmCategory = connection.prepareStatement(sqlCategory);
            stmCategory.setObject(1, categoryId);
            stmCategory.setObject(2, categoryName);
            
            String sqlPayable = "insert into Payable values(?,?,?,?)";
             PreparedStatement stmPayable = connection.prepareStatement(sqlPayable);
            stmPayable.setObject(1, payableId);
            stmPayable.setObject(2, netAmount);
            stmPayable.setObject(3, supplyId);
             stmPayable.setObject(4, null);
            
            if (val == 1) {
                int res = stmCategory.executeUpdate();
                int resSupplier = stmSupplier.executeUpdate();
                int resItem = stmitem.executeUpdate();
                int resPayable = stmPayable.executeUpdate();

                if (res == 1 && resItem == 1 && resSupplier == 1 && resPayable==1) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            }

            if (val == 2) {
                int resSupplier = stmSupplier.executeUpdate();
                int resItem = stmitem.executeUpdate();
                int resPayable = stmPayable.executeUpdate();

                if (resItem == 1 && resSupplier == 1&& resPayable==1) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            }

            if (val == 3) {
                int resSupplier = stmSupplier.executeUpdate();
                int resPayable = stmPayable.executeUpdate();
                if (resSupplier == 1&& resPayable==1) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            }

        } catch (SQLException e) {
            connection.rollback();
            System.out.println("error@ " + e.getMessage());
            e.printStackTrace();
            System.out.println("error@ " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }
    
    public List ViewInventoryDetails(){
        
     
        Connection con = null;
        PreparedStatement  stm = null;
        ResultSet rst = null;
        int last=0;
        
        try
        { 
            
            
            String sql = "select i.item_name,i.Item_id,sup.Supplier_name, c.Category_id,c.Category_name, s.Unit_price,Sum(s.Quantity)-Sum(o.Quantity) from Items i, Category c, Supply_details s, Supplier sup, Purchase_details o where i.Item_id = s.Item_id and i.Category_id =c.Category_id and sup.Supplier_id = s.Supplier_id and o.Item_id = i.Item_id group by i.Item_id,"
                    +"sup.Supplier_name,c.Category_id,c.Category_name, s.Unit_price,i.item_name,s.Supplier_id";          
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
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

                ListofInventoryDetailsList.add(inventoryDetails);
               
               
            }
            return ListofInventoryDetailsList;
        }
        catch(SQLException e)
        {
            System.out.println("error@ " + e.getMessage());
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
         e.printStackTrace();  
        }
       return ListofInventoryDetailsList;
    } 
    
}
