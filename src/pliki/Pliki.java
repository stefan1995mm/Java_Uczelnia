/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pliki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Stefan
 */


public class Pliki {
        void zapis(String plik) throws FileNotFoundException{
        PrintWriter zapis = new PrintWriter(plik);
        Scanner odczyt = new Scanner(System.in);
        String tekst;
        tekst = odczyt.nextLine();
        zapis.println(tekst);
        zapis.close();
    }
    
    void odczyt(String plik) throws FileNotFoundException{
        Scanner odczyt = new Scanner(new File(plik));
        String tekst = odczyt.nextLine();
        System.out.println(tekst);
    }
    
    

    public static void main(String[] argv) throws FileNotFoundException{
      //  File file = new File("ala.txt");
        Pliki test = new Pliki();
        test.zapis("ala.txt");
        test.odczyt("ala.txt");
        

    }
    
}
