package com.solvd.Entity;

import java.util.Objects;

public class Cars {

    private int id;
    private String model;
    private int year;
    private int Users_Id;
    private int Car_Class_Id;

    public Cars(){}

    public Cars(int id, String model, int year, int Users_Id, int Car_Class_Id) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.Users_Id = Users_Id;
        this.Car_Class_Id = Car_Class_Id;
    }

    public void setId() {
        this.id = id;
    }

    public void setModel() {
        this.model = model;
    }

    public void setYear() {
        this.year = year;
    }

    public void setUsers_Id() {
        this.Users_Id = Users_Id;
    }

    public void setCar_Class_Id() {
        this.Car_Class_Id = Car_Class_Id;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear () {
        return year;
    }

    public int getUsers_Id() {
        return Users_Id;
    }

    public int getCar_Class_Id() {
        return Car_Class_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id && year == cars.year && Users_Id == cars.Users_Id && Car_Class_Id == cars.Car_Class_Id && Objects.equals(model, cars.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, year, Users_Id, Car_Class_Id);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", Users_Id=" + Users_Id +
                ", Car_Class_Id=" + Car_Class_Id +
                '}';
    }
}
