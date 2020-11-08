package org.bbtracker.server.jersey;

import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.model.*;
import org.bbtracker.server.transfer.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServiceImpl implements Service {

    @Autowired
    UserRepository repo;

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
    public void signup(SignupRequest req) {
        // TODO validation
       MUser p = new MUser();
       p.username = 			req.username.toLowerCase().trim();
       p.password = 		hash(req.password);
       p.id = idUser++;
       users.add(p);
    }

    @Override
    public SigninResponse signin(SigninRequest req) throws BadCredentials {
        for (MUser user : users) {
            if (user.username.equals(req.username)) {
                byte[] hash = hash(req.password);
                if (Arrays.equals(hash, user.password)) {
                    SigninResponse response = new SigninResponse();
                    response.userID = user.id;
                    response.username = user.username;
                    return response;
                }
            }
        }
        throw new BadCredentials();
    }

    @Override
    public BabyDetailResponse babyDetail(Long id) {
        return null;
    }

    @Override
    public void addBaby(AddBabyRequest req) {
        System.out.println("Adding baby");
        System.out.println("on trouve ?");
        for (TestEntity e : repo.findByPipo("gna   " + 9)){
            System.out.println("found " + e.id + "  " + e.pipo);
        }
        System.out.println("on ajoute ");
        for (int i = 0 ; i < 10 ; i++ ) {
            TestEntity e = new TestEntity();
            e.pipo = "gna   " + i;
            repo.save(e);
            System.out.println("id  "  + e.id);
        }
        System.out.println("on liste ");
        for (TestEntity te : repo.findAll()){
            System.out.println("recov from BD " + te.id + "  " + te.pipo);
        }
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
        for (Long babyID : user.babiesIDs){
            MBaby b =  findBabyByID(babyID);
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