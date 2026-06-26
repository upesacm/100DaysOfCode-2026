import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for (char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            if ("aeiouy".indexOf(c) == -1)
                System.out.print("." + c);
        }
    }
}