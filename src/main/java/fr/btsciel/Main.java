package fr.btsciel;



public class Main {
    public static void main(String[] args){

        AfficheurLCD af = new AfficheurLCD();
        af.listerLesPorts().forEach(System.out::println);

    }

}