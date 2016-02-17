/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

/**
 * Class Exceptions die thrown kunnen worden bij foute adres input.
 *
 * @author yannick.thibos
 */
public class AdresException extends RuntimeException {

    public AdresException() {
        super();
    }
    
    public AdresException(String message) {
        super(message);
    }
    
    public AdresException(Throwable cause) {
        super(cause);
    }
    
    public AdresException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
