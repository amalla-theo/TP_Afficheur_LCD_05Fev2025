package fr.btsciel;

import fr.btsciel.clavier.In;
import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AfficheurLCD extends LiaisonSerie {

    public void conf(String leCom)throws SerialPortException{
        super.initCom(leCom);
        initialiserAfficheur();
    }

    void initialiserAfficheur() throws SerialPortException {
        super.configurerParametres(19200,8,0,1);
    }




    public void ecrireClavier() throws InterruptedException {
        System.out.println("Que voulez-vous ecrire ?");
        super.ecrire((byte)0xA2);
        super.ecrire(In.readString().getBytes(StandardCharsets.US_ASCII));
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }

    public void ecrireAstier() throws InterruptedException {
        super.ecrire((byte)0xA2);
        super.ecrire("Astier".getBytes(StandardCharsets.UTF_8));
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }

    public void ligne2() throws InterruptedException {
        super.ecrire((byte)0xA1);
        super.ecrire((byte)0x00);
        super.ecrire((byte)0x01);
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }
    public void ligne3() throws InterruptedException {
        super.ecrire((byte)0xA1);
        super.ecrire((byte)0x00);
        super.ecrire((byte)0x02);
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }
    public void ligne4() throws InterruptedException {
        super.ecrire((byte)0xA1);
        super.ecrire((byte)0x00);
        super.ecrire((byte)0x03);
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }

    public void effacer() throws InterruptedException {
        super.ecrire((byte)0xA3);
        super.ecrire((byte)0x01);
        super.ecrire((byte)0x00);
        Thread.sleep(2);
    }


    public ArrayList<String> listerLesPorts() {
        System.out.println("je passe");
        return super.listerLesPorts();
    }
}
