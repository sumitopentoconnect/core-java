package com.example.corejava.stream_api;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {


    public static void run() {
        streamAPI();
    }

    private static void streamAPI() {
        System.out.println("3. Stream API ========================================== ");

        System.out.println("Creating Streams -> From Arrays");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

        System.out.println("Creating Streams -> Using Of");
        Stream<String> stream2 = Stream.of("x", "y", "z");
        stream2.forEach(System.out::println);

        System.out.println("Creating Streams -> From Collections");
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream3 = list.stream();
        stream3.forEach(System.out::println);

        System.out.println("Parallel Streams");
        list.parallelStream().forEach(element -> doWork(element));

        System.out.println("Stream Operations -> match");
        boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
        System.out.println(isExist);

        System.out.println("Stream Operations -> filtering");
        List<String> list1 = Arrays.asList("Sumit", "Amit", "Deepak", "Himanshu");
        Stream<String> filteredStream = list1.stream().filter(element -> element.contains("d"));
        filteredStream.forEach(System.out::println);

        // create D:\\My.txt", "D:\\Another.txt files before running below code block.
//        System.out.println("Stream Operations -> mapping");
//        List<String> uris = Arrays.asList("D:\\My.txt", "D:\\Another.txt");
//        Stream<Path> pathStream = uris.stream().map(uri -> Paths.get(uri));
//        pathStream.forEach(System.out::println);


        System.out.println("Stream Operations -> FlatMapping");
        List<CustomerDetail> details = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            details.add(new CustomerDetail("name"+i, Arrays.asList("888888888"+i, "777777777"+i, "999999999"+i)));
        }
        Stream<String> flatMappedStream = details.stream().flatMap(detail -> detail.getMobiles().stream());
        flatMappedStream.forEach(System.out::println);

        System.out.println("Stream Operations -> Matching");
        boolean anyContainH = list1.stream().anyMatch(element -> element.contains("H"));
        boolean allContainH = list1.stream().allMatch(element -> element.contains("H"));
        boolean noneContainH = list1.stream().noneMatch(element -> element.contains("H"));

        System.out.println("anyContainH = " + anyContainH );
        System.out.println("allContainH = " + allContainH );
        System.out.println("noneContainH = " + noneContainH );

        System.out.println("Stream Operations -> Reduction");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum );

        System.out.println("Stream Operations -> Collecting");
        List<String> upperCaseList = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("upperCaseList = " + upperCaseList );

    }

    private static void doWork(String e) {
        System.out.println(e);
    }


    static class CustomerDetail {
        private final String name;
        private final List<String> mobiles;

        public CustomerDetail(String name, List<String> mobiles) {
            this.name = name;
            this.mobiles = mobiles;
        }

        public String getName() {
            return name;
        }

        public List<String> getMobiles() {
            return mobiles;
        }
    }

}
