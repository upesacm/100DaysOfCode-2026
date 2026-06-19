#include <stdio.h>

void arrMax(int arr[], int arrSize){
    int max = arr[0];
    for(int i=1; i<arrSize; i++){
        (max<arr[i]) && (max=arr[i]);
    }
    printf("%d", max);
}

int main(){
    int exampleArr[] = {2 ,3 ,4 ,3};
    arrMax(exampleArr, sizeof(exampleArr)/sizeof(exampleArr[0]));
    return 0;
}