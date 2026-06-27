import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String vowels = "AEIOUYaeiouy";
        StringBuilder r = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) == -1) {
                r.append('.').append(Character.toLowerCase(ch));
            }
        }

        System.out.println(r);
        sc.close();
    }
}