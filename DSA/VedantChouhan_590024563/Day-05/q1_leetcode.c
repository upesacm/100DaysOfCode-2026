#include <stdio.h>
#include <stdbool.h>

int main() {
    int nums[] = {2, 3, 1, 1, 4};
    int n = sizeof(nums) / sizeof(nums[0]);

    int maxReach = 0;

    for(int i = 0; i < n; i++) {

        if(i > maxReach) {
            printf("false\n");
            return 0;
        }

        if(i + nums[i] > maxReach) {
            maxReach = i + nums[i];
        }

        if(maxReach >= n - 1) {
            printf("true\n");
            return 0;
        }
    }

    printf("false\n");

    return 0;
}