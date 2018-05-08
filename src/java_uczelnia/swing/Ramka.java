/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_uczelnia.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Stefan
 */

public class Ramka extends JFrame{
    private static int szerokosc = 600;
    private static int wysokosc = 400;
    private static final String TYTUL = "Edytor";
    private final int szerokoscEkranu;
    private final int wysokoscEkranu;
    private JPanel panel;
    private JLabel etykieta;
    private JButton przycisk;
    private JTextField tekst;
    public Ramka(){
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
        etykieta = new JLabel();
        etykieta.setText("Przed zmianą");
        panel.add(etykieta);
        przycisk=new JButton("zmiana etykiety");
        tekst = new JTextField();
        tekst.setEnabled(true);
        tekst.setColumns(10);
        przycisk.addActionListener((ActionEvent e) -> {
            etykieta.setText("Po zmianie");
            if(tekst.isEnabled()){
                tekst.setEnabled(false);
                tekst.setBackground(Color.gray);
            }
            else{
                tekst.setEnabled(true);
                tekst.setBackground(Color.white);
            }
        });
        panel.add(przycisk);
        panel.add(tekst);
        add(panel);
    }
}
/*
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               etykieta.setText("Po zmianie");
               if(tekst.isEnabled()){
                   tekst.setEnabled(false);
               }
               else{
                   tekst.setEnabled(true);
               }
            }
        });*/