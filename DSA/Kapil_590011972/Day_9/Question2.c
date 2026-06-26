#include <stdio.h>
#define MAX_STRING_LENGTH 100

int main() {
  char string[MAX_STRING_LENGTH];
  printf("Enter the string: ");
  fgets(string, MAX_STRING_LENGTH, stdin);

  int idx = 0;
  for (int i = 0; i != '\n'; i++) {
    if (string[i] == ' ')
      continue;
    string[idx] = string[i];
    idx++;
  }
  string[idx] = '\0';

  printf("New String: %s", string);
}
