package banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LittleBankApplication {
    private static final Logger log = LoggerFactory.getLogger(LittleBankApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LittleBankApplication.class);
    }

}
