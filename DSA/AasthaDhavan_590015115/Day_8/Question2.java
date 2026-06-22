import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = sc.nextLine();

        for (int i = s.length() - 1; i >= 0; i--)
            System.out.print(s.charAt(i));
    }
}