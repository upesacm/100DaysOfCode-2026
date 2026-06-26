import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Set<Character> distinct = new HashSet<>();
        for (char c : s.toCharArray()) {
            distinct.add(c);
        }

        if (distinct.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
