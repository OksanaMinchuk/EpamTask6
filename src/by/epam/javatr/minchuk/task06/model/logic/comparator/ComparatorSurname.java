package by.epam.javatr.minchuk.task06.model.logic.comparator;

import by.epam.javatr.minchuk.task06.model.entity.Employee;

import java.util.Comparator;

public class ComparatorSurname implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
