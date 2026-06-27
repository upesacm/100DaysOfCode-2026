import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.next();

        boolean[] present = new boolean[256];
        int total = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(!present[ch]) {
                present[ch] = true;
                total++;
            }
        }

        int ans = str.length();

        for(int i = 0; i < str.length(); i++) {

            boolean[] seen = new boolean[256];
            int count = 0;

            for(int j = i; j < str.length(); j++) {

                char ch = str.charAt(j);

                if(!seen[ch]) {
                    seen[ch] = true;
                    count++;
                }

                if(count == total) {
                    ans = Math.min(ans, j - i + 1);
                    break;
        }
        }
        }

        System.out.println("Length of smallest window = " + ans);
    }
}