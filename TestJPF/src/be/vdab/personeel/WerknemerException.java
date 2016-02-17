/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.personeel;

/**
 *
 * @author yannick.thibos
 */
public class WerknemerException extends Exception {

    WerknemerException() {
        super();
    }
       
    WerknemerException(String message) {
        super(message);
    }
    
    WerknemerException(Throwable cause) {
        super(cause);
    }
    
    WerknemerException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
