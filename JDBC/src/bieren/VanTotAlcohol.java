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
import java.util.Scanner;

/**
 *
 * @author Yannick.Thibos
 */
public class VanTotAlcohol {
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in);
                Connection connection = BierenConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(
          "SELECT alcohol, naam FROM bieren WHERE alcohol BETWEEN ? AND ?\n" +
          "ORDER BY alcohol DESC, naam ASC")){
            
            System.out.println("Geef een minimum en een maximum alcoholpercentage "
                    + "(gescheiden door een spatie) om naar te zoeken:");
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            
            statement.setInt(1, min);
            statement.setInt(2, max);
            
            System.out.println("--- Resultaten tussen " + min + " en " + max + " ---");
            
            ResultSet results = statement.executeQuery();
            
            while (results.next()) {
                System.out.printf("%4.1f%% %s%n", results.getDouble("alcohol"), results.getString("naam"));
            }
            
            results.close();
            
        } catch (Exception e) {
            System.out.println("EXC: " + e.getMessage());
        }
        
    }
    
}
