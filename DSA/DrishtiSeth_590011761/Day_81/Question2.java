import java.util.*;

public class Main {

    public static int findUnique(int[] nums) {

        int result = 0;

        // Check all 32 bits of an integer
        for (int bit = 0; bit < 32; bit++) {

            int count = 0;

            for (int num : nums) {

                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // If remainder is 1, this bit belongs to the unique number
            if (count % 3 != 0) {
                result |= (1 << bit);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findUnique(nums));

        sc.close();
    }
}
