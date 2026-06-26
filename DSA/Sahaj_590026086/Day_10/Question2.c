#include <stdio.h>
#include <string.h>
int main(){
    char str[1000];
    int freq[256]={0},count=0;
    printf("Enter a string: ");
    scanf("%s", str);
    for(int i=0;str[i]!='\0';i++){
        if(freq[(int)str[i]]==0){
            freq[(int)str[i]]=1;
            count++;
        }
    }
    if(count%2==0)
        printf("CHAT WITH HER!\n");
    else
        printf("IGNORE HIM!\n");
    return 0;
}
