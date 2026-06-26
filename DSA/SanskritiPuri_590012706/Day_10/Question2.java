import java.util.HashSet;

public class Main {

    public static String determineGender(String username) {

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < username.length(); i++) {
            set.add(username.charAt(i));
        }

        if (set.size() % 2 == 0) {
            return "CHAT WITH HER!";
        } else {
            return "IGNORE HIM!";
        }
    }

    public static void main(String[] args) {

        System.out.println(determineGender("alex"));
        System.out.println(determineGender("abc"));
        System.out.println(determineGender("sevenkplus"));
    }
}
