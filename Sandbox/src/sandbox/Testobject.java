/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.Serializable;

/**
 *
 * @author yannick.thibos
 */
public class Testobject implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String data;

    public Testobject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Testobject{" + "data=" + data + '}';
    }
    
    
}
