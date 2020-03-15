package velin.project.atelje117;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
public class Atelje117Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelje117Application.class, args);
    }

}
