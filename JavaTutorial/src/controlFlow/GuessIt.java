package controlFlow;

import java.util.Random;

public class GuessIt {
    /**
     * This class is generating a random number and check if it is equal to a value, if it is print a message
     * @param args
     */
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(3) + 1;
        System.out.printf("Generated number is: %d.%n", randomNumber);

        if (randomNumber == 3) {
            System.out.println("You got it!");
        } else {
            System.out.println("Sorry you didn't get it.");
        }

        switch (randomNumber) {
            case 1:
                System.out.println("number is 1");
                break;
            case 2:
                System.out.println("Number is 2");
                break;
            default:
                System.out.println("another number");
                break;
        }

        String command = null;
        if ("stop".equals(command)) {
            System.out.println("Stopping now...");
        } else if ("go".equals(command)) {
            System.out.println("Going now...");
        } else {
            System.out.println("Command not understood");
        }
    }

    private static boolean shouldIGo() {
        return true;
    }
}
