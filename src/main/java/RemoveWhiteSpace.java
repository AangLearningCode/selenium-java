public class RemoveWhiteSpace {
    public static void main(String[] args) {
        String str ="    Hello World        and Java Programming    ";
        removeWhiteSpace(str);
    }
    private static void removeWhiteSpace(String str) {
        String result = str.replaceAll("\\s+", " ");
        if(result.charAt(0) == ' ') {
            result = result.substring(1);
        }
        System.out.println(result);
    }
}
