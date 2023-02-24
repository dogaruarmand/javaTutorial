package numbers;

import java.security.SecureRandom;
import java.util.Random;

public class MathStuff {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;
        System.out.println(Math.min(num1, num2));
        System.out.println(Math.pow(num1, num2));
        System.out.println(Math.random());
        System.out.println((int)(Math.random() * 10));
        System.out.println(Math.round(5.0));
        System.out.println(Math.sqrt(4));

        Random random = new Random();
        System.out.println(random.nextInt(10)); // create a random number

        SecureRandom secureRandom = new SecureRandom();
        System.out.println(secureRandom.nextInt(10)); // create random number

        System.out.println(calcAreaOfCircle(3));

    }

    /**
     * This method calculate the area of a circle
     * It uses the formula: area = PI * radius^2
     * @param radius
     * @return area
     */
    public static double calcAreaOfCircle(double radius) {
        // Area = PI * r^2
        return Math.PI * Math.pow(radius, 2);
    }
}
