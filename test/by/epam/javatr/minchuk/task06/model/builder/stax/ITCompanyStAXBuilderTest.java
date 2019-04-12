package by.epam.javatr.minchuk.task06.model.builder.stax;

import by.epam.javatr.minchuk.task06.model.builder.ITCompanyData;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITCompanyStAXBuilderTest {

    private ITCompanyStAXBuilder stAXBuilder;

    @Before
    public void setUp() {
        stAXBuilder = ITCompanyStAXBuilder.getUniqueInstance();
    }

    @After
    public void tearDown() {
        stAXBuilder = null;
    }

    @Test
    public void testCreateITCompany() {
        ITCompany expected = ITCompanyData.initITCompany();
        stAXBuilder.createITCompany(ProjectConstant.XML_FILE_PATH);
        ITCompany actual =  stAXBuilder.getItCompany();
        Assert.assertEquals(expected, actual);
    }
}
