package org.example;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dolgozo {
    private String név;
    private String neme;
    private String részleg;
    private int belepesÉve;
    private int bér;

    public Dolgozo(String név, String neme, String részleg, int belepesÉve, int bér) {
        this.név = név;
        this.neme = neme;
        this.részleg = részleg;
        this.belepesÉve = belepesÉve;
        this.bér = bér;
    }

    public Dolgozo(String név, String neme, String részleg, String belepesÉve, String bér){
        this(név, neme, részleg, Integer.parseInt(belepesÉve), Integer.parseInt(bér));
    }

    public Dolgozo(String[] adatok){
        this(adatok[0], adatok[1], adatok[2], adatok[3], adatok[4]);
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getNeme() {
        return neme;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }

    public String getRészleg() {
        return részleg;
    }

    public void setRészleg(String részleg) {
        this.részleg = részleg;
    }

    public int getBelepesÉve() {
        return belepesÉve;
    }

    public void setBelepesÉve(int belepesÉve) {
        this.belepesÉve = belepesÉve;
    }

    public int getBér() {
        return bér;
    }

    public void setBér(int bér) {
        this.bér = bér;
    }

    //fájl beolvasása: készítsünk egy osztálymetódust amelynek feladata a forrás állomány beolvasása.
    //A metódus paramétere legyen a beolvasandó fájl neve, eredményül egy dolgozókbol álló listát adjon vissza!

    public static ArrayList<Dolgozo> beolvasas(String fájl){
        ArrayList<Dolgozo> dolgozok = new ArrayList<Dolgozo>();

        File fajl = new File(fájl);
        try {
            Scanner olvaso = new Scanner(fajl, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Dolgozo tmp = new Dolgozo(adatok);
                dolgozok.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Fájl beolvasási figyelmeztetés.");
            error.setHeaderText(null);
            error.setContentText("A fájl beolvasásakor hiba történt, ellenőrizze a fájlt.");
            error.show();
        }

        return dolgozok;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)",this.név,this.részleg);
    }
}
