import java.util.*;

public class WordFrequencyAnalyzer {

    public static Map<String, Integer> analyzeWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+"); // split on whitespace characters

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        Map<String, Integer> sortedWordCounts = new TreeMap<>(new Comparator<String>() {
            public int compare(String word1, String word2) {
                int count1 = wordCounts.get(word1);
                int count2 = wordCounts.get(word2);
                if (count1 == count2) {
                    return word1.compareTo(word2);
                } else {
                    return count2 - count1;
                }
            }
        });

        sortedWordCounts.putAll(wordCounts);

        return sortedWordCounts;
    }

    public static void main(String[] args) {
        String text = "Learning is hard but learning to code is worth it";
        Map<String, Integer> wordCounts = analyzeWordFrequency(text);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
