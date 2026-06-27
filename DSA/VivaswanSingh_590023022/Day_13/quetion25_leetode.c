typedef struct
{
    char word[1001];
    int count;
} WordEntry;

bool isBanned(char *word, char **banned, int bannedSize)
{
    for (int i = 0; i < bannedSize; i++)
    {
        if (strcmp(word, banned[i]) == 0)
            return true;
    }
    return false;
}

char *mostCommonWord(char *paragraph, char **banned, int bannedSize)
{
    WordEntry words[1000];
    int wordCount = 0;

    char current[1001];
    int len = 0;

    int maxCount = 0;
    char answer[1001] = "";

    int n = strlen(paragraph);

    for (int i = 0; i <= n; i++)
    {
        if (i < n && isalpha((unsigned char)paragraph[i]))
        {
            current[len++] = tolower((unsigned char)paragraph[i]);
        }
        else if (len > 0)
        {
            current[len] = '\0';
            len = 0;

            if (isBanned(current, banned, bannedSize))
                continue;

            int index = -1;

            for (int j = 0; j < wordCount; j++)
            {
                if (strcmp(words[j].word, current) == 0)
                {
                    index = j;
                    break;
                }
            }

            if (index == -1)
            {
                strcpy(words[wordCount].word, current);
                words[wordCount].count = 1;
                index = wordCount;
                wordCount++;
            }
            else
            {
                words[index].count++;
            }

            if (words[index].count > maxCount)
            {
                maxCount = words[index].count;
                strcpy(answer, words[index].word);
            }
        }
    }

    char *result = (char *)malloc(strlen(answer) + 1);
    strcpy(result, answer);

    return result;
}