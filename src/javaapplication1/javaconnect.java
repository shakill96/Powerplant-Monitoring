package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shakill
 */
import java.sql.*;
import javax.swing.*;

public class javaconnect {
    //--  Déclarations
    Connection conn = null;
    
    public static Connection ConnectDb(){
        try{
    //--  Initialisations
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shakill\\PowerPlant.db");
    JOptionPane.showMessageDialog(null, "Connection Established");
    return conn;
}
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
}
    }
}
