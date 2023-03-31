package org.depinfo.omnisus;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Gson.class)
public class ConfigJSON {

    @Bean
    public Gson gson() {
        return CustomGson.getIt();
    }

}