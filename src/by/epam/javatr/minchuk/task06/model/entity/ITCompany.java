package by.epam.javatr.minchuk.task06.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class {@code ITCompany}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ITCompany {

    private List<Employee> employees;

    public ITCompany() {
       employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public boolean removeEmployee(Employee employee) {
        return employees.remove(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompany itCompany = (ITCompany) o;
        return employees.equals(itCompany.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\tITCompany\n");
        for (Employee employee : employees) {
            builder.append(employee).append("\n");
        }
        return builder.toString();
    }
}
