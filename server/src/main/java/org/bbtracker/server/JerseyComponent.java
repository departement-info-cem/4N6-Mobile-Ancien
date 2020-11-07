package org.bbtracker.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api/*")                              // TODO change to fix the prefix for all services, remove if none
public class JerseyComponent extends ResourceConfig {
    public JerseyComponent() {
        packages("org.bbtracker.server.jersey");        // TODO change if you change your package name
    }
}
