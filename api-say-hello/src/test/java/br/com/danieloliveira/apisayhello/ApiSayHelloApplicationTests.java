package br.com.danieloliveira.apisayhello;

import static org.assertj.core.api.BDDAssertions.then;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ApiSayHelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ApiSayHelloApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturn200WhenSendingRequestToRoot() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody()).isEqualTo("Hi!");
    }

    @Test
    void shouldReturn200WhenSendingRequestToGreeting() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("http://localhost:" + port + "/greeting",
                String.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody()).isNotEmpty();
    }
}
