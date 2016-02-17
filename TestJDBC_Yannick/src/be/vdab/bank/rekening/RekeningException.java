/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.bank.rekening;

/**
 *
 * @author yannick.thibos
 */
public class RekeningException extends Exception {
    
    public RekeningException() {
        super();
    }
    
    public RekeningException(String message) {
        super(message);
    }
    
    public RekeningException(Throwable cause) {
        super(cause);
    }
    
    public RekeningException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
