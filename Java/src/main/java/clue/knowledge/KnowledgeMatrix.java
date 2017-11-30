package clue.knowledge;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import clue.logic.Card;
import clue.logic.CardName;
import clue.logic.CardType;
import clue.logic.Character;
import clue.logic.Player;
import clue.logic.Room;
import clue.logic.Weapon;

public class KnowledgeMatrix {

    Player _ownPlayer;
    List<Player> _players;
    Map<String, PlayerKnowledge> _matrix;
    List<CardName> _possibleCharacters;
    List<CardName> _possibleWeapons;
    List<CardName> _possibleRooms;

    Character solutionCharacter = null;
    Weapon solutionWeapon = null;
    Room solutionRoom = null;

    //get the players from the game and set up their knowledge
    //at the beginning of the game we don't know anything about
    //all player knowledge, we will fill it in as the game progresses
    public KnowledgeMatrix(Player aPlayer, List<Player> otherPlayers) {
        _ownPlayer = aPlayer;
        _players = otherPlayers;

        _matrix = new HashMap<>();

        
        for(Player player: _players) {
            _matrix.put(player.getLabel(), new PlayerKnowledge(null));
        }
        _possibleCharacters = new ArrayList<>();
        _possibleWeapons = new ArrayList<>();
        _possibleRooms = new ArrayList<>();
        
        CardName.getCharacterNames().forEach(c -> _possibleCharacters.add(c));
        CardName.getWeaponNames().forEach(w -> _possibleWeapons.add(w));
        CardName.getRoomNames().forEach(r -> _possibleRooms.add(r));


        String tLabel;
        CardType type;
        for(Card card: _ownPlayer.getCards()) {

            tLabel = card.getLabel();
            type = card.getCardType();
            switch (type) {
                case CHARACTER: 
                    _possibleCharacters.remove(tLabel);
                    break;
                case WEAPON:
                    _possibleWeapons.remove(tLabel);
                    break;
                case ROOM:
                    _possibleRooms.remove(tLabel);              
                    break;   
            }
        }
       
    }

    public void updateMatrix() {

        // for(CardName name: CardName.values())
        //     int numKnown = 0;
        //     int numNotHas = 0;
        //     for(Player player; _players) {
        //         PlayerKnowledge knowledgeSet = _matrix.get(player.getLabel());
        //         if(knowledgeSet.knowledgeState(_cardNames[i]) == Info.HAS) {
        //             ++numKnown;
        //         }
        //         if(knowledgeSet.knowledgeState(_cardNames[i]) == Info.HASNOT) {
        //             ++numNotHas;
        //         }
        //     }

        //     if(numNotHas == _players.size()) {
        //         if()
        //     }
        // }
    }
}