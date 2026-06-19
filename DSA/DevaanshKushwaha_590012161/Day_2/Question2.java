import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {12, 35, 1, 10, 34, 1};
        int max = nums[0];
        for (int n : nums)
            if (n > max) max = n;
        System.out.println(max);
    }
}
