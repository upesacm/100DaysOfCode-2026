#include <stdio.h>
#include <stdlib.h>

int* unionArray(int arr1[],int n,int arr2[],int m,int* size){
    int *res=(int*)malloc((n+m)*sizeof(int));
    int i=0,j=0,k=0;

    while(i<n && j<m){
        if(arr1[i]<arr2[j]){
            if(k==0 || res[k-1]!=arr1[i]) res[k++]=arr1[i];
            i++;
        }
        else if(arr1[i]>arr2[j]){
            if(k==0 || res[k-1]!=arr2[j]) res[k++]=arr2[j];
            j++;
        }
        else{
            if(k==0 || res[k-1]!=arr1[i]) res[k++]=arr1[i];
            i++;
            j++;
        }
    }

    while(i<n){
        if(k==0 || res[k-1]!=arr1[i]) res[k++]=arr1[i];
        i++;
    }

    while(j<m){
        if(k==0 || res[k-1]!=arr2[j]) res[k++]=arr2[j];
        j++;
    }

    *size=k;
    return res;
}

int main(){
    int n,m;
    scanf("%d",&n);
    int arr1[n];
    for(int i=0;i<n;i++) scanf("%d",&arr1[i]);

    scanf("%d",&m);
    int arr2[m];
    for(int i=0;i<m;i++) scanf("%d",&arr2[i]);

    int size;
    int *result=unionArray(arr1,n,arr2,m,&size);

    for(int i=0;i<size;i++) printf("%d ",result[i]);

    free(result);
    return 0;
}