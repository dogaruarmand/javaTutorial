package numbers;

import java.math.BigDecimal;

public class NumberStuff {
    public static void main(String[] args) {
        byte myByte = 13; // -128 : 127 bit
        boolean myFlag = true; // shortest value 0 or 1
        short myBigShort = 45; // two bytes memory assign -32758 : 32767
        char myChar = 'g';
        char myA = 'A'; // ASCI 65
        char biggerShort = 64000; // can use double as a short can use numbers
        int myInt = 123; // -2147483648 : 2147483647
        float myFloat = 13.4f; // identical as int
        long myLong = 1234; // -9223372036854775808 : 9223372036854775807
        double myDouble = 1234.1234; // identical as long

        float num1 = 2.15f;
        float num2 = 1.10f;
        System.out.println(num1 - num2);

        byte anotherByte = 0x1f; // 0x tell java that i wanna introduce a hexanumber
        int anotherInt = 0b01 | 0b10 | 0b100; // 0b -> tell java that I wanna introduce an binary number number 7, | is like a +
        System.out.println(anotherInt % 4); // tell witch bit is on

        BigDecimal num3 = new BigDecimal("2.15");
        BigDecimal num4 = new BigDecimal("1.10");
        System.out.println(num3.subtract(num4));  // preferred use for money calculations, also BigInteger is a class for integer witch is long


    }
}
