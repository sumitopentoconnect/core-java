package com.example.corejava.lambda_expressions;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();


    public static void run() {
        lambdaExpressions();
    }

    private static void lambdaExpressions() {
        System.out.println("1. Lambda Expressions ========================================== ");
        // Traditional anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional anonymous class -> Hello, World!");
            }
        };

        // Lambda Expression
        Runnable r2 = () -> System.out.println("Lambda Expression -> Hello, World!");

        executor.execute(r1);
        executor.execute(r2);
        executor.shutdown();
    }

}
