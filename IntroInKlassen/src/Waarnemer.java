/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Waarnemer {
    private int min, max, avg, n;
    
    public Waarnemer() {
        min = max = avg = 0;
    }
    
    public int getMin() {
        return min;
    }
    
    public int getMax() {
        return max;
    }
    
    public int getAvg() {
        return avg;
    }
    
    public void add(int temp) {
        int x = avg * n++;
        x += temp;
        avg = x / n;
        
        if (temp > max) max = temp;
        if (temp < min) min = temp;
    }
    
}
