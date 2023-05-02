package org.example;

public interface IAdagolofalkon {

    public void feltolt(); //feltölti a flakont szinültig
    public void feltölt(double mennyiseg);//feltöli a flakont az adott mennyiséggel

    public void adagol();// egy adaggal csökkenti a falkon tartalmát

    public void adagol(int hanyszor);//megadott számú adagal csökkenti a flakon tartalmát

    public boolean uresE();//megadja hogy a falkon üres e vagy sem

    public double aktualisMennyiseg();

    public double getMaximalisMennyiseg();

}
