package com.example.corejava.functional_interface;

import java.util.function.*;

public class Example {

    public static void run() {
        customFunctionalInterface();
        builtInFunctionalInterface();
    }

    private static void customFunctionalInterface() {
        System.out.println("2. Functional Interface ========================================== ");
        Greeting greet = name -> System.out.println("Hello, " + name);
        greet.sayHello("Alice");

        Calculator add = (a, b) -> a + b;
        System.out.println(add.operate(5, 3)); // 8
        Calculator multiply = (a, b) -> a * b;
        System.out.println(multiply.operate(5, 3)); // 15
    }


    @FunctionalInterface
    public interface Greeting {
        void sayHello(String name);
    }

    @FunctionalInterface
    public interface Calculator {
        int operate(int a, int b);
    }

    private static void builtInFunctionalInterface() {
        System.out.println("2.1. Built-in Functional Interface ========================================== ");
        //1. Predicate: Represents a boolean-valued function of one argument.
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // true

        //2. Function: Represents a function that accepts one argument and produces a result.
        Function<String, Integer> length = str -> str.length();
        System.out.println(length.apply("hello")); // 5

        //3. Consumer: Represents an operation that accepts a single input argument and returns no result.
        Consumer<String> printer = System.out::println;
        printer.accept("Hello World");

        //4. Supplier: Represents a supplier of results.
        Supplier<Double> random = Math::random;
        System.out.println(random.get());

        //5. BiFunction: Represents a function that accepts two arguments and produces a result.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; System.out.println(add.apply(2, 3)); // 5
    }


}
