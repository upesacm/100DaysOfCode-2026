import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = sc.next();

        HashSet<Character> distinctChars = new HashSet<>();

        for (char ch : username.toCharArray()) {
            distinctChars.add(ch);
        }

        if (distinctChars.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

        sc.close();
    }
}
