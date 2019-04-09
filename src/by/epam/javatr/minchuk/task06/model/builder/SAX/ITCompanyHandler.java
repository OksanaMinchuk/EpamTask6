package by.epam.javatr.minchuk.task06.model.builder.SAX;

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
    private EnumSet<ITCompanyEnum> withText;

    public ITCompanyHandler() {
        itCompany = new ITCompany();
        withText = EnumSet.range(ITCompanyEnum.NAME, ITCompanyEnum.PROJECT);
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        ITCompanyEnum temp = ITCompanyEnum.valueOf(localName.toUpperCase());

        switch (temp) {
            case DEVELOPER:
                currentEmployee = new Developer();
                break;
            case TESTER:
                currentEmployee = new Tester();
                break;
            case PROJECTMANAGER:
                currentEmployee = new ProjectManager();
                break;
            default:
                if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }

        currentEmployee.setId(attrs.getValue(0));

        if (attrs.getLength() == 2) {
            currentEmployee.setUsername(attrs.getValue(1));
        }
    }

    public void endElement(String uri, String localName, String qName) {

        ITCompanyEnum temp = ITCompanyEnum.valueOf(localName.toUpperCase());
        switch (temp) {
            case DEVELOPER:
            case TESTER:
            case PROJECTMANAGER:
                if (currentEmployee != null) {
                    itCompany.addEmployee(currentEmployee);
                }
                break;
            default:
                if (withText.contains(temp)) {
                    currentEnum = null;
                }
                break;
        }
    }

    public void characters(char[] ch, int start, int lenght) {

        String s = new String(ch, start, lenght).trim();

        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    currentEmployee.setName(s);
                    break;
                case SURNAME:
                    currentEmployee.setSurname(s);
                    break;
                case SALARYPERHOUR:
                    currentEmployee.setSalaryPerHour(Double.parseDouble(s));
                    break;
                    default:
                        if (currentEmployee instanceof Developer) {

                            Developer developer = (Developer) currentEmployee;

                            switch (currentEnum) {
                                case LEVEL:
                                    developer.setLevel(Engineer.EngineerLevelType.valueOf(s));
                                    break;
                                case DEVELOPERTYPE:
                                    developer.setDeveloperType(Developer.DeveloperType.valueOf(s));
                                    break;
                                case SKILL:
                                    developer.setSkill(s);
                                    break;
                            }

                        } else  if (currentEmployee instanceof Tester) {

                            Tester tester = (Tester) currentEmployee;
                            switch (currentEnum) {
                                case LEVEL:
                                    tester.setLevel(Engineer.EngineerLevelType.valueOf(s));
                                    break;
                                case TESTERTYPE:
                                    tester.setTesterType(Tester.TesterType.valueOf(s));
                                    break;
                            }

                        } else if (currentEmployee instanceof ProjectManager) {
                            ProjectManager projectManager = (ProjectManager) currentEmployee;
                            projectManager.setProject(s);
                        }
            }
        }
        currentEmployee = null;
    }

}
