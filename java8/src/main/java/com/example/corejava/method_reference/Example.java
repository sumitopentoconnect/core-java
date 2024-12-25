package com.example.corejava.method_reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void run() {
        methodReference();
    }

    private static void methodReference() {
        List<User> list = Arrays.asList(new User("Sumit"), new User("Amit"), new User("Deepak"));
        System.out.println("5. Method References ========================================== ");
        List<String> userNames = list.stream().map(u -> User.toUpperCase(u.getName())).collect(Collectors.toList());
        System.out.println("Static Method = " + userNames);
        List<String> userNames2 = list.stream().map(u -> u.getName()).map(User::toUpperCase).collect(Collectors.toList());
        System.out.println("Static Method  = " + userNames2);
        List<String> userNames3 = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("Instance Method  = " + userNames3);
        List<String> list1 = Arrays.asList("Sumit","Amit");
        List<User> userNames4 = list1.stream().map(User::new).collect(Collectors.toList());
        System.out.println("Reference to a Constructor  = " + userNames4);
    }



    public static class User {

        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static String toUpperCase(String name) {
            return name.toUpperCase();
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
