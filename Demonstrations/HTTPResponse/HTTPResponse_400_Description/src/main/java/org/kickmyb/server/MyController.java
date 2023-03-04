package org.kickmyb.server;

import org.kickmyb.server.exceptions.UnauthorizedException;
import org.kickmyb.server.exceptions.UnhandledException;
import org.kickmyb.server.exceptions.WrongValueException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MyController {

    @PostMapping("/ajouterMot")
    public @ResponseBody String ajouterMot(@RequestBody Map<String, String> json) throws UnauthorizedException {
        // On map comme on n'a pas de classe de transfert et plus qu'une variable à mettre dans le body
        String token = json.get("token");
        String mot = json.get("mot");
        if (token == null || token.equals("")) {
            throw new UnauthorizedException("Vous n'avez pas l'authorisation pour faire cette action");
        }
        System.out.println("Votre mot reçu : " + mot);
        return "Succès";
    }

    @PostMapping("/ajouterSalaire")
    public @ResponseBody void ajouterSalaire(@RequestBody Integer salaire) throws WrongValueException {
        if (salaire < 0){
            throw new WrongValueException("La valeur n'est pas valide");
        }
        System.out.println("Salaire ajouté : " + salaire);
    }

    @GetMapping("/unknown")
    public @ResponseBody void unknown() throws UnhandledException {
            throw new UnhandledException("Le serveur a rencontré une erreur");
    }
}
