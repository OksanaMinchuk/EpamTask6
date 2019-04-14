package by.epam.javatr.minchuk.task06.model;

import by.epam.javatr.minchuk.task06.model.entity.*;

public class ITCompanyData {

    private static Developer developer1 = new Developer("id1", "John", "Conor", 50,
            "conor", Engineer.EngineerLevelType.MIDDLE, Developer.DeveloperType.BACK_END, "Java");
    private static Developer developer2 = new Developer("id2", "Donald", "Freeman", 45.5,
            "freeman", Engineer.EngineerLevelType.MIDDLE, Developer.DeveloperType.BACK_END, "C++");
    private static Developer developer3 = new Developer("id3", "Jack", "Gilbert", 54.5,
            "gilbert",Engineer.EngineerLevelType.SENIOR, Developer.DeveloperType.FRONT_END, "HTML");
    private static Tester tester1 = new Tester("id4", "Alex", "Miller", 30.0, "miller",
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.MANUAL);
    private static Tester tester2 = new Tester("id5", "Tom", "Gibbs", 24.7, "gibbs",
            Tester.EngineerLevelType.JUNIOR, Tester.TesterType.AUTOMATION);
    private static ProjectManager projectManager1 = new ProjectManager("id6", "Scott", "Johnson",
            60.0,"johnson", "Online-Store");

    public static ITCompany initITCompany() {
        ITCompany itCompany = new ITCompany();
        itCompany.addEmployee(developer1);
        itCompany.addEmployee(developer2);
        itCompany.addEmployee(developer3);
        itCompany.addEmployee(tester1);
        itCompany.addEmployee(tester2);
        itCompany.addEmployee(projectManager1);
        return itCompany;
    }
}
