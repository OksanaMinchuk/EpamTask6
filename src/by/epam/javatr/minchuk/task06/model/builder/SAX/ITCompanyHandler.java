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
        withText = EnumSet.range(ITCompanyEnum.NAME, ITCompanyEnum.PROJECTMANAGER);
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
            currentEmployee.setId(attrs.getValue(1));
        }
    }

    public void endElement(String uri, String localName, String qName) {

        ITCompanyEnum temp = ITCompanyEnum.valueOf(localName.toUpperCase());


    }




}
