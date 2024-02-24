package hw04JDK;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {

    public List<Employee> employeeList = new ArrayList<>();


// Добавить метод добавления нового сотрудника в справочник
    public void addEmployee(int tableNumber, String name, String phoneNumber, int experience) {
        Employee newEmployee = new Employee(tableNumber, name, phoneNumber, experience);
        employeeList.add(newEmployee);
        System.out.println("A new employee has been successfully added " + newEmployee.toString());
    }

// Добавить метод, который ищет сотрудника по табельному номеру
    public Employee findEmployeeByTableNumber(int tableNumber) {
        System.out.print("Employee with table number " + tableNumber + " : ");
        if (!employeeList.isEmpty()) {
            for (Employee e : employeeList) {
                if (e.getTableNumber() == tableNumber) {
                    return e;
                }
            }
        }
        return null;
    }

// Добавить метод, который ищет сотрудника по стажу (может быть список)

    public List<Employee> findByExperience(int experience) {
        System.out.print("Employee with experience " + experience + " : ");
        if (!employeeList.isEmpty()) {
            List<Employee> currentExperienceEmployees = new ArrayList<>(employeeList.size());
            for (Employee e: employeeList) {
                if (e.getExperience() == experience) {
                    currentExperienceEmployees.add(e);
                }
            }
            return currentExperienceEmployees;
        }
        return null;
    }

// Метод, который ищет сотрудников со стажем больше или равно заданного (может быть список)
    public List<Employee> findAboveExperience(int experience) {
        System.out.print("Employee with experience above " + experience + " : ");
        if (!employeeList.isEmpty()) {
            List<Employee> currentExperienstEmployees = new ArrayList<>(employeeList.size());
            for (Employee e: employeeList) {
                if (e.getExperience() >= experience) {
                    currentExperienstEmployees.add(e);
                }
            }
            return currentExperienstEmployees;
        }
        return null;
    }

// Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public List<String> findPhoneByName(String name) {
        System.out.print("Employee's called " + name + " phone number : ");
        if (!employeeList.isEmpty()) {
            List<String> currentNameEmployees = new ArrayList<>(employeeList.size());
            for (Employee e: employeeList) {
                if (e.getName().equals(name)){
                    currentNameEmployees.add(e.getPhoneNumber());
                }
                return currentNameEmployees;
            }
        }
        return null;
    }



}
