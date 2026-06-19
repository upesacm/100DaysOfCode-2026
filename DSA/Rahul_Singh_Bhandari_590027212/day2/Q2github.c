#include<stdio.h>
int lasgest(int*arr,int len){
    int k=arr[0];
    for(int i=1;i<len;i++){
        if(arr[i]>k){
            k=arr[i];
        }

    }
    return k;
}