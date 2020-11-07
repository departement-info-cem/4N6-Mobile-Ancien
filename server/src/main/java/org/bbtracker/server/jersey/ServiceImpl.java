package org.bbtracker.server.jersey;

import org.bbtracker.server.model.*;
import org.bbtracker.server.transfer.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServiceImpl implements Service {

    @Autowired
    UserRepository repo;

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
        for (int i = 0 ; i < 10 ; i++ ) {
            TestEntity e = new TestEntity();
            e.pipo = "gna   " + i;
            repo.save(e);
            System.out.println("id  "  + e.id);
        }
        for (TestEntity te : repo.findAll()){
            System.out.println("recov from BD " + te.id + "  " + te.pipo);
        }
    }
}