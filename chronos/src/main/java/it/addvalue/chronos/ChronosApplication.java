package it.addvalue.chronos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ChronosApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChronosApplication.class, args);
  }
}
