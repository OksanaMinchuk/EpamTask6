package by.epam.javatr.minchuk.task06.controller;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import by.epam.javatr.minchuk.task06.model.builder.ITCompanyFactoryBuilder;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.model.exception.XMLProjectException;
import by.epam.javatr.minchuk.task06.model.logic.Sorter;
import by.epam.javatr.minchuk.task06.util.validator.ValidatorSAXXSD;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.apache.log4j.Logger;

/**
 * Class {@code MainController}
 *
 * @autor Oksana Minchuk
 * @version 1.0 06.04.2019
 */

public class MainController {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void main(String[] args) {

        ITCompany itCompany;

        //Check schema
        //ValidatorXSD.validateScheme();
        ValidatorSAXXSD.validateScheme();

        //dom Parsing
        LOGGER.trace("DOM Parsing");
        AbstractITCompanyBuilder builderDOM = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.DOM.toString());
        builderDOM.createITCompany(ProjectConstant.XML_FILE_PATH);
        itCompany = builderDOM.getItCompany();
        LOGGER.info(itCompany);

        //StAX Parsing
        LOGGER.trace("STAX Parsing");
        AbstractITCompanyBuilder builderSTAX = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.STAX.toString());
        builderSTAX.createITCompany(ProjectConstant.XML_FILE_PATH);
        itCompany = builderSTAX.getItCompany();
        LOGGER.info(itCompany);

        //sax Parsing
        LOGGER.trace("SAX Parsing");
        AbstractITCompanyBuilder builderSAX = new ITCompanyFactoryBuilder().
                createITCompanyBuilder(ITCompanyFactoryBuilder.TypeParser.SAX.toString());
        builderSAX.createITCompany(ProjectConstant.XML_FILE_PATH);
        itCompany = builderSAX.getItCompany();
        LOGGER.info(itCompany);

        //sorting
        try {
            Sorter.sortBySalary(itCompany);
            LOGGER.info(itCompany);
        } catch (XMLProjectException e) {
            e.printStackTrace();
        }
    }
}
