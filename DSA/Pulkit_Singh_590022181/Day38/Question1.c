#include <stdio.h>

int countStudents(int students[], int sandwiches[], int n) {

    int count[2] = {0, 0};

    for (int i = 0; i < n; i++)
        count[students[i]]++;

    for (int i = 0; i < n; i++) {

        if (count[sandwiches[i]] == 0)
            return n - i;

        count[sandwiches[i]]--;
    }

    return 0;
}

int main() {

    int students[] = {1, 1, 0, 0};
    int sandwiches[] = {0, 1, 0, 1};
    int n = 4;

    printf("Students unable to eat = %d\n",
           countStudents(students, sandwiches, n));

    return 0;
}