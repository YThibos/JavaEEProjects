/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Yannick.Thibos
 */
public class BierenVerwijderen {
    
    public static void main(String[] args) {
        
        try (Connection connection = BierenConnector.getConnection(); 
                Statement statement = connection.createStatement()){
            
            String verwijdererBieren = 
                    "DELETE bieren.* FROM bieren WHERE alcohol IS NULL";
            System.out.println("Record(s) verwijderd: " + statement.executeUpdate(verwijdererBieren));
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
}
