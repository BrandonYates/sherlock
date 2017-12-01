package clue.knowledge;

import java.util.ArrayList;
import java.util.List;

public class SuggestionHistory {

    private List<Suggestion> history;
    private String gameId;

    public SuggestionHistory(String aGameId) {
        gameId = aGameId;
        history = new ArrayList<>();
    }

    public String getGameId() {
        return gameId;
    }

    public void addSuggestion(Suggestion aSuggestion) {

        history.add(aSuggestion);
    }
}
