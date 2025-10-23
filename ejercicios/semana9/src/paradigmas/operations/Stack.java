package src.paradigmas.operations;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Pila genérica con operaciones básicas y operate(Operator).
 * Para operate(…) se asume T extiende Number; en la práctica úsala con Double para evitar casting.
 */
public class Stack<T extends Number> {

    private final ArrayList<T> data = new ArrayList<>();

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T top() {
        return (data.isEmpty()) ? null : data.get(data.size() - 1);
    }

    public T pop() {
        if (data.isEmpty()) throw new NoSuchElementException("Stack underflow");
        return data.remove(data.size() - 1);
    }

    public void push(T value) {
        if (value == null) throw new IllegalArgumentException("null not allowed");
        data.add(value);
    }

    public T operate(Operator oper) {

        T v1 = pop(); 
        T v2 = pop();
        T v3 = pop();

        double a = v2.doubleValue();
        double b = v1.doubleValue();
        Operator c = new Operator(v3.toString());

        return switch (oper) {
            case ADD -> { yield a + b; }
            case MINUS ->  { yield a - b; }
            case MULT -> { yield a * b; }
            case DIV -> {
                if (b == 0.0) throw new ArithmeticException("Division by zero");
                yield a / b;
            }
            default -> throw new UnsupportedOperationException("Unknown operator: " + oper);
        };
    }
}
