package com.solvd.Entity;

import java.util.Objects;

public class Licenses {

    private int id;
    private String license_number;
    private String expiration_date;
    private int Users_Id;
    private int Salary_Id;
    private int Ratings_Id;

    public Licenses() {}

    Licenses(int id, String license_number, String expiration_date, int Users_Id, int Salary_Id, int Raitings_Id) {
        this.id = id;
        this.license_number = license_number;
        this.expiration_date = expiration_date;
        this.Users_Id = Users_Id;
        this.Salary_Id = Salary_Id;
        this.Ratings_Id = Raitings_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public void setUsers_Id(int users_Id) {
        Users_Id = users_Id;
    }

    public void setSalary_Id(int salary_Id) {
        Salary_Id = salary_Id;
    }

    public void setRatings_Id(int ratings_Id) {
        Ratings_Id = ratings_Id;
    }

    public int getId() {
        return id;
    }

    public String getLicense_number() {
        return license_number;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public int getUsers_Id() {
        return Users_Id;
    }

    public int getSalary_Id() {
        return Salary_Id;
    }

    public int getRatings_Id() {
        return Ratings_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licenses licenses = (Licenses) o;
        return id == licenses.id && Users_Id == licenses.Users_Id && Salary_Id == licenses.Salary_Id && Ratings_Id == licenses.Ratings_Id && Objects.equals(license_number, licenses.license_number) && Objects.equals(expiration_date, licenses.expiration_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license_number, expiration_date, Users_Id, Salary_Id, Ratings_Id);
    }

    @Override
    public String toString() {
        return "Licenses{" +
                "id=" + id +
                ", license_number='" + license_number + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                ", Users_Id=" + Users_Id +
                ", Salary_Id=" + Salary_Id +
                ", Ratings_Id=" + Ratings_Id +
                '}';
    }
}
