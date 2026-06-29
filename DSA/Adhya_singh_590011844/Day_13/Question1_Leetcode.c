#include <string.h>
#include <ctype.h>
#include <stdlib.h>

char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    char words[1000][50];
    int count[1000] = {0};
    int total = 0;

    for (int i = 0; paragraph[i]; i++) {
        if (isalpha(paragraph[i]))
            paragraph[i] = tolower(paragraph[i]);
        else
            paragraph[i] = ' ';
    }

    char *token = strtok(paragraph, " ");

    while (token != NULL) {
        int isBanned = 0;

        for (int i = 0; i < bannedSize; i++) {
            if (strcmp(token, banned[i]) == 0) {
                isBanned = 1;
                break;
            }
        }

        if (!isBanned) {
            int found = -1;

            for (int i = 0; i < total; i++) {
                if (strcmp(words[i], token) == 0) {
                    found = i;
                    break;
                }
            }

            if (found == -1) {
                strcpy(words[total], token);
                count[total]++;
                total++;
            } else {
                count[found]++;
            }
        }

        token = strtok(NULL, " ");
    }

    int max = 0;
    for (int i = 1; i < total; i++) {
        if (count[i] > count[max])
            max = i;
    }

    char *ans = (char *)malloc(strlen(words[max]) + 1);
    strcpy(ans, words[max]);

    return ans;
}