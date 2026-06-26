import java.util.Scanner;

public class RemoveSpaceFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            }
        }

        System.out.println(result.toString());
        sc.close();
    }
}