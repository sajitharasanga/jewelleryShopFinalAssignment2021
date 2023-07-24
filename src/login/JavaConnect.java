/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package login;

/**
 *
 * @author sajit
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class JavaConnect {
 Connection conn; 
 
 public static Connection ConnecrDb(){
     try{
         Class.forName("org.sqlite.JdBC");
         Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sajit\\Documents\\JShop.db");
         return conn;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return null;
     }
 }
}
