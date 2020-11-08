package org.bbtracker.server.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joris on 15-09-15.
 */

public class MUser {

    public Long id;
    public String username;
    public byte[] password;

    public List<Long> babiesIDs = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MUser{");
        sb.append("email='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", babiesIDs=").append(babiesIDs);
        sb.append('}');
        return sb.toString();
    }
}
