package org.bbtracker.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 15-09-15.
 */
@Entity
public class MBaby  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;

    @OneToMany(fetch=FetchType.EAGER)
    public List<MBabyEvent> events = new ArrayList<>();

}
