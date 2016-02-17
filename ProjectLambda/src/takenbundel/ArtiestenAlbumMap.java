/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author yannick.thibos
 */
public class ArtiestenAlbumMap {

    private static final Path ARTIESTEN = Paths.get("/data/albumsartists.txt");

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(ARTIESTEN)) {
            // Map de gelezen regels naar een Map<String, List<String>>
            Map<String, List<String>> artistsPerAlbum = lines
                    .collect(Collectors.groupingBy(
                            // De artiesten bevinden zich na de eerste komma in de regel
                            fullString -> fullString.substring(fullString.indexOf(",") + 1)));
            artistsPerAlbum.entrySet().stream()
                    .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                    .forEach(
                    // Voor elke entry <String, List<String>>
                    entry -> {
                        // print <String, .. 
                        System.out.println(entry.getKey() + "\n---------");
                        // haal de ..List<String>>, conv naar stream en forEach print
                        entry.getValue().stream().forEach(System.out::println);
                        System.out.println("");
                    });
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
