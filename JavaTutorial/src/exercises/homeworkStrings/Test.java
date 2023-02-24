package exercises.homeworkStrings;

public class Test {

    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        String[] splitedText = text.split("[ .,]+");

        int maxLength = 1;
        String maxWord = "";
        int counter = 0;

        for (String w : splitedText) {
            maxLength = maxWord.length();

            int newMax = w.length();

            if (maxLength < newMax) {
                maxWord = w;
                maxLength = newMax;
            }
        }

        for (int maxItem = 0; maxItem < splitedText.length; maxItem++) {
            if (splitedText[maxItem].length() == maxLength) {
                counter++;
            }
        }

        System.out.println("Maximum length of a word from text is " + maxLength + " and it appears " + counter + " times.");
    }

}