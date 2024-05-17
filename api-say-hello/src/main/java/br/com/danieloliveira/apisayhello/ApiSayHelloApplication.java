package br.com.danieloliveira.apisayhello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiSayHelloApplication {
    private static Logger log = LoggerFactory.getLogger(ApiSayHelloApplication.class);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        SpringApplication.run(ApiSayHelloApplication.class, args);
    }

    @GetMapping("/greeting")
    public String greet() {
        log.info("Access /greeting");
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations", "Hw are you?", "Good morning!",
                "Nice to see you", "Nice to meet you");
        int randomNum = RANDOM.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @GetMapping("/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }
}
