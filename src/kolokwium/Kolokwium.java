package kolokwium;

import java.io.FileWriter;
import java.io.IOException;

public class Kolokwium {
    public void zapis(String sciezka){
        String liczba = null;
        Double cyfra = 0.0;
        try(FileWriter plik = new FileWriter(sciezka,false)){
            plik.write(cyfra.toString());

        }catch (IOException ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        Kolokwium kolos = new Kolokwium();
        kolos.zapis("liczby/double.txt");
    }
}
