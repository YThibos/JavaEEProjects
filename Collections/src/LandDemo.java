
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class LandDemo {
    
    public static void main (String[] args) {
        
        ArrayList al = new ArrayList(11);
        
        double avg = 0.0;
        int n = 0;
        
        al.add(new Land("BE", "Belgie", "Brussel", 10574595, 30510));
        al.add(new Land("Alb", "Albanie", "Tirana", 3600523, 28748));
        al.add(new Land("AU", "Oostenrijk", "Wenen", 8469929, 83858));
        al.add(new Land("Ar", "Armenie", "Jerevan", 3029900, 29800));
        al.add(new Land("LI", "Litouwen", "Vilnius", 3401138, 65200));
        al.add(new Land("YS", "Ijsland", "Reykjavik", 304261, 103000));
        al.add(new Land("bla", "blaland", "blastad", 1000000, 50000));
        al.add(new Land("bli", "bliland", "blistad", 2000000, 50000));
        al.add(new Land("ble", "bleland", "blestad", 4000000, 50000));
        al.add(new Land("blo", "bloland", "blostad", 100000000, 50000));
        
        for (Object object : al) {
            System.out.println(((Land)object).getNaam() + " " + String.format("%.2f",((Land)object).bevolkingsdichtheid()));
            avg += ((Land)object).bevolkingsdichtheid();
            n++;
        }
        
        System.out.println(String.format("%.3f", avg) + "/" + n);
        avg /= n;
        System.out.println("Gemiddelde: " + String.format("%.2f", avg));
        
        Land closeToAvg;
        
        int closest = 0;
        
        for (int i = 0; i < al.size(); i++) {
            Object object = al.get(i);
            if ((Math.abs(((Land)object).bevolkingsdichtheid() - avg)) < 
                    Math.abs(((Land)al.get(closest)).bevolkingsdichtheid() - avg)) {
                closest = i;
            }
        }
        
        Land closeAvgLand = (Land)al.get(closest);
        System.out.println("Land dichtste bij gemiddelde: " + closeAvgLand.getNaam());
        
        
    }
    
}
