package com.solvd.Entity;

import java.util.Objects;

public class CarServices {

    private int id;
    private String service_name;

    public CarServices(){

    }

    public CarServices(int id, String service_name) {
        this.id = id;
        this.service_name = service_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getId() {
        return id;
    }

    public String getService_name() {
        return service_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarServices that = (CarServices) o;
        return id == that.id && Objects.equals(service_name, that.service_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, service_name);
    }

    @Override
    public String toString() {
        return "CarServices{" +
                "id=" + id +
                ", service_name='" + service_name + '\'' +
                '}';
    }
}
