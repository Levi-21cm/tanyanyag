package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Egésztömbművelet {
    public int[] elembeszuras(int[] eredetiTomb[], int ertek, int index);
    public int compare(int[] elemek,int[] elemek2);
    public int[] copyof(int[] masolniValoTomb , int tombHossza);
    public int[] copyofRange(int[] masolniValoTomb , int kezdoindex,int vegindex);
    public boolean equals(int[] tomb1 , int[] tomb2);
    public String toString(int[] tomb);
    public ArrayList<Integer> asList(int[] tomb);
    public double elemekAtlaga(int[] tomb, int kezdoindex,int végindex);
    public int[] buborekRendezes(int[] tomb);
    public int[] reverse(int[] tomb);

}
