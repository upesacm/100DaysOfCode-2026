#include <ctype.h>
#include <stdlib.h>
#include <string.h>

char *mostCommonWord(char *paragraph, char **banned, int bannedSize)
{
    char words[1000][25];
    int freq[1000] = {0};
    int count = 0;

    char word[25];
    int k = 0;

    for (int i = 0;; i++)
    {
        char ch = paragraph[i];

        if (isalpha(ch))
        {
            word[k++] = tolower(ch);
        }
        else
        {
            if (k > 0)
            {
                word[k] = '\0';

                int ban = 0;
                for (int j = 0; j < bannedSize; j++)
                {
                    if (strcmp(word, banned[j]) == 0)
                    {
                        ban = 1;
                        break;
                    }
                }

                if (!ban)
                {
                    int found = -1;

                    for (int j = 0; j < count; j++)
                    {
                        if (strcmp(words[j], word) == 0)
                        {
                            found = j;
                            break;
                        }
                    }

                    if (found == -1)
                    {
                        strcpy(words[count], word);
                        freq[count] = 1;
                        count++;
                    }
                    else
                    {
                        freq[found]++;
                    }
                }

                k = 0;
            }

            if (ch == '\0')
                break;
        }
    }

    int max = 0;

    for (int i = 1; i < count; i++)
    {
        if (freq[i] > freq[max])
            max = i;
    }

    char *result = malloc(strlen(words[max]) + 1);
    strcpy(result, words[max]);

    return result;
}