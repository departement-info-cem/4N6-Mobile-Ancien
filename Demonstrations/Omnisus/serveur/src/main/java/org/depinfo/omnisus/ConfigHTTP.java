package org.depinfo.omnisus;

import org.depinfo.omnisus.admin.AdminMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigHTTP implements WebMvcConfigurer {
    @Autowired
    AdminMiddleware adminMiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminMiddleware);
    }
}