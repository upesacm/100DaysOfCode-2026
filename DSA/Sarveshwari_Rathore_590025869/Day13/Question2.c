#include <stdio.h>
#include <string.h>
char subs[1000][100];
int subcount = 0;
int exists(char temp[]) {
    for (int i=0; i<subcount; i++) {
        if (strcmp(subs[i], temp) == 0)
            return 1;
    }
    return 0;
}
void generate(char str[], int index, char temp[], int pos) {
    if (str[index] == '\0') {
        temp[pos] = '\0';
        if (!exists(temp)) {
            strcpy(subs[subcount], temp);
            subcount++;
        }
        return;
    } generate(str, index + 1, temp, pos);
    temp[pos] = str[index];
    generate(str, index + 1, temp, pos + 1);
}
int countdsubSeq(char str[]) {
    char temp[100];
    subcount = 0;
    generate(str, 0, temp, 0);
    return subcount;
}

int main() {
    char s1[100], s2[100];
    scanf("%s", s1);
    scanf("%s", s2);
    int c1 = countdsubSeq(s1);
    int c2 = countdsubSeq(s2);
    if (c1 >= c2)
        printf("%s", s1);
    else
        printf("%s", s2);
    return 0;
}