package by.epam.javatr.minchuk.task06.model.logic;

import by.epam.javatr.minchuk.task06.model.entity.Employee;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.model.exception.XMLProjectException;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class {@code FinderMaxSalary}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderMaxSalary {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns max salary value
     *
     * @param itCompany ITCompany object
     * @return maxSalary
     * @throws XMLProjectException
     */
    public static double findMaxSalary(ITCompany itCompany) throws XMLProjectException {
        if (itCompany != null) {
            List<Employee> employees = itCompany.getEmployees();
            double maxSalary = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalaryPerHour() > maxSalary) {
                    maxSalary = employees.get(i).getSalaryPerHour();
                }
            }
            LOGGER.info("method findMaxSalary is successful");
            return maxSalary;
        } else {
            throw new XMLProjectException("Invoking a method \"findMaxSalary\" for a null object");
        }
    }
}
