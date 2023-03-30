package com.endava.streams;

import com.endava.employees.Employee;
import com.endava.employees.IEmployee;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.Predicate.not;

public class StreamsStuff {
    public static void main(String[] args) {
        String peopleText = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmerzzzzzz, {locpd=2000,yoe=10,iq=140}
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

//        peopleText.lines()
//                .map(s -> Employee.createEmployee(s))
//                .forEach(System.out::println);

//        record Car(String make, String model){}
//        Stream.of(new Car("Ford", "Bronco"), new Car("Tesla", "x"), new Car("Tesla", "3"))
//                .filter(c -> "Tesla".equals(c.make))
//                .forEach(System.out::println);
//
//        String myVar = null;
//        Stream.ofNullable(myVar) //ofNullable doesn't put null into stream
//                .forEach(System.out::println);
//
//        Stream.of("one", "two", "three", "four")
//            .map(String::hashCode)
//                .map(Integer::toHexString)
//            .forEach(System.out::println);

        Predicate<Employee> dummyEmpSelector = employee -> "N/A".equals(employee.getLastName());
        Predicate<Employee> overFiveSelector = e -> e.getSalary() > 5000;

        /**
         * find someone who respect a condition
         */
//        Optional<Employee> optionEmp = peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .map(e -> (Employee) e)
//                .filter(dummyEmpSelector.negate())
//                .findFirst();
//        System.out.println(optionEmp
//                .map(Employee::getFirstName)
//                .orElse("No match"));
//
//        boolean allOver3K = peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .map(e -> (Employee)e)
//                .filter(dummyEmpSelector.negate())
//                .allMatch(e -> e.getSalary() > 2500);
//        System.out.println(allOver3K);
//
//        /**
//         * remove the duplicate letters from firstname
//         */
//        peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .map(e -> (Employee)e)
//                .map(Employee::getFirstName)
//                .map(firstName -> firstName.split(""))
//                .flatMap(Arrays::stream)
//                .map(String::toLowerCase)
//                .distinct()
//                .forEach(System.out::print);
//        System.out.println("\nFilter employees");




        long sum = peopleText
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee)e)
                .filter(dummyEmpSelector.negate().and(overFiveSelector))
                .collect(Collectors.toSet()).stream()
                .sorted(comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary))
                .mapToInt(StreamsStuff::showEmpAndGetSalary)
                .skip(5)
//                .sum();
//                .average();
                .reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(sum);
    }

    public static int showEmpAndGetSalary(IEmployee e) {
        System.out.println(e);
        return e.getSalary();
    }
}
