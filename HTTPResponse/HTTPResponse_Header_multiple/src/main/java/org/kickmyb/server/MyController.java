package org.kickmyb.server;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    //401
    @PostMapping("/ajouterMot")
    public ResponseEntity<java.lang.String> ajouterMot(@RequestBody Map<String, String> json){
        // On map comme on n'a pas de classe de transfert et plus qu'une variable à mettre dans le body
        String token = json.get("token");
        String mot = json.get("mot");

        HttpHeaders responseHeaders = new HttpHeaders();
        if (token == null || token.equals("")) {

            responseHeaders.set("Warning",
                    "199 - STATUS " + HttpStatus.UNAUTHORIZED);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .build();
        }
        System.out.println("Votre mot reçu : " + mot);
        return new ResponseEntity<>("Succès", HttpStatus.ACCEPTED);

    }

    //400
    @PostMapping("/ajouterSalaire")
    public ResponseEntity<java.lang.String> ajouterSalaire(@RequestBody Integer salaire) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (salaire < 0){

            responseHeaders.set("Warning",
                    "199 - La valeur n'est pas valide");

            return ResponseEntity.badRequest()
                    .headers(responseHeaders)
                    .build();
        }
        System.out.println("Salaire ajouté : " + salaire);
        return new ResponseEntity<>("Succès", HttpStatus.ACCEPTED);
    }

    @PostMapping("/remplirFormulaireSolo")
    public @ResponseBody Error remplirFormulaireSolo(@RequestBody MyForm form){
        List<String> usernames = new ArrayList<>();

        /* Liste des erreurs à renvoyer :
            username is empty (400 BadRequest)
            username is taken (409 Conflict)
            password is empty (400 BadRequest)
          */

        //MÉTHODE 1 : Retourner la première uniquement
        Error e = new Error();
        if (form.username == null || form.username.equals("")){
            e.code = HttpStatus.BAD_REQUEST.toString();
            e.message = "USERNAME NOT SET";
        }
        else if (usernames.contains(form.username)){
            e.code = HttpStatus.CONFLICT.toString();
            e.message = "USERNAME IS TAKEN";
        }
        else if (form.password == null || form.password.equals("")){
            e.code = HttpStatus.BAD_REQUEST.toString();
            e.message = "PASSWORD NOT SET";
        }
        return e;
    }

    @PostMapping("/remplirFormulaireMultiple")
    public @ResponseBody List<Error> remplirFormulaireMultiple(@RequestBody MyForm form){
        List<String> usernames = new ArrayList<>();

        /* Liste des erreurs à renvoyer :
            username is empty or null (400 BadRequest)
            username is taken (409 Conflict)
            password is empty (400 BadRequest)
          */

        //MÉTHODE 2 : Retourner toutes les erreurs
        List<Error> errors = new ArrayList<>();
        Error e;
        if (form.username == null || form.username.equals("")){
            e = new Error();
            e.code = HttpStatus.BAD_REQUEST.toString();
            e.message = "USERNAME NOT SET";
            errors.add(e);
        }
        if (usernames.contains(form.username)){
            e = new Error();
            e.code = HttpStatus.CONFLICT.toString();
            e.message = "USERNAME IS TAKEN";
            errors.add(e);
        }
        if (form.password == null || form.password.equals("")){
            e = new Error();
            e.code = HttpStatus.BAD_REQUEST.toString();
            e.message = "PASSWORD NOT SET";
            errors.add(e);
        }
        return errors;
    }

    // Autres méthodes de gestion des erreurs du monde réel : https://agiletribe.wordpress.com/2015/09/16/json-rest-api-exception-handling/
}
