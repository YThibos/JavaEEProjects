
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class CursusCollection {

    public static void main(String[] args) {
        
        HashSet<Cursus> coll = new HashSet<Cursus>();
        
        coll.add( new Cursus(5, "Word", 100));
        coll.add( new Cursus(3, "Excel", 100));
        coll.add( new Cursus(1, "Windows", 90));
        coll.add( new Cursus(4, "Access", 120));
        coll.add( new Cursus(2, "Powerpoint", 80));
        
        int somPrijs = 0;
        
        Iterator<Cursus> it = coll.iterator();
        
        while (it.hasNext()) {
            Cursus next = it.next();
            somPrijs += next.getPrijs();
            System.out.println(next);
        }
        
        System.out.println("Som van de prijzen: " + somPrijs);
        
    }
    
}
