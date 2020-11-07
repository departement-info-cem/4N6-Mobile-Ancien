package org.bbtracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by joris on 15-09-15.
 */
public class MUser {

    public Long id;
    public String email;
    public byte[] password;

    public List<Long> babiesIDs = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MUser{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", babiesIDs=").append(babiesIDs);
        sb.append('}');
        return sb.toString();
    }
}
