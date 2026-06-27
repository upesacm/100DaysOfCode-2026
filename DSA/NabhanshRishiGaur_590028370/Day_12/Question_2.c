#include <stdio.h>
#include <string.h>
#include <limits.h>

int main() {
    char str[1005];
    scanf("%s", str);

    int n = strlen(str);

    int vis[256] = {0};
    int totalDistinct = 0;

    for (int i = 0; i < n; i++) {
        if (!vis[(unsigned char)str[i]]) {
            vis[(unsigned char)str[i]] = 1;
            totalDistinct++;
        }
    }

    int ans = INT_MAX;

    for (int i = 0; i < n; i++) {
        int freq[256] = {0};
        int count = 0;

        for (int j = i; j < n; j++) {
            if (freq[(unsigned char)str[j]] == 0)
                count++;

            freq[(unsigned char)str[j]]++;

            if (count == totalDistinct) {
                if (j - i + 1 < ans)
                    ans = j - i + 1;
                break;
            }
        }
    }

    printf("%d\n", ans);

    return 0;
}
