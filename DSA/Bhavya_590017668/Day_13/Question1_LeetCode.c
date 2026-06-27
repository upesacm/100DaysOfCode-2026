typedef struct {
    char word[100];
    int count;
} WordFreq;

int isBanned(char *word, char **banned, int bannedSize) {
    for (int i = 0; i < bannedSize; i++) {
        if (strcmp(word, banned[i]) == 0)
            return 1;
    }
    return 0;
}

char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    WordFreq freq[1000];
    int freqSize = 0;

    char word[100];
    int index = 0;
    int len = strlen(paragraph);

    for (int i = 0; i <= len; i++) {
        if (isalpha(paragraph[i])) {
            word[index++] = tolower(paragraph[i]);
        } else {
            if (index > 0) {
                word[index] = '\0';

                if (!isBanned(word, banned, bannedSize)) {
                    int found = 0;

                    for (int j = 0; j < freqSize; j++) {
                        if (strcmp(freq[j].word, word) == 0) {
                            freq[j].count++;
                            found = 1;
                            break;
                        }
                    }

                    if (!found) {
                        strcpy(freq[freqSize].word, word);
                        freq[freqSize].count = 1;
                        freqSize++;
                    }
                }
                index = 0;
            }
        }
    }

    int maxCount = 0;
    char *result = malloc(100);

    for (int i = 0; i < freqSize; i++) {
        if (freq[i].count > maxCount) {
            maxCount = freq[i].count;
            strcpy(result, freq[i].word);
        }
    }

    return result;
}