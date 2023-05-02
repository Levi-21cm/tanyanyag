package org.example;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pilotak {
    private String név;
    private String születési_dátum;
    private String nemzetiség;

    private int rajtszám;

    public Pilotak(String név, String születési_dátum, String nemzetiség, int rajtszám) {
        this.név = név;
        this.születési_dátum = születési_dátum;
        this.nemzetiség = nemzetiség;
        this.rajtszám= rajtszám;
    }

    public Pilotak(String[] adatok) {
        if (adatok.length ==3){
            this.név = adatok[0];
            this.születési_dátum = adatok[1];
            this.nemzetiség = adatok[2];
            this.rajtszám = 0;
        }else {
            this.név = adatok[0];
            this.születési_dátum = adatok[1];
            this.nemzetiség = adatok[2];
            this.rajtszám = Integer.parseInt(adatok[3]);
        }
    }

    public String getNév() {
        return név;
    }

    public String getSzületési_dátum() {
        return születési_dátum;
    }

    public String getNemzetiség() {
        return nemzetiség;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public void setSzületési_dátum(String születési_dátum) {
        this.születési_dátum = születési_dátum;
    }

    public void setNemzetiség(String nemzetiség) {
        this.nemzetiség = nemzetiség;
    }

    public int getRajtszám() {
        return rajtszám;
    }

    public void setRajtszám(int rajtszám) {
        this.rajtszám = rajtszám;
    }

    @Override
    public String toString() {
        return "Pilotak{" +
                "név='" + név + '\'' +
                ", születési_dátum='" + születési_dátum + '\'' +
                ", nemzetiség='" + nemzetiség + '\'' +
                ", rajtszám=" + rajtszám +
                '}';
    }

    public static ArrayList<Pilotak> beolvasas(String fajl){
        ArrayList<Pilotak> pilotak = new ArrayList<Pilotak>();

        File file = new File(fajl);
        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while ((olvaso.hasNextLine())){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Pilotak tmp = new Pilotak(adatok);
                pilotak.add(tmp);
                System.out.println(tmp);
            }
            olvaso.close();
        } catch (FileNotFoundException e) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Fájl beolvasási figyelmeztetés.");
            error.setHeaderText(null);
            error.setContentText("A fájl beolvasásakor hiba történt, ellenőrizze a fájlt.");
            error.show();
        }
        return pilotak;
    }
}
