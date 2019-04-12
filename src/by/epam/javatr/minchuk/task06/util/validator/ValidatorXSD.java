package by.epam.javatr.minchuk.task06.util.validator;

import by.epam.javatr.minchuk.task06.model.exception.XMLParserErrorHandler;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
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

    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final SchemaFactory factory  = SchemaFactory.newInstance(LANGUAGE);

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void validateScheme() {
        Schema schema = null;
        try {
            schema = factory.newSchema(new File(ProjectConstant.XSD_FILE_PATH));
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setSchema(schema);
            SAXParser parser = saxParserFactory.newSAXParser();
            parser.parse(ProjectConstant.XML_FILE_PATH, new XMLParserErrorHandler());
            LOGGER.info(ProjectConstant.XML_FILE_PATH + " is valid");
        } catch (SAXException e) {
            LOGGER.error(ProjectConstant.XML_FILE_PATH + " sax error: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            LOGGER.error(ProjectConstant.XML_FILE_PATH + " config error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e.getMessage());;
        }
    }
}
