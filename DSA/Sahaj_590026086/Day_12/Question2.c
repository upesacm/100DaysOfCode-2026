#include <stdio.h>
#include <string.h>

int main() {
    char str[1000];
    printf("Enter string: ");
    scanf("%s", str);

    int n = strlen(str);
    int freq[256] = {0}, distinct = 0;

    for(int i = 0; i < n; i++) {
        if(freq[(int)str[i]] == 0) {
            freq[(int)str[i]] = 1;
            distinct++;
        }
    }

    int count[256] = {0}, formed = 0, left = 0, minLen = n;

    for(int right = 0; right < n; right++) {
        count[(int)str[right]]++;

        if(count[(int)str[right]] == 1) formed++;

        while(formed == distinct) {
            if(right - left + 1 < minLen)
                minLen = right - left + 1;

            count[(int)str[left]]--;
            if(count[(int)str[left]] == 0)
                formed--;

            left++;
        }
    }

    printf("%d\n", minLen);
    return 0;
}
