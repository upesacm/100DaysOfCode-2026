#include <stdio.h>
#include <string.h>

void SpaceRemover(char str[]) {
    if (str == NULL) {
        printf("The string is empty\n");
        return;
    }

    int j = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] != ' ') {
            str[j] = str[i];
            j++;
        }
    }
    
    str[j] = '\0'; 
}

int main() {
    char str[100]; 

    printf("Enter a string with spaces: ");
    fgets(str, sizeof(str), stdin);
    
    SpaceRemover(str);

    printf("String after removing spaces: %s\n", str);

    return 0;
}