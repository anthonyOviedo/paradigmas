import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
public class Main {

    public static void main(String[] args) {

        // method = a block of code that is executed whenever it is called upon

        int x = 3;
        int y = 4;

        int z = add(x,y);
        System.out.println("z = 3 + 4: " + z);
        
        z = succ(x);
        System.out.println("z = 3 + 1: " + z);

        z = succ2.apply(x); // using lambda expression with apply method
        System.out.println("z = 3 + 2: " + z);

        Object o = "original hello";
        Object p = id.apply(o).toString()+" but p";
        System.out.println(o);
        System.out.println(p);

        Object u = id2("Hola generic");
        Object u2 = u + " but u2";
        System.out.println(u);
        System.out.println(u2);

        // function composition
        Function<Integer, Integer> f = a -> a + 1;
        Function<Integer, Integer> g = a -> a * 2;
        Function<Integer, Integer> h = comp(f, g);
        int result = h.apply(3); // (3 + 1) * 2
        System.out.println("Result of composition h(3) = (3 + 1) * 2: " + result);

        var array = new Integer[]{1,2,3,4,5};
        var list = arrayToList(array);
        System.err.println("List :" + list.size());
        System.err.println("Array :" + array.length);

        Arrays.stream(array).forEach(n -> System.err.print(n + " "));

    }
    
    public static <T> List<T> arrayToList(T[] array)  {
        List<T> list = new ArrayList<>();
        for (T item : array) {
            list.add(item);
        }
        return list;
    }

    static int add(int x, int y) {
        int z = x + y;
        return z;
    }

    static int succ (int x) {
        return x + 1;
    }

    static Function< Integer, Integer > succ2 = x -> x + 2;

    static Function<Object,Object> id = x -> x ;

    static <T> T id2 (T x){return x;}


    static <S, T, R> Function<S, R> comp(Function<S, T> f, Function<T, R> g){
        return (S x) -> g.apply(f.apply(x));
    }

    static <S, T, R> Function<S, R> comp2(Function<S, T> f, Function<T, R> g){
        return x -> g.apply(f.apply(x));
    }


 
}