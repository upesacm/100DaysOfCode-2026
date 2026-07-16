#include<stdio.h>
#include<stdlib.h>
#define MAX 100
struct Stack{
    int arr[MAX];
    int top;
};
void init(struct Stack *s){
    s->top=-1;
}
int isEmpty(struct Stack *s){
    return s->top==-1;
}
void push(struct Stack *s,int x){
    s->arr[++s->top]=x;
}
int pop(struct Stack *s){
    return s->arr[s->top--];
}
void display(struct Stack *s){
    printf("[");
    for(int i=0;i<=s->top;i++){
        printf("%d",s->arr[i]);
        if(i!=s->top)printf(",");
    }
    printf("]");
}
void copyStack(struct Stack *src,struct Stack *dest){
    struct Stack temp;
    init(&temp);
    while(!isEmpty(src))
        push(&temp,pop(src));
    while(!isEmpty(&temp)){
        int x=pop(&temp);
        push(src,x);
        push(dest,x);
    }
}
int main(){
    struct Stack st,copy;
    init(&st);
    init(&copy);
    push(&st,1);
    push(&st,2);
    push(&st,3);
    push(&st,4);
    copyStack(&st,&copy);
    display(&copy);
    return 0;
}