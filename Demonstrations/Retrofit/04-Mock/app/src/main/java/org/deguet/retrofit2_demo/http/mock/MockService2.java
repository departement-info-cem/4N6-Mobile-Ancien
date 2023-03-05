package org.deguet.retrofit2_demo.http.mock;

import org.deguet.retrofit2_demo.http.Service2;
import org.deguet.retrofit2_demo.transfer.Utilisateur;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;

public class MockService2 implements Service2 {

    private BehaviorDelegate<Service2> delegate;

    public MockService2(BehaviorDelegate<Service2> delegate){
        this.delegate = delegate;
    }

    @Override
    public Call<Utilisateur> creer(Utilisateur utilisateur) {
        Utilisateur u = new Utilisateur();
        u.id = 12L;
        u.login = "superMock";
        return this.delegate.returningResponse(u).creer(utilisateur);
    }

    @Override
    public Call<List<Utilisateur>> utilisateurs() {
        List<Utilisateur> liste = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            Utilisateur u = new Utilisateur();
            u.id = 1000L + i;
            u.login = "superMock " + i;
            liste.add(u);
        }
        return this.delegate.returningResponse(liste).utilisateurs();
    }
}
