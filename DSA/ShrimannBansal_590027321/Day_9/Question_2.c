#include <stdio.h>

void removeSpaces(char *s)
{
    int i = 0;
    int j = 0;

    while (s[i] != '\0')
    {
        if (s[i] != ' ')
        {
            s[j] = s[i];
            j++;
        }
        i++;
    }

    s[j] = '\0';
}

int main()
{
    char s[1000];

    fgets(s, sizeof(s), stdin);

    int i = 0;
    while (s[i] != '\0')
    {
        if (s[i] == '\n')
        {
            s[i] = '\0';
            break;
        }
        i++;
    }

    removeSpaces(s);

    printf("%s\n", s);

    return 0;
}