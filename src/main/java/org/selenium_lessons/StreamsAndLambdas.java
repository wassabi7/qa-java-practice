package org.selenium_lessons;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAndLambdas {

    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Diego");
        names.add("Alisa");
        names.add("Bob");
        names.add("Jack");

        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actualName = names.get(i);

            if (actualName.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Stream Filter
    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Diego");
        names.add("Alisa");
        names.add("Bob");
        names.add("Jack");

        long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        long count = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack").filter(s -> s.startsWith("A")).count();
        System.out.println(count);
    }

    @Test
    public void printNamesWithLengthFour() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        names.filter(s -> s.length() > 4).forEach(System.out::println);
    }

    @Test
    public void printFastResult() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        names.filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
    }

    // Stream Map
    @Test
    public void printNamesEndsWithLetterToUppercase() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        names.filter(s -> s.endsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void printNamesEndsWithLetterToUppercaseAndSorted() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        names.filter(s -> s.endsWith("a"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void mergeArrayLists() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        Stream<String> names1 = Stream.of("Sergio", "Vasya", "Liza", "Alex", "Artur");
        Stream<String> newNames = Stream.concat(names, names1);

        newNames.sorted().forEach(System.out::println);

    }

    @Test
    public void anyMatch() {
        Stream<String> names = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack");
        Stream<String> names1 = Stream.of("Sergio", "Vasya", "Liza", "Alex", "Artur");
        Stream<String> newNames = Stream.concat(names, names1);

        boolean match = newNames.anyMatch(s -> s.equalsIgnoreCase("Sergio"));
        Assert.assertTrue(match);
    }

    // Stream Collect
    @Test
    public void convertingStreamToList() {
        List<String> list = Stream.of("Anna", "Diego", "Alisa", "Bob", "Jack")
                .filter(s -> s.endsWith("a"))
                .map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(list.get(0));
    }

    @Test
    public void printUniqueNumbersOfArrayAndSort() {
        List<Integer> list = Arrays.asList(3, 2, 2, 2, 4, 6, 7, 1, 3, 2, 1, 7);
        list.stream().distinct().sorted().forEach(System.out::println);
    }
}
