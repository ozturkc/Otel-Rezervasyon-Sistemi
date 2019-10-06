/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author developer
 */
public class DbConnect {
  
    
    public static  Connection  dbBaglanti() {
                 Connection connect=null;
        try{
              Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/otelRezervasyon?"+"useSSL=false","root","");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());         
    }
                return connect;

    }
    

        
        
    
}
