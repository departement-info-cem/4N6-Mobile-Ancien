package org.depinfo.omnisus.user;

import jakarta.persistence.*;
import org.depinfo.omnisus.grade.MGrade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;

    @Column(unique = true)
    public String username;

    @Basic
    public String password;

    public String publicName;

    @OneToMany(fetch= FetchType.EAGER, mappedBy = "user")
    public List<MGrade> grades = new ArrayList<>();
}
