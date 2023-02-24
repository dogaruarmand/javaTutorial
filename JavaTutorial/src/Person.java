import java.time.LocalDate;

public class Person {
    private String firstName;
    private String middleName = "Name";
    public String lastName;
    protected LocalDate dob;
    public static double PI = 3.14; //o variabila static poate sa fie accesata/afisata chiar daca nu este initailizata clasa din care provine
//    public static int[] nums;  //nums poate fi definit mai jos
    public static int[] nums = initNums(); //sau se initializeaza apeland metoda static de initializare a numerelor

    static { //metoda care se refera la orice variabila de tip static din clasa
        nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
    }

    public static int[] initNums() { // metoda de initializare a parametrilor statici ai unei functii
        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        return nums;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public char getMiddleName() {
        return middleName.charAt(0);
    }

    public void saySomething(String message) {
        System.out.println(message);
    }

    public int add( int num1, int num2) {
        return num1 + num2;
    }

    public void test(String[] words) {

    }

    public void test2(String... words) {
        System.out.println(words.length);
    }

    public static void main(String[] args) { // metoda public static void este metoda principala care se apeleaza chiar daca nu se initializeaza clasa din care provine
        Person p1 = new Person();
        p1.firstName = "FirstName";
        p1.lastName = "LastName";
        p1.sayHello();
        p1.saySomething("Have a nice day!");
        System.out.println(p1.getMiddleName());
        System.out.println(p1.add(2, 3));
        p1.test(new String[] {"one", "two", "three"});
        p1.test2("one", "two", "three");
        System.out.println(PI);
    }
}
