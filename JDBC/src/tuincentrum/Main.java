/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuincentrum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import tuincentrum.database.TuincentrumConnector;

/**
 *
 * @author Yannick.Thibos
 */
public class Main {

    public static void main(String[] args) {

        String preparedQuery = "SELECT naam FROM leveranciers WHERE woonplaats = ?";

        try (Connection connection = TuincentrumConnector.getConnection();
                Statement statement = connection.createStatement();
                Scanner scanner = new Scanner(System.in);
                PreparedStatement prepStatement = connection.prepareStatement(preparedQuery)) {
            System.out.println("--- CONNECTED TO DATABASE ---");

            String update_sql = "UPDATE planten SET verkoopprijs = verkoopprijs * 0.1)";
            //System.out.println(statement.executeUpdate(update_sql));

            String selectIDNaam = "SELECT id, naam FROM leveranciers ORDER BY id";
            ResultSet results = statement.executeQuery(selectIDNaam);

            while (results.next()) {
                System.out.printf("%4d %s%n", results.getInt("id"),
                        results.getString("naam"));
            }

            String calcAverage = "SELECT avg(verkoopprijs) as Gemiddelde FROM planten";
            results = statement.executeQuery(calcAverage);

            while (results.next()) {
                System.out.println("Gemiddelde: " + results.getBigDecimal("Gemiddelde"));
            }

            System.out.println("\nGeef een woonplaats van een leverancier in: ");
            String woonplaats = scanner.nextLine();
            prepStatement.setString(1, woonplaats);

            results = prepStatement.executeQuery();

            while (results.next()) {
                System.out.println(results.getString("naam"));
            }

            results.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println("--- DATABASE CONNECTION TERMINATED BY EXCEPTION ---");
        }

    }

}
