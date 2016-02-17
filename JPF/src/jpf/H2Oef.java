/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpf;

/**
 *
 * @author yannick.thibos
 */
public class H2Oef {
    
    public static void main (String args[]) {
        
        // Oef1
        System.out.println("OEF1\n");
        byte b = 127;
        short sh = 30001;
        long lo = 999999999999999999L;
        char ch = 'X';
        String str = "Hello world";
        boolean bool = true;
        
        System.out.println("byte: " + b + "\nshort: " + sh
                    + "\nlong: " + lo + "\nchar: " + ch
                    + "\nstring: " + str + "\nboolean" + bool);
        
        // Oef2
        System.out.println("\nOEF2");
        int punt1 = 8, punt2 = 6, punt3 = 9, punt4 = 4;
        int som = punt1+punt2+punt3+punt4;
        double gemiddelde = (som) / 4;
        double percent = (som / 40) * 100;
        System.out.println("Gemiddelde: " + gemiddelde);
        System.out.println("Behaalde percentage: " + percent); 
        
        // Oef3
        System.out.println("\nOEF3");
        int aankoopEur = 1;
        int aankoopCent = 27;
        int terugEur = 1 - aankoopEur;
        int terugCent = 100 - aankoopCent; 
        System.out.println("Op aankoop " + aankoopEur + "." + aankoopCent + "EUR: ");
        System.out.println(terugEur + "." + terugCent + "EUR terug.");
        System.out.println(terugEur % 1 + " x 1EUR");
        System.out.println(terugCent / 50 + " x 50 cent");
        terugCent %= 50;
        System.out.println(terugCent / 20 + " x 20 cent");
        terugCent %= 20;
        System.out.println(terugCent / 10 + " x 10 cent");
        terugCent %= 10;
        System.out.println(terugCent / 5 + " x 5 cent");
        terugCent %= 5;
        System.out.println(terugCent / 2 + " x 2 cent");
        terugCent %= 2;
        System.out.println(terugCent / 1 + " x 1 cent");
        
        // Oef4
        System.out.println("\nOEF4");
        int aantalsec = 5924;
        int h, m, s;
        h = aantalsec / 3600;
        aantalsec %= 3600;
        m = aantalsec / 60;
        s = aantalsec % 60;
        System.out.println(aantalsec + "s = " + h + "h" + m + "m" + s + "s");
        
    }
    
}
