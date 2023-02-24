package exercises.homeworkStrings;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private int maxWordLength = 1;
    private int nrWordsMaximCharLength = 0;
    public static void main(String[] args) {
        Main main = new Main();
        String str = "This is my beautiful string with many words with different lengths";
        System.out.println(str);
        String[] splited = str.split("\\s+");
        //Map<String, Integer> res = new HashMap<String, Integer>();
        Map[] res;
        for (String word : splited) {
            res = main.calculateLength(word);
        }
        System.out.format("In the string above there are %s words with maxim length of %s chars.", res.get("words"), res.get("length"));
    }

    private Map[] calculateLength(String word) {
        Map<String, Integer> result = new HashMap<>();
        if (word.length() >= this.getMaxWordLength()){
            this.setMaxWordLength(word.length());
            if (this.getNrWordsMaximCharLength() == 0){
                this.setNrWordsMaximCharLength(1);
            } else {
                this.setNrWordsMaximCharLength(this.getNrWordsMaximCharLength() + 1);
            }
        }

        result.put("length",this.getMaxWordLength());
        result.put("words",this.getNrWordsMaximCharLength());

        return new Map[]{result};
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
}
