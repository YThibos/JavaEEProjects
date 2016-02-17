/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.bank;

import be.vdab.bank.database.Queries;
import be.vdab.bank.database.databaseConnector;
import be.vdab.bank.rekening.Rekening;
import be.vdab.bank.rekening.RekeningException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Eenvoudige simulatie van een bank-programma.
 * Het programma kan enkele eenvoudige transacties verwerken op rekeningen,
 * en houdt deze bij een een MySQL database.
 *
 * @author yannick.thibos
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("--- BANK MENU ---");

        try (Scanner scanner = new Scanner(System.in)) {

            int input = 0;

            do {
                System.out.println("1. Nieuwe rekening");
                System.out.println("2. Saldo consulteren");
                System.out.println("3. Overschrijven");
                System.out.println("4. Stop");
                System.out.println("5. CLEAR DATABASE");
                System.out.print("\n Tik het nummer van uw gewenste actie: ");
                input = scanner.nextInt();

                long rekeningNr;

                switch (input) {
                    case 4:
                        return;
                    case 1:
                        System.out.println("-- Nieuwe rekening --");
                        System.out.println("Geef het rekeningnummer van de nieuwe rekening in (12 cijfers):");
                        rekeningNr = scanner.nextLong();
                        System.out.println("Geef het startsaldo van de nieuwe rekening:");
                        BigDecimal startSaldo = scanner.nextBigDecimal();
                        maakNieuweRekening(rekeningNr, startSaldo);
                        break;
                    case 2:
                        System.out.println("-- Saldo consulteren --");
                        System.out.println("Geef het rekeningnummer waarvan u het saldo wil consulteren:");
                        rekeningNr = scanner.nextLong();
                        consulteerSaldo(rekeningNr);
                        break;
                    case 3:
                        System.out.println("-- Overschrijven --");
                        System.out.println("Geef het rekeningnummer waarvan u een bedrag wil overschrijven:");
                        long vanRekeningNr = scanner.nextLong();
                        System.out.println("Geef het rekeningnummer waarNAAR u een bedrag wil overschrijven:");
                        long naarRekeningNr = scanner.nextLong();
                        System.out.println("Geef het bedrag dat u wil overschrijven: ");
                        BigDecimal bedrag = scanner.nextBigDecimal();
                        verwerkOverschrijving(vanRekeningNr, naarRekeningNr, bedrag);
                        break;
                    case 5:
                        clearDatabase();
                        break;
                    default:
                        System.out.println("Ongeldige menukeuze. Probeer opnieuw.");
                }

            } while (input != 4);
        }

    }

    private static void maakNieuweRekening(long rekeningNr, BigDecimal startSaldo) {

        try {
            Rekening nieuweRekening = new Rekening(rekeningNr, startSaldo);

            try (Connection bankConnection = databaseConnector.getConnection();
                    PreparedStatement insertStatement
                    = bankConnection.prepareStatement(Queries.SQL_INSERT_NIEUWE_REKENING);
                    PreparedStatement selectStatement
                    = bankConnection.prepareStatement(Queries.SQL_SELECT_REKENINGEN)) {

                bankConnection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                bankConnection.setAutoCommit(false);

                selectStatement.setLong(1, nieuweRekening.getRekeningNr());
                try (ResultSet gevondenRekeningenSet = selectStatement.executeQuery()) {

                    if (gevondenRekeningenSet.next()) {
                        throw new RekeningException("Rekeningnummer bestaat al.");
                    } else {
                        insertStatement.setLong(1, nieuweRekening.getRekeningNr());
                        insertStatement.setBigDecimal(2, nieuweRekening.getSaldo());
                        insertStatement.executeUpdate();
                        bankConnection.commit();
                        System.out.println("Rekening met nummer " + rekeningNr + " toegevoegd.");
                    }
                }

            } catch (SQLException ex) {
                System.out.printf("Fout bij verbinden met de databank:%n%s%n%n", ex.getMessage());
            }

        } catch (RekeningException ex) {
            System.out.printf("Rekening aanmaken geannuleerd:%n%s%n", ex.getMessage());
        }

    }

    private static void consulteerSaldo(long rekeningNr) {

        try (Connection bankConnection = databaseConnector.getConnection();
                PreparedStatement selectStatement
                = bankConnection.prepareStatement(Queries.SQL_SELECT_REKENINGEN)) {

            bankConnection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            selectStatement.setLong(1, rekeningNr);
            try (ResultSet gevondenRekeningenSet = selectStatement.executeQuery()) {
                if (!gevondenRekeningenSet.next()) {
                    throw new RekeningException("Rekening niet gevonden in de databank");
                } else {
                    Rekening rekening = new Rekening(
                            gevondenRekeningenSet.getLong("rekeningNr"),
                            gevondenRekeningenSet.getBigDecimal("saldo"));
                    System.out.println(rekening + "\n");
                }

            } catch (RekeningException ex) {
                System.out.printf("Fout bij consulteren van rekening:%n%s%n%n", ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.printf("Fout bij verbinden met databank:%n%s%n%n", ex.getMessage());
        }

    }

    private static void verwerkOverschrijving(long vanRekeningNr, long naarRekeningNr, BigDecimal bedrag) {

        try {
            
            Rekening vanRekening = new Rekening(vanRekeningNr);
            Rekening naarRekening = new Rekening(naarRekeningNr);
            
            try (Connection bankConnection = databaseConnector.getConnection();
                    PreparedStatement selectStatement
                            = bankConnection.prepareStatement(Queries.SQL_SELECT_VANNAAR_REKENINGEN);
                    PreparedStatement updateStatement
                            = bankConnection.prepareStatement(Queries.SQL_UPDATE_REKENINGEN)) {
                
                bankConnection.setAutoCommit(false);
                bankConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                
                selectStatement.setLong(1, vanRekening.getRekeningNr());
                selectStatement.setLong(2, naarRekening.getRekeningNr());
                
                try (ResultSet vanEnNaarRekening = selectStatement.executeQuery()) {
                    if (vanEnNaarRekening.next()) {
                        vanRekening = new Rekening(
                                vanEnNaarRekening.getLong("rekeningNr"), 
                                vanEnNaarRekening.getBigDecimal("saldo"));
                        if (vanEnNaarRekening.next()) {
                            naarRekening = new Rekening(
                                vanEnNaarRekening.getLong("rekeningNr"),
                                vanEnNaarRekening.getBigDecimal("saldo"));
                            
                            vanRekening.schrijfOver(naarRekening, bedrag);
                            
                            updateStatement.setBigDecimal(1, vanRekening.getSaldo());
                            updateStatement.setLong(2, vanRekening.getRekeningNr());
                            updateStatement.addBatch();
                            
                            updateStatement.setBigDecimal(1, naarRekening.getSaldo());
                            updateStatement.setLong(2, naarRekening.getRekeningNr());
                            updateStatement.addBatch();
                            
                            updateStatement.executeBatch();

                            bankConnection.commit();
                            
                            System.out.println("Overschrijving voltooid.\n");
                            
                        }
                        else {
                            throw new RekeningException("'Naar' rekeningnummer niet gevonden in de databank");
                        }
                    }
                    else {
                        throw new RekeningException("'Van' rekeningnummer niet gevonden in de databank");
                    }
                }
                
                
            } catch (SQLException ex) {
                System.out.printf("Fout bij verbinden met de databank:%n%s%n%n", ex.getMessage());
            }
        } catch (RekeningException ex) {
            System.out.printf("Fout bij het opvragen van de rekeningen:%n%s%n%n", ex.getMessage());
        }
    }

    private static void clearDatabase() {
        try (Connection connection = databaseConnector.getConnection();
                Statement deleteStatement = connection.createStatement()) {
            
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            deleteStatement.executeUpdate(Queries.SQL_DELETE_ALL_RECORDS);
            
        } catch (SQLException ex) {
            System.out.printf("Fout bij verbinden met de databank:%n%s%n%n", ex.getMessage());
        }
    }

}

