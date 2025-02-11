package fr.btsciel;


import jssc.SerialPortException;

public class Main {
    public static void main(String[] args) throws SerialPortException, InterruptedException {

        AfficheurLCD af = new AfficheurLCD();
        af.listerLesPorts().forEach(System.out::println);

        af.conf("com3");


        af.effacer();
        af.ecrireClavier();


    }

}