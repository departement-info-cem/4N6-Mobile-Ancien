package org.sbac.id;

import org.sbac.model.MUtilisateur;
import org.sbac.transfert.ConnexionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebServiceID {

    @Autowired      private ServiceID serviceUtilisateur;

    @PostMapping("/api/id/signin")
    public @ResponseBody String signin(@RequestBody ConnexionReq s) throws ServiceID.BadCredentials {
        System.out.println("ID : demande de connexion " + s);
        s.nomUtilisateur = s.nomUtilisateur.trim().toLowerCase();
        serviceUtilisateur.connexion(s.nomUtilisateur, s.motDePasse);
        return s.nomUtilisateur;
    }

    @PostMapping("/api/id/signup")
    public @ResponseBody String signup(@RequestBody ConnexionReq s) throws ServiceID.BadCredentials {
        System.out.println("ID : demande inscription " + s);
        serviceUtilisateur.sinscrire(s);
        return signin(s);
    }

}
