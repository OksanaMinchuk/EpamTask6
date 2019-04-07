package by.epam.javatr.minchuk.task06.util;

import by.epam.javatr.minchuk.task06.model.entity.ITCompany;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnmarshalXML {

    private static final String XML_FILE_PATH = "src" + File.separator + "resources" + File.separator + "input"+ File.separator + "itcompany.xml";

    public static ITCompany createUnmarshalITCompany(){
        ITCompany itCompany = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ITCompany.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(XML_FILE_PATH);
            itCompany = (ITCompany) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itCompany;
    }
}
