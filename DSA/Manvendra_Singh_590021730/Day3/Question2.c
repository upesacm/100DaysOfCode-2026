// This function counts the occurrences of a target value in an array of integers. The input parameters are:
int countOccurrences(int* nums, int n, int target) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (nums[i] == target)
            count++;
    }
    return count;
}  