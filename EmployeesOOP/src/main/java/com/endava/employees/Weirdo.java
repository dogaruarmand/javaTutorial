package com.endava.employees;

import java.time.LocalDate;

public record Weirdo(String lastName, String firstName, LocalDate dob) {
    /**
     * this is another contructor for this record class
     * the parameters that you don't want in the constructor must be initialized/hardcoded
     * @param lastName
     * @param firstName
     */
    public Weirdo(String lastName, String firstName) {
        this(lastName, firstName, LocalDate.of(1, 1, 1));
    }

    public String sayHello() {
        return " Hello World";
    }
}
