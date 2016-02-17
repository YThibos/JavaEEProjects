/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

/**
 *
 * @author yannick.thibos
 */
public class ReadWriteObjects {

    public static void main(String[] args) {

        Testobject o1 = new Testobject("String 1");
        Testobject o2 = new Testobject("String 2");
        Testobject o3 = new Testobject("String 3");
        Testobject o4 = new Testobject("String 4");
        Testobject o5 = new Testobject("String 5");

        try {
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("Testobjects.dat"));

            oout.writeObject(o1);
            oout.writeObject(o2);
            oout.writeObject(o3);
            oout.writeObject(o4);
            oout.writeObject(o5); 
            oout.writeObject((int)100);
            oout.flush();
            oout.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Testobjects.dat"));

            boolean done = false;

            while (!done) {
                Object object = null;
                try {
                    System.out.println("**Object read**");
                    object = oin.readObject();
                } catch (EOFException eofe) {
                    System.out.println("**Done reading: eof**");
                    done = true;
                } catch (OptionalDataException ode) {
                    // ode.eof = true 
                    System.out.println("**Done reading: ode");
                    done = ode.eof;
                }

                if (object != null) {
                    if (object instanceof Testobject) {
                        System.out.println(((Testobject) object).getData());
                    } 
                    // int wordt bij het wegschrijven in een Integer wrapper gestoken!
                    else if (object instanceof Integer) {
                        System.out.println("Integer: " + object);
                    }
                    else {
                        System.out.println(object);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
