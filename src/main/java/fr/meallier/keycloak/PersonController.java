package fr.meallier.keycloak;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping(path = "/hello")
    public String hello() {
        return "hello world";
	}
	
    @GetMapping(path = "/authenticated")
    public String authenticated() {
        return "You are authenticated !";
    }

    @GetMapping(path = "/remote")
    public String remote(MyRemoteController remoteController) {
        logger.warn(">>>>personController>>>>>>>>>>>>>{}",remoteController);
        return remoteController.getInfos();
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You are logged out !";
    }
    
    @GetMapping("/account")
    public AccessToken loadUserDetail(KeycloakAuthenticationToken authentication) {
		SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();	
		return account.getKeycloakSecurityContext().getToken();
	}

}