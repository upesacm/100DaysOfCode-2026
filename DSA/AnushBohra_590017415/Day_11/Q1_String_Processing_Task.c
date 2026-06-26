#include <stdio.h>
#include <ctype.h>

int main()
{
    char str[101];

    scanf("%s", str);

    for (int i = 0; str[i] != '\0'; i++)
    {
        char ch = tolower(str[i]);

        if (ch != 'a' &&
            ch != 'e' &&
            ch != 'i' &&
            ch != 'o' &&
            ch != 'u' &&
            ch != 'y')
        {
            printf(".%c", ch);
        }
    }

    return 0;
}