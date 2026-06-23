public class RemoveSpaces {
    public static String removeSpaces(String s) {
        return s.replace(" ", "");
    }

    public static void main(String[] args) {
        String str = "My Name is Mouli Rathor";
        System.out.println(removeSpaces(str));
    }
}
