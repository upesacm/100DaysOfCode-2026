import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                result += ch;
            }
        }

        System.out.println(result);
    }
}
