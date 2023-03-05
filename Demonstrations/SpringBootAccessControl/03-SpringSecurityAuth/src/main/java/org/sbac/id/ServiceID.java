package org.sbac.id;

import org.sbac.model.MUtilisateur;
import org.sbac.model.DepotUtilisateur;

import org.sbac.transfert.InscriptionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Component
@Transactional
public class ServiceID implements UserDetailsService {

    public static class BadCredentials extends Exception { }

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private DepotUtilisateur userRepository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        MUtilisateur utilisateur = userRepository.findByNomUtilisateur(nom.trim().toLowerCase()).get();
        User u = new User(utilisateur.nomUtilisateur, utilisateur.motDePasse, new ArrayList<>());
        return u;
    }


    public void sinscrire(InscriptionReq req) throws BadCredentials {
        String nom = req.nomUtilisateur.toLowerCase().trim();
        try{
            userRepository.findByNomUtilisateur(nom).get();
            throw new BadCredentials();
        } catch (NoSuchElementException e) {
            MUtilisateur p = new MUtilisateur();
            p.nomUtilisateur = nom;
            p.motDePasse = passwordEncoder.encode(req.motDePasse);
            userRepository.save(p);
        }
    }
}
