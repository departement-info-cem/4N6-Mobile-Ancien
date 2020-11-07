package org.bbtracker.server.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 15-09-15.
 */
public class MBaby  {

    public Long id;
    public String name;
    public List<MBabyEvent> events = new ArrayList<>();

}
