#include <stdio.h>
#include <string.h>

int main()
{
    char s[200];

    fgets(s, sizeof(s), stdin);

    int j = 0;

    for(int i = 0; s[i] != '\0'; i++)
    {
        if(s[i] != ' ' && s[i] != '\n')
        {
            s[j] = s[i];
            j++;
        }
    }

    s[j] = '\0';

    printf("%s", s);

    return 0;
}
