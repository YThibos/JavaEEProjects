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
public class JPF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long rekNr = 737524091952L;
        int deeltal = (int)rekNr / 100;
        int rest = (int)(deeltal % 97);
        byte controle = (byte)(rekNr % 100);
        
        System.out.println(rest == controle);
        
    }
    
}
