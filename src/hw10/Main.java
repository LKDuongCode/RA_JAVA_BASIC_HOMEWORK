package hw10;

public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company(5);

        Manager manager = new Manager("Alice", 8000);
        Developer developer = new Developer("Bob", 5000);
        myCompany.addEmployee(manager);
        myCompany.addEmployee(developer);

        manager.work();
        developer.work();

        manager.takeVacation();
        developer.takeVacation();

        myCompany.startMeeting();
    }
}
