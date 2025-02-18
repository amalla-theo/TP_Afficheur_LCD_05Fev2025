package fr.btsciel;


import fr.btsciel.clavier.In;
import jssc.SerialPortException;

public class Main {
    public static void main(String[] args) throws SerialPortException, InterruptedException {

        AfficheurLCD af = new AfficheurLCD();
        af.listerLesPorts().forEach(System.out::println);
        af.conf("com3");
        af.effacer();
        af.ecrireCentre("AMALLA", (byte)0);



    }
}