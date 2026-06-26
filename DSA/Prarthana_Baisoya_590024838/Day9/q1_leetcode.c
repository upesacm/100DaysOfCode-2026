#include <stdio.h>
#include <string.h>

int main()
{
    char s[200];

    fgets(s, sizeof(s), stdin);

    int n = strlen(s);
    int count = 0;

    int i = n - 1;

    while(i >= 0 && (s[i] == ' ' || s[i] == '\n'))
    {
        i--;
    }

    while(i >= 0 && s[i] != ' ')
    {
        count++;
        i--;
    }

    printf("%d", count);

    return 0;
}
