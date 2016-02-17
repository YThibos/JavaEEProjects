/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yannick.Thibos
 */
public class AantalBierenPerBrouwer {
    
    public static void main(String[] args) {
        
        try (Connection connection = BierenConnector.getConnection();
                Statement statement = connection.createStatement()) {
            
            String query = "SELECT brouwers.naam as Naam, count(*) as Aantal FROM bieren INNER JOIN brouwers ON bieren.brouwerid = brouwers.id\n" +
"GROUP BY brouwers.naam\n" +
"ORDER BY Naam";
            ResultSet results = statement.executeQuery(query);
            
            while (results.next()) {
                System.out.printf("%-30s\t%d%n", results.getString("naam"), results.getInt("Aantal"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
