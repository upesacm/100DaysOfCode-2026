#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {

    char paragraph[1000];
    char banned[20][50];
    int bannedCount;

    printf("Enter paragraph:\n");
    fgets(paragraph, sizeof(paragraph), stdin);

    printf("Enter number of banned words: ");
    scanf("%d", &bannedCount);

    printf("Enter banned words:\n");
    for(int i = 0; i < bannedCount; i++) {
        scanf("%s", banned[i]);
    }

    char words[200][50];
    int freq[200] = {0};
    int wordCount = 0;

    char word[50];
    int k = 0;

    int len = strlen(paragraph);

    for(int i = 0; i <= len; i++) {

        if(isalpha(paragraph[i])) {
            word[k++] = tolower(paragraph[i]);
        }
        else {
            if(k > 0) {
                word[k] = '\0';
                k = 0;

                int isBanned = 0;

                for(int j = 0; j < bannedCount; j++) {
                    if(strcmp(word, banned[j]) == 0) {
                        isBanned = 1;
                        break;
                    }
                }

                if(!isBanned) {

                    int found = -1;

                    for(int j = 0; j < wordCount; j++) {
                        if(strcmp(words[j], word) == 0) {
                            found = j;
                            break;
                        }
                    }

                    if(found == -1) {
                        strcpy(words[wordCount], word);
                        freq[wordCount] = 1;
                        wordCount++;
                    }
                    else {
                        freq[found]++;
                    }
                }
            }
        }
    }

    int max = 0;
    int index = 0;

    for(int i = 0; i < wordCount; i++) {
        if(freq[i] > max) {
            max = freq[i];
            index = i;
        }
    }

    printf("Most Common Word: %s\n", words[index]);

    return 0;
}