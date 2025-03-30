import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class printRepeatingElements {
    /*

    * */
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
//        printRepeating(arr);
        printRepeatingPosition(arr);
    }

    private static void printRepeating(int[] arg){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arg.length; i++) {
            Integer mapValue = map.get(arg[i]);
            if (mapValue == null) {
                map.put(arg[i], 1);
            } else {
                map.put(arg[i], mapValue + 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            }
        };
    }

    private static void printRepeatingPosition(int[] arg){
        Map<Integer, Integer> map = new HashMap<>();
        int argLength = arg.length;
        for (int i = 0; i< argLength; i++){
            Integer mapValue = map.get(arg[i]);
            if(mapValue == null){
                map.put(arg[i],1);
            } else {
                map.put(arg[i], mapValue + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            if(entry.getValue() > 1){
                for (int i = 0; i < argLength;){
                    if (arg[i] == entry.getKey()){
                        list.add(i);
                    }
                    i++;
                }
                System.out.println("The value " + entry.getKey() + " is repeated at position " + list);
            }

        }

    }
}
