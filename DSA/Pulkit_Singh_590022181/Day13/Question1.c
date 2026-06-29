#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_WORDS 1000
#define MAX_LEN 20

typedef struct {
    char word[MAX_LEN];
    int count;
} WordCount;

int isBanned(char word[], char banned[][MAX_LEN], int bannedSize) {
    for (int i = 0; i < bannedSize; i++) {
        if (strcmp(word, banned[i]) == 0)
            return 1;
    }
    return 0;
}

int findWord(WordCount words[], int size, char word[]) {
    for (int i = 0; i < size; i++) {
        if (strcmp(words[i].word, word) == 0)
            return i;
    }
    return -1;
}

int main() {
    char paragraph[1001];
    printf("Enter paragraph:\n");
    fgets(paragraph, sizeof(paragraph), stdin);

    int bannedSize;
    printf("Enter number of banned words: ");
    scanf("%d", &bannedSize);

    char banned[100][MAX_LEN];
    for (int i = 0; i < bannedSize; i++) {
        scanf("%s", banned[i]);
    }

    WordCount words[MAX_WORDS];
    int wordCount = 0;

    char temp[MAX_LEN];
    int j = 0;

    int len = strlen(paragraph);

    for (int i = 0; i <= len; i++) {
        if (isalpha(paragraph[i])) {
            temp[j++] = tolower(paragraph[i]);
        } else {
            if (j > 0) {
                temp[j] = '\0';

                if (!isBanned(temp, banned, bannedSize)) {
                    int index = findWord(words, wordCount, temp);

                    if (index == -1) {
                        strcpy(words[wordCount].word, temp);
                        words[wordCount].count = 1;
                        wordCount++;
                    } else {
                        words[index].count++;
                    }
                }
                j = 0;
            }
        }
    }

    int max = 0;
    char answer[MAX_LEN];

    for (int i = 0; i < wordCount; i++) {
        if (words[i].count > max) {
            max = words[i].count;
            strcpy(answer, words[i].word);
        }
    }

    printf("Most Common Word: %s\n", answer);

    return 0;
}