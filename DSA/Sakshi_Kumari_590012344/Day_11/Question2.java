import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));

            if (ch != 'a' && ch != 'e' && ch != 'i' &&
                ch != 'o' && ch != 'u') {
                result.append('.').append(ch);
            }
        }

        System.out.println(result);
    }
}
