/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.EmployeeDetails;
import database.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class EmployeeDetailsDao {

    public List<List<String>> ListofEmployeeList = new ArrayList<List<String>>();

    public boolean addEmployee(EmployeeDetails emp) throws SQLException, ParseException {

        String Employee_name = emp.getEmployeeName();
        int teleNo = emp.getTelephoneNo();
        String personalAddress = emp.getPersonalAddress();
        String nic = emp.getNic();

        Date dateOfBirth = emp.getDateOfBirth();
        String Employee_Id = emp.getEmployeeId();
        String userName = emp.getEmployeeId();
        int age = emp.getAge();
        String gender = emp.getGender();
        String Department = emp.getDepartment();
        String position = emp.getPosition();
        Date hiredDate = emp.getHiredDate();
        String password = emp.getPassWord();
        String mailAddress = emp.getmailAddress();

        PreparedStatement stm = null;
        Connection connection = null;

        try {
            String sql = "insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);

            stm.setObject(1, Employee_Id);
            stm.setObject(2, Employee_name);
            stm.setObject(3, Department);
            stm.setObject(4, mailAddress);
            stm.setObject(5, userName);
            stm.setObject(6, password);
            stm.setObject(7, 1);
            stm.setObject(8, teleNo);
            stm.setObject(9, personalAddress);
            stm.setObject(10, nic);
            stm.setObject(11, gender);
            stm.setObject(12, dateOfBirth);
            stm.setObject(13, age);
            stm.setObject(14, hiredDate);

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

    public List ViewEmployeeDetails() {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rst = null;
        int last = 0;

        try {

            String sql = "select emp.Employee_id,emp.Employee_name,emp.Dateofbirth,emp.Personal_adress,emp.TeleNo,emp.Department,emp.Hireddate"
                    + " from Employee emp";
            //  String sql = "select emp.Employee_id,emp.Employee_name,emp.Department,emp.Mail_address,emp.User_name,emp.Role_id,emp.TeleNo,emp.Personal_adress,emp.nic"
            // +",emp.Gender,emp.Dateofbirth,emp.Age,emp.Hireddate from Employee emp";
            Connection connection = DBConnection.getDBConnection().getConnection();
            stm = connection.prepareStatement(sql);
            rst = stm.executeQuery();

            while (rst.next()) {
                List<String> employeedetails = new ArrayList<String>();
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

    public String nextEmployeeId() {
        Connection con = null;
        Statement stm = null;
        ResultSet rst = null;
        int last = 0;
        String id = "";

        try {
            String sql = "select Employee_id from Employee";
            Connection connection = DBConnection.getDBConnection().getConnection();
            //stm = connection.createStatement();
            stm = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(sql);

            rst.last();
            last = rst.getRow() + 1;
            id = "E00" + last;
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }
}
