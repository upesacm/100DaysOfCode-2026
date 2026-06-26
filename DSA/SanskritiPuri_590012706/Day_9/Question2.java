public class Main {

    public static String removeSpaces(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s1 = "C od ing";
        System.out.println(removeSpaces(s1));

        String s2 = "abc d ";
        System.out.println(removeSpaces(s2));
    }
}
