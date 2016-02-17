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
public class Gemeente {
    
    private String naam;
    private int postNr;
    
    public Gemeente(String naam, int postNr) throws PostNrException {
        setNaam(naam);
        setPostNr(postNr);
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public void setPostNr(int postNr) throws PostNrException {
        if (postNr < 1000 || postNr > 9999) 
            throw new PostNrException("Ongeldige postcode", postNr);
        this.postNr = postNr;
    }
    
    @Override
    public String toString() {
        return postNr + " " + naam;
    }
    
}
