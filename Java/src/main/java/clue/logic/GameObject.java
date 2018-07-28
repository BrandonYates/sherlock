package clue.logic;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "OBJECT_TYPE",
    discriminatorType = DiscriminatorType.STRING)
public class GameObject {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id;
    @Column(insertable = false, updatable = false)
    protected String label;

    public GameObject() {
        label = "NOT SET";
    }

    public GameObject(String aLabel) {
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
