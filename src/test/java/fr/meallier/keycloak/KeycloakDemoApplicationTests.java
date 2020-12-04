package fr.meallier.keycloak;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest. WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = KeycloakDemoApplication.class)
class KeycloakDemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MyRemoteController myRemoteController;

	@Test
	void smokeTest() {
		assertThat(this.restTemplate).isNotNull();
		assertThat(this.myRemoteController).isNotNull();
	}

	@Test
	public void helloTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hello",
				String.class)).contains("hello world");
	}

	@Test
	public void remoteTest() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/remote",
				String.class)).startsWith("Test");
	}


	@Test
	public void remoteControllerTest() throws Exception {
		assertThat(this.myRemoteController.getInfos()).startsWith("Test");
	}

}
