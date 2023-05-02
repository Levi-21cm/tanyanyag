package org.example;

public class kezfertotlenitofalkon implements IAdagolofalkon{

    private double aktualisMennyiseg;
    private double maximalisMennyiseg;
    @Override
    public void feltolt() {
        this.aktualisMennyiseg= maximalisMennyiseg;
    }

    @Override
    public void feltölt(double mennyiseg) {
        if ((this.aktualisMennyiseg + mennyiseg) > this.maximalisMennyiseg){
            throw new IllegalArgumentException("A megadott mennyiséggel a flakon túlcsordul");
        }else      
    }

    @Override
    public void adagol() {

    }

    @Override
    public void adagol(int hanyszor) {

    }

    @Override
    public boolean uresE() {
        return false;
    }

    @Override
    public double aktualisMennyiseg() {
        return 0;
    }

    @Override
    public double getMaximalisMennyiseg() {
        return 0;
    }
}
