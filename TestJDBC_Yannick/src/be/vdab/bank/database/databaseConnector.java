/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasse met vooraf ingestelde URL en login gegevens naar de bank-database.
 *
 * @author yannick.thibos
 */
public class databaseConnector {
    
    private static final String URL = "jdbc:mysql://localhost/bank?useSSL=false&";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    
    private databaseConnector() {}
    
    /**
     * Maakt en geeft een Connection met de bank-database terug, ingelogd met username 'cursist'
     * 
     * @return Een connection met de bank-database, ingelogd als 'cursist'
     * @throws SQLException Indien er niet met de database kon verbonden worden
     * (database bestaat niet, foutieve login, etc.)
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
