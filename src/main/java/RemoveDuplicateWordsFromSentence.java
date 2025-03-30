import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateWordsFromSentence {
    public static void main(String[] args) {
        String str = "Goodbye bye bye world world world good Goodbye";
        printSentenceWithoutDuplicateWords(str);
        printDuplicateWordOnly(str);
    }

    private static void printSentenceWithoutDuplicateWords(String str){
        String[] words = str.split("\\s");
        String newString = "";
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer mapValue = map.get(word);
            if(mapValue == null){
                map.put(word, 1);
                newString = newString + word + " ";
            } else{
                continue;
            }
        }
        System.out.println(newString);
    }
    private static void printDuplicateWordOnly(String str){
        String[] words = str.split("\\s");
        String newString = "";
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            Integer mapValue = map.get(word);
            if(mapValue == null){
                map.put(word, 1);
            } else {
                map.put(word, mapValue + 1);
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() > 1){
                newString = newString + entry.getKey() + " ";
            } else {
                continue;
            }
        }
        System.out.println(newString);
    }
}
