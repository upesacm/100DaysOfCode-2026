// LeetCode Question 213: House Robber II
// Given an array of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police, considering the houses are arranged in a circle.
int rob2(int* nums, int n) {
    int maxMoney = 0;
    for (int mask = 0; mask < (1 << n); mask++) {
        int valid = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (mask & (1 << i)) {
                int next = (i + 1) % n;   // circular adjacency
                if (mask & (1 << next)) { valid = 0; break; }
                sum += nums[i];
            }
        }
        if (valid && sum > maxMoney) maxMoney = sum;
    }
    return maxMoney;
}