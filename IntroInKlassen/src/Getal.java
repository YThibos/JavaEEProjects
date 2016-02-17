/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Getal {
 
    private int x;
    
    public Getal (int a) {
        x = a;
    }
    
    public void setX(int a) {
        x = a;
    }
    
    public int getX() {
        return x;
    }
    
    public double toDouble() {
        return x;
    }
    
    public void print() {
        System.out.print(x);
    }
    
    public int absoluut() {
        return (x >= 0) ? x : -x;
    }
    
    public int som(int a) {
        return x + a;
    }
    
    public float som(float a) {
        return x += a;
    }
    
    public double som(double a) {
        return x += a;
    }
    
    public void add(int a) {
        x += a;
    }
    
}
