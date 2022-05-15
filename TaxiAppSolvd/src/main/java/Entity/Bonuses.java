package Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "Bonuses")
public class Bonuses {

    private int id;
    private String type_bonus;

    public Bonuses() {}

    public Bonuses(int id, String type_bonus) {
        this.id = id;
        this.type_bonus = type_bonus;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setBonuses(String type_bonus) {
        this.type_bonus = type_bonus;
    }

    @XmlAttribute(name = "idBonus")
    public int getId() {
        return id;
    }

    @XmlElement(name = "typeBonus")
    public String getBonuses() {
        return type_bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonuses bonuses = (Bonuses) o;
        return id == bonuses.id && Objects.equals(type_bonus, bonuses.type_bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type_bonus);
    }

    @Override
    public String toString() {
        return "Bonuses{" +
                "id=" + id +
                ", type_bonus='" + type_bonus + '\'' +
                '}';
    }
}
