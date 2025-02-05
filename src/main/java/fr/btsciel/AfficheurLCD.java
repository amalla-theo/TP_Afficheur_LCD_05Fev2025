package fr.btsciel;

import jssc.SerialPortException;

import java.util.ArrayList;

public class AfficheurLCD extends LiaisonSerie {

    public void conf(String leCom)throws SerialPortException{
        super.initCom(leCom);
        super.configurerParametres(19200,8,0,1);
    }


    public ArrayList<String> listerLesPorts() {
        System.out.println("je passe");
        return super.listerLesPorts();
    }
}
