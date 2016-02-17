/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import java.io.PrintStream;

/**
 *
 * @author yannick.thibos
 */
public class Gemiddelden implements Runnable {

    private double[] arr;
    private double avg;
    private int from;
    private int to;
    PrintStream stream;

    public Gemiddelden(double[] arr, int from, int to, PrintStream stream) {
        this.arr = arr;
        this.avg = 0;
        this.from = from;
        this.to = to;
        this.stream = stream;
    }

    @Override
    public void run() {

        double sum = 0;

        for (int i = from; i < to; i++) {
            if (i % 10000 == 0) stream.println(sum + " + " + arr[i]);
            sum += arr[i];
        }

        avg = sum / (to - from + 1);

    }

    public double getAvg() {
        return avg;
    }

}
