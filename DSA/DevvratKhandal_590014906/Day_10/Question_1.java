import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter haystack: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle: ");
        String needle = sc.nextLine();

        int ans = -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
            }
            }

            if (found) {
                ans = i;
                break;
        }
        }

        System.out.println("Index = " + ans);

        sc.close();
}
}