package fr.meallier.keycloak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private MyValue myValue;

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping(path = "/remote")
    public String remote(MyRemoteController remoteController) {
        logger.warn(">>>>personController.myValue: {}",myValue.getValue());
        return remoteController.getInfos();
    }
}