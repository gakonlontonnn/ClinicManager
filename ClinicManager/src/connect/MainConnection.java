/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC
 */
public class MainConnection {
  public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ClinicManager;encrypt=true;trustServerCertificate=true;", "sa", "sqladmin");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return conn;
    }
    public static void main(String[] args) {
        if (MainConnection.getConnection() != null) {
            System.out.println("Ket noi thanh cong");
        }
    }
}