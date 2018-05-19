package clue.controllers;

import clue.logic.Game;
import clue.logic.GameObject;

import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GameController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Gson serializer = new Gson();
    private static SessionFactory factory;

    public GameController() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @RequestMapping("/gameobject")
    public GameObject gameObject(@RequestParam(value="label", defaultValue = "default") String label) {
        return new GameObject(String.format(template, label));
    }

    @RequestMapping("/newgame/simple")
    public String newGame(@RequestParam(value="players")String[] players) {

        String label = String.valueOf(System.currentTimeMillis());

        Game newGame = new Game(label);
        newGame.makePlayers(players);
        newGame.makeDeck();
        return serializer.toJson(newGame);
    }

    @RequestMapping("/newgame")
    public String newGame(@RequestParam(value="label")String label,
                          @RequestParam(value="players")String[] players) {

        Game newGame = new Game(label);
        newGame.makePlayers(players);

        return serializer.toJson(newGame);
    }

    @RequestMapping("/getObject")
    public String getObject(@RequestParam(value="id")String id) {

        GameObject tObject = new GameObject("");

        return serializer.toJson(tObject);
    }
}
