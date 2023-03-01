package firstApp;

import firstApp.model.Dog;
import firstApp.model.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person johnny = new Person("johnny", "smith", LocalDate.of(2000, 11, 1));
        System.out.format("The person first name is: %s. \n", johnny.getFirstName());
        johnny.setLastName("smith");
        System.out.format("The person last name is: %s. \n", johnny.getLastName());

        System.out.println("Hello World");

        Person armand = new Person("Armand", "Dogaru", LocalDate.of(1984, 07, 28));
        Person mihaela = new Person("Mihaela", "Doagru", LocalDate.of(1985,02,20));

        armand.setSpouse(mihaela);

        Dog stela = new Dog("Stela", LocalDate.of(2022, 06, 01));
        stela.bark();
        armand.setPet(stela);

        System.out.println(armand);
    }
}
