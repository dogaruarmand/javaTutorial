package regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
    public static void main(String[] args) {
        System.out.println("cat".matches("cat")); // check if a string match a regular string expression ( case sensitive )
        System.out.println("bat".matches("[cCbB]at")); // brackets expression check possibilities
        System.out.println("dat".matches("[a-fA-F]at")); // brackets expression check possibilities range of chars
        System.out.println("cat".matches("[^c]at")); // brackets expression check possibilities range of chars ^ - not this char
        System.out.println("flat".matches("[^c]at")); // expecting one char between brackets
        System.out.println("cat".matches("\\wat"));  //allow any letter from latin alphabet
        System.out.println("1".matches("\\d")); //allow any digit
        System.out.println("321-333-7652".matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
        System.out.println("321-333-7652".matches("\\d{3}-\\d{3}-\\d{4}")); // allow digits multiplied x times {x} and hyphen between digits
        System.out.println("321-333.7652".matches("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{4}")); //  multiplied x times {x} and hyphen or . or space (\\s) between digits
        System.out.println("321   333 7652".matches("\\d{3}[-.\\s]+\\d{3}[-.\\s]+\\d{4}")); // + sign means one or more char
        System.out.println("3213337652".matches("\\d{3}[-.\\s]*\\d{3}[-.\\s]*\\d{4}")); // * sign means 0 or more char
        System.out.println("321-333-7652".matches("\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{4}")); // ? sign means 0 or 1 char
        System.out.println("321-333-7652".matches("\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{3,4}")); // \\d{3,4} - 3 to 4 digits
        System.out.println("321-333-7652".matches("\\d{3}[-.\\s]?\\d{3}[-.\\s]?\\d{3,}")); // \\d{3,} - minimum 3 digits


        String regex = """
        # This is my regex to parse the parts of a phone number
        ((?<countryCode>\\d{1,2})[-.\\s]?)? #get's country code
        (\\(?(?<areaCode>\\d{3})\\)?[-.\\s]?) #get's area code
        ((\\d{3})[-.\\s]?) # get's exchange
        (\\d{4}) #get's line number
        """; // two groups in this pattern, parantheses inside is for delimiter a subgroup  that contains only the digits
        String phoneNumber = "12.(232) 333.2365";

        System.out.println(phoneNumber.matches("(\\d{3}[-.\\s]?){2}\\d{3,}")); // (\d{3}[-.\s]?){2} - mach between parantheses two times
        // expresion that accept one number in front

        System.out.println("1.321-333-7652".matches(regex)); // (\d{3}[-.\s]?){2} - mach between paranthises two times

        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS); // create pattern , not recommended to do it recursively

        Matcher mat = pat.matcher(phoneNumber); //create a matcher between the pattern and the string

        if (mat.matches()) {
            System.out.println("Country code with . = " + mat.group(1));  // print group 1
            System.out.println("Country code = " + mat.group("countryCode"));  // print group 2 when exists quantifier it takes the last group
            System.out.println("Area code with . = " + mat.group(3));
            System.out.println("Area code = " + mat.group("areaCode"));
            System.out.println("Exchange code with . = " + mat.group(5));
            System.out.println("Exchange code= " + mat.group(6));
            System.out.println("Line number = " + mat.group(7));
            System.out.println("Entire phone number = " + mat.group(0)); // returns entire string
        }
        // ?: put at start at the group for not remembering the group
        //?<> naming the group inside < >
    }
}
