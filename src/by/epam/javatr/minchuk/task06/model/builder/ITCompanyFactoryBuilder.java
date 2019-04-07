package by.epam.javatr.minchuk.task06.model.builder;

import by.epam.javatr.minchuk.task06.model.builder.DOM.ITCompanyDOMBuilder;
import by.epam.javatr.minchuk.task06.model.builder.SAX.ITCompanySAXBuilder;
import by.epam.javatr.minchuk.task06.model.builder.StAX.ITCompanyStAXBuilder;

public class ITCompanyFactoryBuilder {

    public enum TypeParser{
        DOM, SAX, STAX
    }

    public AbstractITCompanyBuilder createITCompanyBuilder(String typeParser) {
        AbstractITCompanyBuilder abstractITCompanyBuilder = null;
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                abstractITCompanyBuilder = new ITCompanyDOMBuilder(); break;
            case SAX:
                abstractITCompanyBuilder = new ITCompanySAXBuilder(); break;
            case STAX:
                abstractITCompanyBuilder = new ITCompanyStAXBuilder(); break;
        }
        return abstractITCompanyBuilder;
    }
}
