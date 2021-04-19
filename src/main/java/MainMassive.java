import java.util.ArrayList;

public class MainMassive {
    public static void main(String[] args) {
        System.out.println("Новый массив:");
        Massive<?> m = new Massive<>(new BoxOrange(), new BoxApple());
        m.info();

        System.out.println("\nМеняем элементы местами:");
        m.masElementsExchange();
        m.info();

        System.out.println("\nArrayList:");
        ArrayList<?> list = m.arrayToArrayList();
        for (Object o : list) System.out.println(o.getClass().getName());
    }
}
