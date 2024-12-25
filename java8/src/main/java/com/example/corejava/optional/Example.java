package com.example.corejava.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {


    public static void run() {
        streamAPI();
    }

    private static void streamAPI() {
        System.out.println("6. The Power of Optional ========================================== ");

        System.out.println("Creating Optional -> Empty");
        Optional<String> optional = Optional.empty();
        System.out.println(optional);

        System.out.println("Creating Optional -> With Value");
        String str = "Hello, world!";
        Optional<String> optional2 = Optional.of(str);
        System.out.println(optional2);

        System.out.println("Creating Optional -> ofNullable");
        Optional<String> optional3 = Optional.ofNullable(str);
        System.out.println(optional3);
        Optional<String> optional4 = Optional.ofNullable(null);
        System.out.println(optional4);

        System.out.println("6.2 Using Optional ");
        List<String> list = Arrays.asList("a","b","c");
        List<String> listOpt = list != null ? list : new ArrayList<>();
        System.out.println(listOpt);
        List<String> listOpt2 = Optional.ofNullable(list).orElseGet(() -> new ArrayList<>());
        System.out.println(listOpt2);

        System.out.println("6.3 Chaining with map()");
        System.out.println(getCityOldStyle());
        System.out.println(getCityJava8Style());

        System.out.println("6.4 Throwing Exceptions with Optional");
        String value = "Sumit";
        Optional<String> valueOpt = Optional.ofNullable(value);
        String result = valueOpt.orElseThrow(CustomException::new).toUpperCase();
        System.out.println(result);
    }

    public static String getCityOldStyle(){
        User user = new User("Sumit", new Address("Pune"));
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String city = address.getCity();
                if (city != null) {
                    return city;
                }
            }
        }
        return "not specified";
    }

    public static String getCityJava8Style(){
        User instance = new User("Sumit", new Address("Pune"));
        Optional<User> user = Optional.ofNullable(instance);
        return user
                .map(User::getAddress)
                .map(Address::getCity)
                .orElse("not specified");
    }


    public static class User {

        private final String name;
        private final Address address;

        public User(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public Address getAddress() {
            return address;
        }
    }


    public static class Address {

        private final String city;

        public Address(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }


    public static class CustomException extends RuntimeException {

    }

}
