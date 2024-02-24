package hw04JDK;

/**
 * Урок 4. Коллекции
 * Создать справочник сотрудников
 * Необходимо:
 * Создать класс справочник сотрудников, который содержит внутри
 * коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник
 */

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
