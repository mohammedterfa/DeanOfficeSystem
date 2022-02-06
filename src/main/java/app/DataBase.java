/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Terfa
 */
public class DataBase {
    Connection conn = null;
    
    public Connection conection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/samproject","root","");
            
        }
        catch(Exception e){
            System.out.print(e);
        }
        
        return conn;
    
    }
    
}
