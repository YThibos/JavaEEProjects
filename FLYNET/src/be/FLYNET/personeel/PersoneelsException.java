/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.personeel;

/**
 * Class exceptions die thrown kunnen worden bij foute input bij Personeel.
 * 
 * @author yannick.thibos
 */
public class PersoneelsException extends Exception {
    
    public PersoneelsException() {
        super();
    }
    
    public PersoneelsException(String message) {
        super(message);
    }

    public PersoneelsException(Throwable cause) {
        super(cause);
    }
    
    public PersoneelsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
