import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (ch != 'a' && ch != 'e' && ch != 'i' &&
                ch != 'o' && ch != 'u') {

                ans = ans + "." + ch;
        }
        }

        System.out.println(ans);

        sc.close();
}
}