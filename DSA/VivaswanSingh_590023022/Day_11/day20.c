#include <stdio.h>
#include <ctype.h>

int main()
{
    char str[101];

    scanf("%100s", str);

    for (int i = 0; str[i] != '\0'; i++)
    {
        char ch = tolower((unsigned char)str[i]);

        if (ch != 'a' && ch != 'e' && ch != 'i' &&
            ch != 'o' && ch != 'u' && ch != 'y')
        {
            printf(".%c", ch);
        }
    }

    return 0;
}