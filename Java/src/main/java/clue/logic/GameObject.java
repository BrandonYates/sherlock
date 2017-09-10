package clue.logic;

import java.util.UUID;

public class GameObject {

  protected String _id;
  protected String _label;

  public GameObject() {
    _id = UUID.randomUUID().toString();
    _label = "NOT SET";
  }   

  public GameObject(String aLabel) {
    _id = UUID.randomUUID().toString();
    _label = aLabel;
  }

  public GameObject(String id, String label) {
    _id = id;
    _label = label;
  }

  public String getID() {
    return _id; 
  }

  public String getLabel() {
    return _label;
  }
  
  public String toString() {

    return _id + " | " + _label;
  }
}
