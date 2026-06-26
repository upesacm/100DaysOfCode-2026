import java.util.*;
public class Question2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        Set<Character> distinct = new HashSet<>();

        for (char ch : username.toCharArray()) {
            distinct.add(ch);
        }

        if (distinct.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
        sc.close();
    }
}
    

