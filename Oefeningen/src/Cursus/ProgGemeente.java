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
public class ProgGemeente {

    public static void main(String[] args) {
        try {
            Gemeente eenGemeente = new Gemeente("Ertvelde", 123);
        } catch (PostNrException e) {
            System.out.println(e.getMessage() +
            " " +e.getVerkeerdPostNr());
        } 
    } 
}
