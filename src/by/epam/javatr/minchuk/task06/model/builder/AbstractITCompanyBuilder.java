package by.epam.javatr.minchuk.task06.model.builder;

import by.epam.javatr.minchuk.task06.model.entity.ITCompany;

/**
 * Class {@code AbstractITCompanyBuilder}
 *
 * @autor Oksana Minchuk
 * @version 1.0 06.04.2019
 */

public abstract class AbstractITCompanyBuilder {

    protected ITCompany itCompany;

    public AbstractITCompanyBuilder() {
        itCompany = new ITCompany();
    }

    public AbstractITCompanyBuilder(ITCompany itCompany) {
        this.itCompany = itCompany;
    }

    public ITCompany getItCompany() {
        return itCompany;
    }

    abstract public void createITCompany(String filename);
}
