package com.company;

/**
 * Created by Laptop on 2016-05-06.
 */
public class Pracownik {
    private String imię;
    private String nazwisko;
    private double placa;
    private char plec;
    private int dzial;
    public Pracownik(String imię,String nazwisko,double placa,char plec,int dzial){
        this.imię=imię;
        this.nazwisko=nazwisko;
        this.placa=placa;
        this.plec = plec;
        this.dzial=dzial;
    }
    public boolean czyPracujeWDziale(int d){
        if (this.dzial==d)
            return true;
        else
            return false;
    }

    public double getPlaca() {
        return placa;
    }
    public int getDzial() {
        return dzial;
    }

    @Override
    public String toString() {
        return ""+
                ""+imię+
                "     "+nazwisko+
                "  "+plec+
                "  "+dzial+
                "  "+placa+" zł";
    }
}
