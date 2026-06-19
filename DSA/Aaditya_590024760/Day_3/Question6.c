#include<stdio.h>
int num[50];
int main(){
    int n;
    printf("Enter The number of elements in the array: " );
    scanf("%d",&n);

    printf("Enter %d Elements: ", n);
    for(int i = 0; i<n ; i++){
        scanf("%d", &num[i]);
    }
    int count = 0;
    int target;
    printf("Enter the target Number: ");
    scanf("%d",&target);

    for(int i= 0; i<n ;i++){
        if(num[i]==target){
            count++;
        }
    }
    printf("The number appears %d times in the array.",  count);
    return 0;
}
