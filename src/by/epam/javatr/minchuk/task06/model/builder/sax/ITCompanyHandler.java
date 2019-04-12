package by.epam.javatr.minchuk.task06.model.builder.sax;

import by.epam.javatr.minchuk.task06.model.builder.ITCompanyEnum;
import by.epam.javatr.minchuk.task06.model.entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;

public class ITCompanyHandler extends DefaultHandler {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private ITCompany itCompany;
    private Employee currentEmployee;
    private ITCompanyEnum currentEnum;
    private EnumSet<ITCompanyEnum> types;
    private EnumSet<ITCompanyEnum> fields;

    public ITCompanyHandler() {
        itCompany = new ITCompany();
        types = EnumSet.range(ITCompanyEnum.DEVELOPER, ITCompanyEnum.PROJECTMANAGER);
        fields = EnumSet.range(ITCompanyEnum.NAME, ITCompanyEnum.PROJECT);
    }

    public ITCompany getItCompany() {
        return itCompany;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if (ITCompanyEnum.DEVELOPER.getValue().equalsIgnoreCase(localName)) {
            currentEmployee = new Developer();

        } else if (ITCompanyEnum.TESTER.getValue().equalsIgnoreCase(localName)) {
            currentEmployee = new Tester();

        } else if (ITCompanyEnum.PROJECTMANAGER.getValue().equalsIgnoreCase(localName)) {
            currentEmployee = new ProjectManager();

        } else {
            ITCompanyEnum temp = ITCompanyEnum.valueOf(localName.toUpperCase());
            if (fields.contains(temp)) {
                currentEnum = temp;
            }
        }
        if (attrs.getLength() == 2) {
            currentEmployee.setId(attrs.getValue(0));
            currentEmployee.setUsername(attrs.getValue(1));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
       if (types.contains(ITCompanyEnum.valueOf(localName.toUpperCase()))) {
           itCompany.addEmployee(currentEmployee);
       }
    }

    @Override
    public void characters(char[] ch, int start, int lenght) {

        String s = new String(ch, start, lenght).trim();

        if (currentEnum != null) {
            if (currentEnum == ITCompanyEnum.NAME) {
                currentEmployee.setName(s);

            } else if (currentEnum == ITCompanyEnum.SURNAME) {
                currentEmployee.setSurname(s);

            } else if (currentEnum == ITCompanyEnum.SALARYPERHOUR) {
                currentEmployee.setSalaryPerHour(Double.parseDouble(s));
            }

            if (currentEmployee instanceof Engineer) {
                Engineer engineer = (Engineer)currentEmployee;
                if (currentEnum == ITCompanyEnum.LEVEL) {
                    engineer.setLevel(Engineer.EngineerLevelType.valueOf(s));
                }
            }

            if (currentEmployee instanceof Developer) {
                Developer developer = (Developer)currentEmployee;
                if (currentEnum == ITCompanyEnum.DEVELOPERTYPE) {
                    developer.setDeveloperType(Developer.DeveloperType.valueOf(s));
                } else if (currentEnum == ITCompanyEnum.SKILL) {
                    developer.setSkill(s);
                }
            }

            if (currentEmployee instanceof Tester) {
                Tester tester = (Tester) currentEmployee;
                if (currentEnum == ITCompanyEnum.TESTERTYPE) {
                    tester.setTesterType(Tester.TesterType.valueOf(s));
                }
            }

            if (currentEmployee instanceof ProjectManager) {
                ProjectManager projectManager = (ProjectManager) currentEmployee;
                if (currentEnum == ITCompanyEnum.PROJECT) {
                    projectManager.setProject(s);
                }
            }
        }
        currentEnum = null;
    }
}
