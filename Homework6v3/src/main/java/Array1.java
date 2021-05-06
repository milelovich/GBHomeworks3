import java.util.Arrays;

public class Array1 {

//    Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
//    необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных
//    данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]

    public static int[] findAfterFour(int[] values) {
        if (values == null || values.length == 0) {
            throw new RuntimeException("Массив не должен быть пустым");
        }

        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 4) {
                index = i + 1;
            }
        }

        if (index == -1) {
            throw new RuntimeException("Четверок не найдено");
        }

        int[] copied = new int[values.length - index];
        System.arraycopy(values, index, copied, 0, copied.length);
        return copied;
    }

}
