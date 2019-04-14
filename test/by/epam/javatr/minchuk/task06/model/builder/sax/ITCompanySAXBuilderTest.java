package by.epam.javatr.minchuk.task06.model.builder.sax;

import by.epam.javatr.minchuk.task06.model.ITCompanyData;
import by.epam.javatr.minchuk.task06.model.entity.ITCompany;
import by.epam.javatr.minchuk.task06.util.constant.ProjectConstant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITCompanySAXBuilderTest {

    private ITCompanySAXBuilder saxBuilder;

    @Before
    public void setUp() {
        saxBuilder = ITCompanySAXBuilder.getUniqueInstance();
        saxBuilder.createITCompany(ProjectConstant.XML_FILE_PATH);
    }

    @After
    public void tearDown() {
        saxBuilder = null;
    }

    @Test
    public void testCreateITCompany() {
        ITCompany expected = ITCompanyData.initITCompany();
        ITCompany actual =  saxBuilder.getItCompany();
        Assert.assertEquals(expected, actual);
    }
}
