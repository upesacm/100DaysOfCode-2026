#include <stdio.h>

int lb(int a[], int n, int x){
    int l=0,r=n;
    while(l<r){
        int m=l+(r-l)/2;
        if(a[m]<x) l=m+1;
        else r=m;
    }
    return l;
}

int ub(int a[], int n, int x){
    int l=0,r=n;
    while(l<r){
        int m=l+(r-l)/2;
        if(a[m]<=x) l=m+1;
        else r=m;
    }
    return l;
}

int main(){
    int n,x;
    scanf("%d",&n);

    int a[n];
    for(int i=0;i<n;i++)
        scanf("%d",&a[i]);

    scanf("%d",&x);

    printf("%d", ub(a,n,x)-lb(a,n,x));
    return 0;
}