/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.FLYNET.vloot;

/**
 *
 * @author yannick.thibos
 */
public class VliegMaatschappijException extends Exception {

    public VliegMaatschappijException() {
        super();
    }
    
    public VliegMaatschappijException(String message) {
        super(message);
    }
    
    public VliegMaatschappijException(Throwable cause) {
        super(cause);
    }
    
    public VliegMaatschappijException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
