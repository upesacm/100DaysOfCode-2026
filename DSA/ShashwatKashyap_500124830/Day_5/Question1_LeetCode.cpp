bool canJump(vector<int>& nums) {
    int i = 0, cnt = 0;
    while (i < nums.size()) {
        if (cnt < i)
            return false;
        cnt = max(cnt, i + nums[i]);
        if (cnt >= nums.size() - 1)
            return true;
        i++;
    }
    return true;
}
