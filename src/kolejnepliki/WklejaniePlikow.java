package kolejnepliki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WklejaniePlikow {
    public static void main(String[] args) {
        UIManager.LookAndFeelInfo[] style = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo styl: style){
            System.out.println(styl);
        }

        EventQueue.invokeLater(() -> {
            Ramka ramka1 = new Ramka();
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            ramka1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ramka1.setVisible(true);

        });

    }
}

class Ramka extends JFrame {
    private static int szerokosc = 600;
    private static int wysokosc = 400;
    private static final String TYTUL = "Edytor";
    private final int szerokoscEkranu;
    private final int wysokoscEkranu;
    private JPanel panel;
    private JTextArea tekst;
    private JScrollPane skrol;
    private JButton wczytaj;
    private JButton zapisz;
    public Ramka(){
        wczytaj = new JButton("Wczytaj");
        zapisz = new JButton("Zapisz");
        setSize(szerokosc,wysokosc);
        setLocationByPlatform(true);
        setTitle(TYTUL);
        setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension rozmiarEkranu = tk.getScreenSize();
        szerokoscEkranu = rozmiarEkranu.width;
        wysokoscEkranu = rozmiarEkranu.height;
        szerokosc = szerokoscEkranu/2;
        wysokosc = wysokoscEkranu/2;
        setSize(szerokosc,wysokosc);
        panel = new JPanel();
        tekst = new JTextArea();
        tekst.setEnabled(true);
        tekst.setColumns(60);
        tekst.setRows(20);
        skrol = new JScrollPane(tekst);
        skrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        wczytaj.addActionListener(e -> {
            Scanner odczyt = null;
            String kopiowanie = null;
            try {
                odczyt = new Scanner(new File("ala.txt"));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            while(odczyt.hasNext()) {
                kopiowanie += odczyt.nextLine();
                kopiowanie += "\n";
            }
            odczyt.close();
            tekst.append(kopiowanie);
        });
        zapisz.addActionListener(e -> {
            PrintWriter zapis = null;
            try {
                zapis = new PrintWriter("ala2.txt");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            String test = tekst.getText();
            zapis.println(test);
            zapis.close();
        });
        panel.add(zapisz);
        panel.add(wczytaj);
        panel.add(skrol);
        add(panel);
    }
}