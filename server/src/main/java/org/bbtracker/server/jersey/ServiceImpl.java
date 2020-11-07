package org.bbtracker.server.jersey;

import org.aspectj.weaver.ast.Test;
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
}