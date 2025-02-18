package fr.btsciel;

import fr.btsciel.clavier.In;
import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class AfficheurLCD extends LiaisonSerie {

    private final int Vitesse = 19200;
    private final int Data = 8;
    private final int Parity = 0;
    private final int Stop = 1;
    private final byte CODE_DEBUT_ECRITURE = ((byte) 0xA2);
    private final byte CODE_FIN_ECRITURE = ((byte) 0x00);
    private final byte CODE_DEPLACEMENT = ((byte) 0xA1);
    final byte COLONNE_0 = ((byte) 0x00);

    public void conf(String leCom) throws SerialPortException {
        super.initCom(leCom);
        initialiserAfficheur();
    }



    void initialiserAfficheur() {
        super.configurerParametres(Vitesse, Data, Parity, Stop);
    }


    public void deplacerCurseur(byte colonne, byte ligne) throws InterruptedException {
        super.ecrire(CODE_DEPLACEMENT);
        super.ecrire(colonne);
        super.ecrire(ligne);
        Thread.sleep(2);
    }


    public void ecrire(String texteAEcrire) throws InterruptedException {
        byte ligne = 0;
        super.ecrire(CODE_DEBUT_ECRITURE);
        for (int i = 0; i < texteAEcrire.length(); i++) {
            super.ecrire((byte) texteAEcrire.charAt(i));
            if ((i + 1) % 20 == 0) {
                super.ecrire(CODE_FIN_ECRITURE);
                deplacerCurseur(COLONNE_0, ++ligne);
                super.ecrire(CODE_DEBUT_ECRITURE);
            }
        }
        super.ecrire(CODE_FIN_ECRITURE);
    }



    public void ecrireCentre(String nom, byte centre) throws InterruptedException {
        centre = (byte)((20 - nom.length())/2);
        super.ecrire(CODE_DEBUT_ECRITURE);
        deplacerCurseur(centre, (byte)0);
        for (int i = 0; i < nom.length(); i++) {
            super.ecrire((byte) nom.charAt(i));
        }
        super.ecrire(CODE_FIN_ECRITURE);
    }



        public void effacer() throws InterruptedException {
            super.ecrire((byte) 0xA3);
            super.ecrire((byte) 0x01);
            Thread.sleep(2);
        }


        public ArrayList<String> listerLesPorts() {
            System.out.println("je passe");
            return super.listerLesPorts();
        }

    }

