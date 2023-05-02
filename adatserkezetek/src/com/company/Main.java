package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> lancolt = new LinkedList<>();
        lancolt.add(15);//elem hozzáadás
        lancolt.add(3);
        lancolt.add(9);
        lancolt.add(22);
        lancolt.add(3,92);
        lancolt.addFirst(26);
        lancolt.addLast(23);
        System.out.println(lancolt.contains(22));//benne van e sé egy igaz hamis érték
        System.out.println(lancolt.get(3));//3as indexet kérr
        System.out.println(lancolt.indexOf(92));//visszaadja az indexét
    }
}
