/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import bieren.database.Brouwer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.8 Omzet niet gekend
 * Je toont per brouwer, waarvan de omzet niet gekend is, de naam en zijn aantal bieren.
 * @author yannick.thibos
 */
public class OmzetNietGekend {
    
    private static final String SQL_SELECT_BROUWERSZONDEROMZET = 
            "SELECT brouwers.naam as naam, count(*) as aantal"
            + " FROM bieren INNER JOIN brouwers ON bieren.brouwerid = brouwers.id"
            + " WHERE brouwers.omzet IS NULL"
            + " GROUP BY naam";
    
    public static void main(String[] args) {
        
        try (Connection connection = BierenConnector.getConnection();
                Statement statement = connection.createStatement()){

                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                
                ResultSet results = statement.executeQuery(SQL_SELECT_BROUWERSZONDEROMZET);
                
                Map<String, Integer> bierenPerBrouwer = new HashMap<>();
                while (results.next()) {
                    bierenPerBrouwer.put(results.getString("naam"), results.getInt("aantal"));
                }
                
                
                System.out.println("BROUWER - AANTAL");
                bierenPerBrouwer.entrySet().stream()
                        .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                        .forEach(entry -> {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                });
                
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
