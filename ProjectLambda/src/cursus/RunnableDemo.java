/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author yannick.thibos
 */
public class RunnableDemo {

    private static final Path DATA_PATH = Paths.get("/data");
    private static final Path COUNTRIES_PATH = DATA_PATH.resolve("countries.txt");
    private static final Path COUNTRIES_BACKUP_PATH = DATA_PATH.resolve("countries.bak");
    private static final Path LANGUAGES_PATH = DATA_PATH.resolve("languages.txt");
    private static final Path LANGUAGES_BACKUP_PATH = DATA_PATH.resolve("languages.bak");

    private static void legeRegelsVerwijderen() {

        try {

            // Verwijder de oude backup, en move (hernoem) huidig countries.txt bestand naar .bak backup
            Files.deleteIfExists(COUNTRIES_BACKUP_PATH);
            Files.move(COUNTRIES_PATH, COUNTRIES_BACKUP_PATH);

            // Open bufferedreader en writer (try with resources)
            try (BufferedReader reader = Files.newBufferedReader(COUNTRIES_BACKUP_PATH);
                    Writer bufferedWriter = Files.newBufferedWriter(COUNTRIES_PATH);
                    PrintWriter writer = new PrintWriter(bufferedWriter)) {
                // Lees regel per regel in tot regel == null
                for (String regel; (regel = reader.readLine()) != null;) {
                    // Lege regels skippen
                    if (!regel.isEmpty()) {
                        writer.printf("%s%n", regel);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void dubbelsVerwijderen() {

        // Maak een hashset (die enkel unieke entries kan bevatten!!) om
        // de unieke talen uit de file te halen en op te slaan.
        Set<String> uniekeTalen = new LinkedHashSet<>();

        try {

            // Delete old backup, rename current .txt to .bak
            Files.move(LANGUAGES_BACKUP_PATH, LANGUAGES_PATH);
            Files.deleteIfExists(LANGUAGES_BACKUP_PATH);

            // Open resources (bufferedreader
            try (BufferedReader reader = Files.newBufferedReader(LANGUAGES_BACKUP_PATH)) {
                for (String regel; (regel = reader.readLine()) != null;) {
                    // Hashset zal automatisch dubbels negeren (SET!)
                    uniekeTalen.add(regel);
                }
            }
            try (Writer bufferedWriter = Files.newBufferedWriter(LANGUAGES_PATH);
                    PrintWriter writer = new PrintWriter(bufferedWriter)) {
                for (String taal : uniekeTalen) {
                    writer.printf("%s%n", taal);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Thread(() -> legeRegelsVerwijderen()).start();
        new Thread(() -> dubbelsVerwijderen()).start();
    }
}
