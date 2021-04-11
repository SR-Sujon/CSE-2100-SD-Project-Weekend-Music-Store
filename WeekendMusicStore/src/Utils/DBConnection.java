/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sujon
 */
public class DBConnection {
    Connection connect = null;
    public static Connection DBcon() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jarvis","root","");
            return con;
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
