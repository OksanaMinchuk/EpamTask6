package by.epam.javatr.minchuk.task06.util;

import by.epam.javatr.minchuk.task06.model.exception.XMLParserErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class {@code ValidatorSAXXSD}  validate during parsing document
 *
 * @autor Oksana Minchuk
 * @version 1.0 06.04.2019
 */

public class ValidatorXSD {

    private static final Logger LOGGER;
    private static final String XML_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"
            + File.separator + "itcompany.xml";
    private static final String XSD_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"
            + File.separator + "itcompanySchema.xsd";
    private static final String LOGNAME = "validatorLog.log";
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final SchemaFactory factory  = SchemaFactory.newInstance(LANGUAGE);

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void validateScheme() {
        Schema schema = null;
        try {
            schema = factory.newSchema(new File(XSD_FILE_PATH));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser parser = saxParserFactory.newSAXParser();
            parser.parse(XML_FILE_PATH, new XMLParserErrorHandler(LOGNAME));
            LOGGER.info(XML_FILE_PATH + " is valid");
        } catch (SAXException e) {
            LOGGER.error(XML_FILE_PATH + " SAX error: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            LOGGER.error(XML_FILE_PATH + " config error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e.getMessage());;
        }
    }
}
