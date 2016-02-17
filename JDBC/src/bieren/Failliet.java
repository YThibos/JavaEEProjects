/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bieren;

import bieren.database.BierenConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yannick.thibos
 */
public class Failliet {
    
    private static final String SQL_UPDATE_BIEREN_BROUWER2 = "update bieren\n" +
"set brouwerid = 2\n" +
"where alcohol >= 8.5 and brouwerid = 1";
    private static final String SQL_UPDATE_BIEREN_BROUWER3 = "update bieren\n" +
"set brouwerid = 3\n" +
"where alcohol < 8.5 and brouwerid = 1";
    private static final String SQL_DELETE_BROUWER1 = "delete from brouwers\n" +
"where id = 1";
    
    public static void main(String[] args) {
        
        try (Connection connection = BierenConnector.getConnection();
                Statement statement = connection.createStatement();){
            
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
            
            
            statement.addBatch(SQL_UPDATE_BIEREN_BROUWER2);
            statement.addBatch(SQL_UPDATE_BIEREN_BROUWER3);
            statement.addBatch(SQL_DELETE_BROUWER1);
            statement.executeBatch();
            
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("EXCEPTION " + e.getMessage());
        }
        
    }
    
}
