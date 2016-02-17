/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class RekeningException extends Exception {
    
    private String rekeningNr;
    
    public RekeningException() {}
    
    public RekeningException(String message) {
        super(message);
    }
    
    public RekeningException(String message, String rekeningNr) {
        super(message);
        this.rekeningNr = rekeningNr;
    }
    
    public String getVerkeerdRekeningNr() {
        return rekeningNr;
    }
    
}
