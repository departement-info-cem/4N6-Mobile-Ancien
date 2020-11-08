package org.bbtracker.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

// Ce composant permet à Spring d'intégrer les éléments de Jersey
// Chaque service de Jersey et lui même détecter via une annotation

@Component
@ApplicationPath("/api/*")                              // TODO change to fix the prefix for all services, remove if none
public class JerseyComponent extends ResourceConfig {
    public JerseyComponent() {
        packages("org.bbtracker.server.jersey");        // TODO change if you change your package name
    }
}
