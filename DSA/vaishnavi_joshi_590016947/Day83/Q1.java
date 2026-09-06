class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Check all 32 bits of an integer
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int num : nums) {
                // Check if ith bit is set
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // If count is not divisible by 3,
            // this bit belongs to the single number
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}