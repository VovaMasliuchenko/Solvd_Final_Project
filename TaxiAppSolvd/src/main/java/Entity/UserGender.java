package Entity;

import java.util.Objects;

public class UserGender {

    private int id;
    private String gender;

    public UserGender(){}

    public UserGender(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGender that = (UserGender) o;
        return id == that.id && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender);
    }

    @Override
    public String toString() {
        return "UserGender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
