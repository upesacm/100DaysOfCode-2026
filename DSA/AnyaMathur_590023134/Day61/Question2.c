// Problem 2
// The Wizard Academy 

#include <stdio.h>

int findDepth(int student, int mentor[], int n) {
    int depth = 1;
    while (mentor[student - 1] != -1) {
        student = mentor[student - 1];
        depth++;
    }
    return depth;
}

int minimumGroups(int n, int mentor[]) {
    int maxDepth = 1;
    for (int i = 1; i <= n; i++) {
        int depth = findDepth(i, mentor, n);
        if (depth > maxDepth)
            maxDepth = depth;
    }
    return maxDepth;
}

int main() {
    int n;
    printf("Enter number of students: ");
    scanf("%d", &n);
    int mentor[n];
    printf("Enter the mentor array (-1 if the student has no mentor):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &mentor[i]);
    }
    int result = minimumGroups(n, mentor);
    printf("Minimum number of groups required: %d\n", result);
    return 0;
}