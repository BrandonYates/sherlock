package clue.logic;

import javax.persistence.*;

//@Entity
////@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(
//    name = "OBJECT_TYPE",
//    discriminatorType = DiscriminatorType.STRING)
@MappedSuperclass
public class GameObject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  protected long id;
  @Column(insertable = false, updatable = false)
  protected String label;

  public GameObject() {
    label = "NOT SET";
  }

  public GameObject(String aLabel) {
    label = aLabel;
  }

  public GameObject(long id, String label) {
    this.id = id;
    this.label = label;
  }

  public long getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String toString() {

    return id + " | " + label;
  }
}
