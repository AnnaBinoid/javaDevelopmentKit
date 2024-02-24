package hw04JDK;

public class Main04 {

    public static void main(String[] args) {

        EmployeeDirectory firstDirectory = new EmployeeDirectory();
        firstDirectory.addEmployee(1, "Veider Dart", "001", 10);
        firstDirectory.addEmployee(2, "Sidius (Palpatin) Dart", "002", 100);
        firstDirectory.addEmployee(3, "Skywalker Luke", "003", 5);
        firstDirectory.addEmployee(4, "Yoda", "004", 100);

        System.out.println("\n");
        System.out.println(firstDirectory.findEmployeeByTableNumber(1));
        System.out.println(firstDirectory.findEmployeeByTableNumber(10));
        System.out.println("\n");

        System.out.println(firstDirectory.findByExperience(100));
        System.out.println(firstDirectory.findByExperience(3));
        System.out.println(firstDirectory.findAboveExperience(10));

        System.out.println("\n");
        System.out.println(firstDirectory.findPhoneByName("Veider Dart"));
        System.out.println(firstDirectory.findPhoneByName("Organa Leia"));
    }

}
