package com.stackroute.db;

import java.lang.String;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCTransactionDemo {
    public static void jdbcTransactionMethod() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");
       // Connection dbConnection = null;
       // PreparedStatement preparedStatementInsert = null;
        //PreparedStatement preparedStatementUpdate = null;


        dbConnection.setAutoCommit(false); //transaction block start

        String insertTableSQL = "INSERT INTO customer"
                + "(id, name, age, gender) VALUES"
                + "(?,?,?,?)";

        String updateTableSQL = "UPDATE customer SET name =? "
                + "WHERE id = ?";

        PreparedStatement preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
        preparedStatementInsert.setInt(1, 5);
        preparedStatementInsert.setString(2, "Amirtha");
        preparedStatementInsert.setInt(3, 24);
        preparedStatementInsert.setString(4, "F");
//preparedStatementInsert.setTimestamp(4, getCurrentTimeStamp());
preparedStatementInsert.executeUpdate(); //data IS NOT commit yet

        PreparedStatement preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL);
        preparedStatementUpdate.setString(1, "A very very long string caused DATABASE ERROR");
        preparedStatementUpdate.setInt(2, 999);
        preparedStatementUpdate.executeUpdate(); //Error, rollback, including the first insert statement.

        dbConnection.commit(); //transaction block end
    }
}
