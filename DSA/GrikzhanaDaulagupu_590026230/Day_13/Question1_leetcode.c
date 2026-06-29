#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define SIZE 10007

typedef struct Node {
    char word[101];
    int count;
    struct Node *next;
} Node;

unsigned hash(char *s) {
    unsigned h = 0;
    while (*s)
        h = h * 31 + *s++;
    return h % SIZE;
}

char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    Node *table[SIZE] = {0};
    char temp[101];
    int idx = 0;
    int maxCount = 0;
    char *ans = (char *)malloc(101);

    for (int i = 0;; i++) {
        char c = paragraph[i];

        if (isalpha(c)) {
            temp[idx++] = tolower(c);
        } else {
            if (idx > 0) {
                temp[idx] = '\0';
                idx = 0;

                // Check if banned
                int ban = 0;
                for (int j = 0; j < bannedSize; j++) {
                    if (strcmp(temp, banned[j]) == 0) {
                        ban = 1;
                        break;
                    }
                }

                if (!ban) {
                    unsigned h = hash(temp);
                    Node *p = table[h];

                    while (p && strcmp(p->word, temp))
                        p = p->next;

                    if (p)
                        p->count++;
                    else {
                        p = (Node *)malloc(sizeof(Node));
                        strcpy(p->word, temp);
                        p->count = 1;
                        p->next = table[h];
                        table[h] = p;
                    }

                    if (p->count > maxCount) {
                        maxCount = p->count;
                        strcpy(ans, p->word);
                    }
                }
            }

            if (c == '\0')
                break;
        }
    }

    return ans;
}
