package org.bbtracker.server;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
public class JerseyComponent extends ResourceConfig {
    public JerseyComponent() {
        packages("org.bbtracker.server.jersey");
    }
}