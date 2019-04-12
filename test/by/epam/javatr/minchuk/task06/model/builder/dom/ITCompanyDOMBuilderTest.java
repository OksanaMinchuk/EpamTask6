package by.epam.javatr.minchuk.task06.model.builder.dom;

import by.epam.javatr.minchuk.task06.model.builder.ITCompanyData;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ITCompanyDOMBuilderTest {

    private ITCompanyDOMBuilder domBuilder;

    @Before
    public void setUp() {
        domBuilder = ITCompanyDOMBuilder.getUniqueInstance();
    }

    @After
    public void tearDown() {
        domBuilder = null;
    }

    @Test
    public void testCreateITCompany() {
        ITCompany expected = ITCompanyData.initITCompany();
        domBuilder.createITCompany(ProjectConstant.XML_FILE_PATH);
        ITCompany actual =  domBuilder.getItCompany();
        Assert.assertEquals(expected, actual);
    }
}
