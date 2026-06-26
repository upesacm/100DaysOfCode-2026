#include <stdio.h>
#include <ctype.h>
int main(){
    char str[1000];
    printf("Enter a string: ");
    scanf("%s", str);
    for(int i=0;str[i]!='\0';i++){
        char c=tolower(str[i]);
        if(c!='a'&&c!='e'&&c!='i'&&c!='o'&& c!='u'){
            printf(".%c", c);
        }
    }
    return 0;
}
