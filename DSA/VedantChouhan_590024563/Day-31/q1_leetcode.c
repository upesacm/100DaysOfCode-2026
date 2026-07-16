#include <stdio.h>

void finalPrices(int prices[], int n, int answer[]) {

    int stack[500];
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {

        while (top != -1 && stack[top] > prices[i]) {
            top--;
        }

        if (top == -1)
            answer[i] = prices[i];
        else
            answer[i] = prices[i] - stack[top];

        stack[++top] = prices[i];
    }
}

int main() {

    int prices[] = {8, 4, 6, 2, 3};
    int n = sizeof(prices) / sizeof(prices[0]);

    int answer[n];

    finalPrices(prices, n, answer);

    printf("Final Prices: ");

    for (int i = 0; i < n; i++) {
        printf("%d ", answer[i]);
    }

    printf("\n");

    return 0;
}