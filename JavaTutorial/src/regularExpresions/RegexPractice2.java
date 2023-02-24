package regularExpresions;

public class RegexPractice2 {
    public static void main(String[] args) {
        System.out.println("doggy".matches(".")); // . = one char, mach any char
        System.out.println("doggy".matches("^.....")); // ^ = begin of the line
        System.out.println("doggy".matches("^.....?")); // ? = end of the line
        System.out.println("doggy".matches("^...$..?")); // $ = new line
        System.out.println("doggy".matches("\\b.....?")); // \\b = area between words space not included
        System.out.println("---".matches("\\W\\W\\W")); // anything that word char
        System.out.println("abc".matches("\\D\\D\\D")); // anything that digits char
        System.out.println(".".matches("\\S")); // non space char
    }
}
