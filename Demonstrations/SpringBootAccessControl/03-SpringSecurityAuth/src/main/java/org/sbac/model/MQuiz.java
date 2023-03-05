package org.sbac.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MQuiz {

    @Id     @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Basic
    public String nom;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    public List<MQuestion> questions = new ArrayList<>();

}
