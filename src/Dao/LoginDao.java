/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.LoginCredentials;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class LoginDao {

    public Boolean AuthenticateUser(LoginCredentials logincredentials) {
        //Dbcrypto crypt = new Dbcrypto();     
        String username = logincredentials.getUserName(); //Keeping user entered values in temporary variables.
        String password = logincredentials.getPassword();
        //String passwordhash=crypt.encrypt(password);

        try {
            String sql = "select user_name,Pass_word from Employee";
            Connection connection = DBConnection.getDBConnection().getConnection();//establishing connection
            Statement statement = connection.createStatement(); //Statement is used to write queries
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) // Until next row is present otherwise it return false
            {
                String usernamedb = result.getString("user_name"); //fetch the values present in database
                String passworddb = result.getString("Pass_word").trim();

                if ((username.equals(usernamedb) && password.equals(passworddb))) {
                    return true; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false; // Just returning appropriate message otherwise
    }

}
