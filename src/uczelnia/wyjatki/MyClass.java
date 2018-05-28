package uczelnia.wyjatki;

import java.util.Scanner;

class MyException extends Exception{
    public MyException(){

    }
    public MyException(String ex){
        super(ex);
    }
}
public class MyClass {
    public static void main(String[] args) {
        try {
            Klasa.method1();
            System.out.println("Pomyslne wykonanie");
        }catch (MyException ex){
            ex.printStackTrace();

        }

    }
}


class Klasa {
    public static void method1() throws MyException{
        System.out.println("");
        Scanner nowy = new Scanner(System.in);
        if(nowy.hasNextInt()){
            System.out.println(nowy.nextInt());
        }else {
            throw new MyException("notatka");
        }
    }
    public static void main(String[] args) {

    }
}