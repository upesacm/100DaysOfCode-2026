// C program to check if two arrays are equal or not
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAX_VAL 1001

bool areEqual(int* a, int* b, int n) {
    int count[MAX_VAL] = {0};
    for (int i = 0; i < n; i++) { count[a[i]]++; count[b[i]]--; }
    for (int i = 0; i < MAX_VAL; i++) if (count[i] != 0) return false;
    return true;
}

int main() {
    int a[] = {1, 2, 3, 4}, b[] = {4, 3, 2, 1}, n = 4;
    printf("%s\n", areEqual(a, b, n) ? "True" : "False");
}