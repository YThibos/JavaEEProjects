/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takenbundel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class RechthoekKleinsteOppervlakte {

    public static void main(String[] args) {

        List<Rechthoek> figuren = new ArrayList<>();
        figuren.add(new Rechthoek(1, 1));
        figuren.add(new Rechthoek(10, 10));
        figuren.add(new Rechthoek(100, 100));
        figuren.add(new Rechthoek(2, 50));
        figuren.add(new Rechthoek(2, 5));
        figuren.add(new Rechthoek(3, 3));
        figuren.add(new Rechthoek(0, 0));

        figuren.stream().mapToInt(
            rechthoek -> rechthoek.oppervlakte())
                .sorted()
                .forEach(System.out::println);
        
    }

}
