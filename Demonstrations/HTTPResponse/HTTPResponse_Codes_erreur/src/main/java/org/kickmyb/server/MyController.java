package org.kickmyb.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MyController {

    //TODO : Aller voir dans le README.md et trouver la description des codes

    //401
    @PostMapping("/ajouterMot")
    public ResponseEntity<java.lang.String> ajouterMot(@RequestBody Map<String, String> json){
        // On map comme on n'a pas de classe de transfert et plus qu'une variable à mettre dans le body
        String token = json.get("token");
        String mot = json.get("mot");
        if (token == null || token.equals("")) {
            return new ResponseEntity<>( "Vous n'avez pas l'authorisation pour faire cette action", HttpStatus.UNAUTHORIZED);
        }
        System.out.println("Votre mot reçu : " + mot);
        return new ResponseEntity<>("Succès", HttpStatus.ACCEPTED);
    }

    //400
    @PostMapping("/ajouterSalaire")
    public ResponseEntity<java.lang.String> ajouterSalaire(@RequestBody Integer salaire) {
        if (salaire < 0){
            return new ResponseEntity<>( "La valeur n'est pas valide", HttpStatus.BAD_REQUEST);
        }
        System.out.println("Salaire ajouté : " + salaire);
        return new ResponseEntity<>("Succès", HttpStatus.ACCEPTED);
    }

    //500
    @GetMapping("/unknown")
    public ResponseEntity<java.lang.String>  unknown(){
        return new ResponseEntity<>( "Le serveur a rencontré une erreur", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
