/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_uczelnia.swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Stefan
 */
public class Przyciski {
    public static void main(String[] args){
        UIManager.LookAndFeelInfo[] style = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo styl: style){
            System.out.println(styl);
        }
       
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ramka ramka1 = new Ramka();
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                  e.printStackTrace();
                }
                Ramka ramka2 = new Ramka();
                ramka1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ramka1.setVisible(true);
                ramka2.setVisible(true);
            }
        });
    }
}
