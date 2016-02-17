/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannick.thibos
 */
public class OnevenGetallen {

    public static void main(String[] args) {

        Set<Integer> getallen = new LinkedHashSet<>();

        int input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                input = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Ongeldige input");
                input = 0;
            }

            getallen.add(input);
        } while (input != 0);

        System.out.println("Oneven getallen ingegeven door gebruiker: ");
        getallen.stream()
                .filter(getal -> getal % 2 == 0)
                .sorted((get1, get2) -> get2 - get1)
                .forEach(getal -> System.out.println(getal));

    }

}
