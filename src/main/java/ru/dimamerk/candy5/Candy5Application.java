package ru.dimamerk.candy5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dimamerk.candy5.service.EaterService;

@SpringBootApplication
public class Candy5Application implements CommandLineRunner {

    final EaterService eaterService;

    public Candy5Application(EaterService eaterService) {
        this.eaterService = eaterService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Candy5Application.class, args);
    }

    @Override
    public void run(String... args) {
        eaterService.start();
    }

}
