package org.bbtracker.server.service;

import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.exceptions.Existing;
import org.bbtracker.server.model.MBaby;
import org.bbtracker.server.model.MToken;
import org.bbtracker.server.model.MUser;
import org.bbtracker.server.repo.MBabyEventRepository;
import org.bbtracker.server.repo.MBabyRepository;
import org.bbtracker.server.repo.MTokenRepository;
import org.bbtracker.server.repo.MUserRepository;
import org.bbtracker.server.transfer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Component
public class ServiceWithDB implements Service{

    @Autowired MUserRepository repoUser;
    @Autowired MBabyRepository repoBaby;
    @Autowired MBabyEventRepository repoBabyEvent;
    @Autowired MTokenRepository repoToken;

    @Override
    public SigninResponse signup(SignupRequest req) throws BadCredentials {
        // TODO validate username and password
        try{
            repoUser.findByUsername(req.username).get();
            throw new BadCredentials();
        } catch (NoSuchElementException e) {
            MUser p = new MUser();
            p.username = 			req.username.toLowerCase().trim();
            p.password = 		hash(req.password);
            repoUser.save(p);
            SigninRequest r = new SigninRequest();
            r.username = req.username;
            r.password = req.password;
            return signin(r);
        }
    }

    @Override
    public SigninResponse signin(SigninRequest req) throws BadCredentials {
        try{
            MUser user = repoUser.findByUsername(req.username).get();
            byte[] hash = hash(req.password);
            if (!Arrays.equals(hash, user.password)) throw new BadCredentials();
            // All is good create token
            MToken tok = MToken.forUser(user, 5);
            repoToken.save(tok);
            SigninResponse response = new SigninResponse();
            response.token = tok.secret;
            response.username = user.username;
            return response;
        } catch (NoSuchElementException e) {
            throw new BadCredentials();
        }
    }

    @Override
    public void signout(String value) throws BadCredentials {
        MToken token = repoToken.findBySecret(value).get();
        repoToken.delete(token);
    }

    @Override
    public MUser userFromToken(String token) throws BadCredentials {
        try {
            MToken tok = repoToken.findBySecret(token).get();
            if (tok.expirationDate.before(new Date())) throw new BadCredentials();
            MUser user = repoUser.findById(tok.userID).get();
            return user;
        } catch(Exception e) {
            throw new BadCredentials();
        }
    }

    @Override
    public BabyDetailResponse babyDetail(Long id, MUser user) {
        MBaby baby = user.babies.stream().filter(elt -> elt.id == id).findFirst().get();
        BabyDetailResponse response = new BabyDetailResponse();
        response.name = baby.name;
        response.id = baby.id;
        return response;
    }

    @Override
    public void addBaby(AddBabyRequest req) throws Existing {
        // TODO validation
        if (req.name.trim().length() == 0) throw new IllegalArgumentException();
        // Go get user
        MUser user = repoUser.findById(req.ownerId).get();
        // TODO validate no baby with same name
        for (MBaby b : user.babies) {
            if (b.name.toLowerCase().equals(req.name.toLowerCase())) throw new Existing();
        }
        // All is good
        MBaby baby = new MBaby();
        baby.name = req.name;
        repoBaby.save(baby);
        user.babies.add(baby);
        repoUser.save(user);
    }

    @Override
    public List<BabyHomeResponse> home(Long userID) {
        MUser user = repoUser.findById(userID).get();
        List<BabyHomeResponse> res = new ArrayList<>();
        for (MBaby baby : user.babies) {
            BabyHomeResponse r = new BabyHomeResponse();
            r.id = baby.id;
            r.eventsInDay = baby.events.size();
            //r.last = baby.events.get(baby.events.size()-1);
            r.name = baby.name;
            res.add(r);
        }
        return res;
    }

    public static byte[] hash(String s) {
        try{
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256"); // TODO changer pour changer l'algorithme de hash.
            md.update(s.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return digest;
        }
        catch(UnsupportedEncodingException e){throw new Error();}
        catch (NoSuchAlgorithmException e) {throw new Error();}
    }
}
