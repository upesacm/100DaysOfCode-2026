#include <stdio.h>
#define MAX 100
int stack1[MAX], stack2[MAX], temp[MAX];
int top1=-1,top2=-1,topTemp=-1;
void push1(int x){
    stack1[++top1]=x;
}
int pop1() 
{
    return stack1[top1--];
}

void push2(int x) 
{
    stack2[++top2]=x;
}
void pushTemp(int x) 
{
    temp[++topTemp]=x;
}

int popTemp() 
{
    return temp[topTemp--];
}
int main() 
{
    int n,i,x;
    printf("Enter number of elements: ");
    scanf("%d",&n);
    printf("Enter stack elements:\n");
    for(i=0;i<n;i++) {
        scanf("%d", &x);
        push1(x);
    }
    while(top1!=-1) 
    {
        pushTemp(pop1());
    }
    while(topTemp != -1) 
    {
        x=popTemp();
        push1(x);   
        push2(x);   
    }
    printf("Copied Stack: ");
    for(i=0;i<=top2;i++) {
        printf("%d ",stack2[i]);
    }
    return 0;
}