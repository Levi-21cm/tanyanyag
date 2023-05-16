package hu.katolikuskeri.cli;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Dijasok {
    private int Év;
    private String Név;

    private String SzületésHalálozás;
    private String Országkód;
    private int Tol;
    private int Ig;

    public Dijasok(int év, String név, String születésHalálozás, String országkód) {
        Év = év;
        Név = név;
        SzületésHalálozás = születésHalálozás;
        Országkód = országkód;
    }
    public Dijasok(String[] adatok){
        this(Integer.parseInt(adatok[0]),adatok[1],adatok[2], adatok[3]);
    }

    public int getÉv() {
        return Év;
    }

    public void setÉv(int év) {
        Év = év;
    }

    public String getNév() {
        return Név;
    }

    public void setNév(String név) {
        Név = név;
    }

    public String getSzületésHalálozás() {
        return SzületésHalálozás;
    }

    public void setSzületésHalálozás(String születésHalálozás) {
        SzületésHalálozás = születésHalálozás;
    }

    public String getOrszágkód() {
        return Országkód;
    }

    public void setOrszágkód(String országkód) {
        Országkód = országkód;
    }

    public static ArrayList<Dijasok> beolvas(String file){
        ArrayList<Dijasok> dijasoks = new ArrayList<>();

        File fájl = new File(file);

        try {
            Scanner olvaso = new Scanner(fájl, StandardCharsets.UTF_8);

            olvaso.nextLine();
            int otszazsor= 0;

            while ((olvaso.hasNextLine())&&(otszazsor<=500)){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Dijasok tmp = new Dijasok(adatok);
                dijasoks.add(tmp);
                otszazsor++;
            }

            olvaso.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return dijasoks;
    }
//    public int elethosszEvekben() {
//        return Tol == -1 || Ig == -1 ? -1 : Ig - Tol;
//    }
//
//    public Boolean ismertElethossz() {
//        return elethosszEvekben() != -1;
//    }
//
//    public Dijasok(String szuletesHalalozas) {
//        String[] m = szuletesHalalozas.split("-");
//        try {
//            Tol = Integer.parseInt(m[0]);
//        } catch (Exception e) {
//            Tol = -1;
//        }
//        try {
//            Ig = Integer.parseInt(m[1]);
//        } catch (Exception e) {
//            Ig = -1;
//        }
//    }

}
