#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* mostCommonWord(char* paragraph, char** banned, int bannedSize) {
    static char result[101];
    
    typedef struct {
        char word[101];
        int count;
    } WordFreq;
    
    WordFreq uniqueWords[1000];
    int uniqueCount = 0;
    
    int len = strlen(paragraph);
    char currentWord[101];
    int wordIdx = 0;
    
    for (int i = 0; i <= len; i++) {
        if (isalpha(paragraph[i])) {
            currentWord[wordIdx++] = tolower(paragraph[i]);
        } 
        else if (wordIdx > 0) {
            currentWord[wordIdx] = '\0';
            
            int isBanned = 0;
            for (int j = 0; j < bannedSize; j++) {
                if (strcmp(currentWord, banned[j]) == 0) {
                    isBanned = 1;
                    break;
                }
            }
            
            if (!isBanned) {
                int found = 0;
                for (int j = 0; j < uniqueCount; j++) {
                    if (strcmp(uniqueWords[j].word, currentWord) == 0) {
                        uniqueWords[j].count++;
                        found = 1;
                        break;
                    }
                }
                
                if (!found) {
                    strcpy(uniqueWords[uniqueCount].word, currentWord);
                    uniqueWords[uniqueCount].count = 1;
                    uniqueCount++;
                }
            }
            wordIdx = 0;
        }
    }
    
    int maxCount = 0;
    for (int j = 0; j < uniqueCount; j++) {
        if (uniqueWords[j].count > maxCount) {
            maxCount = uniqueWords[j].count;
            strcpy(result, uniqueWords[j].word);
        }
    }
    
    return result;
}

int main() {
    char paragraph[] = "Bob hit a ball, the hit BALL flew far after it was hit.";
    char* banned[] = {"hit"};
    int bannedSize = 1;
    
    char* answer = mostCommonWord(paragraph, banned, bannedSize);
    
    printf("Most common word: %s\n", answer);
    
    return 0;
}