class Solution {
public:
    int singleNumber(vector<int>& nums) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int cnt = 0;

            for (int num : nums) {

                if (num & (1 << i)) {
                    cnt++;
                }
            }

            if (cnt % 3 != 0) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
};