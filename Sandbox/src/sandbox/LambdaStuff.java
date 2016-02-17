/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author yannick.thibos
 */
public class LambdaStuff {

    public static void main(String[] args) throws IOException {

        // REGEX to match one or more consecutive whitespace
        Pattern pattern = Pattern.compile("\\s+");
        
        // Count occurences of each word in a Stream<String> sorted by word
        Map<String, Long> wordCounts = 
                // Get stream from hamlet.txt
                Files.lines(Paths.get("/data/hamlet.txt"))
                // (?!') removes apostrophes in words , \\p{P} removes punctuation
                .map(line -> line.replaceAll("(?!')\\p{P}", ""))
                // splits lines in Stream<String>'s
                .flatMap(line -> pattern.splitAsStream(line))
                // Collects each stream 
                .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
        
        wordCounts.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(""))
                .collect(
                    Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
                .forEach((letter, wordList) -> 
                {
                    System.out.printf("%n%C%n", letter);
                    wordList.stream().forEach(word -> System.out.printf(
                            "%13s: %d%n", word.getKey(), word.getValue()));
                });
        
    }

}
