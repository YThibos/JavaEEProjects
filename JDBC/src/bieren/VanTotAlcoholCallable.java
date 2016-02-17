/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Yannick.Thibos
 */
public class VanTotAlcoholCallable {
    
        private static final String URL = "jdbc:mysql://localhost/bieren?useSSL=false&noAccessToProcedureBodies=true";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String CALL = "{call VanTotAlcohol(?,?)}";
    
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in);
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                CallableStatement statement = connection.prepareCall(CALL)){
            
            System.out.println("Geef min en max (gescheiden door spatie) alcohol om naar te zoeken: ");
            double min = scanner.nextDouble();
            double max = scanner.nextDouble();
            
            statement.setDouble(1, min);
            statement.setDouble(2, max);
            
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    System.out.printf("%-30s %s %10.1f%%%n", results.getString("biernaam"), results.getString("brouwernaam"), results.getDouble("alcohol"));
                }
            }
            
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        
    }
    
}
