#include <stdio.h>

int main()
{
    char str[101];

    scanf("%s", str);

    for (int i = 0; str[i] != '\0'; i++)
    {
        char ch = str[i];

        if (ch >= 'A' && ch <= 'Z')
            ch = ch + 32;

        if (ch != 'a' && ch != 'e' && ch != 'i' &&
            ch != 'o' && ch != 'u')
        {
            printf(".%c", ch);
        }
    }

    return 0;
}