class Solution {
public:
    vector<int> scores(vector<int>& nums) {
        int i = 0, j = nums.size() - 1;
        int p1 = 0, p2 = 0;
        bool turn = true;

        while (i <= j) {
            int pick;
            if (nums[i] > nums[j])
                pick = nums[i++];
            else
                pick = nums[j--];

            if (turn)
                p1 += pick;
            else
                p2 += pick;

            turn = !turn;
        }

        return {p1, p2};
    }
};