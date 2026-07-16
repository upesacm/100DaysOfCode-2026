/*Reverse a String Using Stack
Explanation
Reverse the given string using a stack and print the reversed string.*/

#include<stdio.h>
#include<string.h>
#define MAX 100

char stack[MAX];
int top = -1;

void push(char ch){
    if(top == MAX - 1){
        printf("Stack Overflow");
    }else{
        stack[++top] = ch;
    }
}

char pop(){
    if(top == -1){
        printf("Stack Underflow");
        return '\0';
    }else{
        return stack[top--];
    }
}

int main(){

    char str[MAX];
    int i;

    printf("Enter a string: ");
    scanf("%s", str); 

    for(i = 0; str[i] != '\0'; i++){
        push(str[i]);
    }

    printf("Reversed string: ");
    while(top != -1){
        printf("%c", pop());
    }

    printf("\n");

    return 0;
}