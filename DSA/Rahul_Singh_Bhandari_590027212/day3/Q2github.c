#include<stdio.h>
#include<stdlib.h>
int count(int*arr,int size ,int ele){
    int j=0;
    for(int i=0;i<size;i++){
        if(arr[i]==ele){
            j++;
        }
    } return j;
} 
int main(){
    int array[]={1,1,2,2,2,2};
    int b,occ;
    b= (sizeof(array))/sizeof(array[0]);
    int c=2;
    occ=count(array,b,c);
    printf("%d",occ);
    return 0;
}