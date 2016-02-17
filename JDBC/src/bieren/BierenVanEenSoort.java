/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author yannick.thibos
 */
public class BierenVanEenSoort {
    
    private static final String SQL_SELECT_SOORT = "SELECT bieren.naam"
            + " FROM bieren INNER JOIN soorten ON bieren.soortid = soorten.id"
            + " WHERE naam LIKE '%?%'";
    
    public static void main(String[] args) {
        
        String soort;
        System.out.println("Geef een naam van een soort om te zoeken: ");
        try (Scanner scanner = new Scanner(System.in)) {
            soort = scanner.nextLine();
        }
        
        try (Connection connection = BierenConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_SOORT)){

            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            
            statement.setString(1, soort);
            
            ResultSet results = statement.executeQuery();
            
            while (results.next()) {
                System.out.println(results.getString("naam"));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
