/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.Bier;
import bieren.database.BierenConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class BierenVanEenMaand {

    private static final String SQL_SELECT_BIERVMAAND = "SELECT verkochtsinds, naam"
            + " FROM bieren WHERE {fn month(verkochtsinds)} = ?";

    public static void main(String[] args) {

        int maandnummer = 0;

        Scanner scanner = new Scanner(System.in);
        while (maandnummer < 1 || maandnummer > 12) {
            System.out.println("Geef het maandnummer [1,12]:");
            try {
                maandnummer = scanner.nextInt();
            } catch (InputMismatchException ex) {
                maandnummer = 0;
            }
        }

        try (Connection connection = BierenConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BIERVMAAND)) {

            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            statement.setInt(1, maandnummer);

            List<Bier> bieren = new ArrayList<>();
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    Bier bier = new Bier();
                    bier.setVerkochtsinds(results.getDate("verkochtsinds").toLocalDate());
                    bier.setNaam(results.getString("naam"));
                    
                    bieren.add(bier);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            System.out.printf("%nBieren verkocht sinds de %d'de maand%n%n", maandnummer);
            bieren.stream().forEach(bier -> {
                System.out.printf("%s %s%n", bier.getVerkochtsinds(), bier.getNaam());
                });

        } catch (SQLException ex) {
            Logger.getLogger(BierenVanEenMaand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
