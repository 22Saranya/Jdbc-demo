package com.stackroute.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCBatchProcessingDemo {
    public static void jdbcBatchProcessingMethod() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","Root@123");
        con.setAutoCommit(false);

        Statement stmt=con.createStatement();
        stmt.addBatch("insert into customer values(7,'Prabhu',25,'M')");
        stmt.addBatch("insert into customer values(8,'Eureka',24,'F')");

        stmt.executeBatch();//executing the batch

        con.commit();
        con.close();
    }}

