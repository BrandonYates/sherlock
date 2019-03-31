package clue.application;

import byates.game.GameObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public GameObject gameObject(@RequestParam(value="label", defaultValue = "default") String label) {
        return new GameObject(String.format(template, label));
    }

    @RequestMapping("/example")
    public String example() {
        return "HELLO WORLD!";
    }
}
