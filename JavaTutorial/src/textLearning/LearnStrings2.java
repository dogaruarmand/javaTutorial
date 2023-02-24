package textLearning;

public class LearnStrings2 {
    public static void main(String[] args) {
        String fruit = "apple";
        String anotherFruit = "apple"; // for fruit and anotherFruit same object in memory, they share same memory address
        String vegetable = new String("broccoli");  //new memory space allocated
        String anotherVegetable = new String("broccoli");

        //see pointing memory address - check if variables share the same memory address
//        System.out.println(fruit == anotherFruit);
//        System.out.println(vegetable == anotherVegetable);

        String myText = "here's firf my awesome firf text";
//        System.out.println(myText.isBlank()); //verifica daca sunt introduse spatii si retuneaza true

//        System.out.println(myText.replace("FIRF", "nice"));  // replace a string with another one
//        System.out.println(myText.replace('e', 'Z')); // replace char with another char

        String firstName = "  Jake  "; //remove the spaces
//        System.out.format("'%s'\n", firstName);
//        System.out.format("'%s'\n", firstName.strip());
//        System.out.format("'%s'\n", firstName.stripLeading()); // remove white spaces from the beginning of the string
//        System.out.format("'%s'\n", firstName.stripTrailing()); // remove the white spaces at the end of the string

        String multiLineString = """
                        first line here
                                second line here
                third line here
                """;

//        System.out.println(multiLineString.stripIndent());

//        System.out.format("'%s'\n", firstName.trim());  // old method from early java versions remove white spaces
//        System.out.format("'%s'\n ", split("  unu  "));  // custom function created at the bottom of the page

        String myText2 = "Four score and seven years ago";
        int length = myText2.length();
//        System.out.println(mytext2.charAt(3));  // show char at a specific index

        String firstWord = "Apple";
        String secondWord = "apple";
//        System.out.println(firstWord.compareTo(secondWord));
//        System.out.println(firstWord.compareToIgnoreCase(secondWord));
//
//        System.out.println(compareToIgnoreCase("alpha", "Beta"));

//        System.out.println(myText2.contains("seven")); // returns true if contain a string

        String text1 = "this is my text1";
        String text2 = "this is my text2";
//        System.out.println(text1 + " " + text2 + " hello"); // simple way of concatenation for 2 strings (don't do it like this memory consumption


        //recommended method for concatenate strings
        String finalString = new StringBuilder(text1.length() + text2.length() + 1) // inside can have a parameter with the length of strings that we concatenate
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
//        System.out.println(text1.concat(text2));
//        System.out.println(finalString);

        // old method for concatenate strings
        String anotherFinalString = new StringBuffer()
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
//        System.out.println(anotherFinalString);

//        System.out.format("%s %s\n", text1, text2);

        String oneMoreFinalString = String.format("%s %s", text1, text2);
//        System.out.println(oneMoreFinalString);

        // length of stings
        System.out.println(myText2.length());

    }

    public static String split(String text) {  // simple method that strip spaces from a string
        return text.replace(" ", "");
    }

    public static int compareToIgnoreCase(String text1, String text2) {
        return text1.toLowerCase().compareTo(text2.toLowerCase());
    }
}
