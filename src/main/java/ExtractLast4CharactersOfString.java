public class ExtractLast4CharactersOfString {
    public static void main(String[] args) {
        String str = "Hello World";
//        System.out.println(extractLast4Characters(str));
        prrintLast4Characters(str);
    }
    private static String extractLast4Characters(String str) {
        return str.substring(str.length() - 4);
    }
    private static void prrintLast4Characters(String str){
        for (int i = str.length() - 4; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}
