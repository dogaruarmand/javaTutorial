package regularExpresions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParses {
    public static void main(String[] args) {
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;
        /*
        look for anchor points, parts of text that are never change ( student number: , birthdate: .... )
        Pattern.DOTALL -> allow the dot to match next row
        | -. means OR
        Pattern.COMMENTS -> allow comments
         */

        String regex = """
            Student\\sNumber:\\s(?<studentNum>\\d{10}).* # Grab the stundent number            
            Grade:\\s+(?<grade>\\d{1,2}).* #Grab the grade
            Birthdate:\\s+(?<birthMonth>\\d{1,2})/(?<birthDay>\\d{1,2})/(?<birthYear>\\d{4}).* #Grab the birthdate            
            Gender:\\s+(?<gender>\\w+)\\b.* #Grab the gender  \\b word bundery area between a word char and a non word char (new line)            
            State\\sID:\\s+(?<stateID>\\d+)\\b.*? # Grab the state ID
            Cumulative.*?\\)\\s+(?<weightedGPA>[\\d\\.]+)\\b.* # Grab the weighted GPA
            #Weighted\\)\\s+(?<weightedGPA>[\\d\\.]+)\\b.* # Grab the weighted GPA
            #Unweighted\\)\\s+(?<unweightedGPA>[\\d\\.]+)\\b.* # Grab the unweighted GPA
            """; // regular expression
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS); // create the pattern for compare
        Matcher mat = pat.matcher(transcript); // match the string we want to compare with the pattern
        if (mat.matches()) {
            System.out.println(mat.group("studentNum"));
            System.out.println(mat.group("grade"));
            System.out.println(mat.group("birthMonth"));
            System.out.println(mat.group("birthDay"));
            System.out.println(mat.group("birthYear"));
            System.out.println(mat.group("gender"));
            System.out.println(mat.group("stateID"));
            System.out.println(mat.group("weightedGPA"));
//            System.out.println(mat.group("unweightedGPA"));
        }
    }
}
