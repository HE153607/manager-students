/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Dao {
    protected Connection connection;

    public Dao() {
        try {
           String user = "sa";
           String pass = "anh";
           String url = "jdbc:sqlserver://localhost:1433;databaseName=Manager";
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection =DriverManager.getConnection(url, user, pass);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
