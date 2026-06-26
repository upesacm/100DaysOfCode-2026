#include <stdio.h>
#define UNIQUE_CHARACTERS 128
#define STRING_LENGTH 1000

// this code works for ascii characters only
int main() {
  int unique[UNIQUE_CHARACTERS] = {0};
  char string[STRING_LENGTH];

  printf("Enter the string: ");
  fgets(string, STRING_LENGTH, stdin);

  for (int i = 0; string[i] != '\0' && string[i] != '\n'; i++)
    unique[string[i]]++;

  int unique_char = 0;
  for (int i = 0; i < UNIQUE_CHARACTERS; i++) {
    if (unique[i])
      unique_char++;
  }

  if (unique_char % 2 == 0)
    printf("CHAT WITH HER!");
  else
    printf("IGNORE HER!");
}
