package org.bbtracker;

import org.bbtracker.transfer.AddBabyRequest;
import org.bbtracker.transfer.BabyDetailResponse;
import org.bbtracker.transfer.SignupRequest;

import java.util.List;

public interface Service {

    void signup(SignupRequest req);

    BabyDetailResponse babyDetail(Long id);

    void addBaby(AddBabyRequest req);
}