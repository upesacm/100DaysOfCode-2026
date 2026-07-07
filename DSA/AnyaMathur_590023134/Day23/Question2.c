// Problem 2
// Backspace Equality 

#include <stdio.h>
#include <string.h>

int backspaceCompare(char s[], char t[]){
    int sIndex = strlen(s) - 1;
    int tIndex = strlen(t) - 1;

    int sBackspace = 0;
    int tBackspace = 0;

    while(sIndex >= 0 || tIndex >= 0){
        while(sIndex >= 0){
            if(s[sIndex] == '#'){
                sBackspace++;
                sIndex--;
            }
            else if(sBackspace > 0){
                sBackspace--;
                sIndex--;
            }
            else{
                break;
            }
        }

        while(tIndex >= 0){
            if(t[tIndex] == '#'){
                tBackspace++;
                tIndex--;
            }
            else if(tBackspace > 0){
                tBackspace--;
                tIndex--;
            }
            else{
                break;
            }
        }

        if(sIndex >= 0 && tIndex >= 0){
            if(s[sIndex] != t[tIndex]){
                return 0;
            }
        }
        else if(sIndex >= 0 || tIndex >= 0){
            return 0;
        }
        sIndex--;
        tIndex--;
    }
    return 1;
}

int main(){
    char s[100], t[100];

    printf("Enter first string: ");
    scanf("%s", s);
    printf("Enter second string: ");
    scanf("%s", t);

    if(backspaceCompare(s, t)){
        printf("True");
    }
    else{
        printf("False");
    }
    return 0;
}