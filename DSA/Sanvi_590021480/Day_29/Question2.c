#include <stdio.h>
#include <string.h>

int main() {
    
    char stack[1000];
    char s[1000];
    printf("Enter string: ");
    scanf("%s",s);
    int top=-1;
    for(int i=0;i<strlen(s);i++){
        stack[++top]=s[i];
    }
    for(int i=0;i<strlen(s);i++){
        top--;
        printf("%c",stack[top+1]);
    }

    return 0;
}
