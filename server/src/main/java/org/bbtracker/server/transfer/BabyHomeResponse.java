package org.bbtracker.server.transfer;

import org.bbtracker.server.model.MBabyEvent;

import java.util.UUID;

/**
 * Created by joris on 15-09-15.
 */
public class BabyHomeResponse {

    public String name;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TBabyPlusLast{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", last=").append(last);
        sb.append(", eventsInDay=").append(eventsInDay);
        sb.append('}');
        return sb.toString();
    }

    public Long id;

    public MBabyEvent last;

    public int eventsInDay;

}
