/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.JOptionPane;

/**
 *
 * @author Terfa
 */
public class Data {
    private String usern,pas;
    public Data(String usern,String pas){
        this.usern = usern;
        this.pas = pas;
    }
    public String getusern(){
        return usern;
   }
    
    public String getpas(){
        return pas;
   }
}
