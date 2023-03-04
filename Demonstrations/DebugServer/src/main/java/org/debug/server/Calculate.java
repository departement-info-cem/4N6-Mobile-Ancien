package org.debug.server;

import org.debug.server.exception.PipoException;
import org.debug.server.exception.PopiException;

import java.util.Date;

public class Calculate {

    private String highlySecretValue = "5";
    String resultat = "Resultat";
    public void doStuff() throws PipoException, PopiException {
        try {
            int nombre = 89;
            luckyNumber(nombre);
            fixValPorto(nombre/2);
            fixValDumbo();
            fixValGino();
            calculateResult();
        } catch (Exception e){
            throw new PopiException("Erreur très grave", e);
        }
    }

    String chiffre = null;
    private void luckyNumber(int nombre) {
        int total = 0;
        for (int i = 1 ; i < 1000 ; i++){
            total += ((i+1) / (i % nombre));
        }
        System.out.println("TOTAL" + total);
    }

    private void fixValPorto(int age){
        Date today = new Date();
        highlySecretValue = today.toString();
        int value = (int) (new Date().getTime()/1000);
        if (age > 18 && today != null && value != 0){
            highlySecretValue += age;
        }
        highlySecretValue = resultat + highlySecretValue;
        resultat = chiffre;
        highlySecretValue = "5";
    }

    private void fixValDumbo(){
        for(int i = 0 ; i < 55; i ++){
            highlySecretValue = "Note : " + i;
        }
        highlySecretValue = resultat;
    }

    private void fixValGino(){
        Integer secretAlsoValue = Integer.parseInt(highlySecretValue.trim());
        secretAlsoValue *= 5;
        highlySecretValue = Integer.toString(secretAlsoValue);
    }

    public void calculateResult(){
        highlySecretValue = chiffre;
        resultat += " 2022 - Officiel";
        System.out.println(Math.pow(Integer.parseInt(highlySecretValue)*10, 2));
    }
}
