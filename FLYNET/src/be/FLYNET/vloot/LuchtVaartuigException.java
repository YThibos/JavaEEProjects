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
public class LuchtVaartuigException extends Throwable {

    LuchtVaartuigException() {
        super();
    }
    
    LuchtVaartuigException(String message) {
        super(message);
    }
    
    LuchtVaartuigException(Throwable cause) {
        super(cause);
    }

    LuchtVaartuigException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
