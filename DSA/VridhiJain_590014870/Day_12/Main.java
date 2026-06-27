import java.util.Scanner;
public class Main {
    public static int smallestWindow(String s) {
        boolean[] a = new boolean[256];
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!a[c]) {
                a[c] = true;
                d++;
            }
        }
        int ans = s.length();
        for (int i = 0; i < s.length(); i++) {
            boolean[] b = new boolean[256];
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!b[c]) {
                    b[c] = true;
                    count++;
                }
                if (count == d) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(smallestWindow(s));
    }
}