import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the size of array");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input");
            return;
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("please enter the element at index " + i);
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Please enter the targer");
        int target = sc.nextInt();
        int[] result = new int[2];
        for (int i = 0; i <= arr.length - 1; i++){
            for (int j = i + 1; j <= arr.length -1 ;j++){
                    if(arr[i] + arr[j] == target){
                        result[0] = i;
                        result[1] = j;
                        System.out.println(Arrays.toString(result));
                        return;
                    }
            }
        }

    }
}
