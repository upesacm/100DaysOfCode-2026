#include <stdio.h>
#include <string.h>

int main()
{
    char s1[100];
    char s2[100];

    scanf("%s", s1);
    scanf("%s", s2);

    int n = strlen(s1);
    int m = strlen(s2);

    int found = -1;

    for(int i = 0; i <= n - m; i++)
    {
        int ok = 1;

        for(int j = 0; j < m; j++)
        {
            if(s1[i + j] != s2[j])
            {
                ok = 0;
                break;
            }
        }

        if(ok)
        {
            found = i;
            break;
        }
    }

    printf("%d", found);

    return 0;
}
