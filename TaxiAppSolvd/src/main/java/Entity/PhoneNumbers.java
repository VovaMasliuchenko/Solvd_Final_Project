package Entity;

import java.util.Objects;

public class PhoneNumbers {

    private int id;
    private String phone_number;
    private int User_Id;

    PhoneNumbers() {}

    PhoneNumbers(int id, String phone_number, int User_Id) {
        this.id = id;
        this.phone_number = phone_number;
        this.User_Id = User_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getUser_Id() {
        return User_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumbers that = (PhoneNumbers) o;
        return id == that.id && User_Id == that.User_Id && Objects.equals(phone_number, that.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone_number, User_Id);
    }

    @Override
    public String toString() {
        return "PhoneNumbers{" +
                "id=" + id +
                ", phone_number='" + phone_number + '\'' +
                ", User_Id=" + User_Id +
                '}';
    }
}
