package exercises.homeworkStrings;

public class SecondClass {
    private int maxWordLength = 1;
    private int nrWordsMaximCharLength = 0;
    private int counter = 0;
    public static void main(String[] args) {
        SecondClass main = new SecondClass();


        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        System.out.println(str);
        String[] splited = str.split("[ ,.]+");
        for (String word : splited) {
            main.calculateLength(word);
        }
        System.out.format("In the string above there are %s words with maximum length of %s chars.", main.getNrWordsMaximCharLength(), main.getMaxWordLength());
    }

    private void calculateLength(String word) {
        if (word.length() >= this.getMaxWordLength()){
            if (this.getMaxWordLength() < word.length() && this.getNrWordsMaximCharLength() > 0){
                this.setNrWordsMaximCharLength(this.getNrWordsMaximCharLength() - this.getCounter());
                this.setCounter(0);
            }
            this.setMaxWordLength(word.length());
            if (this.getNrWordsMaximCharLength() == 0){
                this.setNrWordsMaximCharLength(1);
                this.setCounter(1);
            } else {
                this.setNrWordsMaximCharLength(this.getNrWordsMaximCharLength() + 1);
                this.setCounter(this.getCounter() + 1);
            }
        }
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public void setMaxWordLength(int maxWordLength) {
        this.maxWordLength = maxWordLength;
    }

    public int getNrWordsMaximCharLength() {
        return nrWordsMaximCharLength;
    }

    public void setNrWordsMaximCharLength(int nrWordsMaximCharLength) {
        this.nrWordsMaximCharLength = nrWordsMaximCharLength;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}