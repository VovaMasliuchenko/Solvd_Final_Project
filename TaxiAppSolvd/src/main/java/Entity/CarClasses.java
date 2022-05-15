package Entity;

import java.util.Objects;

public class CarClasses {

    private int id;
    private String car_class;

    public CarClasses(){}

    public CarClasses(int id, String car_class) {
        this.id = id;
        this.car_class = car_class;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public int getId() {
        return id;
    }

    public String getCar_class() {
        return car_class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarClasses that = (CarClasses) o;
        return id == that.id && Objects.equals(car_class, that.car_class);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car_class);
    }

    @Override
    public String toString() {
        return "CarClasses{" +
                "id=" + id +
                ", car_class='" + car_class + '\'' +
                '}';
    }
}
