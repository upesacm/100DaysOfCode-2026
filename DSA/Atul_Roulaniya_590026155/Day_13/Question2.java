import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n1 = s1.length();
        int[] dp1 = new int[n1 + 1];
        int[] last1 = new int[256];
        for (int i = 0; i < 256; i++)
        {
            last1[i] = -1;
        }
        dp1[0] = 1;
        for (int i = 1; i <= n1; i++) 
        {
            dp1[i] = 2 * dp1[i - 1];
            char ch = s1.charAt(i - 1);

            if (last1[ch] != -1)
            {
                dp1[i] -= dp1[last1[ch] - 1];
            }
            last1[ch] = i;
        }
        int n2 = s2.length();
        int[] dp2 = new int[n2 + 1];
        int[] last2 = new int[256];

        for (int i = 0; i < 256; i++)
            last2[i] = -1;

        dp2[0] = 1;

        for (int i = 1; i <= n2; i++) {
            dp2[i] = 2 * dp2[i - 1];
            char ch = s2.charAt(i - 1);

            if (last2[ch] != -1)
                dp2[i] -= dp2[last2[ch] - 1];

            last2[ch] = i;
        }

        if (dp1[n1] >= dp2[n2])
            System.out.println(s1);
        else
            System.out.println(s2);
    }
}