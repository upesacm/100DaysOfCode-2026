import java.io.*;

public class Question2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        int unique = 0;
        int count = 0;

        while (count < n) {
            String[] input = br.readLine().trim().split("\\s+");

            for (String s : input) {
                if (s.isEmpty()) continue;

                unique ^= Integer.parseInt(s);
                count++;

                if (count == n) break;
            }
        }

        System.out.println(unique);
    }
}