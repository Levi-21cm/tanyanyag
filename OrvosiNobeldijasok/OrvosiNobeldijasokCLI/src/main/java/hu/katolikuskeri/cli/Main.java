package hu.katolikuskeri.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dijasok> dijasoks = Dijasok.beolvas("orvosi_nobeldijak.txt");
        System.out.println("3. feladat: Dijazottak száma: " + dijasoks.size() + " fő");
        int max = 0;
        for (Dijasok elem: dijasoks){
            if (elem.getÉv()>max){
                max= elem.getÉv();
            }
        }
        System.out.println("4. feladat: Utolsó év: " + max);


        System.out.println("5. feladat: Kérem adja meg egy ország kódját: ");
        Scanner konzol = new Scanner(System.in);
        String orszagkodBeker = konzol.next();
        Dijasok bekert = dijasoks.get(0);
        int bekertindex= 0;
        int szamlalo = 0;

        for (int i = 0; i < dijasoks.size();i++){
            if (dijasoks.get(i).getOrszágkód().equals(orszagkodBeker)){
                szamlalo++;
                bekertindex = i ;
            }
        }
        if (szamlalo==1){
            System.out.println("\t\tA megadott ország díjazottja:");
            System.out.println("\t\tNév: "+ dijasoks.get(bekertindex).getNév());
            System.out.println("\t\tÉv: "+ dijasoks.get(bekertindex).getÉv());
            System.out.println("\t\tSz/H: "+ dijasoks.get(bekertindex).getSzületésHalálozás());

        }
        else {
            System.out.println("A megadott országból "+ szamlalo+ " fő díjazott volt!");
        }
        HashMap<String,Integer> statisztika = new HashMap<>();
        for (Dijasok elem : dijasoks){
            String orszagkod = elem.getOrszágkód();
            if (statisztika.containsKey(orszagkod)){
                int szam = statisztika.get(orszagkod);
                statisztika.put(orszagkod,szam+1);
            }else {
                statisztika.put(orszagkod,1);
            }
        }
        System.out.println("6. Statisztika");
        for (String orszag: statisztika.keySet()){
            int díjazottakSzama = statisztika.get(orszag);
            if (díjazottakSzama > 5) {
                System.out.println("\t\t"+orszag + ": " + díjazottakSzama);
            }
        }

//        for (Dijasok elem: dijasoks){
//            if (elem.getOrszágkód().equals(orszagkodBeker)){
//                szamlalo++;
//            }
//        }
    }
}