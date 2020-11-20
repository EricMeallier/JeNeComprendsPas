package fr.meallier.keycloakDemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import fr.meallier.keycloak.KeycloakDemoApplication;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = KeycloakDemoApplication.class)
class KeycloakDemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void smokeTest() {
		assertThat(restTemplate).isNotNull();
	}

	@Test
	public void helloTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
				String.class)).contains("Hello World");
	}

	@Test
	public void remoteTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/remote",
				String.class)).startsWith("Test");
	}

}
