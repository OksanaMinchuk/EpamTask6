package by.epam.javatr.minchuk.task06.model.logic;

import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.model.exception.XMLProjectException;
import by.epam.javatr.minchuk.task06.model.logic.comparator.ComparatorSalary;
import by.epam.javatr.minchuk.task06.model.logic.comparator.ComparatorSurname;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;

/**
 * Class {@code Sorter}  allows to sort Employee by different conditions
 *
 * @autor Oksana Minchuk
 * @version 1.0 16.03.2019
 */

public class Sorter {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private static Comparator comparator;

    public static void sortBySalary(ITCompany itCompany) throws XMLProjectException {
        if (itCompany.getEmployees() != null) {
            comparator = new ComparatorSalary();
            Collections.sort(itCompany.getEmployees(), comparator);
            LOGGER.info("sorting by salary is successful");
        } else {
            LOGGER.error("method throws exception");
            throw new XMLProjectException("Invoking a method \"sortBySalary\" for a null object");
        }
    }

    public static void sortBySurnameAndSalary(ITCompany itCompany) throws XMLProjectException {
        if (itCompany.getEmployees() != null) {
            comparator = new ComparatorSurname();
            Collections.sort(itCompany.getEmployees(), comparator.thenComparing(new ComparatorSalary()));
            LOGGER.info("sorting by surname and salary is successful");
        } else {
            LOGGER.error("method throws exception");
            throw new XMLProjectException("Invoking a method \"sortBySurnameAndSalary\" for a null object");
        }
    }
}
