class Solution {

    public int countSubarrays(int[] arr, int l, int r) {

        int lastInvalid = -1;
        int lastValid = -1;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] > r) {
                lastInvalid = i;
            }
            if (arr[i] >= l && arr[i] <= r) {
                lastValid = i;
            }
            if (lastValid > lastInvalid) {
                ans += lastValid - lastInvalid;
            }
        }

        return ans;
    }
}
