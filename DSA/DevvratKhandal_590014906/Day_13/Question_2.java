import java.util.*;

public class Question_2 {

    static HashSet<String> set;

    static void find(String s, int index, String current) {

        if (index == s.length()) {
            set.add(current);
            return;
        }

        // Take character
        find(s, index + 1, current + s.charAt(index));

        // Don't take character
        find(s, index + 1, current);
    }

    static int countSubsequence(String s) {

        set = new HashSet<>();

        find(s, 0, "");

        return set.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String s1 = sc.nextLine();

        System.out.println("Enter second string:");
        String s2 = sc.nextLine();

        int a = countSubsequence(s1);
        int b = countSubsequence(s2);

        System.out.println("String with maximum distinct subsequences is:");
        if (a >= b)
            System.out.println(s1);
        else
            System.out.println(s2);
    }
}