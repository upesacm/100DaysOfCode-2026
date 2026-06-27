import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder ans = new StringBuilder();

        for (char ch : s.toCharArray()) {
            char c = Character.toLowerCase(ch);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }

            ans.append('.').append(c);
        }

        System.out.print(ans);
    }
}