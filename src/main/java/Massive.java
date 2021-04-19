import java.util.ArrayList;
import java.util.Arrays;

    public class Massive<T> {
        private T[] massive;

        public Massive(T... mas) { this.massive = mas; }

        public void masElementsExchange(){
            T tmp = massive[0];
            massive[0] = massive[1];
            massive[1] = tmp;
        }

        public void setObj(T[] mas) { this.massive = mas; }

        public T[] getObj() { return massive; }

        public void info() { for (T item : massive) System.out.println(item.getClass().getName()); }

        public ArrayList<T> arrayToArrayList() {
            ArrayList<T> list = new ArrayList<>(Arrays.asList(massive));
            return list;
        }
    }

