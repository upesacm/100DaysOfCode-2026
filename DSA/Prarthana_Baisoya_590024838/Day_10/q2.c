#include <stdio.h>
#include <string.h>

int main()
{
    char s[100];
    scanf("%s", s);

    int freq[26] = {0};
    int count = 0;

    for(int i = 0; s[i] != '\0'; i++)
    {
        int pos = s[i] - 'a';

        if(freq[pos] == 0)
        {
            freq[pos] = 1;
            count++;
        }
    }

    if(count % 2 == 0)
    {
        printf("CHAT WITH HER!");
    }
    else
    {
        printf("IGNORE HIM!");
    }

    return 0;
}
