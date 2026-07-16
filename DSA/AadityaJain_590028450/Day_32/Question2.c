/*Copy From One Stack To Another
Explanation
Copy all elements from one stack to another while preserving the original order using only stack operations, and print the copied stack.*/

#include<stdio.h>
#define MAX 100

int stack1[MAX], stack2[MAX];
int top1 = -1, top2 = -1;

void push1(int x){
    stack1[++top1] = x;
}

int pop1(){
    return stack1[top1--];
}

void push2(int x){
    stack2[++top2] = x;
}

int pop2(){
    return stack2[top2--];
}

void display(){
    for(int i = top2; i >= 0; i--){
        printf("%d ", stack2[i]);
    }
    printf("\n");
}

int main(){

    int temp[MAX], top = -1;
    int i, n, x;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter stack elements: ");
    for(i = 0; i < n; i++){
        scanf("%d", &x);
        push1(x);
    }

    while(top1 != -1){
        push2(pop1());
    }

    while(top2 != -1){
        x = pop2();
        push1(x);
        temp[++top] = x;
    }

    while(top != -1){
        push2(temp[top--]);
    }

    display();

    return 0;
}