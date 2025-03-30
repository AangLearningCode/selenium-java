public class FindLargestSmallestAnd2ndLargest {
    public static void main(String[] args) {
        int[] arg = {23,5,1,89,65,0,23,432,12,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        printLargest2ndLargestAndSmallest(arg);
        printSmallest2nd(arg);
    }

    private static void printLargest2ndLargestAndSmallest(int[] arg){
        int argLength = arg.length;
        int largest = arg[0];
        int smallest = arg[0];
        int secondLargest = arg[0];

        for(int i = 0; i < argLength; i++){
            if(arg[i] > largest){
                secondLargest = largest;
                largest = arg[i];
            } else if(arg[i] < smallest){
                smallest = arg[i];
            }
        }
//        System.out.println("Largest: " + largest);
//        System.out.println("Smallest: " + smallest);
        System.out.println("Second Largest: " + secondLargest);

    }
    private static void printSmallest2nd(int[] arg){
        int argLength = arg.length;
        int smallest = arg[0];
        int secondSmallest = arg[0];
        for (int i = 0; i < argLength; i++){
            if(arg[i] < smallest){
                secondSmallest = smallest;
                smallest= arg[i];
            }
        }
        System.out.println("Smallest: " + smallest);
    }
}
