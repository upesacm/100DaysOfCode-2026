import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean repeat = false;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    repeat = true;
                    break;
                }
            }
            if (repeat == false) {
                count++;
            }
        }
        if (count % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}