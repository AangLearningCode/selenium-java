import java.util.Arrays;

public class moveNegativeNumberToStart {
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        moveNegativeNumber(arr);
    }

    private static void moveNegativeNumber(int[] arr){
        int[] tempArr = new int[arr.length];
        int negativeCount = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                tempArr[negativeCount] = arr[i];
                negativeCount++;
            }
        }
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > 0){
                tempArr[negativeCount] = arr[i];
                negativeCount++;
            }
        }
        System.out.println(Arrays.toString(tempArr));
    }
}
