import java.util.HashMap;
import java.util.Map;

public class VowelsFrequencyOfEachCharacter {
    public static void main(String[] args) {
        String str = "Learn with Japneet Sachdeva";
        getVowelsFrequency(str);
    }

    private static void getVowelsFrequency(String str){
        Map<Character, Integer> map = new HashMap<>();
        String[] words = str.split(" ");
        map.put('A', 0);
        map.put('E', 0);
        map.put('I', 0);
        map.put('O', 0);
        map.put('U', 0);
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);

        for(String word:words){
            for(int i = 0; i < word.length(); i++){
                if(map.containsKey(word.charAt(i))){
                    int mapValue = map.get(word.charAt(i));
                    map.put(word.charAt(i),mapValue + 1);
                }
            }
        }
        map.forEach((k,v) -> System.out.println("Character:" + k +" Frequency " + v));


    }
}
