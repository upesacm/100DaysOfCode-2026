#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(){
    char s[100];
    printf("Enter the string\n");
    fgets(s,100,stdin);
    s[strcspn(s,"\n")] = '\0';

    for(int j=0; s[j] != '\0';j++){
        s[j] = tolower(s[j]);
    }

    int i=0,left=0;
    while(s[left] != '\0'){
        if(!(strchr("aeiou",s[left]))){
            s[i++] = s[left];
        } 
        left ++;
    }
    s[i] = '\0';
    int k=strlen(s)-1;
    s[2 * strlen(s)] = '\0';
    while(k>=0){
        s[2*k+1] = s[k];
        s[2*k] = '.';
        k--;
    }
    printf("%s ",s);
}