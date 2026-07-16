/*  Q1: Given a stack of integers and an integer x, insert x at the bottom of the 
stack while preserving the order of the remaining elements, and print the updated stack.

Example: 
Input:Stack = [1,2,3,4], x = 5;  Output:[5,1,2,3,4]   */


#include <stdio.h>
#define MAX 100

int stack[MAX];
int top= -1;
int temp_stack[MAX];


void push(int value)
{
    if (top == MAX-1)
    printf("overflow.");

    else 
    stack[++top] = value;

}


int pop()
{
    if (top == -1)
    {
        printf("underflow.");
    }

    int num= stack[top];
    top--;
    return num;
}


int main()
{
    int n,x,i;

    printf("enter n:");
    scanf("%d", &n);


    printf("enter elements: ");

    for (int i=0; i<n; i++)
    {
        scanf("%d", &stack[i]);
        push(stack[i]);
    }

    printf("enter x: ");
    scanf("%d", &x);

    int count=0;
    for (int i=0; i<n;i++)
    {
        temp_stack[count++]= pop();
    }
    push(x);

    for (int i=n-1; i>=0; i--)
    {
        push(temp_stack[i]);
    }


    printf("updated array: ");

    for (int i=0; i<=n; i++)
    {
        printf("%d ",  stack[i]);
    }

    return 0;
}