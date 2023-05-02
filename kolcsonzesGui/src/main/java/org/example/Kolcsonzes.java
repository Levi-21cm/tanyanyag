package org.example;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kolcsonzes {
    private String Név;
    private char JAzon;
    private LocalTime EÓra;
    private LocalTime EPerc;
    private LocalTime VÓra;
    private LocalTime VPerc;

    public Kolcsonzes(String név, char JAzon, LocalTime EÓra, LocalTime EPerc, LocalTime VÓra, LocalTime VPerc) {
        Név = név;
        this.JAzon = JAzon;
        this.EÓra = EÓra;
        this.EPerc = EPerc;
        this.VÓra = VÓra;
        this.VPerc = VPerc;
    }
    public Kolcsonzes(String[] adatok){
        this(adatok[0], adatok[1].charAt(0), LocalTime.parse(adatok[2]), LocalTime.parse(adatok[3]), LocalTime.parse(adatok[4]),LocalTime.parse(adatok[5]));
    }

    public String getNév() {
        return Név;
    }

    public void setNév(String név) {
        Név = név;
    }

    public char getJAzon() {
        return JAzon;
    }

    public void setJAzon(char JAzon) {
        this.JAzon = JAzon;
    }

    public LocalTime getEÓra() {
        return EÓra;
    }

    public void setEÓra(LocalTime EÓra) {
        this.EÓra = EÓra;
    }

    public LocalTime getEPerc() {
        return EPerc;
    }

    public void setEPerc(LocalTime EPerc) {
        this.EPerc = EPerc;
    }

    public LocalTime getVÓra() {
        return VÓra;
    }

    public void setVÓra(LocalTime VÓra) {
        this.VÓra = VÓra;
    }

    public LocalTime getVPerc() {
        return VPerc;
    }

    public void setVPerc(LocalTime VPerc) {
        this.VPerc = VPerc;
    }
    public static ArrayList<Kolcsonzes> beolvasas(String fájl){
        ArrayList<Kolcsonzes> kolcsonzes = new ArrayList<Kolcsonzes>();

        File fajl = new File(fájl);
        try {
            Scanner olvaso = new Scanner(fajl, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Kolcsonzes tmp = new Kolcsonzes(adatok);
                kolcsonzes.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Fájl beolvasási figyelmeztetés.");
            error.setHeaderText(null);
            error.setContentText("A fájl beolvasásakor hiba történt, ellenőrizze a fájlt.");
            error.show();
        }

        return kolcsonzes;
    }
}
