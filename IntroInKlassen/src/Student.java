/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yannick.thibos
 */
public class Student {
    
    private String naam;
    private int score;
    
    public Student(String naam) {
        this.naam = naam;
        score = 0;
    }
    
    public Student(String naam, int score) {
        this.naam = naam;
        this.score = score;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public String getNaam() {
        return naam;
    }
 
    public void setScore(int a) {
        score = a;
    }
    
    public int getScore() {
        return score;
    }
    
}
