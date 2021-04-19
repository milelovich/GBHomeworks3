import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

//    c. Для хранения фруктов внутри коробки можете использовать ArrayList;

    public Box(){
        fruits = new ArrayList<>();
    }

//    d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
//    (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    public float getWeight(){
        float result = 0;
        for(T fruit : fruits){
            result += fruit.getWeight();
        }
        return result;
    }

//    g. Не забываем про метод добавления фрукта в коробку.
    public void add(T fruit){
        fruits.add(fruit);
    }

//    e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//    которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
//    (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean compare(Box<?> smth) {
        if (getWeight() == smth.getWeight()) {
            return true;
        } else
            {
                return false;
            }
    }

//    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
//    фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
//    а в другую перекидываются объекты, которые были в этой коробке;
    public static <U extends Fruit> void transfer(Box<? extends U> box1, Box<? super U> box2) {
        box2.fruits.addAll(box1.fruits);
        box1.fruits.clear();
    }
}
