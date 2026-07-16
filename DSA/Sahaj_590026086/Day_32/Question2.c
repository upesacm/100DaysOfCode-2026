#include <stdio.h>
#define MAX 1000

int st1[MAX],st2[MAX], temp[MAX];
int top1=-1,top2=-1,top3=-1;

void push1(int x){ 
    st1[++top1]=x;
}
void push2(int x){
    st2[++top2]=x;
}
void push3(int x){
    temp[++top3]=x;
}

int pop1(){
    return st1[top1--];
}
int pop2(){
    return temp[top3--];
}

int main(){
    int n;
    printf("Enter the number of elements you want to enter:");
    scanf("%d", &n);
    for (int i=0;i<n;i++){
        int x;
        printf("Enter the element:");
        scanf("%d", &x);
        push1(x);
    }
    while (top1!=-1){
        push3(pop1());
    }
    while (top3!=-1){
        int x = pop2();
        push1(x);
        push2(x);
    }
    printf("[");
    for (int i=0;i<=top2;i++){
        printf("%d",st2[i]);
        if (i<top2)
            printf(",");
    }
    printf("]\n");
    return 0;
}
