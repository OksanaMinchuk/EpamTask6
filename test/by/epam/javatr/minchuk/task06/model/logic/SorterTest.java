package by.epam.javatr.minchuk.task06.model.logic;

import by.epam.javatr.minchuk.task06.model.builder.dom.ITCompanyDOMBuilder;
import by.epam.javatr.minchuk.task06.model.entity.*;
import by.epam.javatr.minchuk.task06.model.exception.XMLProjectException;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorterTest {

    private ITCompanyDOMBuilder domBuilder;

    @Before
    public void setUp() {
        domBuilder = ITCompanyDOMBuilder.getUniqueInstance();
        domBuilder.createITCompany(ProjectConstant.XML_FILE_PATH);
    }

    @After
    public void tearDown() {
        domBuilder = null;
    }

    @Test
    public void testSortBySalary() throws XMLProjectException {
        ITCompany expected = new ITCompany();
        expected.addEmployee(new Tester("id5", "Tom", "Gibbs", 24.7, "gibbs",
                Tester.EngineerLevelType.JUNIOR, Tester.TesterType.AUTOMATION));
        expected.addEmployee(new Tester("id4", "Alex", "Miller", 30.0, "miller",
                Tester.EngineerLevelType.MIDDLE, Tester.TesterType.MANUAL));
        expected.addEmployee(new Developer("id2", "Donald", "Freeman", 45.5,
                "freeman", Engineer.EngineerLevelType.MIDDLE, Developer.DeveloperType.BACK_END, "C++"));
        expected.addEmployee(new Developer("id1", "John", "Conor", 50,
                "conor", Engineer.EngineerLevelType.MIDDLE, Developer.DeveloperType.BACK_END, "Java"));
        expected.addEmployee(new Developer("id3", "Jack", "Gilbert", 54.5,
                "gilbert",Engineer.EngineerLevelType.SENIOR, Developer.DeveloperType.FRONT_END, "HTML"));
        expected.addEmployee(new ProjectManager("id6", "Scott", "Johnson",
                60.0,"johnson", "Online-Store"));
        ITCompany actual =  domBuilder.getItCompany();
        Sorter.sortBySalary(actual);
        Assert.assertEquals(expected, actual);
    }
}
