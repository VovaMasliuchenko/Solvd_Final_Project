package Entity;

import java.util.Objects;

public class Orders {

    private int id;
    private int price;
    private String start_point;
    private String end_point;
    private int Licenses_Id;
    private int Users_Id;

    Orders() {}

    Orders(int id, int price, String start_point, String end_point, int Licenses_Id, int Users_Id) {
        this.id = id;
        this.price = price;
        this.start_point = start_point;
        this.end_point = end_point;
        this.Licenses_Id = Licenses_Id;
        this.Users_Id = Users_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public void setLicenses_Id(int licenses_Id) {
        Licenses_Id = licenses_Id;
    }

    public void setUsers_Id(int users_Id) {
        Users_Id = users_Id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getStart_point() {
        return start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public int getLicenses_Id() {
        return Licenses_Id;
    }

    public int getUsers_Id() {
        return Users_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && price == orders.price && Licenses_Id == orders.Licenses_Id && Users_Id == orders.Users_Id && Objects.equals(start_point, orders.start_point) && Objects.equals(end_point, orders.end_point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, start_point, end_point, Licenses_Id, Users_Id);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", start_point='" + start_point + '\'' +
                ", end_point='" + end_point + '\'' +
                ", Licenses_Id=" + Licenses_Id +
                ", Users_Id=" + Users_Id +
                '}';
    }
}
