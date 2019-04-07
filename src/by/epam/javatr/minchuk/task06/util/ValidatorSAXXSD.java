package by.epam.javatr.minchuk.task06.util;

import by.epam.javatr.minchuk.task06.model.exception.XMLParserErrorHandler;
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
    private static final String XML_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"+ File.separator + "itcompany.xml";
    private static final String XSD_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"+ File.separator + "itcompanySchema.xsd";
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final String LOGNAME = "validatorLog.log";

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void validateScheme() {
        SchemaFactory factory  = SchemaFactory.newInstance(LANGUAGE);
        File shemaLocation = new File(XSD_FILE_PATH);
        try {
            Schema schema = factory.newSchema(shemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XML_FILE_PATH);

            XMLParserErrorHandler xmlParserErrorHandler = new XMLParserErrorHandler(LOGNAME);
            validator.setErrorHandler(xmlParserErrorHandler);

            validator.validate(source);
            LOGGER.info(XML_FILE_PATH + " is valid.");
        } catch (SAXException e) {
            LOGGER.error(XML_FILE_PATH + " is not valid because " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error(XML_FILE_PATH + " is not valid because " + e.getMessage());
        }

    }
}
