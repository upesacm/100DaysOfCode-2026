#include <stdio.h>
int singleNumber(int nums[], int n) {
    int answer = 0;
    for (int bit = 0; bit < 31; bit++) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] & (1 << bit))
                count++;
        }
        if (count % 3 != 0)
            answer = answer | (1 << bit);
    }
    return answer;
}
int main() {
    int n;
    scanf("%d", &n);
    int nums[n];
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);
    printf("%d\n", singleNumber(nums, n));
    return 0;
}