package by.epam.javatr.minchuk.task06.model.builder.SAX;

import by.epam.javatr.minchuk.task06.model.builder.ITCompanyEnum;
import by.epam.javatr.minchuk.task06.model.entity.Employee;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import org.apache.log4j.Logger;
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
}
