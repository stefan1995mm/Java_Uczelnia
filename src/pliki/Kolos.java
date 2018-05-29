package pliki;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kolos {
    public void odczyt(String sciezka){
        try(Scanner skanowanie = new Scanner(new FileInputStream(sciezka))) {
            while(skanowanie.hasNext())
            System.out.println(skanowanie.nextLine());
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }
    }
    public void zapis(String sciezka){

        try(FileWriter plik = new FileWriter(sciezka,true)){
            Scanner zapis = new Scanner(System.in);
            plik.write(zapis.nextLine());
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        Kolos pliki = new Kolos();
        pliki.zapis("plik.txt");
    }
}
