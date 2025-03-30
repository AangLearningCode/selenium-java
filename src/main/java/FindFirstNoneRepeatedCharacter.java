import java.util.HashMap;
import java.util.Map;

public class FindFirstNoneRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        firstNonRepeatedCharacter(str);
    }

    public static void firstNonRepeatedCharacter(String str) {
        Map<Character,Integer> map = new HashMap<>();
        int counter = 1;
        for(int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))) { //if the map contains the character, then update the value of that key
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else { //if the map does not contain the character, then add it to the map
                map.put(str.charAt(i),counter);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }

}
