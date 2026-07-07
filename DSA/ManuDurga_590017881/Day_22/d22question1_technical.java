package Day_22;

import java.util.*;
public class d22question1_technical {
    
    public static int[] scores(int[] nums) {
        int i = 0, j = nums.length - 1, p1 = 0, p2 = 0;
        boolean t = true;
        while (i <= j) {
            int p = nums[i] > nums[j] ? nums[i++] : nums[j--];
            if (t) p1 += p; else p2 += p;
            t = !t;
        }
        return new int[]{p1, p2};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        int[] result = scores(digits);
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
