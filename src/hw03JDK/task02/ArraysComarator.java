package hw03JDK.task02;

/*
Напишите обобщенный метод compareArrays(),
который принимает два массива и возвращает true, если они одинаковые,
и false в противном случае.
Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class ArraysComarator {

    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    return false;
                }
            }
        } else { return false;}

        return true;
    }

    public static void main(String[] args) {
        Double[] doubArr1 = {0.1, 1.0, 2.0};
        Double[] doubArr2 = {0.0, 1.0, 2.0};

        String[] stringArr1 = {"cat1", "cat2", "cat3"};
        String[] stringArr2 = {"cat1", "cat2", "cat3"};

        System.out.println(compareArrays(doubArr1, doubArr2));
        System.out.println(compareArrays(stringArr1, stringArr2));
    }
}
