/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author yannick.thibos
 */
public class NewClass {
    
    private int x, y;
    
    public static NewClass createEmptyClass() {
        return new NewClass();
    }
    
    public static NewClass create1x1yClass() {
        NewClass n = new NewClass();
        n.x = n.y = 1;
        return n;
    }
    
    public static void main(String[] args) {
        NewClass dummy = NewClass.createEmptyClass();
    }
}
