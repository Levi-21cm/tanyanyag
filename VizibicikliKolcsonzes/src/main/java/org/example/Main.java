package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Kolcsonzes> kolcsonzes = new ArrayList<Kolcsonzes>();
        File fajl = new File("forras.txt");
        try {
            Scanner olvaso = new Scanner(fajl,"UTF-8");
            olvaso.nextLine();
            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Kolcsonzes seged = new Kolcsonzes();
                seged.Név = adatok[0];
                seged.JAzon = adatok[1].charAt(0);
                seged.EÓra = LocalTime.parse(adatok[2]);
                seged.EPerc = LocalTime.parse(adatok[3]);
                seged.VÓra = LocalTime.parse(adatok[4]);
                seged.VPerc = LocalTime.parse(adatok[5]);

                kolcsonzes.add(seged);
            }


            olvaso.close();
        } catch (FileNotFoundException e) {
            System.out.println("a fájl nem található!");
        }
        System.out.println("5.Feladat: Napi kölcsönzések száma: "+ kolcsonzes.size());
        Scanner konzol = new Scanner(System.in);
        System.out.println("6.Feladat: Kérek egy nevet:");
        String nev = konzol.nextLine();
        for (Kolcsonzes elem: kolcsonzes){
            if (elem.getNév().equals(nev)){
                System.out.println(nev +" kölcsönzései: \n" + elem.getEÓra()+elem.getEPerc()+elem.getVÓra()+elem.getVPerc());
            }
        }
    }
}