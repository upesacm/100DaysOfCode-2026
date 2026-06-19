//Given an sorted integer array and a target value, count the number of occurrences of the target in the array and return the result.
#include<stdio.h>

 int occur(int arr[],int n,int target){
    int count=0;
    for (int i=0;i<n;i++){
        if(arr[i]==target){
            count++;
        }
    }
    return count;
 }
 int main(){
    int arr[]={1,1,2,2,2,2,3,3,3,3,4,4,4};
    int n=sizeof(arr)/sizeof(arr[0]);
 }