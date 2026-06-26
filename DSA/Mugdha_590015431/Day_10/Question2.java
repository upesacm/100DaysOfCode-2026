package DSA.Mugdha_590015431.Day_10;
import java.util.*;
public class Question2 {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < username.length(); i++) {
            set.add(username.charAt(i));
        }

        if(set.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

        sc.close();
    }
}
