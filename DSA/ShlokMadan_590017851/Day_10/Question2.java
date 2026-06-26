import java.util.HashSet;

public class Question2 {

    public static void main(String[] args) {

        String username = "alex";

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < username.length(); i++) {
            set.add(username.charAt(i));
        }

        if (set.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}