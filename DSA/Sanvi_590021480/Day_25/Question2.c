#include <stdio.h>

int main() {
    
    int n,target;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int nums[n];
    printf("Enter array elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&nums[i]);
    }
    printf("Enter target: ");
    scanf("%d",&target);
    int left=0,right=n-1;
    while(left<=right){
        if (nums[left]+nums[right]==target){
            printf("true");
            return 0;
        }
        else if(nums[left]+nums[right]>target)
        right--;
        else
        left++;
    }
    printf("false");

    return 0;
}
