package exercises;

import exercises.finance.extern.Customer;
import exercises.finance.intern.Bank;
import exercises.finance.intern.BankManager;
import exercises.person.Person;

public class Main {
    public static void main(String[] args) {
        String[] week = {"monday", "thursday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        System.out.format("A week has %s days.\n", week.length);
        System.out.format("The 4th day is %s\n", week[3]);

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String[][] ticTacToe = new String[3][3];
        ticTacToe[0][0] = "0";
        ticTacToe[0][1] = "x";
        ticTacToe[0][2] = "x";
        ticTacToe[1][0] = "x";
        ticTacToe[1][1] = "0";
        ticTacToe[1][2] = "0";
        ticTacToe[2][0] = "x";
        ticTacToe[2][1] = "0";
        ticTacToe[2][2] = "0";
        System.out.println(ticTacToe[2][2]);

        createStringArray("1", "2", "3");

        ClassA.showText();

        Car car = new Car("Dacia", "Sandero Stepay", 2017);
        System.out.println(car);

        Bank bank = new Bank("ING");
        bank.setVault(100);
        BankManager bankManger = new BankManager("Bank Manager");
        bankManger.setVault(1500);
        Customer customer = new Customer("Customer", 100);

        Person person = new Person("first", "Name");
        System.out.println(person);

        String stringToBeReplaced = "I have cat beautiful, my cat is red, my cat is meaw";
        System.out.println(stringToBeReplaced.replace("cat", "dog"));

        String testString = "  alphabet  ";
        System.out.println(testString.replace("  alphabet  ", "alphabeT"));

        String address = "12345 Big St., Alphabet City, CA 90210";
        String[] commaSplitted = address.split(",");
        String buildingNumber = commaSplitted[0].substring(0, commaSplitted[0].indexOf(" "));
        System.out.println(buildingNumber);
        String street = commaSplitted[0].substring(commaSplitted[0].indexOf(" ") + 1);
        System.out.println(street);
        String city = commaSplitted[1].strip();
        System.out.println(city);
        String lastPart = commaSplitted[2].strip();
        String state = lastPart.substring(0, lastPart.indexOf(" "));
        System.out.println(state);
        String postalCode = lastPart.substring(lastPart.indexOf(" ") + 1);
        System.out.println(postalCode);

    }

    public static void createStringArray(String... elem) {
        System.out.println(elem.length);
    }
}
