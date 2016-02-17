/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursus;

import java.util.Optional;

/**
 *
 * @author yannick.thibos
 */
public class OptionalDemo {

    private static Optional<Integer> eersteCijfer(String string) {
        
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isDigit(ch)) {
                return Optional.of(Character.getNumericValue(ch));
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<Integer> optioneelCijfer = eersteCijfer("all4you");
        optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
        
        eersteCijfer("geen cijfers hier").ifPresent( cijfer->System.out.println(cijfer * 10) );
    }
    
}
