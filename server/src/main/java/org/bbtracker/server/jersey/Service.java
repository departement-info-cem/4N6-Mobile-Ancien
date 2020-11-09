package org.bbtracker.server.jersey;


import org.bbtracker.server.exceptions.BadCredentials;
import org.bbtracker.server.exceptions.Existing;
import org.bbtracker.server.transfer.*;

import java.util.List;

public interface Service {

    void signup(SignupRequest req) throws BadCredentials;
    SigninResponse signin(SigninRequest req) throws BadCredentials;

    BabyDetailResponse babyDetail(Long id);

    void addBaby(AddBabyRequest req) throws Existing;

    List<BabyHomeResponse> home(Long userID);
}