public class FindMaximumDifference {
    public static void main(String[] args) {
        int[] arg = {23,5,1,89,65,1,23,432,12,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        printMaxDifference(arg);
    }
    private static void printMaxDifference(int[] arg){
        int argLength = arg.length;
        int smallest = arg[0];
        int largest = arg[0];

        for(int i = 0; i < argLength; i++){
            smallest = Math.min(smallest,arg[i]);
            largest = Math.max(largest,arg[i]);
        }
        System.out.println("Max Difference: " + (largest - smallest));
    }
}
