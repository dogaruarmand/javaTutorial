package numbers;

public class NumericWrapper {
    /**
     * Takes in any type of data and stores it somewhere generically
     * @param args
     */
    public static void main(String[] args) {
        int num = 7;
        Integer num1B = Integer.valueOf(num); // java create a wrapper class when we send primitive as an object to a class
        Double myDouble = Double.valueOf(2343.12);
        Float myFloat = Float.valueOf(23.23f);
        Byte myByte = Byte.valueOf("23"); // suply the number as a string, otherwise it will be consider as a double

        storeData(num);

        int age = Integer.parseInt("37");
        double amount = Double.parseDouble("245.12");
        boolean flag = Boolean.parseBoolean("true");

        System.out.printf("You will be %d age in 15 tears.%n", age + 15);
    }

    public static void storeData(Object obj) {
        // do something with obj

    }
}
