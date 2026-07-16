#include <stdio.h>

#define MAX 100

int stack1[MAX], stack2[MAX], tempStack[MAX];
int top1 = -1, top2 = -1, top3 = -1;

// Push operations
void push1(int x) {
    stack1[++top1] = x;
}

void push2(int x) {
    stack2[++top2] = x;
}

void push3(int x) {
    tempStack[++top3] = x;
}

// Pop operations
int pop1() {
    return stack1[top1--];
}

int pop2() {
    return stack2[top2--];
}

int pop3() {
    return tempStack[top3--];
}

void copyStack() {

    // Move stack1 to temporary stack
    while (top1 != -1) {
        push3(pop1());
    }

    // Restore stack1 and copy to stack2
    while (top3 != -1) {
        int x = pop3();
        push1(x);
        push2(x);
    }
}

void printStack2() {

    printf("Copied Stack: [");

    for (int i = 0; i <= top2; i++) {
        printf("%d", stack2[i]);
        if (i != top2)
            printf(",");
    }

    printf("]\n");
}

int main() {

    push1(1);
    push1(2);
    push1(3);
    push1(4);

    copyStack();

    printStack2();

    return 0;
}