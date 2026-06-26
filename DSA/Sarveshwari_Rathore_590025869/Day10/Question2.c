#include <stdio.h>
#include <string.h>
int main(){
    char s[100];
    fgets(s,100,stdin);
    s[strcspn(s,"\n")] = "\0";
    int num=0;
    for(int i=0;s[i] != '\0';i++){
        if(s[i] != ' '){
            num += 1;
        }
    }
    if(num % 2 == 0){
        printf("CHAT WITH HER!\n");
    }else{
        printf("IGNORE HIM!\n");
    }
    return 0;
}