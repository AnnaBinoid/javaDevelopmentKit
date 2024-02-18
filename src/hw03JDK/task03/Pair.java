package hw03JDK.task03;

/*
Напишите обобщенный класс Pair,
который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond()
для получения значений каждого из составляющих пары,
а также переопределение метода toString(),
возвращающее строковое представление пары.
 */

public class Pair<T, S> {

    public T first;
    public S second;

    public Pair (T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "first = " + first + ", second = " + second;
    }

    public static void main(String[] args) {
        Pair<Integer, String> firstPair = new Pair<>(1, "a");
        Pair<Integer, Double> secondPair = new Pair<>(3, 2.0);

        System.out.println(firstPair);
        System.out.println(secondPair);

    }
}
