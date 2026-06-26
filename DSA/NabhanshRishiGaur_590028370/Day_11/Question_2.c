#include <stdio.h>
#include <ctype.h>

int main() {
    char s[105], ans[210];
    scanf("%s", s);

    int k = 0;

    for (int i = 0; s[i]; i++) {
        char ch = tolower(s[i]);

        if (ch!='a' && ch!='e' && ch!='i' &&
            ch!='o' && ch!='u') {
            ans[k++]='.';
            ans[k++]=ch;
        }
    }

    ans[k]='\0';

    printf("%s", ans);

    return 0;
}
