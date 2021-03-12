package org.debug.server;
import static java.lang.System.out;

public class ComptesPayables {
    private Short salaireHoraire = 45;
    private Byte primeHoraire = 5;
    private int nbJourPaieParSemaine;
    private int nbEmployesCompagnie;
    private float salaireAnnuel;
    private long nbFichiersGeneresParAnnee = 5000000000000000000L;
    private int chiffreAffaire = 999999999;
    private long chiffreAffaireEstime = Long.MAX_VALUE;
    private short multiplicateur = 2;
    private short nbAnnee = 50;
    private short[] ancienneteEmployes = {5,1,0,10};


    public void calculerSalaires(){
        for (int i = 0 ; i < ancienneteEmployes.length; i++){
            out.print(Math.floorDiv(nbAnnee, ancienneteEmployes[i]));
        }
    }

    public void calculerMoyenneSalaires(){
        for (int i = 0 ; i < nbAnnee; i++) {
            chiffreAffaireEstime = Math.addExact(chiffreAffaireEstime, chiffreAffaire);
            chiffreAffaireEstime *= chiffreAffaireEstime;
        }
    }

    public void calculerSommeTotaleMaximaleDesSalairesAnneeCours(){
        double sommeTotale = salaireAnnuel * nbEmployesCompagnie + (salaireHoraire + primeHoraire);
        sommeTotale += nbAnnee - (chiffreAffaireEstime - chiffreAffaire);
        sommeTotale = Math.abs(sommeTotale);
        nbFichiersGeneresParAnnee = (long) sommeTotale;
    }

    public long calculerPrimes(){
        return primeHoraire * nbJourPaieParSemaine * nbEmployesCompagnie + (nbFichiersGeneresParAnnee/multiplicateur);
    }

    public void calculerAncienneté(){
        System.out.println(Math.multiplyExact(chiffreAffaire, multiplicateur));
    }

    public void listeEmployesParAgeEtParAncienneté(){

    }

    public void obtenirListeSalairesPourAnnee2020(){
        short updateNumber = (short) (salaireHoraire + nbAnnee + primeHoraire);
        System.out.println(updateNumber);
    }


    public void chercherDepartementInformatiqueNombreEmployésParSexeEtVilleNatale(){
    }





}
