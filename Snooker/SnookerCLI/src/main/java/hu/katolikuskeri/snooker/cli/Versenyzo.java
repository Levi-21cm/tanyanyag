package hu.katolikuskeri.snooker.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Versenyzo {
    private int Helyezes;
    private String Nev;
    private String Orszag;
    private int Nyeremeny;

    public Versenyzo(int helyezes, String nev, String orszag, int nyeremeny) {
        Helyezes = helyezes;
        Nev = nev;
        Orszag = orszag;
        Nyeremeny = nyeremeny;
    }
    private Versenyzo(String[] adatok){
        this(Integer.parseInt(adatok[0]),adatok[1],adatok[2],Integer.parseInt(adatok[3]) );
    }

    public int getHelyezes() {
        return Helyezes;
    }

    public void setHelyezes(int helyezes) {
        Helyezes = helyezes;
    }

    public String getNev() {
        return Nev;
    }

    public void setNev(String nev) {
        Nev = nev;
    }

    public String getOrszag() {
        return Orszag;
    }

    public void setOrszag(String orszag) {
        Orszag = orszag;
    }

    public int getNyeremeny() {
        return Nyeremeny;
    }

    public void setNyeremeny(int nyeremeny) {
        Nyeremeny = nyeremeny;
    }
    public static ArrayList<Versenyzo> beolvas(String forras){
        ArrayList<Versenyzo> versenyzok = new ArrayList<>();
        try {
            Scanner olvas = new Scanner(new File(forras),"UTF-8");

            olvas.nextLine();
            while (olvas.hasNextLine()){
                String sor =olvas.nextLine();
                String[] adatok = sor.split(";");
                Versenyzo tmp = new Versenyzo(adatok);
                versenyzok.add(tmp);
            }


            olvas.close();
        } catch (FileNotFoundException e) {
            System.out.println("a megadott forrásáálomény nem található!");
        }
        return versenyzok;
    }
}
