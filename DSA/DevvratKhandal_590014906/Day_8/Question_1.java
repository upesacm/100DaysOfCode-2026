import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String cleaned = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned += Character.toLowerCase(ch);
            }
        }

        int i = 0;
        int j = cleaned.length() - 1;
        boolean palindrome = true;

        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) {
                palindrome = false;
                break;
            }

            i++;
            j--;
        }

        System.out.println("Is palindrome: " + palindrome);
    }
}