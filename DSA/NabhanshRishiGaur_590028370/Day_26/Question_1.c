void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void sortColors(int* nums, int numsSize) {

    int low = 0;
    int mid = 0;
    int high = numsSize - 1;

    while (mid <= high) {

        if (nums[mid] == 0) {
            swap(&nums[low], &nums[mid]);
            low++;
            mid++;
        }
        else if (nums[mid] == 1) {
            mid++;
        }
        else {
            swap(&nums[mid], &nums[high]);
            high--;
        }
    }
}
