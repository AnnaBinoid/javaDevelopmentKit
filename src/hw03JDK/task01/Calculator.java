package hw03JDK.task01;

/*
Написать класс Калькулятор (необобщенный),
который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
**/


public class Calculator {

    public static <T extends Number> T sum(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        }
        else {throw new IllegalArgumentException("Wrong types of numbers.");}
    }

    public static<T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        }
        else { throw new IllegalArgumentException("Wrong types of numbers.");}
    }

    public static <T extends Number> T divide (T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() / b.intValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
        }
        else {throw new IllegalArgumentException("Wrong types of numbers.");}
    }

    public static<T extends Number> T subtract(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        }
        else {throw new IllegalArgumentException("Wrong types of numbers.");}
    }

    public static void main(String[] args) {

        try {
            int sumOfInts = Calculator.sum(12, 3);
            System.out.println("Sum is: " + sumOfInts);
            double sumOfDoubles = Calculator.sum(12.0, 3.0);
            System.out.println("Sum is: " + sumOfDoubles);
            Number sumOfNumbers = Calculator.sum(12.0, 3);
            System.out.println("Sum is: " + sumOfNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
