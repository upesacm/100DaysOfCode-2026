public class Question2 {
    public int[] scores(int[] nums) {
        int i = 0, j = nums.length - 1, p1 = 0, p2 = 0;
        boolean t = true;
        while (i <= j) {
            int p = nums[i] > nums[j] ? nums[i++] : nums[j--];
            if (t) p1 += p; else p2 += p;
            t = !t;
        }
        return new int[]{p1, p2};
    }
}
