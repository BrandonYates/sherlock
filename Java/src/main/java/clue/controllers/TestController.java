package clue.controllers;

import byates.game.GameBoard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public static final String baseUrl = "/test";

    @RequestMapping(baseUrl + "/gameboard")
    public String gameBoard() {
        return new GameBoard().toString();
    }
}
