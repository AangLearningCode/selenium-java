public class PrintFirstLetterOfString {
    public static void main(String[] args) {
        String str = "Hello This is the example of string";
        printFirstLetterOfString(str);
    }

    private static void printFirstLetterOfString(String str){
        String[] words = str.split(" ");
        for(String word: words){
            System.out.println(word.charAt(0));
        }
    }
}
