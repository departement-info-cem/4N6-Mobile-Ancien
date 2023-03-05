package org.sbac.id;

import org.sbac.transfert.ConnexionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebServiceID {

    @Autowired      private AuthenticationManager authManager;
    @Autowired      private ServiceID userService;

    @PostMapping("/api/id/signin")
    public @ResponseBody String signin(@RequestBody ConnexionReq s) throws ServiceID.BadCredentials {
        System.out.println("ID : demande de connexion " + s);
        s.nomUtilisateur = s.nomUtilisateur.trim().toLowerCase();
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(s.nomUtilisateur, s.motDePasse);
            authManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("Logged as " + s.nomUtilisateur);
            return s.nomUtilisateur;
        } catch (BadCredentialsException bce) {
            throw new ServiceID.BadCredentials();
        }
    }

    @PostMapping("/api/id/signup")
    public @ResponseBody String signup(@RequestBody ConnexionReq s) throws ServiceID.BadCredentials {
        System.out.println("ID : demande inscription " + s);
        userService.sinscrire(s);
        return signin(s);
    }

}
