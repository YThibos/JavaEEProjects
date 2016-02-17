/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuincentrum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yannick.thibos
 */
public class SoortenToevoegen {

    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String INSERT_SQL = "insert into soorten(naam) values (?)";

    public static void main(String[] args) {
        List<String> namen = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Tik soortnamen, tik stop na de laatste naam");

            String nieuweNaam = scanner.nextLine();

            while (!"stop".equalsIgnoreCase(nieuweNaam)) {
                namen.add(nieuweNaam);
                nieuweNaam = scanner.nextLine();
                //System.out.println(nieuweNaam + " added to arraylist ***");
            }

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    PreparedStatement statement
                    = connection.prepareStatement(INSERT_SQL)) {
                
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                connection.setAutoCommit(false);
                
                for (String naam : namen) {
                    statement.setString(1, naam);
                    statement.addBatch();
                }
                
                int[] aantalToegevoegdeRecordsPerInsert = statement.executeBatch();
                connection.commit();
                
                int aantalToegevoegdeSoorten = 0;
                for (int aantalToegevoegdeRecords : aantalToegevoegdeRecordsPerInsert) {
                    aantalToegevoegdeSoorten += aantalToegevoegdeRecords;
                }
                System.out.println(aantalToegevoegdeSoorten);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
