import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        HashSet<Character> set = new HashSet<>();

        for (char ch : username.toCharArray()) {
            set.add(ch); 
        }

        if (set.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
