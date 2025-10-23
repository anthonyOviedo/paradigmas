import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class test <T>{
    public static void main(String[] args){

        UnaryOperator<Integer> f = x -> x + 1;
        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;
        Predicate<Integer> esPar = x -> x % 2 == 0;
        Function<Integer,Integer> id = x -> x;
        BinaryOperator<Integer> multi = (a,b) -> a * b;

        Function<Void, Integer> moo = x -> 666;

        Consumer<String> goo = x -> System.out.println(x + "!!!");
        

        BinaryOperator<Integer> hoo = (x, y) -> x*x - 2*x*y + y*y;
        System.out.println(id.apply(5));
        System.out.println(f.apply(1));
        System.out.println(sumar.apply(2,3));
        System.out.println(esPar.test(3));
        System.out.println(multi.apply(2,3));
        System.out.println(moo.apply(null));
        goo.accept("hola");
        System.out.println(hoo.apply(5,3));
    }
}
