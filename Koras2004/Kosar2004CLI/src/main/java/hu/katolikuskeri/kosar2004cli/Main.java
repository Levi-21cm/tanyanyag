package hu.katolikuskeri.kosar2004cli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Eredmeny> eredmeny = Eredmeny.beolvas("eredmenyek.csv");
        //eredmeny = Eredmeny.beolvas("eredmenyek.txt");


        int hazaidarab = 0;
        int idegendarab= 0;
    for (Eredmeny elem : eredmeny){
        if (elem.getHazai().equals("Real Madrid")){
            hazaidarab++;
        }
        if (elem.getIdegen().equals("Real Madrid")){
            idegendarab++;
        }
    }
        System.out.println("5.feladat: Real Madrid: Hazai: " +hazaidarab +", Idegen: " + idegendarab);


    boolean voltdontetlen = false;
    for(Eredmeny elem: eredmeny){
        if (elem.getHaza_pontok() == elem.getIdegen_pontok()){
            voltdontetlen=true;
            break;
        }
    }
    if (voltdontetlen){
        System.out.println("6.feladat: Volt döntetlen? igen");
    }else {
        System.out.println("6.feladat: Volt döntetlen? nem");
    }
    System.out.println("7.feladat:");
    for (Eredmeny elem :eredmeny){
        if (elem.getIdőpont().equals(LocalDate.of(2004,11,21))){
            System.out.println("\t   " + elem.getHazai() + "-" + elem.getIdegen()+ " (" +elem.getHaza_pontok() +":" +elem.getIdegen_pontok()+")" );
        }
    }

    HashMap<String,Integer> stadionok = new HashMap<>();
        for (Eredmeny elem : eredmeny) {
            String stadion = elem.getHelyszin();
            if (stadionok.containsKey(stadion)) {
                int meccsekSzama = stadionok.get(stadion);
                stadionok.put(stadion, meccsekSzama + 1);
            } else {
                stadionok.put(stadion, 1);
            }
        }

        System.out.println("8.feladat");
        for (Map.Entry<String, Integer> entry : stadionok.entrySet()) {
            String stadion = entry.getKey();
            int meccsekSzama = entry.getValue();
            if (meccsekSzama > 20) {
                System.out.println("\t   " + stadion + ": " + meccsekSzama );
            }
        }

    }


}