package models;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Alias {
  public String name;

  @Id
  @SequenceGenerator(name = "ID_GEN", sequenceName = "ID_GEN")
  @GeneratedValue(strategy = SEQUENCE, generator = "ID_GEN")
  public int id;

  public String toString() {
    return name + " => " + id;
  }

}
