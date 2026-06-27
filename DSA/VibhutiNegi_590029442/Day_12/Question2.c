#include <stdio.h>
#include <string.h>
int main() {
    char str[1000];
    scanf("%s", str);
    int present[256] = {0};
    int totalDistinct = 0;
    for (int i = 0; str[i] != '\0'; i++) {
        if (present[(unsigned char)str[i]] == 0) {
            present[(unsigned char)str[i]] = 1;
            totalDistinct++;
        }
    }
    int freq[256] = {0};
    int left = 0, count = 0;
    int minLength = strlen(str);
    for (int right = 0; str[right] != '\0'; right++) {
        if (freq[(unsigned char)str[right]] == 0)
            count++;
        freq[(unsigned char)str[right]]++;
        while (count == totalDistinct) {
            if (right - left + 1 < minLength)
                minLength = right - left + 1;
            freq[(unsigned char)str[left]]--;
            if (freq[(unsigned char)str[left]] == 0)
              count--;
            left++;
        }
    }
    printf("%d\n", minLength);
    return 0;
}