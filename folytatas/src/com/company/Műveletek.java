package com.company;

import java.util.ArrayList;

public class Műveletek implements Egésztömbművelet{
    @Override
    public int[] elembeszuras(int[][] eredetiTomb, int ertek, int index) {
        int[] ujtomb = new int[eredetiTomb.length+1];
        for (int i =0; i<index;i++){
            ujtomb[i] =eredetiTomb[i];
        }
        ujtomb[index]=ertek;
        for (int i = index +1; i<eredetiTomb.length +1;i++){
            ujtomb[i] = eredetiTomb[i-1];
        }
        return ujtomb;
    }

    @Override
    public int compare(int[] elemek, int[] elemek2) {
        if (elemek.length>elemek2.length){
            return 1;
        }
        else if(elemek.length<elemek2.length){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public int[] copyof(int[] masolniValoTomb, int tombHossza) {
        int[] ujtomb = new int[tombHossza];

        if (tombHossza<masolniValoTomb.length){
            for (int i = 0;i<tombHossza;i++){
                ujtomb[i]=masolniValoTomb[i];
            }
        }else if (tombHossza==masolniValoTomb.length){
            for (int i = 0;i<masolniValoTomb.length;i++){
                ujtomb[i]=masolniValoTomb[i];
            }
        }else {
            for (int i = 0;i<tombHossza;i++){
                ujtomb[i]=masolniValoTomb[i];
            }
            for (int i = tombHossza;i<masolniValoTomb.length;i++){
                ujtomb[i]=-1;
            }
        }
    }

    @Override
    public int[] copyofRange(int[] masolniValoTomb, int kezdoindex, int vegindex) {
        return new int[0];
    }

    @Override
    public boolean equals(int[] tomb1, int[] tomb2) {
    }

    @Override
    public String toString(int[] tomb) {
        String szoveg = "";

        for (int i = 0; i < tomb.length; i++){
            if (i ==(tomb.length)){
                szoveg += tomb[i];
            }else {
                szoveg += tomb[i] + "; ";
            }

    }
        return szoveg;
    }


    @Override
    public ArrayList<Integer> asList(int[] tomb) {
        ArrayList<Integer> asList =new ArrayList<Integer>();

        for (int i = 0;i<tomb.length;i++){
            asList.add(tomb[i]);
        }

        return null;
    }

    @Override
    public double elemekAtlaga(int[] tomb, int kezdoindex, int végindex) {
        if (végindex>= tomb.length){
            throw new IllegalArgumentException("nagyobbat adtál meg mint kellett");
        }
        if (végindex <= 0 || kezdoindex<= 0){
            throw new IllegalArgumentException("nem lehet nulla alatti");
        }
        if (kezdoindex>végindex){
            int seged = kezdoindex;
            kezdoindex=végindex;
            végindex=seged;
        }
        if (kezdoindex==végindex){
            return tomb[kezdoindex];
        }
        double elemekosszes=0;
        for (int i = kezdoindex;i<=végindex;i++){
            elemekosszes+= tomb[i];
        }
        return elemekosszes/(végindex-kezdoindex +1);
    }

    @Override
    public int[] buborekRendezes(int[] tomb) {
        for (int i = tomb.length-1;i>0;i++){
            for (int j = 0;j<i;j++){
                if (tomb[j]>tomb[j+1]){
                    int seged= tomb[j];
                    tomb[j] =tomb[j+1];
                    tomb[j+1]=seged;
                }
            }
        }
        return tomb;
    }

    @Override
    public int[] reverse(int[] tomb) {
        int[] masiktomb= new int[tomb.length];
        int seged=0;
        for (int i = tomb.length-1;i>=0;i--){
            masiktomb[seged] = tomb[i];
            seged++;
        }
        return masiktomb;
    }
}
