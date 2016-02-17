/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author yannick.thibos
 */
public class SystemProperties {

    public static void main(String[] args) {
        
        try (FileOutputStream fout = new FileOutputStream("C:/data/SystemProperties.txt")) {
           Properties props = System.getProperties();
           props.storeToXML(fout, "comments");
        }
        catch (Exception e) {
            System.out.println(e);
        }
         
        
    }
    
}
