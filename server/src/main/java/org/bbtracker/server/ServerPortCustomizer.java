package org.bbtracker.server;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    // TODO use this to change the port
    // Also point to SSL config
    public void customize(ConfigurableWebServerFactory factory) {
        Ssl ssl = new Ssl();
        ssl.setKeyPassword("password");
        ssl.setKeyStore("keystore.jks");
        factory.setSsl(ssl);
        factory.setPort(8787);
    }
}