#include<stdio.h>
int num[50];
int main(){
 int a;
 printf("Enter The number of elements in the array: " );
 scanf("%d",&a);

 printf("Enter %d Elements: ", a);
 for(int j = 0; j<a ; j++){
    scanf("%d", &num[j]);
 }
 int large = 0;
 for(int j= 0; j<a ;j++){
    if(num[j]>large){
        large = num[j];
    }
    else if(large > num[j]){
        large = large;
        }
    }
    printf("Largest Number: %d", large);
    return 0;
 }
