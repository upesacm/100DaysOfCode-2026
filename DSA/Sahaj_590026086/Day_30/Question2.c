#include <stdio.h>
#define MAX 1000

int stack[MAX];
int top=-1;

void push(int x){
    stack[++top]=x;
}

int pop(){
    return stack[top--];
}
void insertatend(int x) {
    if (top==-1){
        push(x);
        return;
    }
    int temp=pop();
    insertatend(x);
    push(temp);
}
int main(){
    int n, x;
    printf("Enter the number of elements you want to enter:");
    scanf("%d", &n);
    for (int i=0;i<n;i++){
        int val;
        printf("Enter the element:");
        scanf("%d", &val);
        push(val);
    }
    printf("Enter the value you want to enter:");
    scanf("%d", &x);
    insertatend(x);
    printf("[");
    for (int i=0;i<=top;i++){
        printf("%d", stack[i]);
        if (i<top)
            printf(",");
    }
    printf("]\n");
    return 0;
}
