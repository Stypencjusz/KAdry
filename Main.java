package com.company;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException, ClassNotFoundException {
	// write your code here
        Kadry Kadry1 = new Kadry();
        boolean a;
        Pracownik Janek = new Pracownik("jan","kowalski",1000,'M',1);
        System.out.println(Janek);
        Kadry1.zapiszDoPliku("plik12.txt",Janek);
    }
}
