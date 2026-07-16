#include <stdio.h>
#define MAX 100
int stack[MAX];
int top=-1;
void push(int x) 
{
    if (top==MAX-1)
        return;
    stack[++top] = x;
}
int pop() 
{
    if (top == -1)
        return -1;
    return stack[top--];
}

void insertBottom(int x) {
    if(top==-1) {
        push(x);
        return;
    }
    int temp=pop();
    insertBottom(x);
    push(temp);
}
void display() 
{
    printf("[");
    for (int i=0;i<=top;i++) {
        printf("%d",stack[i]);
        if (i!=top)
            printf(",");
    }
    printf("]");
}
int main() 
{
    int n,x;
    scanf("%d",&n);
    for (int i=0;i<n;i++) {
        int val;
        scanf("%d", &val);
        push(val);
    }
    scanf("%d",&x);
    insertBottom(x);
    display();
    return 0;
}