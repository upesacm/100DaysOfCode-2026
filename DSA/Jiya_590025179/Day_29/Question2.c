#include <stdio.h>
#include <string.h>
int main() {
    char s[1000],stck[1000];
    int top=-1;
    printf("Enter string: ");
    scanf("%s",s);
    for(int i=0;i<strlen(s);i++) stck[++top]=s[i];
    printf("OUTPUT: \n");
    for(int i=0;i<strlen(s);i++){
        top--;
        printf("%c",stck[top+1]);
    }
    return 0;
}
