import java.util.Scanner;

public class StringProcessingTask {

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!isVowel(ch)) {
                result.append('.')
                      .append(Character.toLowerCase(ch));
            }
        }

        System.out.println(result.toString());
    }
}