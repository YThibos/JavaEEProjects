
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yannick.thibos
 */
public class Oef28 {

    public static void main(String[] args) {

        String[] str = {"scherm", "muis", "keyboard", "case", "processor", "mobo", "gpu", "ram", "software", "slaapstand"};

        Map<String, Integer> freq = new HashMap<String, Integer>();
        String letter;
        Integer currentfreq;
        for (String string : str) {
            letter = string.substring(0, 1);
            currentfreq = freq.get(letter);
            if (currentfreq == null) {
                freq.put(letter, 1);
            } else {
                freq.put(letter, ++currentfreq);
            }
        }

        System.out.println("*** Aantal woorden per letter ***");
        int aantalHash = 0;
        Iterator<String> it = freq.keySet().iterator();
        while (it.hasNext()) {
            ++aantalHash;
            String s = it.next();
            System.out.println(s + " is de begint letter van " + freq.get(s));
        }

        System.out.println("*** Grootte v/d HashMap ***");
        System.out.println(aantalHash);     // of freq.keySet().size()
        
        System.out.println("*** Afdruk van alle keys ***");
        it = freq.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("*** Afdruk van alle values ***");
        Iterator<Integer> itVal = freq.values().iterator();
        while (itVal.hasNext()) {
            System.out.println(itVal.next());
        }

        System.out.println("*** Afdruk van alle key-value pairs ***");
        Iterator itPairs = freq.entrySet().iterator();
        while (itPairs.hasNext()) {
            System.out.println(itPairs.next());            
        }
        
    }

}
