import java.util.*;

public class Question2 {

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

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(removeSpaces(s));

        sc.close();
    }
}