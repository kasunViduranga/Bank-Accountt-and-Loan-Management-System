/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kasun
 */
public class DBConnection {
    
    private Connection connection;
    private static DBConnection dbConnection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management_system","root","1997");
    }
   
    public static DBConnection getInstance() throws Exception{
        if (dbConnection==null) {
            dbConnection = new DBConnection();            
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
