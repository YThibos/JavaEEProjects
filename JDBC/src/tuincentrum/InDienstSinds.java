/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuincentrum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.IllegalFormatException;
import java.util.Scanner;
import tuincentrum.database.TuincentrumConnector;

/**
 *
 * @author yannick.thibos
 */
public class InDienstSinds {

    private static final String SQL_SELECT = "SELECT indienst, voornaam, familienaam"
            + " FROM werknemers WHERE indienst >= ? ORDER BY indienst";
    private static final String SQL_SELECT_2000 = "SELECT indienst, voornaam, familienaam"
            + " FROM werknemers WHERE indienst >= {d '2000-01-01'} ORDER BY indienst";

    public static void main(String[] args) {

        System.out.println("Datum vanaf (dd/mm/yyyy):");

        // prepare formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        java.time.LocalDate datum;

        // read input date and format
        try (Scanner scanner = new Scanner(System.in)) {
            datum = LocalDate.parse(scanner.nextLine(), formatter);
        } catch (DateTimeParseException ex) {
            datum = LocalDate.now();
            System.out.println("Enter a date in the dd/mm/yyyy format");
            System.out.println("'datum' set to LocalDate.now()");
        }

        System.out.println("Looking for " + datum + "..");

        try (Connection connection = TuincentrumConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
                Statement statement2 = connection.createStatement()) {

            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            statement.setDate(1, Date.valueOf(datum));

            try (ResultSet results = statement.executeQuery();
                    ResultSet vanaf2000 = statement2.executeQuery(SQL_SELECT_2000)) {
                System.out.println("--- WERKNEMERS VANAF " + datum + " ---");
                while (results.next()) {
                    System.out.printf("%s :: %s %s %n", results.getDate("indienst"),
                            results.getString("voornaam"), results.getString("familienaam"));
                            LocalDate d = results.getDate("indienst").toLocalDate();
                }
                System.out.println("--- WERKENEMERS VANAF 2000-01-01 hardcoded ---");
                while (vanaf2000.next()) {
                    System.out.printf("%s :: %s %s %n", vanaf2000.getDate("indienst"),
                            vanaf2000.getString("voornaam"), vanaf2000.getString("familienaam"));
                }
            } catch (IllegalFormatException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("SQL EXC: " + ex.getMessage());
        }

    }

}
