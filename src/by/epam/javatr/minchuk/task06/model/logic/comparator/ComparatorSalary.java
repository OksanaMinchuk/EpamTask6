package by.epam.javatr.minchuk.task06.model.logic.comparator;

import by.epam.javatr.minchuk.task06.model.entity.Employee;

import java.util.Comparator;

public class ComparatorSalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalaryPerHour(), o2.getSalaryPerHour());
    }
}
