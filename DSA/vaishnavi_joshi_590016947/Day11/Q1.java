import java.util.Scanner;

public class IsomorphicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != mapT[c2]) {
                System.out.println(false);
                return;
            }

            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        System.out.println(true);
    }
}