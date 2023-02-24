package exercises.regex;

public class regex {
    public static void main(String[] args) {
        String text1 = "stark";
        String regex1 = "[DbLs]t?ark";
        System.out.println(text1.matches(regex1));

        String text2 = "Agracadagra";
        String regex2 = "A(?<code>b?g?ra)cada\\k<code>";
        System.out.println(text2.matches(regex2));
    }
}
