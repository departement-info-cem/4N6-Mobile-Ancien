package org.bbtracker.server.jersey;


import org.bbtracker.server.transfer.AddBabyRequest;
import org.bbtracker.server.transfer.BabyDetailResponse;
import org.bbtracker.server.transfer.SignupRequest;

public interface Service {

    void signup(SignupRequest req);

    BabyDetailResponse babyDetail(Long id);

    void addBaby(AddBabyRequest req);
}