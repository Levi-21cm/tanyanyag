package com.company;

public class LáncoltLista implements ILancoltLista{
    private final int MERET = 20;//konstans a final
    private ListaElem elso=null;
    private int elemSzam =0;
    @Override
    public boolean elemLétrehozás(int adat) {
        if (elemSzam<MERET){
            
        }
    }

    @Override
    public void listaElemekKiírása() {

    }

    @Override
    public boolean elemTörlése(int adat) {
        return false;
    }

    @Override
    public boolean elemTörléseIndex(int index) {
        return false;
    }
}
