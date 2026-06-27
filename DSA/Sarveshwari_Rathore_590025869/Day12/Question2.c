#include <stdio.h>
#include <string.h>
int main() {
    char s[100];
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';
    int n = strlen(s);
    int freq[256] = {0};
    int found[256] = {0};
    int distinct = 0;
    for(int i = 0; s[i] != '\0'; i++){
        if(!found[(char)s[i]]){
            found[(char)s[i]] = 1;
            distinct++;
        }
    }
    int left = 0;
    int count = 0;
    int min = n;
    for(int right = 0; right < n; right++){
        char ch = s[right];
        freq[ch]++;
        if(freq[ch] == 1){
            count++;
        }
        while(count == distinct){
            int len = right - left + 1;
            if(len < min){
                min = len;
            }
            char leftchar = s[left];
            freq[leftchar]--;

            if(freq[leftchar] == 0){
                count--;
            }
            left++;
        }
    }
    printf("%d",min);
    return 0;
}