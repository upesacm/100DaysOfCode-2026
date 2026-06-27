#include <stdio.h>
#include <string.h>

int distinct(char* s) {
    int ans[95] = {0};
    int dis = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int id = s[i] - 32;
        if (ans[id] == 0) {
            ans[id]++;
            dis++;
        }
    }
    return dis;
}

int sdw(char* s) {
    int frequency[95] = {0};
    int total_distinct = distinct(s);
    int cur_dis = 0;
    int i = 0, j = 0;
    int ans = strlen(s)+1;

    while (s[j] != '\0') {
        int idj = s[j]-32;
        if (frequency[idj] == 0) cur_dis++;
        frequency[idj]++;
        j++;

        while (cur_dis == total_distinct) {
            int current_len = j - i;
            if (current_len < ans) ans = current_len;

            int idi = s[i]-32;
            frequency[idi]--;
            if (frequency[idi] == 0) cur_dis--;
            i++;
        }
    }
    return ans;
}

int main() {
    char s[1000];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\r\n")] = '\0';

    if (!s || s[0] == '\0') return 0;
    int ans = sdw(s);
    printf("Smallest Distinct Window: %d", ans);
}