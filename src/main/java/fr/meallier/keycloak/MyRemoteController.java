package fr.meallier.keycloak;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MyRemoteController {

    private static final Logger logger = LoggerFactory.getLogger(MyRemoteController.class);

    @Autowired
    private KeycloakRestTemplate template;

    @Autowired
    private MyValue myValue;

    private String endpoint="http://localhost:8091/account";

    public String getInfos() {
        logger.warn("Message: >>>>>>>>>>>>>>>>>>>>>>>> {}",myValue);
        // ResponseEntity<String> response = template.getForEntity(endpoint, String.class);
        // return response.getBody();
        return myValue.getValue();
    }
}
