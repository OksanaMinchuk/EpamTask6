package by.epam.javatr.minchuk.task06.model.builder.sax;

import by.epam.javatr.minchuk.task06.model.builder.AbstractITCompanyBuilder;
import by.epam.javatr.minchuk.task06.model.builder.dom.ITCompanyDOMBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class ITCompanySAXBuilder extends AbstractITCompanyBuilder {

    private static final Logger LOGGER;
    private static final ReentrantLock LOCK;
    private static ITCompanySAXBuilder uniqueInstance;

    private ITCompanyHandler itCompanyHandler;
    private XMLReader xmlReader;

    static {
        LOGGER = Logger.getRootLogger();
        LOCK = new ReentrantLock();
    }

    private ITCompanySAXBuilder() {
        itCompanyHandler = new ITCompanyHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(itCompanyHandler);
        } catch (SAXException e) {
            LOGGER.error("sax parser error: " + e);
        }
    }

    public static ITCompanySAXBuilder getUniqueInstance() {
        if (uniqueInstance == null) {
            LOCK.lock();
            if (uniqueInstance == null) {
                uniqueInstance = new ITCompanySAXBuilder();
            }
            LOCK.lock();
        }
        return uniqueInstance;
    }

    @Override
    public void createITCompany(String filename) {
        try {
            xmlReader.parse(filename);
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e);
        } catch (SAXException e) {
            LOGGER.error("sax parser error: " + e);
        }
        itCompany = itCompanyHandler.getItCompany();
    }
}
