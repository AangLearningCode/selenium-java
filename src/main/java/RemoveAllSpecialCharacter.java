public class RemoveAllSpecialCharacter {
    public static void main(String[] args) {
        String str = "Learn ^ with @  Japneet @ Sachdeva %^&^&*^&* ";
        removeAllSpecialCharacter(str);
    }

    private static void removeAllSpecialCharacter(String str) {
        String newStr = str.replaceAll("[%^#$()!_+@&*]", "");
        System.out.println(newStr.trim());
    }
}
