/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

/**
 *
 * @author yannick.thibos
 */
public class Stapel {

    private int aantal;

    public synchronized boolean isNietLeeg() {
        return aantal > 0;
    }

    public synchronized void voegtoe(String wie) {
        //System.out.println(wie + ": " + aantal + " +1");
        ++aantal;

    }

    public synchronized void neemAf(String wie) {
        //System.out.println(wie + ": " + aantal + " -1");
        --aantal;
    }

    public int getAantal() {
        return aantal;
    }

}
