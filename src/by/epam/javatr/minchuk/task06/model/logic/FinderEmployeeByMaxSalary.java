package by.epam.javatr.minchuk.task06.model.logic;

import by.epam.javatr.minchuk.task06.model.entity.Employee;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.model.exception.XMLProjectException;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class {@code FinderEmployeeByMaxSalary}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderEmployeeByMaxSalary {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns employee with max salary
     *
     * @param itCompany ITCompany object
     * @param maxSalary the specific condition
     * @return findEmployee Employee object satisfying the specific condition
     * @throws XMLProjectException
     */
    public static Employee findEmployeeByMaxSalary(ITCompany itCompany, double maxSalary) throws XMLProjectException {
        if (itCompany != null && maxSalary > 0) {
            List<Employee> employees = itCompany.getEmployees();
            Employee findEmployee = null;
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getSalaryPerHour() == maxSalary) {
                    findEmployee = employees.get(i);
                }
            }
            LOGGER.info("method findEmployeeByMaxSalary is successful");
            return findEmployee;
        } else {
            throw new XMLProjectException("Invoking a method \"findEmployeeByMaxSalary\" for a null object or wrong maxSalary value");
        }
    }
}
