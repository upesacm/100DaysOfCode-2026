import java.util.HashSet;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();

        HashSet<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < username.length(); i++) {
            uniqueChars.add(username.charAt(i));
        }

        if (uniqueChars.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

        sc.close();
    }
}