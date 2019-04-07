package by.epam.javatr.minchuk.task06.model.entity;

/**
 * Class {@code Tester} is a subclass of Engineer
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class Tester extends Engineer {

    public enum TesterType {
        AUTOMATION, MANUAL
    }

    private TesterType testerType;

    public Tester() {
    }

    public Tester(String id, String name, String surname, int salaryPerHour, String username,
                  EngineerLevelType level, TesterType testerType) {
        super(id, name, surname, salaryPerHour, username, level);
        this.testerType = testerType;
    }

    public Tester(Tester tester) {
        super(tester);
        this.testerType = tester.testerType;
    }

    public TesterType getTesterType() {
        return testerType;
    }

    public void setTesterType(TesterType testerType) {
        this.testerType = testerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tester tester = (Tester) o;
        return testerType == tester.testerType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + testerType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tester {" + super.toString() + ", testerType=" + testerType + "}";
    }
}
