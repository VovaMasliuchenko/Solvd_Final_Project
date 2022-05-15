package Entity;

import java.util.Objects;

public class UserAddress {

    private int id;
    private String address;

    public UserAddress(){}

    public UserAddress(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAddress that = (UserAddress) o;
        return id == that.id && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
