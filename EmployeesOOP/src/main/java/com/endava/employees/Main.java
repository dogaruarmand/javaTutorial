package com.endava.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        /**
         * locpd = lines of code per day
         * yoe = years of experience
         * iq = IQ
         * orgSize = organization size, nr peopleText
         * dr = direct reports
         * projectCount = nr of project
         *
         */
        String peopleText = """
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

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(peopleText);

//        Flyer flyer = new CEO("Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}");
//        flyer.fly();

//        Programmer coder = new Programmer("");
//        coder.cook("hamburger");

        int totalSallaries = 0;
        IEmployee employee = null;
        List<IEmployee> employees = new ArrayList<>();
        while (peopleMat.find()){
            String details = peopleMat.group("details");
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
//            System.out.println(employee.toString());
//            totalSallaries+= employee.getSalary();
        }

//        employees.get(0); // first person from the collection

//        List<String> undesirables = List.of("Wilma5", "Barney4", "Fred2");
//        List<String> undesirables = new ArrayList();
//        undesirables.add("Wilma5");
//        undesirables.add("Barney4");
//        undesirables.add("Fred2");

//        IEmployee myEmp = employees.get(5);
////        System.out.println(myEmp);
//        System.out.println(employees.contains(myEmp));
//
//        IEmployee employee1 = Employee.createEmployee("Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}");
//        System.out.println(employee1);
//        System.out.println(employees.contains(employee1));
//
//        System.out.println(myEmp.equals(employee1));

        /**
         * this loop is used to remove elements from collections while iterate
         */
//        removeUndesirables(employees, undesirables);
//
//        sort employes collections
//        employees.sort(new Comparator<IEmployee>() {
//            @Override
//            public int compare(IEmployee o1, IEmployee o2) {
//                if(o1 instanceof Employee emp1 && o2 instanceof Employee emp2 ){
//                    return emp1.lastName.compareTo(emp2.lastName);
//                }
//                return 0;
//            }
//        });

        for (IEmployee worker : employees) {
            System.out.println(worker.toString());
            totalSallaries+= worker.getSalary();
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("The total pay out should be %s%n", currencyInstance.format(totalSallaries));

        /**
         * weirdo is a record that is like a final class, with constructor in the definition.
         * getter is calling recordname.fieldsname()
         * doesn't have setter
         * can't extend a class
         */
//        Weirdo larry = new Weirdo("David", "Larry", LocalDate.of(1950, 1, 1));
//        System.out.println(larry.lastName());
//
//        Weirdo jake = new Weirdo("Snake", "Jake");
//        jake.sayHello();
    }

//    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
//        for (Iterator<IEmployee> it = employees.iterator(); it.hasNext();) {
//            IEmployee worker = it.next();
//            if (worker instanceof Employee tmpWorker) {
//                if(removalNames.contains(tmpWorker.firstName)) {
//                    it.remove();
//                }
//            }
//        }
//    }
}
