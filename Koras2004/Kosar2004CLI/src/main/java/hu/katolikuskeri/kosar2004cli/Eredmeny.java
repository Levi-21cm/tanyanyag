package hu.katolikuskeri.kosar2004cli;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Eredmeny {

    private String hazai;
    private String idegen;
    private int haza_pontok;
    private int idegen_pontok;
    private String helyszin;
    private LocalDate időpont;

    public Eredmeny(String hazai, String idegen, int haza_pontok, int idegen_pontok, String helyszin, LocalDate időpont) {
        this.hazai = hazai;
        this.idegen = idegen;
        this.haza_pontok = haza_pontok;
        this.idegen_pontok = idegen_pontok;
        this.helyszin = helyszin;
        this.időpont = időpont;
    }

    public Eredmeny(String[] adatok) {
        this(adatok[0], adatok[1], Integer.parseInt(adatok[2]), Integer.parseInt(adatok[3]),adatok[4],LocalDate.parse(adatok[5]) );
    }
    public String getHazai() {
        return hazai;
    }

    public String getIdegen() {
        return idegen;
    }

    public int getHaza_pontok() {
        return haza_pontok;
    }

    public int getIdegen_pontok() {
        return idegen_pontok;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public LocalDate getIdőpont() {
        return időpont;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }
    public static ArrayList<Eredmeny> beolvas(String file){
        ArrayList<Eredmeny> eredmeny = new ArrayList<>();

        File fájl = new File(file);

        try {
            Scanner olvaso = new Scanner(fájl, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Eredmeny tmp = new Eredmeny(adatok);
                eredmeny.add(tmp);
            }

            olvaso.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return eredmeny;
    }
}
