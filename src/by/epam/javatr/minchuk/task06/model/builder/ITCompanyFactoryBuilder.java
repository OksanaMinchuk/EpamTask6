package by.epam.javatr.minchuk.task06.model.builder;

import by.epam.javatr.minchuk.task06.model.builder.dom.ITCompanyDOMBuilder;
import by.epam.javatr.minchuk.task06.model.builder.sax.ITCompanySAXBuilder;
import by.epam.javatr.minchuk.task06.model.builder.stax.ITCompanyStAXBuilder;

public class ITCompanyFactoryBuilder {

    public enum TypeParser{
        DOM, SAX, STAX
    }

    public AbstractITCompanyBuilder createITCompanyBuilder(String typeParser) {
        AbstractITCompanyBuilder abstractITCompanyBuilder = null;
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                abstractITCompanyBuilder = ITCompanyDOMBuilder.getUniqueInstance(); break;
            case SAX:
                abstractITCompanyBuilder = ITCompanySAXBuilder.getUniqueInstance(); break;
            case STAX:
                abstractITCompanyBuilder = ITCompanyStAXBuilder.getUniqueInstance(); break;
        }
        return abstractITCompanyBuilder;
    }
}
