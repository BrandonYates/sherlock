package clue.logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class KnowledgeMatrix {

    List<Player> _players;
    List<String> _cardNames;
    Map<String, PlayerKnowledge> _matrix;

    //get the players from the game and set up their knowledge
    //at the beginning of the game we don't know anything about
    //all player knowledge, we will fill it in as the game progresses
    public KnowledgeMatrix(List<Player> players) {
        _players = players;

        _matrix = new HashMap<>();

        for(Player player: _players) {
            _matrix.put(player.getLabel(), new PlayerKnowledge(null));
        }
    }
}