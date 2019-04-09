package by.epam.javatr.minchuk.task06.model.exception;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

public class XMLParserErrorHandler extends DefaultHandler {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public XMLParserErrorHandler(String filename) throws IOException {
        LOGGER.addAppender(new FileAppender(new SimpleLayout(), filename));
    }

    public void warning(SAXParseException e) {
        LOGGER.warn(getLineAdress(e) + e.getMessage());
    }

    public void error(SAXParseException e) {
        LOGGER.error(getLineAdress(e) + e.getMessage());
    }

    public void fatalError(SAXParseException e) {
        LOGGER.fatal(getLineAdress(e) + e.getMessage());
    }

    private String getLineAdress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
