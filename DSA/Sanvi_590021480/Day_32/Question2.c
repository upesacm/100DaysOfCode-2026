#include <stdio.h>

int main() {
    
    int n;
    
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int top=-1;
    int stack1[n],stack2[n],temp[n];
    int top1=-1,top2=-1,topt=-1;
    printf("Enter array elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&stack1[++top1]);
    }
    while(top1!=-1){
        temp[++topt]=stack1[top1--];
    }
    while(topt!=-1){
        int x=temp[topt--];
        stack1[++top1]=x;
        stack2[++top2]=x;
    }
    for(int i=0;i<=top2;i++){
        printf("%d ",stack2[i]);
    }


    return 0;
}
