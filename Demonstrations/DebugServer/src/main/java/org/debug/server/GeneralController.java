package org.debug.server;

import org.debug.server.exception.PipoException;
import org.debug.server.exception.PopiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController {

    private String ingredient = "Fromage";

    @GetMapping("/test")
    public @ResponseBody String test() {
        return "SALUT";
    }

    @GetMapping("/demo")
    public @ResponseBody String[] demo() {
        GrilleInsecte grilleInsecte1 = new GrilleInsecte();
        grilleInsecte1.creerGrille();
        return grilleInsecte1.tranformerGrille1D();
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
        Calculate j = new Calculate();
        j.doStuff();
        return "Success";
    }

    @GetMapping("/req3")
    public @ResponseBody String requeteTrois() {
        System.out.println("REQUETE TROIS ");
        ComptesPayables c = new ComptesPayables();
        try {
            c.calculerSommeTotaleMaximaleDesSalairesAnneeCours();
            c.calculerAncienneté();
            c.calculerMoyenneSalaires();
            c.calculerPrimes();
            c.obtenirListeSalairesPourAnnee2022();
        } catch (Exception e) {
            System.err.println("Erreur dans les calculs");
        }
        return "Success";
    }

}
