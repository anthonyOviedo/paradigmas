package src.paradigmas.operations.utils.test;

import java.util.NoSuchElementException;

import src.paradigmas.operations.Stack;

/** Simple ad-hoc tests for Stack. */
public final class TestStack {

    private int passed;
    private int failed;

    public static void main(String[] args) {
        new TestStack().run();
    }

    private void run() {
        check("emptyStackHasSizeZero", this::emptyStackHasSizeZero);
        check("pushChangesSizeAndTop", this::pushChangesSizeAndTop);
        check("popRespectsLifo", this::popRespectsLifo);
        check("popOnEmptyThrows", this::popOnEmptyThrows);
        check("topOnEmptyThrows", this::topOnEmptyThrows);
        check("pushNullThrows", this::pushNullThrows);

        if (failed > 0) {
            System.err.println("Tests failed: " + failed + " (passed " + passed + ")");
            System.exit(1);
        }
        System.out.println("Tests passed: " + passed);
    }

    private void check(String name, Runnable test) {
        try {
            test.run();
            passed++;
        } catch (Throwable error) {
            failed++;
            System.err.println("- " + name + " FAILED: " + error.getMessage());
        }
    }

    private void emptyStackHasSizeZero() {
        Stack<Double> stack = new Stack<>();
        require(stack.isEmpty(), "stack should start empty");
        require(stack.size() == 0, "size should be zero");
    }

    private void pushChangesSizeAndTop() {
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        require(!stack.isEmpty(), "stack should not be empty after push");
        require(stack.size() == 1, "size should be one after push");
        double top = stack.top();
        assertDoubleEquals(1.0, top, "top should be last pushed value");
        require(stack.size() == 1, "top should not remove element");
    }

    private void popRespectsLifo() {
        Stack<Double> stack = new Stack<>();
        stack.push(1.0);
        stack.push(2.0);
        stack.push(3.0);

        assertDoubleEquals(3.0, stack.pop(), "first pop should return last pushed");
        assertDoubleEquals(2.0, stack.pop(), "pop should follow LIFO");
        assertDoubleEquals(1.0, stack.pop(), "pop should exhaust stack");
        require(stack.isEmpty(), "stack should be empty after popping all");
    }

    private void popOnEmptyThrows() {
        Stack<Double> stack = new Stack<>();

        expectThrows(NoSuchElementException.class, stack::pop, "pop on empty");
    }

    private void topOnEmptyThrows() {
        Stack<Double> stack = new Stack<>();

        expectThrows(NoSuchElementException.class, stack::top, "top on empty");
    }

    private void pushNullThrows() {
        Stack<Double> stack = new Stack<>();

        expectThrows(IllegalArgumentException.class, () -> stack.push(null), "push null");
    }

    private void assertDoubleEquals(double expected, double actual, String message) {
        if (Math.abs(expected - actual) > 1e-9) {
            throw new AssertionError(message + ": expected " + expected + ", got " + actual);
        }
    }

    private void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private <E extends Throwable> void expectThrows(Class<E> type, Runnable action, String name) {
        try {
            action.run();
        } catch (Throwable error) {
            if (type.isInstance(error)) return;
            throw new AssertionError(name + " should throw " + type.getSimpleName() + " but got " + error);
        }
        throw new AssertionError(name + " should have thrown " + type.getSimpleName());
    }
}
