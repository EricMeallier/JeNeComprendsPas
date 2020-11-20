package fr.meallier.keycloak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRemoteController {

    private static final Logger logger = LoggerFactory.getLogger(MyRemoteController.class);

    @Autowired
    private MyValue myValue;

    public String getInfos() {
        logger.warn(">>>>myRemoteController.myValue: {}",myValue);
        return myValue.getValue();
    }
}
