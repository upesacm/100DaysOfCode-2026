#include <stdio.h>
#define M 100
int stack[M];
int top = -1;
void push(int p) {
    if (top == M - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = p;
}
int pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}
int isEmpty() {
    return top == -1;
}
void insertAtBottom(int b) {
    if(isEmpty()){
        push(b);
        return;
    }
    int temp = pop();
    insertAtBottom(b);
    push(temp);
}
void printStack(){
    for (int i = 0; i <= top; i++) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main(){
    int n;
    printf("enter the number of elements to insert:");
    scanf("%d",&n);
    int m;
    for(int i=0;i<n;i++){
        scanf("%d",&m);
        push(m);
    }
    int k;
    printf("Enter the element to insert at bottom");
    scanf("%d",&k);
    insertAtBottom(k);
    printStack();
    return 0;
}