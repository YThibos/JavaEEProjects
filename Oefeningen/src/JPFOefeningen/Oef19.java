package JPFOefeningen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Palindroom {
    
    private String str;
    
    public Palindroom (String expression) {
        str = expression;
    }
    
    public boolean isPalindroom() {
                
        StringBuffer rev = new StringBuffer(str);
        rev.reverse();
        
        // System.out.println(rev + " & " + str);
        return str.equals(rev.toString());
    }
    
    @Override
    public String toString () {
        return str.toString();
    }
    
}

/**
 *
 * @author yannick.thibos
 */
public class Oef19 {
    
    public static void main (String[] args) {
 
        Palindroom p1 = new Palindroom("abcdcba");
        Palindroom p2 = new Palindroom("");
        Palindroom p3 = new Palindroom("1112");
        Palindroom p4 = new Palindroom("fhdkjqlfhjqd");
        Palindroom p5 = new Palindroom("--aa--");
        Palindroom p6 = new Palindroom("AaBbCccCbBaA");
        
        System.out.print(p1 + " :: "); System.out.println(p1.isPalindroom());
        System.out.print(p2 + " :: "); System.out.println(p2.isPalindroom());
        System.out.print(p3 + " :: "); System.out.println(p3.isPalindroom());
        System.out.print(p4 + " :: "); System.out.println(p4.isPalindroom());
        System.out.print(p5 + " :: "); System.out.println(p5.isPalindroom());
        System.out.print(p6 + " :: "); System.out.println(p6.isPalindroom());
        
        
    }
    
}
