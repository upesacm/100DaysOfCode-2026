#include <stdio.h>

#define M 100
int stack1[M], stack2[M], temp[M];
int top1 = -1, top2 = -1, topTemp = -1;

void push1(int x) {
    stack1[++top1] = x;
}

void push2(int x) {
    stack2[++top2] = x;
}

void pushTemp(int x) {
    temp[++topTemp] = x;
}

int pop1() {
    return stack1[top1--];
}

int pop2() {
    return stack2[top2--];
}

int popTemp() {
    return temp[topTemp--];
}

void printStack2() {
    printf("Copied Stack:\n");
    for (int i = top2; i >= 0; i--)
        printf("%d ", stack2[i]);
}

int main() {
    int n, x;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    printf("Enter elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        push1(x);
    }
    while (top1 != -1) {
        pushTemp(pop1());
    }
    while (topTemp != -1) {
        x = popTemp();
        push1(x);
        push2(x);
    }
    printStack2();
    return 0;
}