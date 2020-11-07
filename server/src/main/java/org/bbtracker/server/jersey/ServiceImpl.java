package org.bbtracker.server.jersey;

import org.bbtracker.server.model.*;
import org.bbtracker.server.transfer.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class ServiceImpl implements Service {
    private List<MBaby> babies = new ArrayList<>();
    private List<MUser> users = new ArrayList<>();

   @Override
    public void signup(SignupRequest req) {

    }

    @Override
    public BabyDetailResponse babyDetail(Long id) {
        return null;
    }

    @Override
    public void addBaby(AddBabyRequest req) {
        System.out.println("Adding baby");
    }
}