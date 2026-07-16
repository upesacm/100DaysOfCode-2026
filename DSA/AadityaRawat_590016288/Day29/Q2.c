#include <stdio.h>
#include <string.h>

#define MAXSIZE 1000

typedef struct {
    char arr[MAXSIZE];
    int top;
} Stack;

void push(Stack* s, char c) {
    s->arr[++(s->top)] = c;
}

char pop(Stack* s) {
    return s->arr[(s->top)--];
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void reverseString(char* s) {
    Stack st;
    st.top = -1;
    int n = strlen(s);

    // push every character
    for (int i = 0; i < n; i++)
        push(&st, s[i]);

    // pop back into the string -> reversed order
    for (int i = 0; i < n; i++)
        s[i] = pop(&st);
}

int main() {
    char s[MAXSIZE] = "hello";

    reverseString(s);
    printf("%s\n", s);  // olleh

    return 0;
}