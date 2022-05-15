package Entity;

import java.util.Objects;

public class CarOrders {

    private int id;
    private int price;
    private int Cars_Id;
    private int Car_Services_Id;

    CarOrders() {}

    CarOrders(int id, int price, int Cars_Id, int Car_Services_Id) {
        this.id = id;
        this.price = price;
        this.Cars_Id = Cars_Id;
        this.Car_Services_Id = Car_Services_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCars_Id(int cars_Id) {
        Cars_Id = cars_Id;
    }

    public void setCar_Services_Id(int car_Services_Id) {
        Car_Services_Id = car_Services_Id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getCars_Id() {
        return Cars_Id;
    }

    public int getCar_Services_Id() {
        return Car_Services_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOrders carOrders = (CarOrders) o;
        return id == carOrders.id && price == carOrders.price && Cars_Id == carOrders.Cars_Id && Car_Services_Id == carOrders.Car_Services_Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, Cars_Id, Car_Services_Id);
    }

    @Override
    public String toString() {
        return "CarOrders{" +
                "id=" + id +
                ", price=" + price +
                ", Cars_Id=" + Cars_Id +
                ", Car_Services_Id=" + Car_Services_Id +
                '}';
    }
}
