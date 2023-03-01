package controlFlow;

public class ForLoopExample {
    public static void main(String[] args) {
        String[] fruits = {"apple", "oramge", "pear", "plum"};
        for (int counter = 0; counter < fruits.length; counter++) {
            System.out.printf("Current fruit is %s%n ", fruits[counter]);
        }

        // another approach

        for (String fruit : fruits) {
            System.out.printf("Current fruit is %s%n ", fruit);
        }
    }
}
