/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuincentrum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Yannick.Thibos
 */
public class CallableStatement {

    private static final String URL
            = "jdbc:mysql://localhost/tuincentrum?noAccessToProcedureBodies=true&setSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String CALL = "{call PlantenMetEenWoord(?)}";

    public static void main(String[] args) {
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                java.sql.CallableStatement statement = connection.prepareCall(CALL);
                Scanner scanner = new Scanner(System.in)){
            System.out.println("Zoekterm: ");
            String woord = scanner.nextLine();
            
            statement.setString(1, '%' + woord + '%');
            
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                System.out.println(results.getString("naam"));
            }
            
        } catch (Exception e) {
        }
        
    }
    
}
