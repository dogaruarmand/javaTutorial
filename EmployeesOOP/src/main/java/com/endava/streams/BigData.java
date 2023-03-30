package com.endava.streams;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BigData {
    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender){}
    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
//            Map<String, String> result =
            TreeMap<String, Map<Character, String>> result = Files.lines(Path.of("C:\\Projects\\Java\\Hr5m.csv")).parallel()
                    .skip(1)
                    .limit(10)
                    .map(s -> s.split(","))
                    .map(a -> new Person(a[2], a[4], new BigDecimal(a[25]), a[32], a[5].charAt(0)))
                    .collect(
                            groupingBy(Person::state, TreeMap::new,
                                    groupingBy(Person::gender,
                                            collectingAndThen(
                                                    reducing(BigDecimal.ZERO, Person::salary, (a, b) -> a.add(b)),
                                                    NumberFormat.getCurrencyInstance()::format))
                            ));
//                            .forEach((state, salary) -> System.out.printf("%s -> %s%n", state, salary));
            /*
            Long result =
                    Files.lines(Path.of("C:\\Projects\\Java\\Hr5m.csv")).parallel()
                            .skip(1)
                            .limit(101)
                            .map(s -> s.split(","))
                            .map(arr -> arr[25])
                            .mapToLong(sal -> Long.parseLong(sal))
                            .sum();
//                            .collect(Collectors.summingLong(sal -> Long.parseLong(sal)));

             */
            long endTime = System.currentTimeMillis();
//            System.out.printf("$%,d.00%n",result);
            System.out.println(result);
            int secondsStart = (int)((startTime / 1000) % 60);
            int secondsStop = (int)((endTime / 1000) % 60);
            System.out.println(secondsStop - secondsStart);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
