package Entity;

import java.util.Objects;

public class Salaries {

    private int id;
    private int salary;

    public Salaries(){}

    public Salaries(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salaries salaries = (Salaries) o;
        return id == salaries.id && Objects.equals(salary, salaries.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary);
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "id=" + id +
                ", salary='" + salary + '\'' +
                '}';
    }
}
