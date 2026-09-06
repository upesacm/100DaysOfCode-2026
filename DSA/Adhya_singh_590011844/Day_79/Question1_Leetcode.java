import java.io.*;

public class Main {

    static String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder result =
                new StringBuilder(Math.max(a.length(), b.length()) + 1);

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            result.append((char) ('0' + (sum % 2)));

            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String a = br.readLine().trim();
        String b = br.readLine().trim();

        System.out.println(addBinary(a, b));
    }
}