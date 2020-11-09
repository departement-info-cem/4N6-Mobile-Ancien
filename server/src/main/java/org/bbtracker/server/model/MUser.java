package org.bbtracker.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 15-09-15.
 */

@Entity
public class MUser {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id     public Long id;
    @Basic  public String username;
    @Basic  public byte[] password;

    @OneToMany(fetch=FetchType.EAGER)
    public List<MBaby> babies = new ArrayList<>();

}
