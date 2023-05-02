package hu.katolikuskeri.keri14c.cl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kolcsonzes {
    private String név;
    private char járműAzonosító;
    private LocalTime elvitelIdeje;
    private LocalTime visszatérésIdeje;

    public Kolcsonzes(String név, char azonosító, int eÓra, int ePerc, int vÓra, int vPerc) {
        this.név = név;
        this.járműAzonosító = azonosító;
        this.elvitelIdeje = LocalTime.of(eÓra, ePerc);
        this.visszatérésIdeje = LocalTime.of(vÓra, vPerc);
    }

    @Override
    public String toString() {
        if (this.elvitelIdeje.getMinute() < 10) {
            return String.format("%s (0%d:%d)", this.név, this.elvitelIdeje.getHour(), this.elvitelIdeje.getMinute());
        }else {
            return String.format("%s (%d:%d)", this.név, this.elvitelIdeje.getHour(), this.elvitelIdeje.getMinute());
        }

    }
    public static ArrayList<Kolcsonzes> beolvas(String fájlelérés) throws FileNotFoundException {//ha ideírjuk ezt akkor nem kell a try catch

        ArrayList<Kolcsonzes> kölcsönzések = new ArrayList<>();

        Scanner olvasó = new Scanner(new File(fájlelérés),"UTF-8");



        olvasó.nextLine();
        while (olvasó.hasNextLine()){
            String sor = olvasó.nextLine();
            String[] adatok = sor.split(";");
            kölcsönzések.add(new Kolcsonzes(adatok[0],adatok[1].charAt(0),Integer.parseInt(adatok[2]),Integer.parseInt(adatok[3]),Integer.parseInt(adatok[4]),Integer.parseInt(adatok[5])));
        }

        return kölcsönzések;
    }
}
