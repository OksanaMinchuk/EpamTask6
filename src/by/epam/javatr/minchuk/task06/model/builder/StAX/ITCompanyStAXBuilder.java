package by.epam.javatr.minchuk.task06.model.builder.StAX;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import by.epam.javatr.minchuk.task06.model.builder.ITCompanyEnum;
import by.epam.javatr.minchuk.task06.model.entity.*;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EnumSet;

public class ITCompanyStAXBuilder extends AbstractITCompanyBuilder {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private XMLInputFactory inputFactory;
    private EnumSet<ITCompanyEnum> employeeTypes;

    public ITCompanyStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        employeeTypes = EnumSet.range(ITCompanyEnum.DEVELOPER, ITCompanyEnum.PROJECTMANAGER);
    }

    @Override
    public void createITCompany(String filename) {

        FileInputStream fileInputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            fileInputStream = new FileInputStream(new File(filename));
            reader = inputFactory.createXMLStreamReader(fileInputStream);
            //StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();

                if(type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    if (employeeTypes.contains(ITCompanyEnum.valueOf(name.toUpperCase()))) {
                        Employee employee = buildEmployee(reader);
                        itCompany.addEmployee(employee);
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error!" + e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error("File " + filename + " not found! " + e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file! "+ filename + e);
            }
        }
    }

    private Employee buildEmployee(XMLStreamReader reader) throws XMLStreamException{

        Employee employee = null;

        if (reader.getLocalName() == ITCompanyEnum.DEVELOPER.getValue()) {
            employee = new Developer();

        } else if (reader.getLocalName() == ITCompanyEnum.TESTER.getValue()){
            employee = new Tester();

        } else if (reader.getLocalName() == ITCompanyEnum.PROJECTMANAGER.getValue()) {
            employee = new ProjectManager();
        }

        employee.setId(reader.getAttributeValue(null, ITCompanyEnum.ID.getValue()));
        employee.setUsername(reader.getAttributeValue(null, ITCompanyEnum.USERNAME.getValue()));

        String name;
        while (reader.hasNext()) {

           int type = reader.next();

           switch (type) {
               case XMLStreamConstants.START_ELEMENT:
                   name = reader.getLocalName();

                   switch (ITCompanyEnum.valueOf(name.toUpperCase())) {
                       case NAME:
                           employee.setName(getXMLText(reader));
                           break;
                       case SURNAME:
                           employee.setSurname(getXMLText(reader));
                           break;
                       case SALARYPERHOUR:
                           employee.setSalaryPerHour(Double.parseDouble(getXMLText(reader)));
                           break;
                       default:
                           if (employee instanceof Developer) {
                               Developer developer = (Developer) employee;
                               if (name == ITCompanyEnum.LEVEL.getValue()) {
                                   developer.setLevel(Engineer.EngineerLevelType.valueOf(getXMLText(reader)));

                               } else if (name == ITCompanyEnum.DEVELOPERTYPE.getValue()) {
                                   developer.setDeveloperType(Developer.DeveloperType.valueOf(getXMLText(reader)));

                               } else if (name == ITCompanyEnum.SKILL.getValue()) {
                                   developer.setSkill(getXMLText(reader));
                               }
                           } else if (employee instanceof Tester) {
                               Tester tester = (Tester) employee;
                               if (name == ITCompanyEnum.TESTERTYPE.getValue()) {
                                   tester.setTesterType(Tester.TesterType.valueOf(getXMLText(reader)));
                               }
                           } else if (employee instanceof ProjectManager) {
                               ProjectManager projectManager = (ProjectManager) employee;
                               if (name == ITCompanyEnum.PROJECT.getValue()) {
                                   projectManager.setProject(getXMLText(reader));
                               }
                           }
                       break;
                   }
               break;
               case XMLStreamConstants.END_ELEMENT:
                   name = reader.getLocalName();
                   if (employeeTypes.contains(ITCompanyEnum.valueOf(name.toUpperCase()))) {
                       return employee;
                   }
               break;
           }
        }
        throw new XMLStreamException("Unknown element in tag ITCompany");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
