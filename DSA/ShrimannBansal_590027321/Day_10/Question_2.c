#include <stdio.h>

int main()
{
    char username[101];
    int hashTable[26] = {0};
    int distinct = 0;

    scanf("%s", username);

    for (int i = 0; username[i] != '\0'; i++)
    {
        int key = username[i] - 'a';

        if (hashTable[key] == 0)
        {
            hashTable[key] = 1;
            distinct++;
        }
    }

    if (distinct % 2 == 0)
        printf("CHAT WITH HER!");
    else
        printf("IGNORE HIM!");

    return 0;
}