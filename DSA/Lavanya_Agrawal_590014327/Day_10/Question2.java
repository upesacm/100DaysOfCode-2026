import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        boolean[] seen = new boolean[26];
        int distinct = 0;
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            
            if (!seen[idx]) {
                seen[idx] = true;
                distinct++;
            }
        }
        
        if (distinct % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
        
        sc.close();
    }
}