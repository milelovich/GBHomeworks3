public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        System.out.println("Вес одного яблока: " + a1.getWeight());
        System.out.println("Вес одного апельсина: " + o1.getWeight());

        appleBox1.add(a1);
        appleBox1.add(a2);
        appleBox1.add(a3);
        orangeBox2.add(o1);
        orangeBox2.add(o2);

        System.out.println("\nВес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox2.getWeight());
        System.out.println("Равны ли коробки по весу? ----> " + appleBox1.compare(orangeBox2) + "\n");

        Box<Apple> appleBox2 = new Box<Apple>();
        System.out.println("Вес коробок до перемещения: ");
        System.out.println("Вес первой коробки: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки: " + appleBox2.getWeight());
        appleBox1.transfer(appleBox2);
        System.out.println("Вес коробок после перемещения: ");
        System.out.println("Вес первой коробки: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки: " + appleBox2.getWeight());
    }
    }

