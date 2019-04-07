package by.epam.javatr.minchuk.task06.model.entity;

/**
 * Class {@code Engineer} is a subclass of Employee and a superclass for Developer and Tester
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class Engineer extends Employee {

    public enum EngineerLevelType {
        JUNIOR, MIDDLE, SENIOR
    }

    private EngineerLevelType level;

    public Engineer() {
    }

    public Engineer(String id, String name, String surname, int salaryPerHour, String username,  EngineerLevelType level) {
        super(id, name, surname, salaryPerHour, username);
        this.level = level;
    }

    public Engineer(Engineer engineer) {
        super(engineer);
        this.level = engineer.level;
    }

    public EngineerLevelType getLevel() {
        return level;
    }

    public void setLevel(EngineerLevelType level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Engineer engineer = (Engineer) o;
        return level == engineer.level;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "level=" + level;
    }
}
