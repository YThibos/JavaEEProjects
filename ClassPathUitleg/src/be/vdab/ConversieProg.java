package be.vdab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yannick.thibos
 */
public class ConversieProg {

    public static void main(String[] args) {
        Converter converter = new Converter();
        for (int centimeters = 1; centimeters <= 10; centimeters++) {
            System.out.println(centimeters + " cm = " + converter.centimetersToInches(centimeters) + " inches");
        }
    }
}
