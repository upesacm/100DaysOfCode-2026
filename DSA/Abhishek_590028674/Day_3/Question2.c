#include <stdio.h>

int bSearch(int arr[], int arrSize, int target, int boolFirst){
    int l = 0, h = arrSize-1, result = -1;
    while(l <= h){
        int m = l + (h-l)/2;
        if(arr[m] == target){
            result = m;
            if(boolFirst) 
                h = m-1;
            else
                l = m+1;
        } 
        else if(arr[m] < target)
            l = m+1;
        else
            h = m-1;
    }
    return result;
}

void targetCount(int arr[], int arrSize, int target){
    int first = bSearch(arr, arrSize, target, 1);
    if(first == -1){
        printf("0");
        return;
    }
    int last = bSearch(arr, arrSize, target, 0);
    printf("%d", last-first+1);
}

int main(){
    int exampleArr[] = {1, 1, 2, 2, 2, 3, 3};
    int exampleTarget = 2;
    targetCount(exampleArr, sizeof(exampleArr)/sizeof(exampleArr[0]), exampleTarget);
    return 0;
}