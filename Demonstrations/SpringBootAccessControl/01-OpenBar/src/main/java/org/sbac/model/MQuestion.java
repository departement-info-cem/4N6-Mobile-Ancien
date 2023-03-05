package org.sbac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MQuestion {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id     public Long id;
    public String contenu;
    public Date date;

}
