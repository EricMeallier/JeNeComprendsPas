package fr.meallier.keycloak;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Bean
    public MyValue getMyValue() {
        logger.warn("Test Appel getMyValue");
        return new MyValue("Test" + new Random().nextInt());
    }
}
