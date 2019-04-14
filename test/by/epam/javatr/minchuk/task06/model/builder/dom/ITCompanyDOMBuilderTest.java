package by.epam.javatr.minchuk.task06.model.builder.dom;

import by.epam.javatr.minchuk.task06.model.ITCompanyData;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITCompanyDOMBuilderTest {

    private ITCompanyDOMBuilder domBuilder;

    @Before
    public void setUp() {
        domBuilder = ITCompanyDOMBuilder.getUniqueInstance();
        domBuilder.createITCompany(ProjectConstant.XML_FILE_PATH);
    }

    @After
    public void tearDown() {
        domBuilder = null;
    }

    @Test
    public void testCreateITCompany() {
        ITCompany expected = ITCompanyData.initITCompany();
        ITCompany actual =  domBuilder.getItCompany();
        Assert.assertEquals(expected, actual);
    }
}
