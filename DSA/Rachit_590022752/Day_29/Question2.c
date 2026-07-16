#include <stdio.h>
#include <string.h>

int main() {
    char input[100];
    char stack[100];
    char reverse[100];

    int top = -1;
    int i;

    printf("Enter a string: ");
    fgets(input, sizeof(input), stdin);

    input[strcspn(input, "\n")] = '\0';

    for (i = 0; input[i] != '\0'; i++) {
        top++;
        stack[top] = input[i];
    }

    i = 0;
    while (top >= 0) {
        reverse[i] = stack[top];
        i++;
        top--;
    }
    
    reverse[i] = '\0';
    printf("Reversed String: %s\n", reverse);

    return 0;
}
