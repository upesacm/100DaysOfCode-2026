#include <stdio.h>
#include <string.h>

int main()
{
    char s[100];
    char t[100];

    scanf("%s", s);
    scanf("%s", t);

    int a[256];
    int b[256];

    for(int i = 0; i < 256; i++)
    {
        a[i] = -1;
        b[i] = -1;
    }

    int ok = 1;

    for(int i = 0; s[i] != '\0'; i++)
    {
        if(a[(int)s[i]] == -1 && b[(int)t[i]] == -1)
        {
            a[(int)s[i]] = t[i];
            b[(int)t[i]] = s[i];
        }
        else if(a[(int)s[i]] != t[i] || b[(int)t[i]] != s[i])
        {
            ok = 0;
            break;
        }
    }

    if(ok)
        printf("true");
    else
        printf("false");

    return 0;
}
