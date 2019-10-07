package com.nugge;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        System.out.println("TeMpErAtUrANALySaToRn 9001");
        double temp[] = temperatures();

        for(int i= 0; i<temp.length; i++){

            System.out.println("Temp " +(i+1) +": ");
        }

    }
    private static double[] temperatures(){
        System.out.println("Hur många temperaturer vill du mata in?");
        double[] temps = new double[inputi()];
        for(int i = 0; i<temps.length;i++){
            System.out.println("Ange temperaturvärde "+ (i+1) + ": ");
            double intoarr = inputd();
            if (intoarr < -51 || intoarr > 60) {
                System.out.println("De ha nu alder vari sådandär temperatur!");
                i--;
            } else {
                temps[i] = intoarr;
        }}
        return temps;
    }


    private static double inputd(){
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }
    private static  int inputi(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

}

