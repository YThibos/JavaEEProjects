/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuincentrum;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yannick.Thibos
 */
public class Metadata {

    private static final String URL = "jdbc:mysql://localhost/tuincentrum";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String SQL_SELECT
            = "select id, voornaam, indienst from werknemers";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.printf("%s %d.%d%n", metaData.getDriverName(),
                    metaData.getDriverMajorVersion(),
                    metaData.getDriverMinorVersion()
            );
            System.out.println(metaData.getDatabaseProductName() + ' '
                    + metaData.getDatabaseMajorVersion() + ' '
                    + metaData.getDatabaseMinorVersion());

            try (ResultSet results = statement.executeQuery(SQL_SELECT)) {
                ResultSetMetaData rsmetaData = results.getMetaData();
                for (int index = 1; index <= rsmetaData.getColumnCount(); index++) {
                    System.out.printf("%-20s %s%n", rsmetaData.getColumnName(index),
                            rsmetaData.getColumnTypeName(index));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
