package by.epam.javatr.minchuk.task06.model.builder.dom;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import by.epam.javatr.minchuk.task06.model.builder.ITCompanyEnum;
import by.epam.javatr.minchuk.task06.model.entity.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class ITCompanyDOMBuilder extends AbstractITCompanyBuilder {

    private static final Logger LOGGER;
    private static final ReentrantLock LOCK;
    private static ITCompanyDOMBuilder uniqueInstance;

    private DocumentBuilder documentBuilder;

    static {
        LOGGER = Logger.getRootLogger();
        LOCK = new ReentrantLock();
    }

    private ITCompanyDOMBuilder() {
        this.itCompany = new ITCompany();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Parser configuration error: " + e);
        }
    }

    public static ITCompanyDOMBuilder getUniqueInstance() {
        if (uniqueInstance == null) {
            LOCK.lock();
            if (uniqueInstance == null) {
                uniqueInstance = new ITCompanyDOMBuilder();
            }
            LOCK.lock();
        }
        return uniqueInstance;
    }

    @Override
    public void createITCompany(String fileName) {
        Document document = null;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList employeesList = root.getChildNodes();
            for (int i = 0; i < employeesList.getLength(); i++) {
                Node node = employeesList.item(i);
                if (node instanceof  Element) {
                    Element employeeElement = (Element)node;
                    Employee employee = buildEmployee(employeeElement);
                    itCompany.addEmployee(employee);
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee buildEmployee(Element employeeElement) {
        String name = employeeElement.getNodeName();
        ITCompanyEnum temp = ITCompanyEnum.valueOf(name.toUpperCase());
        Employee employee = null;
        switch (temp) {
            case DEVELOPER:
                employee = new Developer();
                Developer developer = (Developer) employee;
                developer.setLevel(Engineer.EngineerLevelType.valueOf(getElementTextContent(employeeElement, ITCompanyEnum.LEVEL.getValue())));
                developer.setDeveloperType(Developer.DeveloperType.valueOf(getElementTextContent(employeeElement, ITCompanyEnum.DEVELOPERTYPE.getValue())));
                developer.setSkill(getElementTextContent(employeeElement, ITCompanyEnum.SKILL.getValue()));
                break;
            case TESTER:
                employee = new Tester();
                Tester tester = (Tester) employee;
                tester.setLevel(Engineer.EngineerLevelType.valueOf(getElementTextContent(employeeElement, ITCompanyEnum.LEVEL.getValue())));
                tester.setTesterType(Tester.TesterType.valueOf(getElementTextContent(employeeElement, ITCompanyEnum.TESTERTYPE.getValue())));
                break;
            case PROJECTMANAGER:
                employee = new ProjectManager();
                ProjectManager projectManager = (ProjectManager) employee;
                projectManager.setProject(getElementTextContent(employeeElement, ITCompanyEnum.PROJECT.getValue()));
                break;
        }
        employee.setId(employeeElement.getAttribute("id"));
        employee.setName(getElementTextContent(employeeElement, "name"));
        employee.setSurname(getElementTextContent(employeeElement, "surname"));
        employee.setSalaryPerHour(Double.parseDouble(getElementTextContent(employeeElement, "salaryPerHour")));
        employee.setUsername(employeeElement.getAttribute("username"));

        return employee;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return  text;
    }
}
