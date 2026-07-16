/*Insert Element at Bottom of Stack
Explanation
Given a stack of integers and an integer x, insert x at the bottom of the stack while preserving the order of the remaining elements, and print the updated stack.*/

#include<stdio.h>
#define MAX 100

int stack[MAX];
int top = -1;

void push(int x){
    if(top == MAX - 1){
        printf("Stack Overflow");
    }else{
        stack[++top] = x;
    }
}

int pop(){
    if(top == -1){
        printf("Stack Underflow\n");
        return -1;
    }
    
    return stack[top--];
}

int main(){

    int i, n, x;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter the elements: ");
    for(i = 0; i < n; i++){
        scanf("%d", &stack[++top]);
    }

    printf("Enter element to insert: ");
    scanf("%d", &x);

    for(i = top; i >= 0; i--){
        stack[i + 1] = stack[i];
    }
    stack[0] = x;
    top++;

    for(i = 0; i <= top; i++){
        printf("%d ", stack[i]);
    }

    return 0;
}