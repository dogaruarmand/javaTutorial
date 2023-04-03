package com.endava.datastore;

import javax.swing.text.html.Option;
import java.time.Year;
import java.util.Optional;

public class OptionalTest {
    record Car(String make, String model, String color, Year year){}
    record Person(String firstName, String lastName, Optional<Car> car){}
    public static void main(String[] args) {
        Person p1 = new Person("Tom", "Thumb", Optional.of(new Car("Tesla", "X", "Red", Year.of(2018))));
        Person p2 = new Person("Jerry", "Thumb", Optional.of(new Car("Tesla", "Y", "White", Year.of(2020))));

        Optional<Person> optPerson = Optional.of(p1);
        System.out.println(optPerson
                .flatMap(Person::car)
                .map(Car::make)
                .orElse("Unknown make"));

        String msg2 = null;
        Optional<String> optMsg2 = Optional.ofNullable(msg2);
        String finalOutput = optMsg2.orElse("alternative").toUpperCase();
//        System.out.println(finalOutput);

//        Optional<String> optMsg3 = Optional.ofNullable(msg2);
//        if (optMsg3.isPresent()) {
//            System.out.println(optMsg3.get());
//        } else {
//            System.out.println("Nothing here");
//        }
//        System.out.println(optMsg3.orElse("Nothing here"));
//
//        Optional<String> optMsg = Optional.of("Hello");
//        System.out.println(optMsg);
    }
}
