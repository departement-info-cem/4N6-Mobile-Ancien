package org.bbtracker.server.service;


import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.exceptions.Existing;
import org.bbtracker.server.model.MUser;
import org.bbtracker.server.transfer.*;

import java.util.List;

public interface Service {

    // autorisation d'accès
    SigninResponse signup(SignupRequest req) throws BadCredentials;
    SigninResponse signin(SigninRequest req) throws BadCredentials;
    void signout(String value) throws BadCredentials;

    // used for access control
    MUser userFromToken(String token) throws BadCredentials;

    // entity handling
    BabyDetailResponse babyDetail(Long id, MUser user);
    void addBaby(AddBabyRequest req) throws Existing;
    List<BabyHomeResponse> home(Long userID);


}