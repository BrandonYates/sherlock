package clue.controllers;

import clue.logic.Game;
import clue.logic.GameBoard;
import clue.logic.GameObject;
import com.google.gson.Gson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public GameController() {
    try {
      factory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
     logger.error("Failed to create sessionFactory object." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  @RequestMapping("/gameobject")
  public GameObject gameObject(@RequestParam(value="label", defaultValue = "default") String label) {
    return new GameObject(String.format(template, label));
  }

  @RequestMapping("/newgame/simple")
  public String newGame(@RequestParam(value="players")String[] players) {

    logger.debug("Creating new game for " + players.length + " player(s)");
    String label = String.valueOf(System.currentTimeMillis());

    Game newGame = new Game(label);
    newGame.makePlayers(players);
    newGame.makeDeck();

    Session session = factory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      session.save(newGame);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      logger.error("an error occurred", e);
    } finally {
      session.close();
    }

    return serializer.toJson(newGame);
  }

  @RequestMapping("/newgame")
  public String newGame(@RequestParam(value="label")String label,
                        @RequestParam(value="players")String[] players) {

    logger.debug("Creating new game labeled: " + label);

    Game newGame = new Game(label);
    newGame.makePlayers(players);

    Session session = factory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      session.save(newGame);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      logger.error("an error occurred", e);
    } finally {
      session.close();
    }

    return serializer.toJson(newGame);
  }

  @RequestMapping("/testBoard")
  public String getTestBoard() {
    GameBoard testBoard = new GameBoard();

    return testBoard.toString();
  }
}
