package com.stackroute;

import com.stackroute.db.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("crude operation");
        CrudOperation crudOperation = new CrudOperation();
        //crudOperation.displayData();
        crudOperation.displayCustomrerByName("Anu", "f");
        System.out.println("DatabaseMetadataDemo");
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.databaseMetadata();
        System.out.println("JDBC batchprocessing");
        JDBCBatchProcessingDemo jdbcBatchProcessingDemo = new JDBCBatchProcessingDemo();
        try {
            jdbcBatchProcessingDemo.jdbcBatchProcessingMethod();
        } catch (Exception e) {

        }
        JDBCTransactionDemo jdbcTransactionDemo = new JDBCTransactionDemo();
        try {
            jdbcBatchProcessingDemo.jdbcBatchProcessingMethod();
        } catch (Exception e) {
        }
        ResultsetMetadataDemo resultsetMetadataDemo = new ResultsetMetadataDemo();
        resultsetMetadataDemo.resultSetMetaDataMethod();
        RowsetDemo rowsetDemo = new RowsetDemo();
        try {
            rowsetDemo.rowsetDemoMethod();
        } catch (Exception e) {

        }
    }
}
