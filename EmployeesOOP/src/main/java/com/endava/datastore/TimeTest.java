package com.endava.datastore;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate newYears = LocalDate.of(2023, 1, 1);
        System.out.println(newYears.getDayOfWeek());
        newYears.datesUntil(LocalDate.now(), Period.ofMonths(1)) // skip month
                .forEach(System.out::println);

        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfWeek());
//        System.out.println(now.plus(3, ChronoUnit.YEARS));

        List<LocalDate> leapYears = now.datesUntil(LocalDate.now().plusYears(10), Period.ofYears(1))
                .filter(LocalDate::isLeapYear)
                .collect(Collectors.toList());
        System.out.println(leapYears);

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        LocalDate d1 = LocalDate.of(2000, 1, 1);
        LocalDate d2 = LocalDate.of(2000, 1, 1);

        LocalTime lt1 = LocalTime.of(10, 30);
        LocalTime lt2 = LocalTime.of(10, 30);

        LocalDateTime ldt1 = LocalDateTime.of(d1, lt1);
        LocalDateTime ldt2 = LocalDateTime.of(d2, lt2);
        System.out.println(ldt1.equals(ldt2));

        Period diff = Period.between(d1, d2);
        System.out.printf("%d years, %d months, %d days%n", diff.getYears(), diff.getMonths(), diff.getDays());

        System.out.println(ZonedDateTime.of(ldt1, ZoneId.systemDefault()));
    }
}
