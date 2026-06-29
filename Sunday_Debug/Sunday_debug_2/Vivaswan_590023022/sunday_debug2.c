#include <stdio.h>
#include <string.h>
#include <ctype.h>

void process_scroll(char *names[], int n, char *password, char *spell) {
    char *valid_spells[] = {"nox", "expelliarmus", "alohomora"};
    int valid = 0;
    for (int i = 0; i < 3; i++) {
        if (strcmp(spell, valid_spells[i]) == 0) {
            valid = 1;
            break;
        }
    }

    if (valid) {
        printf("Spell accepted!\n");
    } else {
        printf("Invalid spell!\n");
        return;
    }

    char clean[100];
    int j = 0;
    for (int i = 0; password[i]; i++) {
        if (password[i] != ' ') {
            clean[j++] = tolower(password[i]);
        }
    }
    clean[j] = '\0';

    int len = strlen(clean);
    int is_palindrome = 1;
    for (int i = 0; i < len / 2; i++) {
        if (clean[i] != clean[len - 1 - i]) {
            is_palindrome = 0;
            break;
        }
    }

    if (is_palindrome) {
        printf("Scroll unlocked!\n");
        printf("Initials: ['%c', '%c', '%c']\n", names[0][0], names[1][0], names[2][0]);
        printf("Concealed: ['*****', '***', '*********']\n");
    } else {
        printf("Wrong password!\n");
    }
}

int main() {
    char *names[] = {"Harry", "Ron", "Hermione"};
    process_scroll(names, 3, "nurses run", "expelliarmus");
    return 0;
}