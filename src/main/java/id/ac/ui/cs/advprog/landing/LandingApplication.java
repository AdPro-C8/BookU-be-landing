package id.ac.ui.cs.advprog.landing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class LandingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandingApplication.class, args);
    }

}
