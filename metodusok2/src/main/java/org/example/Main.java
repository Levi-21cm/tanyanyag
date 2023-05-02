package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(osszegSzamitas(new  int[] {4,6,3,8,2}));
        System.out.println(legkisebbSzamitas(new int[] {5,1,7,9,3}));

    }
    public static double terulet(int r){
        return 3.14 * r * r;
    }

    public static int osszegSzamitas(int[] szamok){
        if (szamok==null){
            throw new IllegalArgumentException();
        }
        if (szamok.length==0){
            throw new IllegalArgumentException();
        }

        int osszeg=0;
        for (int i =0;i < szamok.length;i++){
            osszeg += szamok[i];
        }
        return osszeg;
    }
    public static int legkisebbSzamitas(int[] szamok){
        int min=szamok[0];
        for (int i =0;i < szamok.length;i++){
            if (szamok[i]<min)
                min = szamok[i];
        }
        return min;
    }

}