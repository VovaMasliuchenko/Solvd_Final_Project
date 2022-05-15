package Entity;

import java.util.Objects;

public class Users {

    private int id;
    private String name;
    private String lastname;
    private String email;
    private int age;
    private int User_Gender_Id;
    private int User_Address_Id;
    private int Bonuses_Id;

    public Users() {}

    Users(int id, String name, String lastname, String email, int age, int User_Gender_Id, int User_Address_Id, int Bonuses_Id) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.User_Gender_Id = User_Gender_Id;
        this.User_Address_Id = User_Address_Id;
        this.Bonuses_Id = Bonuses_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUser_Gender_Id(int user_Gender_Id) {
        User_Gender_Id = user_Gender_Id;
    }

    public void setUser_Address_Id(int user_Address_Id) {
        User_Address_Id = user_Address_Id;
    }

    public void setBonuses_Id(int bonuses_Id) {
        Bonuses_Id = bonuses_Id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getUser_Gender_Id() {
        return User_Gender_Id;
    }

    public int getUser_Address_Id() {
        return User_Address_Id;
    }

    public int getBonuses_Id() {
        return Bonuses_Id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && age == users.age && User_Gender_Id == users.User_Gender_Id && User_Address_Id == users.User_Address_Id && Bonuses_Id == users.Bonuses_Id && Objects.equals(name, users.name) && Objects.equals(lastname, users.lastname) && Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, email, age, User_Gender_Id, User_Address_Id, Bonuses_Id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", User_Gender_Id=" + User_Gender_Id +
                ", User_Address_Id=" + User_Address_Id +
                ", Bonuses_Id=" + Bonuses_Id +
                '}';
    }
}
