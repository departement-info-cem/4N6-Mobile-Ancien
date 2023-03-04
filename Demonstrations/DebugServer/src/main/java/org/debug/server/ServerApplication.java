	package org.debug.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class ServerApplication {
	public static void main(String[] args) { SpringApplication.run(ServerApplication.class, args); }
}
