package org.depinfo.omnisus;

import org.depinfo.omnisus.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class ConfigSecurity {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.headers().frameOptions().sameOrigin().and()
                .csrf().disable().cors().and()
                .authorizeRequests()
                    .requestMatchers("/api/id/**").permitAll()
                    .requestMatchers("/api/admin/**").permitAll()
                    .requestMatchers("/api/**").authenticated().and()
                .securityContext(securityContext -> {
                    securityContext.securityContextRepository(new HttpSessionSecurityContextRepository());
                    securityContext.requireExplicitSave(false);
                })
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    void registerProvider(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService);
    }
}