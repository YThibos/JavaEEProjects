package JPFOefeningen;


import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */

class SimpleCalculator {
    
    String expr;
    
    public SimpleCalculator(String expression) {
        this.expr = expression;
    }
    
    public int solve() {
        
        StringTokenizer eq = new StringTokenizer(expr, " ");
        char op = ' ';
        
        System.out.println(expr);
        
        // Onder de veronderstelling dat de expressie juist w/ ingegeven
        // wordt de eerste waarde geinitialiseerd door ze meteen in te lezen.
        int answer = Integer.parseInt(eq.nextToken());
        
        System.out.println(answer);
        
        // Begin de rest in te lezen, eerstvolgende teken is een operator
        boolean operator = true;
        while (eq.hasMoreTokens()) {
            if (operator) {
                
                // Een operator heeft maar 1 teken, lees het in
                op = eq.nextToken().charAt(0);
                
                System.out.println(op);
                
                // Volgende in te lezen teken is een waarde
                operator = false;
                
            } else {
                
                switch (op) {
                    case '+':
                        answer += Integer.parseInt(eq.nextToken());
                        break;
                    case '-':
                        answer -= Integer.parseInt(eq.nextToken());
                        break;
                    case '*':
                        answer *= Integer.parseInt(eq.nextToken());
                        break;
                    case '/':
                        answer /= Integer.parseInt(eq.nextToken());
                        break;
                }
                
                System.out.println(answer);
                
                // Volgende in te lezen teken is een operator
                operator = true;
            }
        }
        
        return answer;
    }
    
    
    
}

public class Oef18 {
    
    public static void main (String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        SimpleCalculator calc = new SimpleCalculator(in.nextLine());
        
        System.out.println("= " + calc.solve());
        
    }
    
}
