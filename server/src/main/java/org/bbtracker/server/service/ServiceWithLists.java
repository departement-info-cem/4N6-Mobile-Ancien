package org.bbtracker.server.service;

import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.model.*;
import org.bbtracker.server.transfer.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

// TODO décommenter pour remplacer le service avec BD par celui avec des listes
//@Component
public class ServiceWithLists implements Service {

    private List<MBaby> babies = new ArrayList<>();
    private List<MUser> users = new ArrayList<>();
    private long idUser = 1;
    private long idBaby = 1;

    public static byte[] hash(String s) {
        try{
            MessageDigest md;
            md = MessageDigest.getInstance("SHA-256");
            md.update(s.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return digest;
        }
        catch(UnsupportedEncodingException e){throw new Error();}
        catch (NoSuchAlgorithmException e) {throw new Error();}
    }

   @Override
    public SigninResponse signup(SignupRequest req) {
        // TODO validation
       MUser p = new MUser();
       p.username = 			req.username.toLowerCase().trim();
       p.password = 		hash(req.password);
       p.id = idUser++;
       users.add(p);
       return null;
   }

    @Override
    public SigninResponse signin(SigninRequest req) throws BadCredentials {
        for (MUser user : users) {
            if (user.username.equals(req.username)) {
                byte[] hash = hash(req.password);
                if (Arrays.equals(hash, user.password)) {
                    SigninResponse response = new SigninResponse();
                    response.username = user.username;
                    return response;
                }
            }
        }
        throw new BadCredentials();
    }

    @Override
    public void signout(String value) throws BadCredentials {

    }

    @Override
    public MUser userFromToken(String token) throws BadCredentials {
        return null;
    }

    @Override
    public BabyDetailResponse babyDetail(Long id, MUser user) {
        return null;
    }

    @Override
    public void addBaby(AddBabyRequest req) {

    }

    private MUser findUserByID(Long userID) {
       for (MUser u : users) {
           if (u.id == userID) return u;
       }
       return null;
    }

    private MBaby findBabyByID(Long userID) {
        for (MBaby b : babies) {
            if (b.id == userID) return b;
        }
        return null;
    }

    @Override
    public List<BabyHomeResponse> home(Long userID) {
        MUser user = findUserByID(userID);
        List<BabyHomeResponse> babies = new ArrayList<>();
        if (user == null) return babies;
        for (MBaby baby : user.babies){
            MBaby b =  baby;
            BabyHomeResponse elt = new BabyHomeResponse();
            elt.name = b.name;
            elt.id = b.id;
            elt.eventsInDay = numberOfEventsTodayFor(b);
            elt.last = null;  // TODO
            babies.add(elt);
        }
        return babies;
    }

    private int numberOfEventsTodayFor(MBaby b) {
       return new Random().nextInt(5);  // TODO compute for real
    }
}