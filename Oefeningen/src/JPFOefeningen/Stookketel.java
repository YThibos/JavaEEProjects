/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPFOefeningen;

/**
 *
 * @author yannick.thibos
 */
public class Stookketel implements Vervuiler {

    private float CONorm;
    
    public Stookketel (float CONorm) {
        this.CONorm = CONorm;
    }
    
    public void setCONorm(float CONorm) {
        this.CONorm = CONorm;
    }
    
    public float getCONorm() {
        return CONorm;
    }
    
    @Override
    public double geefVervuiling() {
        return CONorm * 100;
    }
    
}
