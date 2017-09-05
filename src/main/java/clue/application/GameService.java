package clue.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"clue.controllers","clue.logic"})
public class GameService {

    public static void main(String[] args) {
        System.out.println("##################");
        System.out.println("##################");
        System.out.println("##     MAIN     ##");
        System.out.println("##################");
        System.out.println("##################");
        SpringApplication.run(GameService.class, args);
    }
}
