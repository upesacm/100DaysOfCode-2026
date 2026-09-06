#include <stdio.h>

int numberOfSteps(int num) {
    int steps = 0;

    while (num != 0) {
        if (num % 2 == 0) {
            num = num / 2;
        } else {
            num = num - 1;
        }

        steps++;
    }

    return steps;
}

int main() {
    int num;

    printf("Enter a number: ");
    scanf("%d", &num);

    printf("Number of steps: %d\n", numberOfSteps(num));

    return 0;
}