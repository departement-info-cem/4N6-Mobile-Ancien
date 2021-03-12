package org.debug.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private String ingredient = "Fromage";

    @GetMapping("/test")
    public @ResponseBody String test() {
        return "SALUT";
    }

    @PostMapping("/req1")
    public @ResponseBody String requeteUne(@RequestBody String s){
        ingredient = s;
        System.out.println("REQUETE UNE "+ ingredient  );
        return ingredient;
    }

    @GetMapping("/req2")
    public @ResponseBody String requeteDeux() throws PipoException, PopiException {
        System.out.println("REQUETE DEUX ");
        JaImEPaSLaProGrAMMAtion j = new JaImEPaSLaProGrAMMAtion();
        j.imAFunction();
        return "Success";
    }

    @GetMapping("/req3")
    public @ResponseBody String requeteTrois() {
        System.out.println("REQUETE TROIS ");
        ComptesPayables c = new ComptesPayables();
        try {
            c.calculerSommeTotaleMaximaleDesSalairesAnneeCours();
            c.listeEmployesParAgeEtParAncienneté();
            c.chercherDepartementInformatiqueNombreEmployésParSexeEtVilleNatale();
            c.calculerAncienneté();
            c.calculerMoyenneSalaires();
            c.calculerPrimes();
            c.obtenirListeSalairesPourAnnee2020();
        }catch(Exception e){
            System.err.println("Erreur dans les calculs");
        }
        return "Success";
    }

}
