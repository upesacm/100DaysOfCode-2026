void sortedSquares(int nums[], int n) {
    int result[n];
    int left = 0, right = n - 1;
    int i;

    for (i = n - 1; i >= 0; i--) {
        if (nums[left] * nums[left] > nums[right] * nums[right]) {
            result[i] = nums[left] * nums[left];
            left++;
        } else {
            result[i] = nums[right] * nums[right];
            right--;
        }
    }

    printf("Sorted Squares: ");
    for (i = 0; i < n; i++)
        printf("%d ", result[i]);
}