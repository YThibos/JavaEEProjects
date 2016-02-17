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
public class Strings {
    
    public static void main(String[] args) {
        
        String str1 = "abcd";
        String str2 = new String("abcd");
        
        System.out.println(str1 + " " + str2);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        String str3 = str1.concat("!!!!");
        System.out.println(str1 + " " + str2);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        
    }
    
}
