package clue.knowledge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SuggestionHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private List<Suggestion> history;

  public SuggestionHistory() {
    history = new ArrayList<>();
  }

  public void addSuggestion(Suggestion aSuggestion) {

    history.add(aSuggestion);
  }

  public void addSuggestions(List<Suggestion> aSuggestion) {
    history.addAll(aSuggestion);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Suggestion> getHistory() {
    return history;
  }

  public void setHistory(List<Suggestion> history) {
    this.history = history;
  }
}
