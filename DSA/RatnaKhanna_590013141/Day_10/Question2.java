import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        int[] freq = new int[26];
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            int index = username.charAt(i) - 'a';
            if (freq[index] == 0) {
                count++;
                freq[index] = 1;
            }
        }
        if (count % 2 == 0)
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
}
