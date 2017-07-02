/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */
package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab02 {

    public void start(String[] args) {

        homework();
    }

    public void homework() {

        double prumer = 0;
        double odchylka = 0;
        TextIO textIo = new TextIO();
        int counter = 1;
        int b = 0;
        double[] array = new double[10]; // takhle se inicializuje pole

        String a = textIo.getLine();

        while (!a.equals("")) { //dokud se nerovna prazdny string jed

            if (!TextIO.isDouble(a)) {
                System.err.println("A number has not been parsed from line: " + counter);
            } else {
                array[b] = Double.parseDouble(a); // Double.parseDouble(a) konvertuje string na double
                b++;

            }
            if (b == 10) { // kdyz se rovna 10
                for (int i = 0; i < 10; i++) {
                    prumer += array[i];
                }
                prumer /= 10;
                for (int i = 0; i < 10; i++) {
                    odchylka = Math.pow(array[i] - prumer, 2);
                }
                odchylka = Math.sqrt(odchylka / 10);
                System.out.printf("%d %.3f %.3f/n", 10, prumer, odchylka);
                b = b % 10; // vzdy kdyz prejede 11 vrati pod
                prumer = 0;
                odchylka = 0; // musim nastavit zpet na 0 
            }

            a = textIo.getLine();
            counter++;

        }
        System.out.println("End of input detected!");
        if (b >= 2) {
            for (int i = 0; i < b; i++) {
                prumer += array[i];
            }
            prumer /= b;
            for (int i = 0; i < b; i++) {
                odchylka = Math.pow(array[i] - prumer, 2);
            }
            odchylka = Math.sqrt(odchylka / b);
            System.out.printf("%d %.3f %.3f/n", b, prumer, odchylka);

        }
    }
}

/* end of Lab02.java */
