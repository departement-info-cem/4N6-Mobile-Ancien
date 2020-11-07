package org.bbtracker;


import java.util.ArrayList;
import java.util.List;

import org.bbtracker.model.MBaby;
import org.bbtracker.transfer.AddBabyRequest;
import org.bbtracker.transfer.BabyDetailResponse;
import org.bbtracker.transfer.SignupRequest;
//import org.springframework.stereotype.Component;


//@Component
public class ServiceImpl implements Service {
    private List<MBaby> babies = new ArrayList<>();
    private List<MBaby> users = new ArrayList<>();

   @Override
    public void signup(SignupRequest req) {

    }

    @Override
    public BabyDetailResponse babyDetail(Long id) {
        return null;
    }

    @Override
    public void addBaby(AddBabyRequest req) {

    }
}