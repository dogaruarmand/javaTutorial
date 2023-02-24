package textLearning;

public class TextLearning {
    public static void main(String[] args) {
        String myText = "four score and seven years ago";
//        System.out.println(myText);
        char[] chars = myText.toCharArray(); // split a string to an array of chars
        int index = 100000;
        if (index < myText.length()) {
            System.out.println(chars[index]);
        }

        String secondText = "score";
        StringBuilder builder = new StringBuilder(myText.length() + secondText.length())
                .append(myText)
                .append(secondText);
//        System.out.println(builder.toString());

//        System.out.println(myText);

//        String myNewText = myText.substring(0, 1).toUpperCase() + myText.substring(1).toLowerCase();
        String firstPart = myText.substring(0, 1); // create a substring starting from begin index ending with end index
        String restPart = myText.substring(1);
        String  myNewText = firstPart.toUpperCase().concat(restPart.toLowerCase());
//        System.out.println(myNewText);

//        System.out.println(myText.indexOf("seven")); // if contains a word and where is starting of ( be aware is case sensitive )

        String myText2 = "ABCDEFGABCDEFG";
//        System.out.println(myText2.indexOf(65));  //returns index of a unicode char if is in the string ex. 65 -> A
//        System.out.println(myText2.indexOf(122)); // -> returns -1 - means character it isn't found in the string
//        System.out.println(myText2.lastIndexOf("A")); // returns last index where it is a match with the char on the string
//        System.out.println(myText2.indexOf("A", 2)); // search a char starting with index

        String phoneNumber = "(234) 333-5551"; //areaCode, exchange, lineNumber
//        System.out.println("phone number = " + phoneNumber);
        String areaCode = getAreaCode(phoneNumber);
        String exchange = getExchange(phoneNumber);
        String lineNumber = getLineNumber(phoneNumber);

//        System.out.println("area code = " + areaCode);
//        System.out.println("exchange = " + exchange);
//        System.out.println("line number = " + lineNumber);

        String text = """
                Smith,Fred,1/1/79,1111 ABC St.,Apple,CA
                McGuire,Jerry,2/2/80,222 DEF St.,Orange,NV
                Flinstone,Fred,3/3/81,3333 GHI St.,Pear,MO
                Rubble,Barney,4/4/82,4444 JKL St.,Pineaple,IL
                Jetson,George,5/5/83,5555 MNO St.,Grapefruit,NY
                """;
        String[] people = text.split("\n"); // split after new line
//        System.out.println(people.length);
//        System.out.println(people[2]);
        String[] george = people[2].split(",");
//        System.out.println(george[3]);

        String filename = "   file001.txt".strip(); // strip is deleting the spaces
//        System.out.println(filename.endsWith("txt")); // tell if string is ending with
//        System.out.println(filename.startsWith("file")); // tell if string is starting with

        String firstString = "apple";
        String secondString = "apple";

        System.out.println(firstString.contentEquals(secondString)); // compare two values of two Stringss
        System.out.println(firstString.equals(secondString)); // c

    }
    public static String getAreaCode(String phoneNumber) {
        return phoneNumber.substring(phoneNumber.indexOf('(') + 1, phoneNumber.indexOf(')'));
    }

    public static String getExchange(String phoneNumber) {
        return phoneNumber.substring(phoneNumber.indexOf(' ') + 1, phoneNumber.indexOf('-'));
    }

    public static String getLineNumber(String phoneNumber) {
        return phoneNumber.substring(phoneNumber.indexOf('-') + 1);
    }
}
