#include <stdio.h>
#include <string.h>

char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    static char result[100];

    char words[1000][20];
    int count[1000] = {0};
    int wordCount = 0;

    char temp[20];
    int idx = 0;

    for (int i = 0;; i++) {
        char c = paragraph[i];

        // Convert uppercase to lowercase manually
        if (c >= 'A' && c <= 'Z')
            c = c + 32;

        // Check if character is a letter
        if (c >= 'a' && c <= 'z') {
            temp[idx++] = c;
        } else {
            if (idx > 0) {
                temp[idx] = '\0';

                int isBanned = 0;
                for (int j = 0; j < bannedSize; j++) {
                    if (strcmp(temp, banned[j]) == 0) {
                        isBanned = 1;
                        break;
                    }
                }

                if (!isBanned) {
                    int found = -1;

                    for (int j = 0; j < wordCount; j++) {
                        if (strcmp(words[j], temp) == 0) {
                            found = j;
                            break;
                        }
                    }

                    if (found == -1) {
                        strcpy(words[wordCount], temp);
                        count[wordCount] = 1;
                        wordCount++;
                    } else {
                        count[found]++;
                    }
                }

                idx = 0;
            }

            if (paragraph[i] == '\0')
                break;
        }
    }

    int max = 0;
    for (int i = 0; i < wordCount; i++) {
        if (count[i] > max) {
            max = count[i];
            strcpy(result, words[i]);
        }
    }

    return result;
}

int main() {
    char paragraph[] = "Bob hit a ball, the hit BALL flew far after it was hit.";
    char *banned[] = {"hit"};

    printf("%s\n", mostCommonWord(paragraph, banned, 1));

    return 0;
}