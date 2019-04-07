package by.epam.javatr.minchuk.task06.model.entity;

import java.util.Objects;

/**
 * Class {@code Employee} is a superclass for all emloyees of IT-Company
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
*/

public class Employee {

    public enum EmployeeType {
        DEVELOPER, TESTER, PROJECTMANAGER
    }

    private int id;
    private String name;
    private String surname;
    private double salaryPerHour;
    private String username;

    public Employee() {
    }

    public Employee(int id, String name, String surname, int salaryPerHour, String username) {
        if (name != ""  && surname != "" && salaryPerHour > 0) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.salaryPerHour = salaryPerHour;
            this.username = username;
        }
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.surname = employee.surname;
        this.salaryPerHour = employee.salaryPerHour;
        this.username = employee.username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getUsernamel() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salaryPerHour, salaryPerHour) == 0 &&
                name.equals(employee.name) &&
                surname.equals(employee.surname) &&
                username.equals(employee.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, salaryPerHour, username);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salaryPerHour=" + salaryPerHour +
                ", username='" + username + '\'' +
                '}';
    }
}
