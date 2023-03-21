package com.endava.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    protected final DateTimeFormatter dtFormater = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
    private final static String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    protected final static Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    protected final Matcher peopleMat;
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;

    protected Employee() {
        peopleMat = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    protected Employee(String personText) {
        peopleMat = Employee.PEOPLE_PAT.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormater.parse(peopleMat.group("dob")));
        }
    }

    public static final IEmployee createEmployee(String employeeText){
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(employeeText);
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(employeeText); // access entire line group without name
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> new DummyEmployee();
//                default -> () -> 0; // lambda expression
            };
        } else {
            return new DummyEmployee();
//            return new Programmer(employeeText);
        }
    }

    public abstract int getSalary();  // by default any method defined in interface is public

    public double getBonus() {
        return getSalary() * 1.10;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName, moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName) && dob.equals(employee.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, dob);
    }

    private static final class DummyEmployee extends Employee {
        @Override
        public int getSalary() {
            return 0;
        }
    }

    /**
     * this method is used to compare last name for TreeSet
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(IEmployee o) {
        Employee other = (Employee) o;
        return this.firstName.compareTo(other.firstName);
    }
}
