package by.epam.javatr.minchuk.task06.util.validator;

import by.epam.javatr.minchuk.task06.model.exception.XMLParserErrorHandler;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Class {@code ValidatorSAXXSD}  validate using class Validator
 *
 * @autor Oksana Minchuk
 * @version 1.0 06.04.2019
 */

public class ValidatorSAXXSD {

    private static final Logger LOGGER;
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void validateScheme() {
        SchemaFactory factory  = SchemaFactory.newInstance(LANGUAGE);
        File shemaLocation = new File(ProjectConstant.XSD_FILE_PATH);
        try {
            Schema schema = factory.newSchema(shemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(ProjectConstant.XML_FILE_PATH);

            XMLParserErrorHandler xmlParserErrorHandler = new XMLParserErrorHandler();
            validator.setErrorHandler(xmlParserErrorHandler);

            validator.validate(source);
            LOGGER.info(ProjectConstant.XML_FILE_PATH + " is valid.");
        } catch (SAXException e) {
            LOGGER.error(ProjectConstant.XML_FILE_PATH + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error(ProjectConstant.XML_FILE_PATH + " is not valid because " + e.getMessage());
        }

    }
}
