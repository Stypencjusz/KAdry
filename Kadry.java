package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Laptop on 2016-05-06.
 */
public class Kadry implements Serializable {
    private Pracownik[] pracownicy_;
    private int zatrudnienie_ = 0;
    private int maks;

    //              1
    public Kadry() {
        maks = 99;
    }

    //              2
    public void dodajPracownika(Pracownik p) {
        if (zatrudnienie_ > maks) {
            System.out.println("Jest za duzo pracownikow");
        } else {
            pracownicy_[zatrudnienie_] = p;
            zatrudnienie_++;
        }
    }

    //              3
    public void dodajPracownikaInteraktywnie(Pracownik p) {
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj imie");
        String imie = odczyt.nextLine();
        System.out.println("Podaj nazwisko");
        String nazwisko = odczyt.nextLine();
        System.out.println("Podaj płacę");
        int placa = odczyt.nextInt();
        System.out.println("Podaj płeć");
        char płeć = odczyt.nextLine().charAt(0);
        System.out.println("Podaj dzial");
        int dzial = odczyt.nextInt();
        p = new Pracownik(imie, nazwisko, placa, płeć, dzial);
        dodajPracownika(p);
        odczyt.close();
    }

    //              4 Nie dziala
    public Pracownik importujZPlikuTekstowego(String Plik) throws FileNotFoundException {
        Scanner odczyt = new Scanner(new File(Plik)).useDelimiter("/n/r");
        String imie = odczyt.nextLine();
        String nazwisko = odczyt.nextLine();
        int placa = odczyt.nextInt();
        String plec = odczyt.next();
        int dzial = odczyt.nextInt();
        char p = plec.charAt(0);
        return new Pracownik(imie, nazwisko, placa, p, dzial);
    }

    //              5
    public double sredniZarobek() {
        double srednia = 0;
        for (int i = 0; i > zatrudnienie_; i++) {
            srednia += pracownicy_[i].getPlaca();
        }
        return srednia / (zatrudnienie_ + 1);
    }

    //              6
    public double sredniZarobek(int d) {
        double srednia = 0;
        int j = 0;
        for (int i = 0; i > zatrudnienie_; i++) {
            if (d == pracownicy_[i].getDzial()) {
                srednia += pracownicy_[i].getPlaca();
                j++;
            }
        }
        return srednia / j;
    }

    //              7
    public int[] dajDzialy() {
        int[] dzial = new int[zatrudnienie_];
        int licznik = 0;
        for (int i = 0; i > zatrudnienie_; i++) {
            for (int j = 0; j > zatrudnienie_; i++) {
                if (dzial[j] != pracownicy_[i].getDzial()) {
                    dzial[licznik] = pracownicy_[i].getDzial();
                    licznik++;
                }
            }
        }
        return dzial;
    }

    //              8

    //              9
    public void zapiszDoPliku(String Plik, Pracownik p) throws IOException, ClassNotFoundException {
        ObjectOutputStream zapisz = new ObjectOutputStream(new FileOutputStream(Plik));
        zapisz.writeObject(p);
    }

    //              10
    public Pracownik odczytajZPliku(String Plik) throws IOException, ClassNotFoundException {
        ObjectInputStream odczytaj = new ObjectInputStream(new FileInputStream(Plik));
        return (Pracownik) odczytaj.readObject();
    }

}

