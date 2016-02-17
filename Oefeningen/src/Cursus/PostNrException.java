/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cursus;

/**
 *
 * @author yannick.thibos
 */
public class PostNrException extends Exception {
    private int verkeerdPostNr;
    public PostNrException () {}
    
    public PostNrException(String omschrijving) {
        super(omschrijving);
    }
    
    public PostNrException(String omschrijving, int verkeerdPostNr) {
        super(omschrijving);
        this.verkeerdPostNr = verkeerdPostNr;
    }
    
    public int getVerkeerdPostNr() {
        return verkeerdPostNr;
    }
}
