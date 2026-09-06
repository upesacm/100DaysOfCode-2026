import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());

        int result = 0;
        int count = 0;

        while (count < n) {

            String[] parts = br.readLine().trim().split("\\s+");

            for (String part : parts) {
                result ^= Integer.parseInt(part);
                count++;

                if (count == n) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}