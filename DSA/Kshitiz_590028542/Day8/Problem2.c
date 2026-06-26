#include <stdio.h>
#include <string.h>

void reverseString(char *str) {
    if (str == NULL) return;

    int left = 0;
    int right = strlen(str) - 1;
    char temp;

    while (left < right) {
        temp = str[left];
        str[left] = str[right];
        str[right] = temp;

        left++;
        right--;
    }
}

int main() {
    char myString; 
    
    printf("Enter a string: ");
    
    scanf("%s", myString); 
    
    printf("Original: %s\n", myString);
    reverseString(myString);
    printf("Reversed: %s\n", myString);

    return 0;
}
