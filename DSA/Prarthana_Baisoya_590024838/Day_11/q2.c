#include <stdio.h>

int main()
{
    char s[100];

    scanf("%s", s);

    for(int i = 0; s[i] != '\0'; i++)
    {
        char ch = s[i];

        if(ch >= 'A' && ch <= 'Z')
        {
            ch = ch + 32;
        }

        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
        {
            continue;
        }

        printf(".%c", ch);
    }

    return 0;
}
