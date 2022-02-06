/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Terfa
 */
public class Metodos {
    DataBase database = new DataBase();
    Connection conn = null;
    ResultSet rs = null;
    Statement stmt = null;
    
    public void fillDataJlist(JList jlits){
        
        try {
            DefaultListModel model = new DefaultListModel();
            conn = database.conection();
            stmt= conn.createStatement();
            rs = stmt.executeQuery("select * from message");
            
            while(rs.next()){
                String subj = rs.getString("subject");
                String id = rs.getString("id");
                model.addElement(id);
                model.addElement(subj);
                
            }
            
            jlits.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
