
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yannick.thibos
 */
public class ArrayListDemo {

    private static void vul(List lijst) {
        lijst.add("fiets");
        lijst.add(null); //null-element toegestaan 
        lijst.add("even");
        lijst.add("dak");
        lijst.add("citroen");
        lijst.add("citroen"); //dubbels toegestaan
        lijst.add("boom");
        lijst.add("aap");
    }

    private static void toon(List lijst) {
        for (int i = 0; i < lijst.size(); i++) {
            String woord = (String) lijst.get(i);
            System.out.println(woord);
        }
    }

    private static void toonVanafIndex(List l, int startPos) {
        System.out.println();
        for (ListIterator li = l.listIterator(startPos); li.hasNext();) {
            System.out.println(li.next());
        }
    }

    private static void toonVanafIndexOmgekeerd(List l, int startPos) {
        System.out.println();
        for (ListIterator li = l.listIterator(startPos); li.hasPrevious();) {
            System.out.println(li.previous());
        }
    }

    public static void main(String[] args) {

        System.out.println("-- List op basis van ArrayList --");

        List al = new ArrayList();
        vul(al);
        toon(al);
        System.out.println();
        al.add(3, "test");
        al.add("beer");
        toon(al);
        System.out.println();

        System.out.println("Element vervangen");
        try {
            ListIterator li = al.listIterator(6);
            li.next();
            li.set("tweede citroen");
            li.add("kers");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index niet gevonden" + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Geen element beschikbaar" + e.getMessage());
        }

        System.out.print("ArrayList afgedrukt vanaf element 3");
        toonVanafIndex(al, 2);
        System.out.print("\nArrayList omgekeerd afgedrukt");
        toonVanafIndexOmgekeerd(al, al.size());

    }

}
