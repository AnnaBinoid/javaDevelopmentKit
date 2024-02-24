package hw04JDK;

public class Employee {
    private String name;
    private String phoneNumber;
    private int experience;
    private int tableNumber;


    public int getTableNumber() {
        return tableNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public Employee(int tableNumber, String name, String phoneNumber, int experience) {
        this.tableNumber = tableNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                " tableNumber : " + getTableNumber() +
                ", name : " + getName() +
                ", phoneNumber : " + getPhoneNumber() +
                ", experience : " + getExperience() +
                '}';
    }
}
