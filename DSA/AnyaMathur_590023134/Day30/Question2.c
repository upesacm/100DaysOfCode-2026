// Problem 2 
// Insert Element at Bottom of Stack 

#include <stdio.h>

int stack[100];
int top = -1;

void push(int value){
    top++;
    stack[top] = value;
}

int pop(){
    int value = stack[top];
    top--;
    return value;
}

void insertAtBottom(int x){
    if(top == -1){
        push(x);
        return;
    }

    int temp = pop();
    insertAtBottom(x);
    push(temp);
}

int main(){
    int n, x;

    printf("Enter number of elements in stack: ");
    scanf("%d", &n);

    printf("Enter stack elements: ");

    for(int i = 0; i < n; i++){
        int value;
        scanf("%d", &value);
        push(value);
    }

    printf("Enter element to insert at bottom: ");
    scanf("%d", &x);

    insertAtBottom(x);

    printf("Stack after insertion: ");

    for(int i = 0; i <= top; i++){
        printf("%d ", stack[i]);
    }

    return 0;
}