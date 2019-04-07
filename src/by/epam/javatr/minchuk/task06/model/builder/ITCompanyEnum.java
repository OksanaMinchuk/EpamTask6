package by.epam.javatr.minchuk.task06.model.builder;

public enum ITCompanyEnum {
    ITCOMPANY("itcompany"),
    DEVELOPER("developer"),
    TESTER("tester"),
    PROJECTMANAGER("projectmanager"),
    ID("id"),
    USERNAME("username"),
    NAME("name"),
    SURNAME("surname"),
    SALARYPERHOUR("salaryPerHour"),
    LEVEL("level"),
    DEVELOPERTYPE("developerType"),
    SKILL("skill"),
    TESTERTYPE("testerType"),
    PROJECT("project");

    private String value;

    ITCompanyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
