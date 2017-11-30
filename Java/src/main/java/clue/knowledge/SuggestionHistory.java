package clue.knowledge;

import java.util.ArrayList;
import java.util.List;

public class SuggestionHistory {

    private List<Suggestion> history;
    private int gameId;

    public SuggestionHistory(int aGameId) {
        gameId = aGameId;
        history = new ArrayList<>();
    }

    public int getGameId() {
        return gameId;
    }

    public void addSuggestion(Suggestion aSuggestion) {

        history.add(aSuggestion);
    }
}
