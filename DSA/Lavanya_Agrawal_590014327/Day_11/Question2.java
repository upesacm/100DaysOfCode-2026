import java.util.*;

public class Question2 {

    public static String processString(String s) {

        StringBuilder result = new StringBuilder();

        String vowels = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (vowels.indexOf(ch) == -1) {

                result.append('.');
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(processString(s));

        sc.close();
    }
}