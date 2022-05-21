package com.solvd.Entity;

import java.util.Objects;

public class HomeNumbers {

    private int id;
    private String home_number;
    private int User_Id;

    public HomeNumbers() {}

    HomeNumbers(int id, String home_number, int User_Id) {
        this.id = id;
        this.home_number = home_number;
        this.User_Id = User_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHome_number(String home_number) {
        this.home_number = home_number;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getId() {
        return id;
    }

    public String getHome_number() {
        return home_number;
    }

    public int getUser_Id() {
        return User_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeNumbers that = (HomeNumbers) o;
        return id == that.id && User_Id == that.User_Id && Objects.equals(home_number, that.home_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, home_number, User_Id);
    }

    @Override
    public String toString() {
        return "HomeNumbers{" +
                "id=" + id +
                ", home_number='" + home_number + '\'' +
                ", User_Id=" + User_Id +
                '}';
    }
}
