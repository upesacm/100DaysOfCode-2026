class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unsigned int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int num : nums) {
                if ((static_cast<unsigned int>(num) >> i) & 1U) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                ans |= (1U << i);
            }
        }

        return static_cast<int>(ans);
    }
};