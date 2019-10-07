package com.nugge;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DecimalFormat dec = new DecimalFormat("#.00");
        System.out.println("TeMpErAtUrANALySaToRn 9001");
        // tar in arrayn med temperatures metoden //
        double[] temp = temperatures();
        // Menyn börjar här //
        int choice = 0;
        while (choice != 7) {
            System.out.println("Vad vill du göra nu?\n 1. Visa Max \n 2. Visa Min \n 3. Visa medelvärde \n 4. Visa medianvärde \n 5. Visa standardavvikelse \n 6. Starta om. \n 7. Avsluta");
            choice = inputi();
            if (choice == 1) {
                System.out.println("Max temperatur är: " + dec.format(getMax(temp)));
            } else if (choice == 2) {
                System.out.println("Min temperatur är: " + dec.format(getMin(temp)));
            } else if (choice == 3) {
                System.out.println("Medel temperatur är: " + dec.format(getAvg(temp)));
            } else if (choice == 4) {
                System.out.println("Median temperatur är: " + dec.format(getMedi(temp)));
            } else if (choice == 5) {
                System.out.println("Standard avvikelsen är: " + dec.format(getSTD(temp)));
            } else if (choice == 6) {
                temp = temperatures();
            }
        }
    }

    private static double[] temperatures() {
        // läser in n mängd tal i arrayn, (filtrering på temperaturer som uppnåtts på jorden) och sorterar dem med arrays.sort //
        System.out.println("Hur många temperaturer vill du mata in?");
        double[] temps = new double[inputi()];
        for (int i = 0; i < temps.length; i++) {
            System.out.println("Ange temperaturvärde " + (i + 1) + ": ");
            double intoarr = inputd();
            if (intoarr < -88 || intoarr > 59) {
                System.out.println("De ha nu alder vari sådandär temperatur!");
                i--;
            } else {
                temps[i] = intoarr;
            }
        }
        Arrays.sort(temps);
        return temps;
    }

    private static double getMax(double[] temp) {
        //returnerar högsta  värdet från arrayn som vi redan sorterade i slutet av temperatures metoden //
        return temp[temp.length - 1];
    }

    private static double getMin(double[] temp) {
        //returnerar lägsta värdet från arrayn som vi redan sorterade i slutet av temperatures metoden //
        return temp[0];
    }

    private static double getAvg(double[] temp) {
        // Lägger ihop alla tal i arrayn till total och returnerar total/ mängden tal i arrayn //
        double total = 0;
        for (double v : temp) {
            total += v;
        }
        return total / temp.length;
    }

    private static double getMedi(double[] temp) {

        // Kollar ifall det finns jämnt eller udda tal i arrayn och skriver ut median temperatur baserat på det.
        if (temp.length % 2 == 0) {
            return (((temp[(temp.length / 2) - 1]) + (temp[(temp.length / 2)])) / 2);
        } else {
            return temp[temp.length / 2];
        }
    }

    private static double getSTD(double[] temp) {
        // räknar först ut totalen  på alla tal i temp arrayn och sedan medeltalet för att sen räkna standard avvikelsen //  
        double total = 0;
        for (double v : temp) {
            total += v;
        }
        double avg = total / temp.length;

        double std1 = 0;
        for (double v : temp) {
            std1 += (v - avg) * (v - avg);
        }
        return Math.sqrt((std1 / temp.length));

    }

    // input scanner för integer värden // 
    private static double inputd() {
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    // input scanner för double värden // 
    private static int inputi() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}

