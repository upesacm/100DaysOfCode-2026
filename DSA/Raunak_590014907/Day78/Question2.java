class Solution {
    public int maximumXOR(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int value = nums[i] ^ nums[j];

                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }
}