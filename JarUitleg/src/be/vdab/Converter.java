/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yannick.thibos
 */
package be.vdab;

public class Converter {

    private final static double CENTIMETERS_IN_ONE_INCH = 2.54;

    public double centimetersToInches(double centimeters) {
        return centimeters / CENTIMETERS_IN_ONE_INCH;
    }
}
