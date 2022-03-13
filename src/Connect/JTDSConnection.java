/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JTDSConnection {
    public static Connection getConnect() {
        final String url = "jdbc:jtds:sqlserver://ADMIN:1433/PRODUCT;instance=SQLEXPRESS";
        String user = "minh2001";
        String password = "minh03062001";
        
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JTDSConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
