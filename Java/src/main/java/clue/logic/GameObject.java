package clue.logic;

import java.util.UUID;

public class GameObject {

  protected String id;
  protected String label;

  public GameObject() {
    id = UUID.randomUUID().toString();
    label = "NOT SET";
  }   

  public GameObject(String aLabel) {
    id = UUID.randomUUID().toString();
    label = aLabel;
  }

  public GameObject(String id, String label) {
    this.id = id;
    this.label = label;
  }

  public String getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String toString() {

    return id + " | " + label;
  }
}
