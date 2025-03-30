public class ChangeSpecialCharacter {
    public static void main(String[] args) {
        String str = "Hello, @Japneet";
        System.out.println(printDifferentSpecialCharacter(str));

    }
    private static String printDifferentSpecialCharacter(String str) {
        return str.replace("@", "_");
    }
}
