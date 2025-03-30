import java.util.HashMap;
import java.util.Map;

public class MapInterface {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Key", 10);
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 30);
        System.out.println(map.get("Alice"));
        map.put("Anna", 20);
        System.out.println(map.containsKey("Bob"));
        System.out.println(map.containsValue(30));
        System.out.println(map.size());

        //loop through the map using entrySet()
//        for(Map.Entry<String, Integer> entry : map.entrySet()){
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key + " : " + value);
//        }

        //loop through the map using keySet()
//        for (String key : map.keySet()){
//            Integer value = map.get(key);
//            System.out.println(key + " : " + value);
//        }
//        //Loop through the map using values()
//
//        for(Integer value : map.values()){
//            System.out.println("Value: " + value);
//        }

        //Loop through the map using forEach
       map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
