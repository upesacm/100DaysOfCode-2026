class Solution {

    // Count subarrays whose maximum element is <= bound
    private int countSubarrays(int[] arr, int bound) {

        int count = 0;
        int ans = 0;

        for (int num : arr) {

            if (num <= bound) {
                count++;
            } else {
                count = 0;
            }

            ans += count;
        }

        return ans;
    }

    public int boundedMaxSubarrays(int[] arr, int l, int r) {

        return countSubarrays(arr, r)
                - countSubarrays(arr, l - 1);
    }
}