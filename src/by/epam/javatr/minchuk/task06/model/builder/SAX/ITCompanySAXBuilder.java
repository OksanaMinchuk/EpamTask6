package by.epam.javatr.minchuk.task06.model.builder.SAX;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class ITCompanySAXBuilder extends AbstractITCompanyBuilder {

    private static final Logger LOGGER;

    private ITCompanyHandler itCompanyHandler;
    private XMLReader xmlReader;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public ITCompanySAXBuilder() {
        itCompanyHandler = new ITCompanyHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(itCompanyHandler);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: " + e);
        }
    }

    @Override
    public void createITCompany(String filename) {
        try {
            xmlReader.parse(filename);
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: " + e);
        }
        itCompany = itCompanyHandler.getItCompany();
    }
}
