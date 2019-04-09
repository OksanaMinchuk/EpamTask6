package by.epam.javatr.minchuk.task06.controller;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import by.epam.javatr.minchuk.task06.model.builder.DOM.ITCompanyDOMBuilder;
import by.epam.javatr.minchuk.task06.model.builder.ITCompanyFactoryBuilder;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.util.ValidatorSAXXSD;
import by.epam.javatr.minchuk.task06.util.ValidatorXSD;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Class {@code MainController}
 *
 * @autor Oksana Minchuk
 * @version 1.0 06.04.2019
 */

public class MainController {
    public static final Logger LOGGER;
    private static final String XML_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"+ File.separator + "itcompany.xml";

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {
        ITCompany itCompany;

        //Check schema 
        ValidatorSAXXSD.validateScheme();

        //DOM Parsing
        LOGGER.info("DOM Parsing");
        AbstractITCompanyBuilder builderDOM = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.DOM.toString());
        builderDOM.createITCompany(XML_FILE_PATH);
        itCompany = builderDOM.getItCompany();
        LOGGER.info(itCompany);

        //STAX Parsing
        LOGGER.info("STAX Parsing");
        AbstractITCompanyBuilder builderSTAX = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.STAX.toString());
        builderSTAX.createITCompany(XML_FILE_PATH);
        itCompany = builderSTAX.getItCompany();
        LOGGER.info(itCompany);

        //SAX Parsing
        LOGGER.info("SAX Parsing");
        AbstractITCompanyBuilder builderSAX = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.SAX.toString());
        builderSTAX.createITCompany(XML_FILE_PATH);
        itCompany = builderSTAX.getItCompany();
        LOGGER.info(itCompany);





    }
}
