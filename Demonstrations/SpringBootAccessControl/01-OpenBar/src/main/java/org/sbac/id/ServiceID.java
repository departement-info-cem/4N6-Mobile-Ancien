package org.sbac.id;

import org.sbac.model.MUtilisateur;
import org.sbac.model.DepotUtilisateur;

import org.sbac.transfert.InscriptionReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Component
@Transactional
public class ServiceID  {


    public static class BadCredentials extends Exception { }

    @Autowired private DepotUtilisateur userRepository;

    public void connexion(String nomUtilisateur, String motDePasse) throws BadCredentials {
        String nom = nomUtilisateur.toLowerCase().trim();
        try{
            MUtilisateur u = userRepository.findByNomUtilisateur(nom).get();
            if (!motDePasse.equals(u.motDePasse)) {
                throw new BadCredentials();
            }
        } catch (NoSuchElementException e) {
            throw new BadCredentials();
        }
    }

    public void sinscrire(InscriptionReq req) throws BadCredentials {
        String nom = req.nomUtilisateur.toLowerCase().trim();
        try{
            userRepository.findByNomUtilisateur(nom).get();
            throw new BadCredentials();
        } catch (NoSuchElementException e) {
            MUtilisateur p = new MUtilisateur();
            p.nomUtilisateur = nom;
            p.motDePasse = req.motDePasse;
            userRepository.save(p);
        }
    }
}
