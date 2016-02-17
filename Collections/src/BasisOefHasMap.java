
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class BasisOefHasMap {

    public static void main(String[] args) {
        
        TreeMap<String,String> landen = new TreeMap<String,String>();
        
        landen.put("BE", "Belgie");
        landen.put("NL", "Nederland");
        landen.put("F", "Frankrijk");
        landen.put("D", "Duitsland");
        landen.put("L", "Luxemburg");
//        landen.put(null, null);
        
        String eenLand = landen.get("F");
        System.out.println("Land met code F: " + eenLand);
        
        String vorigLand = landen.put("F", "Finland");
        System.out.println("Vorig land met code F: " + vorigLand);
        eenLand = landen.get("F");
        System.out.println("Land met code F: " + eenLand);
        
        System.out.println("***View van de Keys***");
        Iterator<String> keys = landen.keySet().iterator();
        while (keys.hasNext()) {
            String landcode = keys.next();
            eenLand = landen.get(landcode);
            System.out.println(landcode + " heeft als value: " + eenLand + " :: ");
            //if (landcode != null) System.out.println(landen.get(landcode).hashCode());
        }
        
        System.out.println("***View van de Values***");
        Iterator<String> vals = landen.values().iterator();
        while (vals.hasNext()) {
            System.out.println(vals.next());            
        }
        
        System.out.println("***View van de Key-Value pairs***");
        Iterator kv = landen.entrySet().iterator();
        while (kv.hasNext()) {
            System.out.println(kv.next());            
        }
        
        System.out.println();
        System.out.println("***Extra methods van TreeMap");
        System.out.println("Eerste key: " + landen.firstKey());
        System.out.println("Laatste key: " + landen.lastKey());
        
        SortedMap<String, String> landenSub = landen.subMap("D", "M");
        System.out.println("***View van de key-value pairs vd submap D-M***");
        Iterator itsub = landenSub.entrySet().iterator();
        while (itsub.hasNext()) {
            System.out.println(itsub.next());            
        }
        
        Map<Cursus, String> cursussen = new TreeMap<Cursus, String>();
        cursussen.put(new Cursus(5, "Word", 100), "Je leert omgaan met een tekstverwerker"); 
        cursussen.put(new Cursus(3, "Excel", 110), "Je leert omgaan met een spreadsheetprogramma"); 
        cursussen.put(new Cursus(1, "Windows", 90), "Je leert omgaan met windows"); 
        cursussen.put(new Cursus(4, "Access", 120), "Je leert omgaan met een databasetoepassing"); 
        cursussen.put(new Cursus(2, "Powerpoint", 80), "Je leert omgaan met een presentatieprogramma"); 
        cursussen.put(new Cursus(6, "PhotoShop", 100), "Je leert omgaan met een fotobewerkingsprogramma");
        System.out.println("***View van de cursussen volgens Keys***");
        Iterator<Cursus> itCursus = cursussen.keySet().iterator();
        while (itCursus.hasNext()) {
            Cursus next = itCursus.next();
            String info = cursussen.get(next);
            System.out.println(next + " heeft als info: \t" + info);
            
        }
    }
    
}
