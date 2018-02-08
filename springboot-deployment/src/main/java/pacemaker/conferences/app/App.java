package pacemaker.conferences.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("pacemaker.conferences")
@EnableJpaRepositories("pacemaker.conferences.jpa")
@EntityScan("pacemaker.conferences.jpa")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
