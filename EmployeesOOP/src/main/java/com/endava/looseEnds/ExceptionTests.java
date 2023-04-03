package com.endava.looseEnds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionTests {
    public static void main(String[] args) {
        try {
            Files.lines(Path.of("blahblahblah"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("We are unable to open the file.");
        } finally {
            System.out.println("Make sure this runs no matter what....");
        }
        doSecondLevel(1);
        System.out.println("You made it to the end");
    }



    private static void doSecondLevel(int num) {
        String[] array = {"one", "two", "three"};
        try {
            System.out.println(array.length / num);
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException  | ArithmeticException e) {
            System.out.printf("Exception type: %s. Message: %s%n ", e.getClass(), e.getMessage());
        }
    }
}
